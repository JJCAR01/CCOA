package com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.dto.DtoProyectoResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.Proyecto;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.entidad.EntidadInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad.EntidadProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.mapeador.MapeadorInformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.mapeador.MapeadorProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.repositorio.jpa.RepositorioInformacionProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.repositorio.jpa.RepositorioProyectoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioProyectoMySQL implements RepositorioProyecto {
    private final RepositorioProyectoJpa repositorioProyectoJpa;
    private final RepositorioInformacionProyectoJpa repositorioInformacionProyectoJpa;

    @Autowired
    private MapeadorProyecto mapeadorProyecto;
    @Autowired
    private MapeadorInformacionProyecto mapeadorInformacionProyecto;
    public RepositorioProyectoMySQL(RepositorioProyectoJpa repositorioProyectoJpa, RepositorioInformacionProyectoJpa repositorioInformacionProyectoJpa) {
        this.repositorioProyectoJpa = repositorioProyectoJpa;
        this.repositorioInformacionProyectoJpa = repositorioInformacionProyectoJpa;
    }

    @Override
    public List<DtoProyectoResumen> listar() {
        var entidad = this.repositorioProyectoJpa.findAll();
        return this.mapeadorProyecto.listarDominio(entidad);
    }

    @Override
    public Proyecto consultarPorId(Long id) {
        var entidad = this.repositorioProyectoJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorProyecto.mapeadorDominio(entidad);
    }

    @Override
    public Long guardar(Proyecto proyecto, InformacionProyecto informacionProyecto) {
        var proyectoEntidad = this.mapeadorProyecto.mapeadorEntidad(proyecto);
        var informacionProyectoEntidad = this.mapeadorInformacionProyecto.mapeadorEntidad(informacionProyecto);
        this.repositorioInformacionProyectoJpa.save(informacionProyectoEntidad);
        return this.repositorioProyectoJpa.save(proyectoEntidad).getIdActividadEstrategica();
    }

    @Override
    public boolean existe(Proyecto proyecto) {
        return this.repositorioProyectoJpa.findByNombre(proyecto.getNombre())!=null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioProyectoJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Proyecto proyecto, Long id) {
        return null;
    }

    @Override
    public List<DtoProyectoResumen> consultarPorIdActividadEstrategica(Long id) {
        List<EntidadProyecto> entidades = (List<EntidadProyecto>) this.repositorioProyectoJpa.findByIdActividadEstrategica(id);
        return this.mapeadorProyecto.listarDominio(entidades);
    }
}
