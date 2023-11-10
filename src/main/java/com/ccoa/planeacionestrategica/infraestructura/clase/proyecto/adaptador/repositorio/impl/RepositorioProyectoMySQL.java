package com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.dto.DtoProyectoResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.DetalleProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.Proyecto;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad.EntidadDetalleProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.mapeador.MapeadorDetalleProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.mapeador.MapeadorInformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.mapeador.MapeadorProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.repositorio.jpa.RepositorioDetalleProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.repositorio.jpa.RepositorioInformacionProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.repositorio.jpa.RepositorioProyectoJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioProyectoMySQL implements RepositorioProyecto {
    private final RepositorioProyectoJpa repositorioProyectoJpa;
    private final RepositorioInformacionProyectoJpa repositorioInformacionProyectoJpa;
    private final MapeadorProyecto mapeadorProyecto;
    private final MapeadorInformacionProyecto mapeadorInformacionProyecto;
    private final MapeadorDetalleProyecto mapeadorDetalleProyecto;
    private final RepositorioDetalleProyectoJpa repositorioDetalleProyectoJpa;
    public RepositorioProyectoMySQL(RepositorioProyectoJpa repositorioProyectoJpa, RepositorioInformacionProyectoJpa repositorioInformacionProyectoJpa,
                                    MapeadorProyecto mapeadorProyecto, MapeadorInformacionProyecto mapeadorInformacionProyecto, MapeadorDetalleProyecto mapeadorDetalleProyecto, RepositorioDetalleProyectoJpa repositorioDetalleProyectoJpa) {
        this.repositorioProyectoJpa = repositorioProyectoJpa;
        this.repositorioInformacionProyectoJpa = repositorioInformacionProyectoJpa;
        this.mapeadorProyecto = mapeadorProyecto;
        this.mapeadorInformacionProyecto = mapeadorInformacionProyecto;
        this.mapeadorDetalleProyecto = mapeadorDetalleProyecto;
        this.repositorioDetalleProyectoJpa = repositorioDetalleProyectoJpa;
    }

    @Override
    public List<DtoProyectoResumen> listar() {
        var entidad = this.repositorioDetalleProyectoJpa.findAll();
        return this.mapeadorDetalleProyecto.listarDominio(entidad);
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
        var informacionProyectoEntidad = this.mapeadorInformacionProyecto.mapeadorEntidad(informacionProyecto);
        var detalleProyectoEntidad = this.mapeadorDetalleProyecto.mapeadorEntidad(detalleProyecto);
        this.repositorioDetalleProyectoJpa.save(detalleProyectoEntidad);
        this.repositorioInformacionProyectoJpa.save(informacionProyectoEntidad);
        return this.repositorioProyectoJpa.save(proyectoEntidad).getIdProyecto();
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

    @Override
    public Long modificar(Proyecto proyecto, InformacionProyecto informacionProyecto, DetalleProyecto detalleProyecto, Long id) {
        var entidad = this.repositorioProyectoJpa.findById(id).orElse(null);
        var entidadInf = this.repositorioInformacionProyectoJpa.findById(id).orElse(null);
        assert entidad != null;
        assert entidadInf != null;
        this.mapeadorProyecto.actualizarEntidad(entidad, proyecto,entidadInf,informacionProyecto);
        this.repositorioInformacionProyectoJpa.save(entidadInf);
        return this.repositorioProyectoJpa.save(entidad).getIdProyecto();
    }

    @Override
    public List<DtoProyectoResumen> consultarPorIdActividadEstrategica(Long id) {
        List<EntidadDetalleProyecto> entidades = this.repositorioDetalleProyectoJpa.findByIdActividadEstrategica(id);
        return this.mapeadorDetalleProyecto.listarDominio(entidades);
    }
}
