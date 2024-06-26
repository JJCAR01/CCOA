package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoActividadGestion;
import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadGestionResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.ActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.documento.DocumentoActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.InformacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestion.RepositorioActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.mapeador.MapeadorActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.mapeador.documento.MapeadorDocumentoActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.mapeador.MapeadorInformacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.repositorio.jpa.RepositorioDocumentoActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.entidad.EntidadActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.repositorio.jpa.RepositorioActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.repositorio.jpa.RepositorioInformacionActividadGestionJpa;
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
    public List<DocumentoActividadGestion> consultarPorIdParaObtenerDocumento(Long id) {
        var entidad = this.repositorioDocumentoActividadGestionJpa.findByIdActividadGestion(id);
        assert entidad != null;
        return this.mapeadorDocumentoActividadGestion.mapeadorListaDocumentos(entidad);
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
        var id = this.repositorioActividadGestionJpa.save(actividadEntidad).getIdActividadGestion();
        this.mapeadorInformacionActividadGestion.actualizarPorcentajeAvance(informacionActividadEntidad,id);
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
        return this.repositorioDocumentoActividadGestionJpa.findById(documentoActividadGestion.getIdActividadGestion()).isPresent();
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioActividadGestionJpa.deleteById(id);
        this.repositorioInformacionActividadGestionJpa.deleteById(id);
        return id;
    }
    @Transactional
    @Override
    public void eliminarPorPat(Long id) {
        var entidades = consultarPorIdPatAEliminar(id);
        entidades.forEach(entidad -> repositorioInformacionActividadGestionJpa.deleteById(entidad.getIdInformacionActividadGestion()));
        this.repositorioActividadGestionJpa.deleteByIdPat(id);
    }

    @Override
    public Long modificar(ActividadGestion actividadGestion,InformacionActividadGestion informacionActividadGestion, Long id) {
        var entidad = this.repositorioActividadGestionJpa.findById(id).orElse(null);
        var entidadInf = this.repositorioInformacionActividadGestionJpa.findById(id).orElse(null);
        assert entidad != null;
        assert entidadInf != null;
        this.mapeadorActividadGestion.actualizarEntidad(entidad, actividadGestion,entidadInf,informacionActividadGestion);
        this.repositorioInformacionActividadGestionJpa.save(entidadInf);
        this.repositorioActividadGestionJpa.save(entidad);
        this.mapeadorInformacionActividadGestion.actualizarPorcentajeAvance(entidadInf,id);
        return id;
    }

    @Override
    public List<DtoActividadGestionResumen> consultarPorIdPat(Long idPat) {
        List<EntidadActividadGestion> entidades = this.repositorioActividadGestionJpa.findByIdPat(idPat);
        return this.mapeadorActividadGestion.listarDominio(entidades);
    }

    @Override
    public List<DtoActividadGestion> consultarPorIdPatParaDuplicar(Long idPat) {
        List<EntidadActividadGestion> entidades = this.repositorioActividadGestionJpa.findByIdPat(idPat);
        return this.mapeadorActividadGestion.obtenerActividadesGestionParaDuplicar(entidades);
    }

    @Override
    public List<DtoIdsActividadGestion> consultarPorIdPatAEliminar(Long idPat) {
        List<EntidadActividadGestion> entidades = this.repositorioActividadGestionJpa.findByIdPat(idPat);
        return this.mapeadorActividadGestion.listarPorIds(entidades);
    }

    @Override
    public Long modificarDocumento(DocumentoActividadGestion documentoActividadGestion, Long id) {
        var entidad = mapeadorDocumentoActividadGestion.obtenerEntidadDocumento(id);
        this.mapeadorDocumentoActividadGestion.actualizarEntidad(entidad, documentoActividadGestion);
        return this.repositorioDocumentoActividadGestionJpa.save(entidad).getIdActividadGestion();
    }

    @Override
    public Long eliminarDocumento(Long id) {
        this.repositorioDocumentoActividadGestionJpa.deleteById(id);
        return id;
    }
}
