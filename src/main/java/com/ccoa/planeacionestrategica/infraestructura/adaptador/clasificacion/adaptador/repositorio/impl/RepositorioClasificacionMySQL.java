package com.ccoa.planeacionestrategica.infraestructura.adaptador.clasificacion.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.dto.DtoClasificacionResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.clasificacion.Clasificacion;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioClasificacion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.clasificacion.adaptador.mapeador.MapeadorClasificacion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.clasificacion.adaptador.repositorio.jpa.RepositorioClasificacionJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioClasificacionMySQL implements RepositorioClasificacion {

    private final RepositorioClasificacionJpa repositorioClasificacionJpa;
    private final MapeadorClasificacion mapeadorClasificacion;

    public RepositorioClasificacionMySQL(RepositorioClasificacionJpa repositorioClasificacionJpa, MapeadorClasificacion mapeadorClasificacion) {
        this.repositorioClasificacionJpa = repositorioClasificacionJpa;
        this.mapeadorClasificacion = mapeadorClasificacion;
    }

    @Override
    public List<DtoClasificacionResumen> listar() {
        var entidad =this.repositorioClasificacionJpa.findAll();
        return this.mapeadorClasificacion.listarDominio(entidad);
    }

    @Override
    public DtoClasificacionResumen consultarPorId(Long id) {
        var entidad = this.repositorioClasificacionJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorClasificacion.listarDtoResumen(entidad);
    }

    @Override
    public Long guardar(Clasificacion clasificacion) {
        return this.repositorioClasificacionJpa.save(this.mapeadorClasificacion.mapeadorEntidad(clasificacion)).getIdClasificacion();
    }

    @Override
    public boolean existe(Clasificacion clasificacion)  {
        return this.repositorioClasificacionJpa.findByNombre(clasificacion.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioClasificacionJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Clasificacion clasificacion, Long id) {
        var entidad = this.repositorioClasificacionJpa.findById(id).orElse(null);
        assert entidad != null;
        this.mapeadorClasificacion.actualizarEntidad(entidad, clasificacion);
        return this.repositorioClasificacionJpa.save(entidad).getIdClasificacion();
    }
}
