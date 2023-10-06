package com.ccoa.planeacionestrategica.infraestructura.clase.actividad.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividad.Actividad;
import com.ccoa.planeacionestrategica.dominio.modelo.actividad.InformacionActividad;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividad;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividad.adaptador.mapeador.MapeadorActividad;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividad.adaptador.mapeador.MapeadorInformacionActividad;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividad.adaptador.repositorio.jpa.RepositorioActividadJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividad.adaptador.repositorio.jpa.RepositorioInformacionActividadJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RepositorioActividadMySQL implements RepositorioActividad {
    private final RepositorioActividadJpa repositorioActividadJpa;
    private final RepositorioInformacionActividadJpa repositorioInformacionActividadJpa;
    private final MapeadorActividad mapeadorActividad;
    private final MapeadorInformacionActividad mapeadorInformacionActividad;

    public RepositorioActividadMySQL(RepositorioActividadJpa repositorioActividadJpa, RepositorioInformacionActividadJpa repositorioInformacionActividadJpa,
                                     MapeadorActividad mapeadorActividad, MapeadorInformacionActividad mapeadorInformacionActividad) {
        this.repositorioActividadJpa = repositorioActividadJpa;
        this.repositorioInformacionActividadJpa = repositorioInformacionActividadJpa;
        this.mapeadorActividad = mapeadorActividad;
        this.mapeadorInformacionActividad = mapeadorInformacionActividad;
    }

    @Override
    public List<DtoActividadResumen> listar() {
        var entidad = this.repositorioActividadJpa.findAll();
        return this.mapeadorActividad.listarDominio(entidad);
    }

    @Override
    public Actividad consultarPorId(Long id) {
        var entidad = this.repositorioActividadJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorActividad.mapeadorDominio(entidad);
    }

    @Override
    public Long guardar(Actividad actividad, InformacionActividad informacionActividad) {
        var actividadEntidad = this.mapeadorActividad.mapeadorEntidad(actividad);
        var informacionActividadEntidad = this.mapeadorInformacionActividad.mapeadorEntidad(informacionActividad);
        this.repositorioInformacionActividadJpa.save(informacionActividadEntidad);
        actividadEntidad.setIdInformacionActividad(informacionActividad.getIdInformacionActividad());
        return this.repositorioActividadJpa.save(actividadEntidad).getIdActividad();
    }

    @Override
    public boolean existe(Actividad actividad) {
        ///this.repositorioActividadJpa.e;
        return true;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioActividadJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Actividad actividad, Long id) {
        return null;
    }

    @Override
    public List<Actividad> consultarPorIdGestion(Long idGestion) {
        return null;
    }

    @Override
    public List<Actividad> consultarPorIdEpica(Long idEpica) {
        return null;
    }
}
