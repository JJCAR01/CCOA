package com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.TipoActividad;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoContrato;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoActividad;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadTipoActividad;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadTipoContrato;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio.jpa.RepositorioTipoActividadJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioTipoActividadMySQL implements RepositorioTipoActividad {

    private final RepositorioTipoActividadJpa repositorioTipoActividadJpa;

    public RepositorioTipoActividadMySQL(RepositorioTipoActividadJpa repositorioTipoActividadJpa) {
        this.repositorioTipoActividadJpa = repositorioTipoActividadJpa;
    }

    @Override
    public List<TipoActividad> listar() {
        List<EntidadTipoActividad> entidadTipoActividades =this.repositorioTipoActividadJpa.findAll();
        return entidadTipoActividades.stream().map(entidadTipoActividad -> TipoActividad.of(entidadTipoActividad.getNombre())).toList();
    }

    @Override
    public TipoActividad consultarPorId(Long id) {
        return this.repositorioTipoActividadJpa.findById(id).map(entidadTipoActividad -> TipoActividad.of(entidadTipoActividad.getNombre())).orElse(null);

    }

    @Override
    public Long guardar(TipoActividad tipoActividad) {
        EntidadTipoActividad entidadTipoActividad = new EntidadTipoActividad(tipoActividad.getNombre());
        return this.repositorioTipoActividadJpa.save(entidadTipoActividad).getId();
    }

    @Override
    public boolean existe(TipoActividad tipoActividad) {
        return this.repositorioTipoActividadJpa.findByNombre(tipoActividad.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioTipoActividadJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(TipoActividad tipoActividad, Long id) {
        repositorioTipoActividadJpa.findById(id);
        EntidadTipoActividad entidadTipoActividad = new EntidadTipoActividad();
        entidadTipoActividad.setId(id);
        entidadTipoActividad.setNombre(tipoActividad.getNombre());
        repositorioTipoActividadJpa.save(entidadTipoActividad);
        return id;
    }
}
