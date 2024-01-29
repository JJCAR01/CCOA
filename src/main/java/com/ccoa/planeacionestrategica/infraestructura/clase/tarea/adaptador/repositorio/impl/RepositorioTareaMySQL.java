package com.ccoa.planeacionestrategica.infraestructura.clase.tarea.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.dto.DtoTareaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.InformacionTarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.Tarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.ETipoASE;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTarea;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.adaptador.entidad.EntidadTarea;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.adaptador.mapeador.MapeadorInformacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.adaptador.mapeador.MapeadorTarea;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.adaptador.repositorio.jpa.RepositorioInformacionTareaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.adaptador.repositorio.jpa.RepositorioTareaJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioTareaMySQL implements RepositorioTarea {

    private final RepositorioTareaJpa repositorioTareaJpa;
    private final RepositorioInformacionTareaJpa repositorioInformacionTareaJpa;
    private final MapeadorTarea mapeadorTarea;
    private final MapeadorInformacionTarea mapeadorInformacionTarea;

    public RepositorioTareaMySQL(RepositorioTareaJpa repositorioTareaJpa, RepositorioInformacionTareaJpa repositorioInformacionTareaJpa, MapeadorTarea mapeadorTarea, MapeadorInformacionTarea mapeadorInformacionTarea) {
        this.repositorioTareaJpa = repositorioTareaJpa;
        this.repositorioInformacionTareaJpa = repositorioInformacionTareaJpa;
        this.mapeadorTarea = mapeadorTarea;
        this.mapeadorInformacionTarea = mapeadorInformacionTarea;
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
        var entidad = this.repositorioTareaJpa.findById(id).orElse(null);
        assert entidad != null;
        this.mapeadorTarea.actualizarEstadoEntidad(tareaEntidad,tarea,entidadInformacionTarea,informacionTarea);
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
        this.repositorioTareaJpa.deleteById(id);
        return id;
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
        this.mapeadorTarea.actualizarEstadoEntidad(entidad, tarea,entidadInformacionTarea,informacionTarea);
        return this.repositorioTareaJpa.save(entidad).getIdTarea();
    }

    @Override
    public List<DtoTareaResumen> consultarPorIdActividadGestion(Long idActividadGestion, ETipoASE tipoASE) {
        var entidades = this.repositorioTareaJpa.findByIdASEAndTipoASE(idActividadGestion,tipoASE);
        return this.mapeadorTarea.listarDominio(entidades);
    }

    @Override
    public List<DtoTareaResumen> consultarPorIdSprint(Long idSprint, ETipoASE tipoASE) {
        List<EntidadTarea> entidades = this.repositorioTareaJpa.findByIdASEAndTipoASE(idSprint,tipoASE);
        return this.mapeadorTarea.listarDominio(entidades);
    }

    @Override
    public List<DtoTareaResumen> consultarPorIdActividadGestionActvidadEstrategica(Long idActividadGestionActividadEstrategica, ETipoASE tipoASE) {
        List<EntidadTarea> entidades = this.repositorioTareaJpa.findByIdASEAndTipoASE(idActividadGestionActividadEstrategica,tipoASE);
        return this.mapeadorTarea.listarDominio(entidades);
    }
}
