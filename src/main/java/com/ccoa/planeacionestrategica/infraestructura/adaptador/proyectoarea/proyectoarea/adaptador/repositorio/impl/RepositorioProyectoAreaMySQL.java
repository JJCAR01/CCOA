package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.dto.DtoProyectoAreaResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.DetalleProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.InformacionProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.ProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.documento.DocumentoProyectoArea;
import com.ccoa.planeacionestrategica.dominio.puerto.proyectoarea.RepositorioProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.entidad.EntidadProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.mapeador.MapeadorDetalleProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.mapeador.documento.MapeadorDocumentoProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.mapeador.MapeadorInformacionProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.mapeador.MapeadorProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.repositorio.jpa.RepositorioDetalleProyectoAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.repositorio.jpa.RepositorioDocumentoProyectoAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.repositorio.jpa.RepositorioInformacionProyectoAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.repositorio.jpa.RepositorioProyectoAreaJpa;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioProyectoAreaMySQL implements RepositorioProyectoArea {
    private final RepositorioProyectoAreaJpa repositorioProyectoAreaJpa;
    private final RepositorioDocumentoProyectoAreaJpa repositorioDocumentoProyectoAreaJpa;
    private final MapeadorDocumentoProyectoArea mapeadorDocumentoProyectoArea;
    private final RepositorioInformacionProyectoAreaJpa repositorioInformacionProyectoAreaJpa;
    private final MapeadorProyectoArea mapeadorProyectoArea;
    private final MapeadorInformacionProyectoArea mapeadorInformacionProyectoArea;
    private final MapeadorDetalleProyectoArea mapeadorDetalleProyectoArea;
    private final RepositorioDetalleProyectoAreaJpa repositorioDetalleProyectoAreaJpa;
    public RepositorioProyectoAreaMySQL(RepositorioProyectoAreaJpa repositorioProyectoAreaJpa, RepositorioDocumentoProyectoAreaJpa repositorioDocumentoProyectoAreaJpa, MapeadorDocumentoProyectoArea mapeadorDocumentoProyectoArea, RepositorioInformacionProyectoAreaJpa repositorioInformacionProyectoAreaJpa,
                                            MapeadorProyectoArea mapeadorProyectoArea, MapeadorInformacionProyectoArea mapeadorInformacionProyectoArea, MapeadorDetalleProyectoArea mapeadorDetalleProyectoArea, RepositorioDetalleProyectoAreaJpa repositorioDetalleProyectoAreaJpa) {
        this.repositorioProyectoAreaJpa = repositorioProyectoAreaJpa;
        this.repositorioDocumentoProyectoAreaJpa = repositorioDocumentoProyectoAreaJpa;
        this.mapeadorDocumentoProyectoArea = mapeadorDocumentoProyectoArea;
        this.repositorioInformacionProyectoAreaJpa = repositorioInformacionProyectoAreaJpa;
        this.mapeadorProyectoArea = mapeadorProyectoArea;
        this.mapeadorInformacionProyectoArea = mapeadorInformacionProyectoArea;
        this.mapeadorDetalleProyectoArea = mapeadorDetalleProyectoArea;
        this.repositorioDetalleProyectoAreaJpa = repositorioDetalleProyectoAreaJpa;
    }

    @Override
    public List<DtoProyectoAreaResumen> listar() {
        var entidad = this.repositorioProyectoAreaJpa.findAll();
        return this.mapeadorProyectoArea.listarDominio(entidad);
    }

    @Override
    public DtoProyectoAreaResumen consultarPorId(Long id) {
        var entidad = this.repositorioProyectoAreaJpa.findById(id).orElse(null);
        var entidadInf = this.repositorioInformacionProyectoAreaJpa.findById(id).orElse(null);
        var entidadDetalle = this.repositorioDetalleProyectoAreaJpa.findById(id).orElse(null);
        assert entidad != null;
        assert entidadInf != null;
        assert entidadDetalle != null;
        return this.mapeadorProyectoArea.mapeadorDominioProyectoArea(entidad,entidadDetalle,entidadInf);
    }

    @Override
    public Long guardar(ProyectoArea proyectoArea, InformacionProyectoArea informacionProyectoArea, DetalleProyectoArea detalleProyectoArea) {
        var proyectoAreaEntidad = this.mapeadorProyectoArea.mapeadorEntidad(proyectoArea);
        var idProyectoArea = this.repositorioProyectoAreaJpa.save(proyectoAreaEntidad).getIdProyectoArea();

        var informacionProyectoAreaEntidad = this.mapeadorInformacionProyectoArea.mapeadorEntidad(informacionProyectoArea);
        informacionProyectoAreaEntidad.setIdInformacionProyectoArea(idProyectoArea);
        this.repositorioInformacionProyectoAreaJpa.save(informacionProyectoAreaEntidad);

        var detalleProyectoAreaEntidad = this.mapeadorDetalleProyectoArea.mapeadorEntidad(detalleProyectoArea);
        detalleProyectoAreaEntidad.setIdDetalleProyectoArea(idProyectoArea);
        mapeadorDetalleProyectoArea.actualizarPorcentajeAvance(detalleProyectoAreaEntidad,idProyectoArea);
        this.repositorioDetalleProyectoAreaJpa.save(detalleProyectoAreaEntidad);

        return idProyectoArea;
    }

    @Override
    public boolean existe(ProyectoArea proyectoArea) {
        return this.repositorioProyectoAreaJpa.findByNombre(proyectoArea.getNombre())!=null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioInformacionProyectoAreaJpa.deleteById(id);
        this.repositorioProyectoAreaJpa.deleteById(id);
        this.repositorioDetalleProyectoAreaJpa.deleteById(id);
        return id;
    }
    @Transactional
    @Override
    public Long eliminarPorPat(Long id) {
        var entidades = consultarPorIdPatAEliminar(id);
        entidades.forEach(entidad -> repositorioInformacionProyectoAreaJpa.deleteById(entidad.getIdInformacionProyectoArea()));
        entidades.forEach(entidad -> repositorioDetalleProyectoAreaJpa.deleteById(entidad.getIdProyectoArea()));
        repositorioProyectoAreaJpa.deleteByIdPat(id);
        return id;
    }

    @Override
    public Long modificar(ProyectoArea proyectoArea, InformacionProyectoArea informacionProyectoArea, DetalleProyectoArea detalleProyectoArea, Long id) {
        var entidad = this.repositorioProyectoAreaJpa.findById(id).orElse(null);
        var entidadInf = this.repositorioInformacionProyectoAreaJpa.findById(id).orElse(null);
        var entidadDetalle= this.repositorioDetalleProyectoAreaJpa.findById(id).orElse(null);
        assert entidad != null;
        assert entidadInf != null;
        assert entidadDetalle != null;
        this.mapeadorProyectoArea.actualizarEntidad(entidad, proyectoArea,entidadInf,informacionProyectoArea,entidadDetalle);
        this.repositorioInformacionProyectoAreaJpa.save(entidadInf);
        this.repositorioProyectoAreaJpa.save(entidad);
        this.mapeadorDetalleProyectoArea.actualizarPorcentajeAvance(entidadDetalle,id);
        return id;
    }
    @Override
    public Long modificarValorEjecutado(ProyectoArea proyectoArea, Long id) {
        var entidad = this.repositorioProyectoAreaJpa.findById(id).orElse(null);
        assert entidad != null;
        this.mapeadorProyectoArea.actualizarValorEjecutado(entidad, proyectoArea);
        return this.repositorioProyectoAreaJpa.save(entidad).getIdProyectoArea();
    }

    @Override
    public List<DtoProyectoAreaResumen> consultarPorIdPat(Long id) {
        List<EntidadProyectoArea> entidades = this.repositorioProyectoAreaJpa.findByIdPat(id);
        return this.mapeadorProyectoArea.listarDominio(entidades);
    }

    public List<DtoIdsProyectoArea> consultarPorIdPatAEliminar(Long id) {
        List<EntidadProyectoArea> entidades = this.repositorioProyectoAreaJpa.findByIdPat(id);
        return this.mapeadorProyectoArea.listarIds(entidades);
    }

    @Override
    public Long guardarDocumento(DocumentoProyectoArea documentoProyectoArea, Long codigo) {
        var documento = this.mapeadorDocumentoProyectoArea.mapeadorEntidadDocumento(documentoProyectoArea,codigo);
        return this.repositorioDocumentoProyectoAreaJpa.save(documento).getIdDocumentoProyectoArea();
    }

    @Override
    public boolean existeDocumento(DocumentoProyectoArea documentoProyectoArea) {
        return this.repositorioDocumentoProyectoAreaJpa.findById(documentoProyectoArea.getIdProyectoArea()).isPresent();
    }

    @Override
    public List<DocumentoProyectoArea> consultarPorIdParaObtenerDocumento(Long id) {
        var entidad = this.repositorioDocumentoProyectoAreaJpa.findByIdProyectoArea(id);
        assert entidad != null;
        return this.mapeadorDocumentoProyectoArea.mapeadorListaDocumentos(entidad);
    }
    @Override
    public Long modificarDocumento(DocumentoProyectoArea documentoProyectoArea, Long id) {
        var entidad = mapeadorDocumentoProyectoArea.obtenerEntidadDocumento(id);
        this.mapeadorDocumentoProyectoArea.actualizarEntidad(entidad, documentoProyectoArea);
        return this.repositorioDocumentoProyectoAreaJpa.save(entidad).getIdDocumentoProyectoArea();
    }
    @Override
    public Long eliminarDocumento(Long id) {
        this.repositorioDocumentoProyectoAreaJpa.deleteById(id);
        return id;
    }
}
