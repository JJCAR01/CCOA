package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.ActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.InformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.documento.DocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadestrategica.RepositorioActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.mapeador.MapeadorDocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.mapeador.MapeadorInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.mapeador.MapeadorActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioDocumentoActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadEstrategicaJpa;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioActividadEstrategicaMySQL implements RepositorioActividadEstrategica {
    private final RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa;
    private final RepositorioDocumentoActividadEstrategicaJpa repositorioDocumentoActividadEstrategicaJpa;
    private final RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa;
    private final MapeadorActividadEstrategica mapeadorActividadEstrategica;
    private final MapeadorDocumentoActividadEstrategica mapeadorDocumentoActividadEstrategica;
    private final MapeadorInformacionActividadEstrategica mapeadorInformacionActividadEstrategica;

    public RepositorioActividadEstrategicaMySQL(RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa, RepositorioDocumentoActividadEstrategicaJpa repositorioDocumentoActividadEstrategicaJpa, RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa,
                                                MapeadorActividadEstrategica mapeadorActividadEstrategica, MapeadorDocumentoActividadEstrategica mapeadorDocumentoActividadEstrategica, MapeadorInformacionActividadEstrategica mapeadorInformacionActividadEstrategica) {
        this.repositorioActividadEstrategicaJpa = repositorioActividadEstrategicaJpa;
        this.repositorioDocumentoActividadEstrategicaJpa = repositorioDocumentoActividadEstrategicaJpa;
        this.repositorioInformacionActividadEstrategicaJpa = repositorioInformacionActividadEstrategicaJpa;
        this.mapeadorActividadEstrategica = mapeadorActividadEstrategica;
        this.mapeadorDocumentoActividadEstrategica = mapeadorDocumentoActividadEstrategica;
        this.mapeadorInformacionActividadEstrategica = mapeadorInformacionActividadEstrategica;
    }

    @Override
    public List<DtoActividadEstrategicaResumen> listar() {
        var entidad = this.repositorioActividadEstrategicaJpa.findAll();
        return this.mapeadorActividadEstrategica.listarDominio(entidad);
    }


    @Override
    public DtoActividadEstrategicaResumen consultarPorId(Long id) {
        var entidad = this.repositorioActividadEstrategicaJpa.findById(id).orElse(null);
        var entidadInf = this.repositorioInformacionActividadEstrategicaJpa.findById(id).orElse(null);
        assert entidad != null;
        assert entidadInf != null;
        return this.mapeadorActividadEstrategica.listarDominioPorId(entidad,entidadInf);
    }

    @Override
    public Long guardar(ActividadEstrategica actividadEstrategica, InformacionActividadEstrategica informacionActividadEstrategica) {
        var entidad = this.mapeadorActividadEstrategica.mapeadorEntidad(actividadEstrategica);
        var idActividad = this.repositorioActividadEstrategicaJpa.save(entidad).getIdActividadEstrategica();
        var informacionGestionEntidad = this.mapeadorInformacionActividadEstrategica.mapeadorEntidad(informacionActividadEstrategica);

        informacionGestionEntidad.setIdInformacionActividadEstrategica(idActividad);
        mapeadorInformacionActividadEstrategica.actualizarPorcentajeAvance(informacionGestionEntidad,idActividad);
        this.repositorioInformacionActividadEstrategicaJpa.save(informacionGestionEntidad);
        return idActividad;
    }

    @Override
    public boolean existe(ActividadEstrategica actividadEstrategica) {
        return this.repositorioActividadEstrategicaJpa.findByNombre(actividadEstrategica.getNombre())!=null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioInformacionActividadEstrategicaJpa.deleteById(id);
        this.repositorioActividadEstrategicaJpa.deleteById(id);
        return id;
    }

    @Transactional
    @Override
    public Long eliminarPorPat(Long id) {
        var entidades = consultarPorIdPatAEliminar(id);
        entidades.forEach(entidad -> repositorioInformacionActividadEstrategicaJpa.deleteById(entidad.getIdActividadEstrategica()));
        repositorioActividadEstrategicaJpa.deleteByIdPat(id);
        return id;
    }

    @Override
    public Long modificar(ActividadEstrategica actividadEstrategica,InformacionActividadEstrategica informacionActividadEstrategica, Long id) {
        var entidad = this.repositorioActividadEstrategicaJpa.findById(id).orElse(null);
        var entidadInf = this.repositorioInformacionActividadEstrategicaJpa.findById(id).orElse(null);
        assert entidad != null;
        assert entidadInf != null;
        this.mapeadorActividadEstrategica.actualizarEntidad(entidad, actividadEstrategica,entidadInf,informacionActividadEstrategica);
        this.repositorioInformacionActividadEstrategicaJpa.save(entidadInf);
        return this.repositorioActividadEstrategicaJpa.save(entidad).getIdActividadEstrategica();
    }

    @Override
    public List<DtoActividadEstrategicaResumen> consultarPorIdPat(Long idPat) {
        List<EntidadActividadEstrategica> entidades = this.repositorioActividadEstrategicaJpa.findByIdPat(idPat);
        return this.mapeadorActividadEstrategica.listarDominio(entidades);
    }

    @Override
    public List<DtoIdsActividadEstrategica> consultarPorIdPatAEliminar(Long idPat) {
        List<EntidadActividadEstrategica> entidades = this.repositorioActividadEstrategicaJpa.findByIdPat(idPat);
        return this.mapeadorActividadEstrategica.listarPorIds(entidades);
    }

    @Override
    public Long guardarDocumento(DocumentoActividadEstrategica documentoActividadEstrategica, Long codigo) {
        var documento = this.mapeadorDocumentoActividadEstrategica.mapeadorEntidadDocumento(documentoActividadEstrategica,codigo);
        return this.repositorioDocumentoActividadEstrategicaJpa.save(documento).getIdDocumentoActividadEstrategica();
    }

    @Override
    public boolean existeDocumento(DocumentoActividadEstrategica documentoActividadEstrategica) {
        return this.repositorioDocumentoActividadEstrategicaJpa.findById(documentoActividadEstrategica.getIdRutaDocumentoActividadEstrategica()).isPresent();
    }

    @Override
    public DocumentoActividadEstrategica consultarPorIdParaObtenerDocumento(Long id) {
        var entidad = this.repositorioDocumentoActividadEstrategicaJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorDocumentoActividadEstrategica.mapeadorDominio(entidad);
    }
}
