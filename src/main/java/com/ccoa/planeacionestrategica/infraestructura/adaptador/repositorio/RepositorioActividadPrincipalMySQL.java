package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadprincipal.ActividadPrincipal;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadprincipal.DatoActividadPrincipal;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadprincipal.DetalleActividadPrincipal;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividadPrincipal;
import com.ccoa.planeacionestrategica.dominio.transversal.formateador.FormateadorHora;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.*;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.actividadprincipal.EntidadActividadPrincipal;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.actividadprincipal.EntidadDatoActividadPrincipal;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.actividadprincipal.EntidadDetalleActividadPrincipal;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.usuario.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.*;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.actividadprincipal.RepositorioActividadPrincipalJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.actividadprincipal.RepositorioDatoActividadPrincipalJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.actividadprincipal.RepositorioDetalleActividadPrincipalJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioActividadPrincipalMySQL implements RepositorioActividadPrincipal {

    private final RepositorioActividadPrincipalJpa repositorioActividadPrincipalJpa;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioLineaEstrategicaJpa repositorioLineaEstrategicaJpa;
    private final RepositorioDetalleActividadPrincipalJpa repositorioDetalleActividadPrincipalJpa;
    private final RepositorioDatoActividadPrincipalJpa repositorioDatoActividadPrincipalJpa;

    public RepositorioActividadPrincipalMySQL(RepositorioActividadPrincipalJpa repositorioActividadPrincipalJpa,
                                              RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioLineaEstrategicaJpa repositorioLineaEstrategicaJpa,
                                              RepositorioDetalleActividadPrincipalJpa repositorioDetalleActividadPrincipalJpa, RepositorioDatoActividadPrincipalJpa repositorioDatoActividadPrincipalJpa) {
        this.repositorioActividadPrincipalJpa = repositorioActividadPrincipalJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioLineaEstrategicaJpa = repositorioLineaEstrategicaJpa;
        this.repositorioDetalleActividadPrincipalJpa = repositorioDetalleActividadPrincipalJpa;
        this.repositorioDatoActividadPrincipalJpa = repositorioDatoActividadPrincipalJpa;

    }

    @Override
    public List<ActividadPrincipal> listar() {

        List<EntidadActividadPrincipal> entidadActividadPrincipales =this.repositorioActividadPrincipalJpa.findAll();
        return entidadActividadPrincipales.stream().map(entidad -> ActividadPrincipal.listar(entidad.getIdActividadPrincipal(), entidad.getNombre(),
                String.valueOf(entidad.getTipoActividad()),entidad.getEntregable(),entidad.getPresupuesto())).toList();
    }

    @Override
    public List<DetalleActividadPrincipal> listarDetalle() {
        List<EntidadDetalleActividadPrincipal> entidadDetalleActividadPrincipales =this.repositorioDetalleActividadPrincipalJpa.findAll();
        return entidadDetalleActividadPrincipales.stream().map(entidad -> DetalleActividadPrincipal.of(entidad.getIdLineaEstrategica(),
                entidad.getIdUsuario(),entidad.getIdTipoGI())).toList();
    }


    @Override
    public ActividadPrincipal consultarPorId(Long id) {
        return this.repositorioActividadPrincipalJpa
                .findById(id)
                .map(entidad -> ActividadPrincipal.listar(entidad.getIdActividadPrincipal(), entidad.getNombre(),
                        String.valueOf(entidad.getTipoActividad()),entidad.getEntregable(),entidad.getPresupuesto())).orElse(null);
    }

    @Override
    public Long guardar(ActividadPrincipal actividadPrincipal, DetalleActividadPrincipal detalleActividadPrincipal, DatoActividadPrincipal datoActividadPrincipal) {
        Optional<EntidadUsuario> entidadUsuario = this.repositorioUsuarioJpa.findById(detalleActividadPrincipal.getIdUsuario());
        Optional<EntidadLineaEstrategica> entidadLineaEstrategica = this.repositorioLineaEstrategicaJpa.findById(detalleActividadPrincipal.getIdLineaEstrategica());

        var entidadActividadPrincipal = new EntidadActividadPrincipal(actividadPrincipal.getNombre(), actividadPrincipal.getTipoActividad(),
                actividadPrincipal.getEntregable(), actividadPrincipal.getPresupuesto());
        var entidadDetalle = new EntidadDetalleActividadPrincipal(entidadLineaEstrategica.get().getIdLineaEstrategica(), entidadUsuario.get().getIdUsuario());

        var entidadDato = new EntidadDatoActividadPrincipal(FormateadorHora.obtenerFechaTexto(datoActividadPrincipal.getFechaInicio()),
                FormateadorHora.obtenerFechaTexto(datoActividadPrincipal.getFechaFinal()),datoActividadPrincipal.getFechaRegistro());
        this.repositorioDatoActividadPrincipalJpa.save(entidadDato);
        this.repositorioDetalleActividadPrincipalJpa.save(entidadDetalle);
        return this.repositorioActividadPrincipalJpa.save(entidadActividadPrincipal).getIdActividadPrincipal();
    }

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

        /*Optional<EntidadUsuario> entidadUsuario = this.repositorioUsuarioJpa.findById(detalleActividadPrincipal.getIdUsuario());
        Optional<EntidadTipoGI> entidadTipoGI = this.repositorioTipoGIJpa.findById(detalleActividadPrincipal.getIdTipoGI());
        Optional<EntidadLineaEstrategica> entidadLineaEstrategica = this.repositorioLineaEstrategicaJpa.findById(detalleActividadPrincipal.getIdLineaEstrategica());
        */

        repositorioActividadPrincipalJpa.findById(id);
        EntidadActividadPrincipal entidadActividadPrincipal = new EntidadActividadPrincipal();
        entidadActividadPrincipal.setIdActividadPrincipal(id);
        entidadActividadPrincipal.setNombre(actividadPrincipal.getNombre());

        /*entidadActividadPrincipal.se(entidadUsuario.get().getIdUsuario());
        entidadActividadPrincipal.setIdLineaEstrategica(entidadLineaEstrategica.get().getId());
        entidadActividadPrincipal.setIdTipoGI(entidadTipoGI.get().getId());
         */

        repositorioActividadPrincipalJpa.save(entidadActividadPrincipal);
        return id;
    }
}
