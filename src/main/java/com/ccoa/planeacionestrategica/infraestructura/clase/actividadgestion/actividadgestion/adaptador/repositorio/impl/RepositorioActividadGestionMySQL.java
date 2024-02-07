package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.actividadgestion.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadGestionResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.ActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.documento.DocumentoActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.InformacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestion.RepositorioActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.actividadgestion.adaptador.entidad.EntidadActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.actividadgestion.adaptador.mapeador.MapeadorDocumentoActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.actividadgestion.adaptador.repositorio.jpa.RepositorioActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.actividadgestion.adaptador.repositorio.jpa.RepositorioDocumentoActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.actividadgestion.adaptador.mapeador.MapeadorActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.actividadgestion.adaptador.mapeador.MapeadorInformacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.actividadgestion.adaptador.repositorio.jpa.RepositorioInformacionActividadGestionJpa;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RepositorioActividadGestionMySQL implements RepositorioActividadGestion {

    private final RepositorioActividadGestionJpa repositorioActividadGestionJpa;
    private final RepositorioInformacionActividadGestionJpa repositorioInformacionActividadGestionJpa;
    private final MapeadorActividadGestion mapeadorActividadGestion;
    private final MapeadorInformacionActividadGestion mapeadorInformacionActividadGestion;
    private final RepositorioDocumentoActividadGestionJpa repositorioDocumentoActividadGestionJpa;
    private final MapeadorDocumentoActividadGestion mapeadorDocumentoActividadGestion;
    public RepositorioActividadGestionMySQL(RepositorioActividadGestionJpa repositorioActividadGestionJpa,
                                            RepositorioInformacionActividadGestionJpa repositorioInformacionActividadGestionJpa, MapeadorActividadGestion mapeadorActividadGestion, MapeadorInformacionActividadGestion mapeadorInformacionActividadGestion, RepositorioDocumentoActividadGestionJpa repositorioDocumentoActividadGestionJpa, MapeadorDocumentoActividadGestion mapeadorDocumentoActividadGestion) {
        this.repositorioActividadGestionJpa = repositorioActividadGestionJpa;
        this.repositorioInformacionActividadGestionJpa = repositorioInformacionActividadGestionJpa;
        this.mapeadorActividadGestion = mapeadorActividadGestion;
        this.mapeadorInformacionActividadGestion = mapeadorInformacionActividadGestion;
        this.repositorioDocumentoActividadGestionJpa = repositorioDocumentoActividadGestionJpa;
        this.mapeadorDocumentoActividadGestion = mapeadorDocumentoActividadGestion;
    }

    @Override
    public List<DtoActividadGestionResumen> listar() {
        var entidad = this.repositorioActividadGestionJpa.findAll();
        return this.mapeadorActividadGestion.listarDominio(entidad);
    }

    @Override
    public DocumentoActividadGestion consultarPorIdParaObtenerDocumento(Long id) {
        var entidad = this.repositorioDocumentoActividadGestionJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorDocumentoActividadGestion.mapeadorDominio(entidad);
    }

    @Override
    public ActividadGestion consultarPorId(Long id) {
        var entidad = this.repositorioActividadGestionJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorActividadGestion.mapeadorDominio(entidad);
    }

    @Override
    public Long guardar(ActividadGestion actividadGestion, InformacionActividadGestion informacionActividadGestion) {
        var actividadEntidad = this.mapeadorActividadGestion.mapeadorEntidad(actividadGestion);
        var informacionActividadEntidad = this.mapeadorInformacionActividadGestion.mapeadorEntidad(informacionActividadGestion);
        this.mapeadorInformacionActividadGestion.actualizarPorcentajeAvance(informacionActividadEntidad,informacionActividadGestion);
        var id = this.repositorioActividadGestionJpa.save(actividadEntidad).getIdActividadGestion();
        informacionActividadEntidad.setIdInformacionActividadGestion(id);
        return this.repositorioInformacionActividadGestionJpa.save(informacionActividadEntidad).getIdInformacionActividadGestion();
    }

    @Override
    public Long guardarDocumento(DocumentoActividadGestion documentoActividadGestion, Long codigo) {
        var documento = this.mapeadorDocumentoActividadGestion.mapeadorEntidadDocumento(documentoActividadGestion,codigo);
        return this.repositorioDocumentoActividadGestionJpa.save(documento).getIdDocumentoActividadGestion();
    }

    @Override
    public boolean existe(ActividadGestion actividadGestion) {
        return this.repositorioActividadGestionJpa.findByNombre(actividadGestion.getNombre())!=null;
    }

    @Override
    public boolean existeDocumento(DocumentoActividadGestion documentoActividadGestion) {
        return this.repositorioDocumentoActividadGestionJpa.findById(documentoActividadGestion.getIdRutaDocumentoActividadGestion()).isPresent();
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioActividadGestionJpa.deleteById(id);
        this.repositorioInformacionActividadGestionJpa.deleteById(id);
        return id;
    }
    @Transactional
    @Override
    public Long eliminarPorPat(Long id) {
        var entidades = consultarPorIdPatAEliminar(id);
        entidades.forEach(entidad -> repositorioInformacionActividadGestionJpa.deleteById(entidad.getIdInformacionActividadGestion()));
        this.repositorioActividadGestionJpa.deleteByIdPat(id);
        return null;
    }

    @Override
    public Long modificar(ActividadGestion actividadGestion,InformacionActividadGestion informacionActividadGestion, Long id) {
        var entidad = this.repositorioActividadGestionJpa.findById(id).orElse(null);
        var entidadInf = this.repositorioInformacionActividadGestionJpa.findById(id).orElse(null);
        assert entidad != null;
        assert entidadInf != null;
        this.mapeadorActividadGestion.actualizarEntidad(entidad, actividadGestion,entidadInf,informacionActividadGestion);
        this.repositorioInformacionActividadGestionJpa.save(entidadInf);
        return this.repositorioActividadGestionJpa.save(entidad).getIdActividadGestion();
    }

    @Override
    public List<DtoActividadGestionResumen> consultarPorIdPat(Long idPat) {
        List<EntidadActividadGestion> entidades = this.repositorioActividadGestionJpa.findByIdPat(idPat);
        return this.mapeadorActividadGestion.listarDominio(entidades);
    }

    @Override
    public List<DtoIdsActividadGestion> consultarPorIdPatAEliminar(Long idPat) {
        List<EntidadActividadGestion> entidades = this.repositorioActividadGestionJpa.findByIdPat(idPat);
        return this.mapeadorActividadGestion.listarPorIds(entidades);
    }
}
