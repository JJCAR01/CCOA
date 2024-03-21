package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadGestionEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.ActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.documento.DocumentoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.InformacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestionestrategica.RepositorioActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.entidad.EntidadActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.mapeador.MapeadorActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.mapeador.MapeadorInformacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.repositorio.jpa.RepositorioActividadGestionEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadGestionEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.mapeador.documento.MapeadorDocumentoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.repositorio.jpa.RepositorioDocumentoActividadGestionEstrategicaJpa;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RepositorioActividadGestionEstrategicaMySQL implements RepositorioActividadGestionEstrategica {

    private final RepositorioActividadGestionEstrategicaJpa repositorioActividadGestionEstrategicaJpa;
    private final RepositorioInformacionActividadGestionEstrategicaJpa repositorioInformacionActividadGestionEstrategicaJpa;
    private final MapeadorActividadGestionEstrategica mapeadorActividadGestionEstrategica;
    private final MapeadorInformacionActividadGestionEstrategica mapeadorInformacionActividadGestionEstrategica;
    private final MapeadorDocumentoActividadGestionEstrategica mapeadorDocumentoActividadGestionEstrategica;
    private final RepositorioDocumentoActividadGestionEstrategicaJpa repositorioDocumentoActividadGestionEstrategicaJpa;
    public RepositorioActividadGestionEstrategicaMySQL(RepositorioActividadGestionEstrategicaJpa repositorioActividadGestionEstrategicaJpa,
                                                       RepositorioInformacionActividadGestionEstrategicaJpa repositorioInformacionActividadGestionEstrategicaJpa, MapeadorActividadGestionEstrategica mapeadorActividadGestionEstrategica, MapeadorInformacionActividadGestionEstrategica mapeadorInformacionActividadGestionEstrategica, MapeadorDocumentoActividadGestionEstrategica mapeadorDocumentoActividadGestionEstrategica, RepositorioDocumentoActividadGestionEstrategicaJpa repositorioDocumentoActividadGestionEstrategicaJpa) {
        this.repositorioActividadGestionEstrategicaJpa = repositorioActividadGestionEstrategicaJpa;
        this.repositorioInformacionActividadGestionEstrategicaJpa = repositorioInformacionActividadGestionEstrategicaJpa;
        this.mapeadorActividadGestionEstrategica = mapeadorActividadGestionEstrategica;
        this.mapeadorInformacionActividadGestionEstrategica = mapeadorInformacionActividadGestionEstrategica;
        this.mapeadorDocumentoActividadGestionEstrategica = mapeadorDocumentoActividadGestionEstrategica;
        this.repositorioDocumentoActividadGestionEstrategicaJpa = repositorioDocumentoActividadGestionEstrategicaJpa;
    }

    @Override
    public List<DtoActividadGestionEstrategicaResumen> listar() {
        var entidad = this.repositorioActividadGestionEstrategicaJpa.findAll();
        return this.mapeadorActividadGestionEstrategica.listarDominio(entidad);
    }

    @Override
    public List<DocumentoActividadGestionEstrategica> consultarPorIdParaObtenerDocumento(Long id) {
        var entidad = this.repositorioDocumentoActividadGestionEstrategicaJpa.findByIdActividadGestionEstrategica(id);
        assert entidad != null;
        return this.mapeadorDocumentoActividadGestionEstrategica.mapeadorListaDocumentos(entidad);
    }

    @Override
    public ActividadGestionEstrategica consultarPorId(Long id) {
        var entidad = this.repositorioActividadGestionEstrategicaJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorActividadGestionEstrategica.mapeadorDominio(entidad);
    }

    @Override
    public Long guardar(ActividadGestionEstrategica actividadGestionEstrategica, InformacionActividadGestionEstrategica informacionActividadGestionEstrategica) {
        var actividadEntidad = this.mapeadorActividadGestionEstrategica.mapeadorEntidad(actividadGestionEstrategica);
        var id = this.repositorioActividadGestionEstrategicaJpa.save(actividadEntidad).getIdActividadGestionEstrategica();
        var informacionActividadEntidad = this.mapeadorInformacionActividadGestionEstrategica.mapeadorEntidad(informacionActividadGestionEstrategica);
        mapeadorInformacionActividadGestionEstrategica.actualizarPorcentajeAvance(informacionActividadEntidad,id);
        informacionActividadEntidad.setIdInformacionActividadGestionEstrategica(id);
        repositorioInformacionActividadGestionEstrategicaJpa.save(informacionActividadEntidad);
        return id;
    }

    @Override
    public Long guardarDocumento(DocumentoActividadGestionEstrategica documentoActividadGestionEstrategica, Long codigo) {
        var documento = this.mapeadorDocumentoActividadGestionEstrategica.mapeadorEntidadDocumento(documentoActividadGestionEstrategica,codigo);
        return this.repositorioDocumentoActividadGestionEstrategicaJpa.save(documento).getIdDocumentoActividadGestionEstrategica();
    }

    @Override
    public boolean existe(ActividadGestionEstrategica actividadGestionEstrategica) {
        return this.repositorioActividadGestionEstrategicaJpa.findByNombre(actividadGestionEstrategica.getNombre())!=null;
    }

    @Override
    public boolean existeDocumento(DocumentoActividadGestionEstrategica documentoActividadGestionEstrategica) {
        return this.repositorioDocumentoActividadGestionEstrategicaJpa.findById(documentoActividadGestionEstrategica.getIdActividadGestionEstrategica()).isPresent();
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioActividadGestionEstrategicaJpa.deleteById(id);
        this.repositorioInformacionActividadGestionEstrategicaJpa.deleteById(id);
        return id;
    }

    @Transactional
    @Override
    public Long eliminarPorActividadEstrategica(Long id) {
        var entidades = consultarPorIdActividadEstrategica(id);
        entidades.forEach(entidad -> repositorioInformacionActividadGestionEstrategicaJpa.deleteById(entidad.getIdActividadGestionEstrategica()));
        repositorioActividadGestionEstrategicaJpa.deleteByIdActividadEstrategica(id);
        return id;
    }

    @Override
    public Long modificar(ActividadGestionEstrategica actividadGestionEstrategica, InformacionActividadGestionEstrategica informacionActividadGestionEstrategica, Long id) {
        var entidad = this.repositorioActividadGestionEstrategicaJpa.findById(id).orElse(null);
        var entidadInf = this.repositorioInformacionActividadGestionEstrategicaJpa.findById(id).orElse(null);
        assert entidad != null;
        assert entidadInf != null;
        this.mapeadorActividadGestionEstrategica.actualizarEntidad(entidad, actividadGestionEstrategica,entidadInf,informacionActividadGestionEstrategica);
        this.repositorioInformacionActividadGestionEstrategicaJpa.save(entidadInf);
        return this.repositorioActividadGestionEstrategicaJpa.save(entidad).getIdActividadGestionEstrategica();
    }
    @Override
    public List<DtoActividadGestionEstrategicaResumen> consultarPorIdActividadEstrategica(Long idActividadEstrategica) {
        List<EntidadActividadGestionEstrategica> entidades = this.repositorioActividadGestionEstrategicaJpa.findByIdActividadEstrategica(idActividadEstrategica);
        return this.mapeadorActividadGestionEstrategica.listarDominio(entidades);
    }

    @Override
    public List<DtoIdsActividadGestionEstrategica> consultarPorIdActividadEstrategicaAEliminar(Long idActividadEstrategica) {
        List<EntidadActividadGestionEstrategica> entidades = this.repositorioActividadGestionEstrategicaJpa.findByIdActividadEstrategica(idActividadEstrategica);
        return this.mapeadorActividadGestionEstrategica.listarPorIds(entidades);
    }

    @Override
    public Long modificarDocumento(DocumentoActividadGestionEstrategica documentoActividadGestionEstrategica, Long id) {
        var entidad = mapeadorDocumentoActividadGestionEstrategica.obtenerEntidadDocumento(id);
        this.mapeadorDocumentoActividadGestionEstrategica.actualizarEntidad(entidad, documentoActividadGestionEstrategica);
        return this.repositorioDocumentoActividadGestionEstrategicaJpa.save(entidad).getIdDocumentoActividadGestionEstrategica();
    }

    @Override
    public Long eliminarDocumento(Long id) {
        this.repositorioDocumentoActividadGestionEstrategicaJpa.deleteById(id);
        return id;
    }
}
