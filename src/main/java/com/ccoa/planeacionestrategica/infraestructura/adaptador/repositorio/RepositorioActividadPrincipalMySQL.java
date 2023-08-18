package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.*;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividadPrincipal;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.*;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.*;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.*;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioActividadPrincipalMySQL implements RepositorioActividadPrincipal {

    private final RepositorioActividadPrincipalJpa repositorioActividadPrincipalJpa;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioLineaEstrategicaJpa repositorioLineaEstrategicaJpa;

    private final RepositorioTipoGIJpa repositorioTipoGIJpa;

    public RepositorioActividadPrincipalMySQL(RepositorioActividadPrincipalJpa repositorioActividadPrincipalJpa,
                                              RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioLineaEstrategicaJpa repositorioLineaEstrategicaJpa, RepositorioTipoGIJpa repositorioTipoGIJpa) {
        this.repositorioActividadPrincipalJpa = repositorioActividadPrincipalJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioLineaEstrategicaJpa = repositorioLineaEstrategicaJpa;
        this.repositorioTipoGIJpa = repositorioTipoGIJpa;
    }

    @Override
    public List<ActividadPrincipal> listar() {
        /*
        List<EntidadActividadPrincipal> entidadActividadPrincipales =this.repositorioActividadPrincipalJpa.findAll();
        return entidadActividadPrincipales.stream().map(entidad -> ActividadPrincipal.of(entidad.getNombre(),entidad.getTipoActividad(),entidad.getEntregable(),entidad.getPresupuesto(),
                entidad.getFechaInicio(),entidad.getFechaFinal(),entidad.getFechaRegistro(),entidad.getIdLineaEstrategica(), entidad.getIdUsuario(), entidad.getIdTipoGI())).toList();
    */return null;
    }


    @Override
    public ActividadPrincipal consultarPorId(Long id) {
        /*
        return this.repositorioActividadPrincipalJpa
                .findById(id)
                .map(entidad -> ActividadPrincipal.of(entidad.getNombre(),entidad.getTipoActividad(),entidad.getEntregable(),entidad.getPresupuesto(),
                entidad.getFechaInicio(),entidad.getFechaFinal(),entidad.getFechaRegistro(),entidad.getIdLineaEstrategica(), entidad.getIdUsuario(), entidad.getIdTipoGI())).orElse(null);
    */return null;}

    @Override
    public Long guardar(ActividadPrincipal actividadPrincipal) {
        /*Optional<EntidadTipoGI> entidadTipoGI = this.repositorioTipoGIJpa.findById(actividadPrincipal.getIdTipoGI());
        Optional<EntidadLineaEstrategica> entidadLineaEstrategica = this.repositorioLineaEstrategicaJpa.findById(actividadPrincipal.getIdLineaEstrategica());
        Optional<EntidadUsuario> entidadUsuario = this.repositorioUsuarioJpa.findById(actividadPrincipal.getIdUsuario());

        EntidadActividadPrincipal entidadActividadPrincipal = new EntidadActividadPrincipal(actividadPrincipal.getNombre(), actividadPrincipal.getTipoActividad(),
                actividadPrincipal.getEntregable(),
                actividadPrincipal.getPresupuesto(), actividadPrincipal.getFechaInicio(), actividadPrincipal.getFechaFinal(),actividadPrincipal.getFechaRegistro(),entidadLineaEstrategica.get().getId(),
                entidadUsuario.get().getId(),entidadTipoGI.get().getId());

        return this.repositorioActividadPrincipalJpa.save(entidadActividadPrincipal).getId();
    */return null;}

    @Override
    public boolean existe(ActividadPrincipal actividadPrincipal) {

        return this.repositorioActividadPrincipalJpa.findByNombre(actividadPrincipal.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioActividadPrincipalJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(ActividadPrincipal actividadPrincipal, Long id) {

/*
        Optional<EntidadTipoGI> entidadTipoGI = this.repositorioTipoGIJpa.findById(actividadPrincipal.getIdTipoGI());
        Optional<EntidadLineaEstrategica> entidadLineaEstrategica = this.repositorioLineaEstrategicaJpa.findById(actividadPrincipal.getIdLineaEstrategica());
        Optional<EntidadUsuario> entidadUsuario = this.repositorioUsuarioJpa.findById(actividadPrincipal.getIdUsuario());

        repositorioActividadPrincipalJpa.findById(id);
        EntidadActividadPrincipal entidadActividadPrincipal = new EntidadActividadPrincipal();
        entidadActividadPrincipal.setId(id);
        entidadActividadPrincipal.setNombre(actividadPrincipal.getNombre());

        entidadActividadPrincipal.setIdUsuario(entidadUsuario.get().getId());
        entidadActividadPrincipal.setIdLineaEstrategica(entidadLineaEstrategica.get().getId());
        entidadActividadPrincipal.setIdTipoGI(entidadTipoGI.get().getId());

        repositorioActividadPrincipalJpa.save(entidadActividadPrincipal);
        return id;*/return null;
    }
}
