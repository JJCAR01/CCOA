package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadGestionResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.ActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.InformacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.entidad.EntidadActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.mapeador.MapeadorActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.mapeador.MapeadorInformacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.repositorio.jpa.RepositorioActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.repositorio.jpa.RepositorioInformacionActividadGestionJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RepositorioActividadGestionMySQL implements RepositorioActividadGestion {

    private final RepositorioActividadGestionJpa repositorioActividadGestionJpa;
    private final RepositorioInformacionActividadGestionJpa repositorioInformacionActividadGestionJpa;
    private final MapeadorActividadGestion mapeadorActividadGestion;
    private final MapeadorInformacionActividadGestion mapeadorInformacionActividadGestion;
    public RepositorioActividadGestionMySQL(RepositorioActividadGestionJpa repositorioActividadGestionJpa,
                                            RepositorioInformacionActividadGestionJpa repositorioInformacionActividadGestionJpa, MapeadorActividadGestion mapeadorActividadGestion, MapeadorInformacionActividadGestion mapeadorInformacionActividadGestion) {
        this.repositorioActividadGestionJpa = repositorioActividadGestionJpa;
        this.repositorioInformacionActividadGestionJpa = repositorioInformacionActividadGestionJpa;
        this.mapeadorActividadGestion = mapeadorActividadGestion;
        this.mapeadorInformacionActividadGestion = mapeadorInformacionActividadGestion;
    }

    @Override
    public List<DtoActividadGestionResumen> listar() {
        var entidad = this.repositorioActividadGestionJpa.findAll();
        return this.mapeadorActividadGestion.listarDominio(entidad);
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
        mapeadorInformacionActividadGestion.actualizarPorcentajeAvance(informacionActividadEntidad,informacionActividadGestion);
        var id = this.repositorioActividadGestionJpa.save(actividadEntidad).getIdActividadGestion();
        informacionActividadEntidad.setIdInformacionActividad(id);
        return this.repositorioInformacionActividadGestionJpa.save(informacionActividadEntidad).getIdInformacionActividad();
    }

    @Override
    public boolean existe(ActividadGestion actividadGestion) {
        return this.repositorioActividadGestionJpa.findByNombre(actividadGestion.getNombre())!=null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioActividadGestionJpa.deleteById(id);
        this.repositorioInformacionActividadGestionJpa.deleteById(id);
        return id;
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
}
