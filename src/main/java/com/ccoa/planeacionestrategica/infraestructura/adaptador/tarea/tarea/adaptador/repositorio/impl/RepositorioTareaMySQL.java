package com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoTarea;
import com.ccoa.planeacionestrategica.dominio.dto.DtoTareaResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsTarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.InformacionTarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.Tarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.documento.DocumentoTarea;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.ETipoASE;
import com.ccoa.planeacionestrategica.dominio.puerto.tarea.RepositorioTarea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.mapeador.documento.MapeadorDocumentoTarea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.mapeador.MapeadorInformacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.mapeador.MapeadorTarea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.repositorio.jpa.RepositorioDocumentoTareaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.repositorio.jpa.RepositorioInformacionTareaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.entidad.EntidadTarea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.repositorio.jpa.RepositorioTareaJpa;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioTareaMySQL implements RepositorioTarea {

    private final RepositorioTareaJpa repositorioTareaJpa;
    private final RepositorioInformacionTareaJpa repositorioInformacionTareaJpa;
    private final MapeadorTarea mapeadorTarea;
    private final MapeadorInformacionTarea mapeadorInformacionTarea;
    private final MapeadorDocumentoTarea mapeadorDocumentoTarea;
    private final RepositorioDocumentoTareaJpa repositorioDocumentoTareaJpa;

    public RepositorioTareaMySQL(RepositorioTareaJpa repositorioTareaJpa, RepositorioInformacionTareaJpa repositorioInformacionTareaJpa, MapeadorTarea mapeadorTarea, MapeadorInformacionTarea mapeadorInformacionTarea, MapeadorDocumentoTarea mapeadorDocumentoTarea, RepositorioDocumentoTareaJpa repositorioDocumentoTareaJpa) {
        this.repositorioTareaJpa = repositorioTareaJpa;
        this.repositorioInformacionTareaJpa = repositorioInformacionTareaJpa;
        this.mapeadorTarea = mapeadorTarea;
        this.mapeadorInformacionTarea = mapeadorInformacionTarea;
        this.mapeadorDocumentoTarea = mapeadorDocumentoTarea;
        this.repositorioDocumentoTareaJpa = repositorioDocumentoTareaJpa;
    }

    @Override
    public List<DtoTareaResumen> listar() {
        var entidad = this.repositorioTareaJpa.findAll();
        return this.mapeadorTarea.listarDominio(entidad);
    }

    @Override
    public Tarea consultarPorId(Long id) {
        var entidad = this.repositorioTareaJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorTarea.mapeadorDominio(entidad);
    }

    @Override
    public Long guardar(Tarea tarea, InformacionTarea informacionTarea) {
        var tareaEntidad = this.mapeadorTarea.mapeadorEntidad(tarea);
        var entidadInformacionTarea = this.mapeadorInformacionTarea.mapeadorEntidad(informacionTarea);
        var id = this.repositorioTareaJpa.save(tareaEntidad).getIdTarea();
        this.mapeadorTarea.actualizarEstadoEntidad(tareaEntidad,tarea,entidadInformacionTarea);
        entidadInformacionTarea.setIdInformacionTarea(id);
        this.repositorioInformacionTareaJpa.save(entidadInformacionTarea);
        return this.repositorioTareaJpa.save(tareaEntidad).getIdTarea();
    }

    @Override
    public boolean existe(Tarea tarea) {
        return this.repositorioTareaJpa.findByNombre(tarea.getNombre())!=null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioInformacionTareaJpa.deleteById(id);
        this.repositorioTareaJpa.deleteById(id);
        return id;
    }
    @Transactional
    @Override
    public void eliminarPorActividadGestionEstrategica(Long id) {
        var entidades = consultarPorIdActividadGestionEstrategicaAEliminar(id);
        entidades.forEach(entidad -> repositorioInformacionTareaJpa.deleteById(entidad.getIdInformacionTarea()));
        repositorioTareaJpa.deleteByIdASE(id);
    }
    @Transactional
    @Override
    public void eliminarPorActividadGestion(Long id) {
        var entidades = consultarPorIdActividadGestionAEliminar(id);
        entidades.forEach(entidad -> repositorioInformacionTareaJpa.deleteById(entidad.getIdInformacionTarea()));
        repositorioTareaJpa.deleteByIdASE(id);
    }

    @Override
    public Long modificar(Tarea tarea,InformacionTarea informacionTarea, Long id) {
        var entidad = this.repositorioTareaJpa.findById(id).orElse(null);
        assert entidad != null;
        var entidadInformacionTarea = this.repositorioInformacionTareaJpa.findById(id).orElse(null);
        assert  entidadInformacionTarea != null;
        this.mapeadorTarea.actualizarEntidad(entidad, tarea, entidadInformacionTarea, informacionTarea);
        return this.repositorioTareaJpa.save(entidad).getIdTarea();
    }

    @Override
    public Long modificarEstado(Tarea tarea, InformacionTarea informacionTarea, Long id) {
        var entidad = this.repositorioTareaJpa.findById(id).orElse(null);
        assert entidad != null;
        var entidadInformacionTarea = this.repositorioInformacionTareaJpa.findById(id).orElse(null);
        assert  entidadInformacionTarea != null;
        this.mapeadorTarea.actualizarEstadoEntidad(entidad, tarea,entidadInformacionTarea);
        return this.repositorioTareaJpa.save(entidad).getIdTarea();
    }

    @Override
    public Long modificarPorcentaje(Tarea tarea, InformacionTarea informacionTarea, Long id) {
        var entidad = this.repositorioTareaJpa.findById(id).orElse(null);
        assert entidad != null;
        var entidadInformacionTarea = this.repositorioInformacionTareaJpa.findById(id).orElse(null);
        assert  entidadInformacionTarea != null;
        this.mapeadorTarea.actualizarPorcentajeEntidad(entidad,entidadInformacionTarea,informacionTarea);
        return this.repositorioTareaJpa.save(entidad).getIdTarea();
    }

    @Override
    public List<DtoTareaResumen> consultarPorIdActividadGestion(Long idActividadGestion, ETipoASE tipoASE) {
        var entidades = this.repositorioTareaJpa.findByIdASEAndTipoASE(idActividadGestion,tipoASE);
        return this.mapeadorTarea.listarDominio(entidades);
    }

    @Override
    public List<DtoTarea> consultarPorIdActividadGestionParaDuplicar(Long idActividadGestion, ETipoASE tipoASE) {
        var entidades = this.repositorioTareaJpa.findByIdASEAndTipoASE(idActividadGestion,tipoASE);
        return this.mapeadorTarea.obtenerTareaParaDuplicar(entidades);
    }

    @Override
    public List<DtoIdsTarea> consultarPorIdActividadGestionAEliminar(Long id) {
        List<EntidadTarea> entidades = this.repositorioTareaJpa.findByIdASEAndTipoASE(id,ETipoASE.ACTIVIDAD_GESTION);
        return this.mapeadorTarea.listarIds(entidades);
    }

    @Override
    public List<DtoTareaResumen> consultarPorIdSprint(Long idSprint, ETipoASE tipoASE) {
        List<EntidadTarea> entidades = this.repositorioTareaJpa.findByIdASEAndTipoASE(idSprint,tipoASE);
        return this.mapeadorTarea.listarDominio(entidades);
    }

    @Override
    public List<DtoTarea> consultarPorIdSprintParaDuplicar(Long idSprint, ETipoASE tipoASE) {
        List<EntidadTarea> entidades = this.repositorioTareaJpa.findByIdASEAndTipoASE(idSprint,tipoASE);
        return this.mapeadorTarea.obtenerTareaParaDuplicar(entidades);
    }

    @Override
    public List<DtoTareaResumen> consultarPorIdSprintProyectoArea(Long idSprintProyectoArea, ETipoASE tipoASE) {
        List<EntidadTarea> entidades = this.repositorioTareaJpa.findByIdASEAndTipoASE(idSprintProyectoArea,tipoASE);
        return this.mapeadorTarea.listarDominio(entidades);
    }

    @Override
    public List<DtoTarea> consultarPorIdSprintProyectoAreaParaDuplicar(Long idSprintProyectoArea, ETipoASE tipoASE) {
        List<EntidadTarea> entidades = this.repositorioTareaJpa.findByIdASEAndTipoASE(idSprintProyectoArea,tipoASE);
        return this.mapeadorTarea.obtenerTareaParaDuplicar(entidades);
    }

    @Override
    public List<DtoTareaResumen> consultarPorIdActividadGestionActvidadEstrategica(Long idActividadGestionActividadEstrategica, ETipoASE tipoASE) {
        List<EntidadTarea> entidades = this.repositorioTareaJpa.findByIdASEAndTipoASE(idActividadGestionActividadEstrategica,tipoASE);
        return this.mapeadorTarea.listarDominio(entidades);
    }

    @Override
    public List<DtoTarea> consultarPorIdActividadGestionActvidadEstrategicaParaDuplicar(Long idActividadGestionActividadEstrategica, ETipoASE tipoASE) {
        List<EntidadTarea> entidades = this.repositorioTareaJpa.findByIdASEAndTipoASE(idActividadGestionActividadEstrategica,tipoASE);
        return this.mapeadorTarea.obtenerTareaParaDuplicar(entidades);
    }

    @Override
    public List<DtoIdsTarea> consultarPorIdActividadGestionEstrategicaAEliminar(Long id) {
        List<EntidadTarea> entidades = this.repositorioTareaJpa.findByIdASEAndTipoASE(id,ETipoASE.ACTIVIDAD_GESTION_ACTIVIDAD_ESTRATEGICA);
        return this.mapeadorTarea.listarIds(entidades);
    }

    @Override
    public List<DocumentoTarea> consultarPorIdParaObtenerDocumento(Long id) {
        var entidad = this.repositorioDocumentoTareaJpa.findByIdTarea(id);
        assert entidad != null;
        return this.mapeadorDocumentoTarea.mapeadorListaDocumentos(entidad);
    }

    @Override
    public Long guardarDocumento(DocumentoTarea documentoTarea, Long codigo) {
        var docTarea = this.mapeadorDocumentoTarea.mapeadorEntidadDocumento(documentoTarea,codigo);
        return this.repositorioDocumentoTareaJpa.save(docTarea).getIdDocumentoTarea();
    }

    @Override
    public boolean existeDocumento(DocumentoTarea documentoTarea) {
        return this.repositorioDocumentoTareaJpa.findById(documentoTarea.getIdTarea()).isPresent();
    }
    @Override
    public Long modificarDocumento(DocumentoTarea documentoTarea, Long id) {
        var entidad = mapeadorDocumentoTarea.obtenerEntidadDocumento(id);
        this.mapeadorDocumentoTarea.actualizarEntidad(entidad, documentoTarea);
        return this.repositorioDocumentoTareaJpa.save(entidad).getIdDocumentoTarea();
    }
    @Override
    public Long eliminarDocumento(Long id) {
        this.repositorioDocumentoTareaJpa.deleteById(id);
        return id;
    }
}
