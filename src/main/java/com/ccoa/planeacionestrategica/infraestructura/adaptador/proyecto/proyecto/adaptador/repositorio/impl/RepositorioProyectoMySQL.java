package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoProyecto;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsProyecto;
import com.ccoa.planeacionestrategica.dominio.dto.DtoProyectoResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.DetalleProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.Proyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.documento.DocumentoProyecto;
import com.ccoa.planeacionestrategica.dominio.puerto.proyecto.RepositorioProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.entidad.EntidadProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.mapeador.MapeadorDetalleProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.mapeador.documento.MapeadorDocumentoProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.mapeador.MapeadorProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.repositorio.jpa.RepositorioDocumentoProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.repositorio.jpa.RepositorioInformacionProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.repositorio.jpa.RepositorioProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.mapeador.MapeadorInformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.repositorio.jpa.RepositorioDetalleProyectoJpa;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioProyectoMySQL implements RepositorioProyecto {
    private final RepositorioProyectoJpa repositorioProyectoJpa;
    private final RepositorioDocumentoProyectoJpa repositorioDocumentoProyectoJpa;
    private final MapeadorDocumentoProyecto mapeadorDocumentoProyecto;
    private final RepositorioInformacionProyectoJpa repositorioInformacionProyectoJpa;
    private final MapeadorProyecto mapeadorProyecto;
    private final MapeadorInformacionProyecto mapeadorInformacionProyecto;
    private final MapeadorDetalleProyecto mapeadorDetalleProyecto;
    private final RepositorioDetalleProyectoJpa repositorioDetalleProyectoJpa;
    public RepositorioProyectoMySQL(RepositorioProyectoJpa repositorioProyectoJpa, RepositorioDocumentoProyectoJpa repositorioDocumentoProyectoJpa, MapeadorDocumentoProyecto mapeadorDocumentoProyecto, RepositorioInformacionProyectoJpa repositorioInformacionProyectoJpa,
                                    MapeadorProyecto mapeadorProyecto, MapeadorInformacionProyecto mapeadorInformacionProyecto, MapeadorDetalleProyecto mapeadorDetalleProyecto, RepositorioDetalleProyectoJpa repositorioDetalleProyectoJpa) {
        this.repositorioProyectoJpa = repositorioProyectoJpa;
        this.repositorioDocumentoProyectoJpa = repositorioDocumentoProyectoJpa;
        this.mapeadorDocumentoProyecto = mapeadorDocumentoProyecto;
        this.repositorioInformacionProyectoJpa = repositorioInformacionProyectoJpa;
        this.mapeadorProyecto = mapeadorProyecto;
        this.mapeadorInformacionProyecto = mapeadorInformacionProyecto;
        this.mapeadorDetalleProyecto = mapeadorDetalleProyecto;
        this.repositorioDetalleProyectoJpa = repositorioDetalleProyectoJpa;
    }

    @Override
    public List<DtoProyectoResumen> listar() {
        var entidad = this.repositorioProyectoJpa.findAll();
        return this.mapeadorProyecto.listarDominio(entidad);
    }

    @Override
    public DtoProyectoResumen consultarPorId(Long id) {
        var entidad = this.repositorioProyectoJpa.findById(id).orElse(null);
        var entidadInf = this.repositorioInformacionProyectoJpa.findById(id).orElse(null);
        var entidadDetalle = this.repositorioDetalleProyectoJpa.findById(id).orElse(null);
        assert entidad != null;
        assert entidadInf != null;
        assert entidadDetalle != null;
        return this.mapeadorProyecto.mapeadorDominioProyecto(entidad,entidadDetalle,entidadInf);
    }

    @Override
    public Long guardar(Proyecto proyecto, InformacionProyecto informacionProyecto,DetalleProyecto detalleProyecto) {
        var proyectoEntidad = this.mapeadorProyecto.mapeadorEntidad(proyecto);
        var idProyecto = this.repositorioProyectoJpa.save(proyectoEntidad).getIdProyecto();

        var informacionProyectoEntidad = this.mapeadorInformacionProyecto.mapeadorEntidad(informacionProyecto);
        informacionProyectoEntidad.setIdInformacionProyecto(idProyecto);
        this.repositorioInformacionProyectoJpa.save(informacionProyectoEntidad);

        var detalleProyectoEntidad = this.mapeadorDetalleProyecto.mapeadorEntidad(detalleProyecto);
        detalleProyectoEntidad.setIdDetalleProyecto(idProyecto);
        mapeadorDetalleProyecto.actualizarPorcentajeAvance(detalleProyectoEntidad,idProyecto);
        this.repositorioDetalleProyectoJpa.save(detalleProyectoEntidad);

        return idProyecto;
    }

    @Override
    public boolean existe(Proyecto proyecto) {
        return this.repositorioProyectoJpa.findByNombre(proyecto.getNombre())!=null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioInformacionProyectoJpa.deleteById(id);
        this.repositorioProyectoJpa.deleteById(id);
        this.repositorioDetalleProyectoJpa.deleteById(id);
        return id;
    }
    @Transactional
    @Override
    public void eliminarPorActividadEstrategica(Long id) {
        var entidades = consultarPorIdActividadEstrategicaAEliminar(id);
        entidades.forEach(entidad -> repositorioInformacionProyectoJpa.deleteById(entidad.getIdInformacionProyecto()));
        entidades.forEach(entidad -> repositorioDetalleProyectoJpa.deleteById(entidad.getIdProyecto()));
        repositorioProyectoJpa.deleteByIdActividadEstrategica(id);
    }

    @Override
    public Long modificar(Proyecto proyecto, InformacionProyecto informacionProyecto, DetalleProyecto detalleProyecto, Long id) {
        var entidad = this.repositorioProyectoJpa.findById(id).orElse(null);
        var entidadInf = this.repositorioInformacionProyectoJpa.findById(id).orElse(null);
        var entidadDetalle = this.repositorioDetalleProyectoJpa.findById(id).orElse(null);
        assert entidad != null;
        assert entidadInf != null;
        assert entidadDetalle != null;
        this.mapeadorProyecto.actualizarEntidad(entidad, proyecto,entidadInf,informacionProyecto,entidadDetalle);
        this.repositorioInformacionProyectoJpa.save(entidadInf);
        this.repositorioProyectoJpa.save(entidad);
        this.mapeadorDetalleProyecto.actualizarPorcentajeAvance(entidadDetalle,id);
        return id;
    }

    @Override
    public Long modificarValorEjecutado(Proyecto proyecto, Long id) {
        var entidad = this.repositorioProyectoJpa.findById(id).orElse(null);
        assert entidad != null;
        this.mapeadorProyecto.actualizarValorEjecutado(entidad, proyecto);
        return this.repositorioProyectoJpa.save(entidad).getIdProyecto();
    }

    @Override
    public List<DtoProyectoResumen> consultarPorIdActividadEstrategica(Long id) {
        List<EntidadProyecto> entidades = this.repositorioProyectoJpa.findByIdActividadEstrategica(id);
        return this.mapeadorProyecto.listarDominio(entidades);
    }

    @Override
    public List<DtoProyecto> consultarPorIdActividadEstrategicaParaDuplicar(Long id) {
        List<EntidadProyecto> entidades = this.repositorioProyectoJpa.findByIdActividadEstrategica(id);
        return this.mapeadorProyecto.obtenerProyectoParaDuplicar(entidades);
    }

    public List<DtoIdsProyecto> consultarPorIdActividadEstrategicaAEliminar(Long id) {
        List<EntidadProyecto> entidades = this.repositorioProyectoJpa.findByIdActividadEstrategica(id);
        return this.mapeadorProyecto.listarIds(entidades);
    }

    @Override
    public Long guardarDocumento(DocumentoProyecto documentoProyecto, Long codigo) {
        var documento = this.mapeadorDocumentoProyecto.mapeadorEntidadDocumento(documentoProyecto,codigo);
        return this.repositorioDocumentoProyectoJpa.save(documento).getIdDocumentoProyecto();
    }

    @Override
    public boolean existeDocumento(DocumentoProyecto documentoProyecto) {
        return this.repositorioDocumentoProyectoJpa.findById(documentoProyecto.getIdProyecto()).isPresent();
    }

    @Override
    public List<DocumentoProyecto> consultarPorIdParaObtenerDocumento(Long id) {
        var entidad = this.repositorioDocumentoProyectoJpa.findByIdProyecto(id);
        assert entidad != null;
        return this.mapeadorDocumentoProyecto.mapeadorListaDocumentos(entidad);
    }

    @Override
    public Long modificarDocumento(DocumentoProyecto documentoProyecto, Long id) {
        var entidad = mapeadorDocumentoProyecto.obtenerEntidadDocumento(id);
        this.mapeadorDocumentoProyecto.actualizarEntidad(entidad, documentoProyecto);
        return this.repositorioDocumentoProyectoJpa.save(entidad).getIdDocumentoProyecto();
    }
    @Override
    public Long eliminarDocumento(Long id) {
        this.repositorioDocumentoProyectoJpa.deleteById(id);
        return id;
    }
}
