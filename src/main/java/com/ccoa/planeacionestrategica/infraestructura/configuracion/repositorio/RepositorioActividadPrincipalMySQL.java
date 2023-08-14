package com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.*;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividadPrincipal;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.*;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio.jpa.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioActividadPrincipalMySQL implements RepositorioActividadPrincipal {

    private final RepositorioActividadPrincipalJpa repositorioActividadPrincipalJpa;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioLineaEstrategicaJpa repositorioLineaEstrategicaJpa;
    private final RepositorioTipoActividadJpa repositorioTipoActividadJpa;
    private final RepositorioTipoGIJpa repositorioTipoGIJpa;

    public RepositorioActividadPrincipalMySQL(RepositorioActividadPrincipalJpa repositorioActividadPrincipalJpa, RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioLineaEstrategicaJpa repositorioLineaEstrategicaJpa, RepositorioTipoActividadJpa repositorioTipoActividadJpa, RepositorioTipoGIJpa repositorioTipoGIJpa) {
        this.repositorioActividadPrincipalJpa = repositorioActividadPrincipalJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioLineaEstrategicaJpa = repositorioLineaEstrategicaJpa;
        this.repositorioTipoActividadJpa = repositorioTipoActividadJpa;
        this.repositorioTipoGIJpa = repositorioTipoGIJpa;
    }

    @Override
    public List<ActividadPrincipal> listar() {
        List<EntidadActividadPrincipal> actividadesPrincipales = this.repositorioActividadPrincipalJpa.findAll();
        return actividadesPrincipales.stream().map(entidad -> ActividadPrincipal.of(entidad.getNombre(),entidad.getEntregable(),entidad.getPresupuesto(),
                entidad.getFechaInicio(),entidad.getFechaFinal(),entidad.getFechaRegistro(),
                LineaEstrategica.of(entidad.getLineaEstrategica().getNombre(),entidad.getLineaEstrategica().getEntregable(),entidad.getLineaEstrategica().getFechaInicio(),entidad.getLineaEstrategica().getFechaFinal(),
                        entidad.getLineaEstrategica().getFechaRegistro(),entidad.getLineaEstrategica().getIndicadorResultado(),
                        Programa.of(entidad.getLineaEstrategica().getPrograma().getNombre(), entidad.getLineaEstrategica().getPrograma().getCodigo(), entidad.getLineaEstrategica().getPrograma().getVersion(),entidad.getLineaEstrategica().getPrograma().getFechaInicio(),
                                entidad.getLineaEstrategica().getPrograma().getFechaFinal(),entidad.getLineaEstrategica().getPrograma().getFechaRegistro(), entidad.getLineaEstrategica().getPrograma().getPresupuestoIngreso(), entidad.getLineaEstrategica().getPrograma().getPresupuestoGasto(),
                                ImperativoEstrategico.of(entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getNombre(),entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getFechaInicio(),
                                        entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getFechaFinal(),entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getFechaRegistro(),
                                        Pat.of(entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getPat().getNombre(),entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getPat().getFechaInicio(),
                                                entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getPat().getFechaFinal(),entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getPat().getFechaRegistro(),
                                                Usuario.of(entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getPat().getUsuario().getNombreUsuario(),entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getPat().getUsuario().getNombre(),
                                                        entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getPat().getUsuario().getApellidos(),entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getPat().getUsuario().getPassword(),
                                                        entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getPat().getUsuario().getCorreo(),entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getPat().getUsuario().getRoles().stream().map(rol -> new Rol(rol.getNombre())).toList(),
                                                        Cargo.of(entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getPat().getUsuario().getCargo().getNombre(),
                                                                Area.of(entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getPat().getUsuario().getCargo().getArea().getNombre())))),
                                        Usuario.of(entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getUsuario().getNombreUsuario(),entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getUsuario().getNombre(),
                                                entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getUsuario().getApellidos(),entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getUsuario().getPassword(),
                                                entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getUsuario().getCorreo(),entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getUsuario().getRoles().stream().map(rol ->
                                                        new Rol(rol.getNombre())).toList(),Cargo.of(entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getUsuario().getCargo().getNombre(),
                                                        Area.of(entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getUsuario().getCargo().getArea().getNombre())))),
                                Usuario.of(entidad.getLineaEstrategica().getPrograma().getUsuario().getNombreUsuario(),entidad.getLineaEstrategica().getPrograma().getUsuario().getNombre(),entidad.getLineaEstrategica().getPrograma().getUsuario().getApellidos(),entidad.getLineaEstrategica().getPrograma().getUsuario().getPassword(),
                                        entidad.getLineaEstrategica().getPrograma().getUsuario().getCorreo(),entidad.getLineaEstrategica().getPrograma().getUsuario().getRoles().stream().map(rol -> new Rol(rol.getNombre())).toList(),
                                        Cargo.of(entidad.getLineaEstrategica().getPrograma().getUsuario().getCargo().getNombre(),Area.of(entidad.getLineaEstrategica().getPrograma().getUsuario().getCargo().getArea().getNombre()))),
                                Area.of(entidad.getLineaEstrategica().getPrograma().getArea().getNombre())),
                        Usuario.of(entidad.getLineaEstrategica().getUsuario().getNombreUsuario(),entidad.getLineaEstrategica().getUsuario().getNombre(),entidad.getLineaEstrategica().getUsuario().getApellidos(),entidad.getLineaEstrategica().getUsuario().getPassword(),
                                entidad.getLineaEstrategica().getUsuario().getCorreo(),entidad.getLineaEstrategica().getUsuario().getRoles().stream().map(rol -> new Rol(rol.getNombre())).toList(),
                                Cargo.of(entidad.getLineaEstrategica().getUsuario().getCargo().getNombre(),Area.of(entidad.getLineaEstrategica().getUsuario().getCargo().getArea().getNombre())))),
                Usuario.of(entidad.getUsuario().getNombreUsuario(),entidad.getUsuario().getNombre(),entidad.getUsuario().getApellidos(),entidad.getUsuario().getPassword(),
                        entidad.getUsuario().getCorreo(),entidad.getUsuario().getRoles().stream().map(rol -> new Rol(rol.getNombre())).toList(),
                        Cargo.of(entidad.getUsuario().getCargo().getNombre(),Area.of(entidad.getUsuario().getCargo().getArea().getNombre()))),
                TipoActividad.of(entidad.getTipoActividad().getNombre()),
                TipoGI.of(entidad.getTipoGI().getCantidad(),entidad.getTipoGI().getValorUnitario(),entidad.getTipoGI().getValorTotal(),entidad.getTipoGI().getObservacion()))).toList();

    }

    @Override
    public ActividadPrincipal consultarPorId(Long id) {
        return this.repositorioActividadPrincipalJpa
                .findById(id)
                .map(entidad -> ActividadPrincipal.of(entidad.getNombre(),entidad.getEntregable(),entidad.getPresupuesto(),
                entidad.getFechaInicio(),entidad.getFechaFinal(),entidad.getFechaRegistro(),
                LineaEstrategica.of(entidad.getLineaEstrategica().getNombre(),entidad.getLineaEstrategica().getEntregable(),entidad.getLineaEstrategica().getFechaInicio(),entidad.getLineaEstrategica().getFechaFinal(),
                        entidad.getLineaEstrategica().getFechaRegistro(),entidad.getLineaEstrategica().getIndicadorResultado(),
                        Programa.of(entidad.getLineaEstrategica().getPrograma().getNombre(), entidad.getLineaEstrategica().getPrograma().getCodigo(), entidad.getLineaEstrategica().getPrograma().getVersion(),entidad.getLineaEstrategica().getPrograma().getFechaInicio(),
                                entidad.getLineaEstrategica().getPrograma().getFechaFinal(),entidad.getLineaEstrategica().getPrograma().getFechaRegistro(), entidad.getLineaEstrategica().getPrograma().getPresupuestoIngreso(), entidad.getLineaEstrategica().getPrograma().getPresupuestoGasto(),
                                ImperativoEstrategico.of(entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getNombre(),entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getFechaInicio(),
                                        entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getFechaFinal(),entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getFechaRegistro(),
                                        Pat.of(entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getPat().getNombre(),entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getPat().getFechaInicio(),
                                                entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getPat().getFechaFinal(),entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getPat().getFechaRegistro(),
                                                Usuario.of(entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getPat().getUsuario().getNombreUsuario(),entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getPat().getUsuario().getNombre(),
                                                        entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getPat().getUsuario().getApellidos(),entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getPat().getUsuario().getPassword(),
                                                        entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getPat().getUsuario().getCorreo(),entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getPat().getUsuario().getRoles().stream().map(rol -> new Rol(rol.getNombre())).toList(),
                                                        Cargo.of(entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getPat().getUsuario().getCargo().getNombre(),
                                                                Area.of(entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getPat().getUsuario().getCargo().getArea().getNombre())))),
                                        Usuario.of(entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getUsuario().getNombreUsuario(),entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getUsuario().getNombre(),
                                                entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getUsuario().getApellidos(),entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getUsuario().getPassword(),
                                                entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getUsuario().getCorreo(),entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getUsuario().getRoles().stream().map(rol ->
                                                        new Rol(rol.getNombre())).toList(),Cargo.of(entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getUsuario().getCargo().getNombre(),
                                                        Area.of(entidad.getLineaEstrategica().getPrograma().getImperativoEstrategico().getUsuario().getCargo().getArea().getNombre())))),
                                Usuario.of(entidad.getLineaEstrategica().getPrograma().getUsuario().getNombreUsuario(),entidad.getLineaEstrategica().getPrograma().getUsuario().getNombre(),entidad.getLineaEstrategica().getPrograma().getUsuario().getApellidos(),entidad.getLineaEstrategica().getPrograma().getUsuario().getPassword(),
                                        entidad.getLineaEstrategica().getPrograma().getUsuario().getCorreo(),entidad.getLineaEstrategica().getPrograma().getUsuario().getRoles().stream().map(rol -> new Rol(rol.getNombre())).toList(),
                                        Cargo.of(entidad.getLineaEstrategica().getPrograma().getUsuario().getCargo().getNombre(),Area.of(entidad.getLineaEstrategica().getPrograma().getUsuario().getCargo().getArea().getNombre()))),
                                Area.of(entidad.getLineaEstrategica().getPrograma().getArea().getNombre())),
                        Usuario.of(entidad.getLineaEstrategica().getUsuario().getNombreUsuario(),entidad.getLineaEstrategica().getUsuario().getNombre(),entidad.getLineaEstrategica().getUsuario().getApellidos(),entidad.getLineaEstrategica().getUsuario().getPassword(),
                                entidad.getLineaEstrategica().getUsuario().getCorreo(),entidad.getLineaEstrategica().getUsuario().getRoles().stream().map(rol -> new Rol(rol.getNombre())).toList(),
                                Cargo.of(entidad.getLineaEstrategica().getUsuario().getCargo().getNombre(),Area.of(entidad.getLineaEstrategica().getUsuario().getCargo().getArea().getNombre())))),
                Usuario.of(entidad.getUsuario().getNombreUsuario(),entidad.getUsuario().getNombre(),entidad.getUsuario().getApellidos(),entidad.getUsuario().getPassword(),
                        entidad.getUsuario().getCorreo(),entidad.getUsuario().getRoles().stream().map(rol -> new Rol(rol.getNombre())).toList(),
                        Cargo.of(entidad.getUsuario().getCargo().getNombre(),Area.of(entidad.getUsuario().getCargo().getArea().getNombre()))),
                TipoActividad.of(entidad.getTipoActividad().getNombre()),
                TipoGI.of(entidad.getTipoGI().getCantidad(),entidad.getTipoGI().getValorUnitario(),entidad.getTipoGI().getValorTotal(),entidad.getTipoGI().getObservacion()))).orElse(null);
    }

    @Override
    public Long guardar(ActividadPrincipal actividadPrincipal) {
        EntidadTipoActividad entidadTipoActividad = this.repositorioTipoActividadJpa.findByNombre(actividadPrincipal.getTipoActividad().getNombre());
        EntidadTipoGI entidadTipoGI = this.repositorioTipoGIJpa.findByObservacion(actividadPrincipal.getTipoGI().getObservacion());
        EntidadUsuario entidadUsuario = this.repositorioUsuarioJpa.findByNombreAndApellidos(actividadPrincipal.getUsuario().getNombre(),
                actividadPrincipal.getUsuario().getApellidos());
        EntidadLineaEstrategica entidadLineaEstrategica = this.repositorioLineaEstrategicaJpa.findByNombre(actividadPrincipal.getLineaEstrategica().getNombre());

        EntidadActividadPrincipal entidadActividadPrincipal = new EntidadActividadPrincipal(actividadPrincipal.getNombre(), actividadPrincipal.getEntregable(),
                actividadPrincipal.getPresupuesto(), actividadPrincipal.getFechaInicio(), actividadPrincipal.getFechaFinal(),actividadPrincipal.getFechaRegistro(),entidadUsuario,
                entidadTipoActividad,entidadTipoGI,entidadLineaEstrategica);

        return this.repositorioActividadPrincipalJpa.save(entidadActividadPrincipal).getId();
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

        EntidadTipoActividad entidadTipoActividad = this.repositorioTipoActividadJpa.findByNombre(actividadPrincipal.getTipoActividad().getNombre());
        EntidadTipoGI entidadTipoGI = this.repositorioTipoGIJpa.findByObservacion(actividadPrincipal.getTipoGI().getObservacion());
        EntidadUsuario entidadUsuario = this.repositorioUsuarioJpa.findByNombreAndApellidos(actividadPrincipal.getUsuario().getNombre(),
                actividadPrincipal.getUsuario().getApellidos());
        EntidadLineaEstrategica entidadLineaEstrategica = this.repositorioLineaEstrategicaJpa.findByNombre(actividadPrincipal.getLineaEstrategica().getNombre());

        repositorioActividadPrincipalJpa.findById(id);
        EntidadActividadPrincipal entidadActividadPrincipal = new EntidadActividadPrincipal();
        entidadActividadPrincipal.setId(id);
        entidadActividadPrincipal.setNombre(actividadPrincipal.getNombre());

        entidadActividadPrincipal.setTipoActividad(entidadTipoActividad);
        entidadActividadPrincipal.setUsuario(entidadUsuario);
        entidadActividadPrincipal.setLineaEstrategica(entidadLineaEstrategica);
        entidadActividadPrincipal.setTipoGI(entidadTipoGI);

        repositorioActividadPrincipalJpa.save(entidadActividadPrincipal);
        return id;
    }
}
