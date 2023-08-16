package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.*;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioLineaEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadLineaEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadPrograma;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioLineaEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioProgramaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioLineaEstrategicaMySQL implements RepositorioLineaEstrategica {

    private final RepositorioLineaEstrategicaJpa repositorioLineaEstrategicaJpa;
    private final RepositorioProgramaJpa repositorioProgramaJpa;

    private final RepositorioUsuarioJpa repositorioUsuarioJpa;

    public RepositorioLineaEstrategicaMySQL(RepositorioLineaEstrategicaJpa repositorioLineaEstrategicaJpa, RepositorioProgramaJpa repositorioProgramaJpa, RepositorioUsuarioJpa repositorioUsuarioJpa) {
        this.repositorioLineaEstrategicaJpa = repositorioLineaEstrategicaJpa;
        this.repositorioProgramaJpa = repositorioProgramaJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
    }

    @Override
    public List<LineaEstrategica> listar() {
        List<EntidadLineaEstrategica> lineaEstrategicas = this.repositorioLineaEstrategicaJpa.findAll();
        return lineaEstrategicas.stream().map(entidad -> LineaEstrategica.of(entidad.getNombre(),entidad.getEntregable(),entidad.getFechaInicio(),entidad.getFechaFinal(),
                entidad.getFechaRegistro(),entidad.getIndicadorResultado(),
                Programa.of(entidad.getPrograma().getNombre(), entidad.getPrograma().getCodigo(), entidad.getPrograma().getVersion(),entidad.getPrograma().getFechaInicio(),
                        entidad.getPrograma().getFechaFinal(),entidad.getPrograma().getFechaRegistro(), entidad.getPrograma().getPresupuestoIngreso(), entidad.getPrograma().getPresupuestoGasto(),
                        ImperativoEstrategico.of(entidad.getPrograma().getImperativoEstrategico().getNombre(),entidad.getPrograma().getImperativoEstrategico().getFechaInicio(),
                                entidad.getPrograma().getImperativoEstrategico().getFechaFinal(),entidad.getPrograma().getImperativoEstrategico().getFechaRegistro(),
                                Pat.of(entidad.getPrograma().getImperativoEstrategico().getPat().getNombre(),entidad.getPrograma().getImperativoEstrategico().getPat().getFechaInicio(),
                                        entidad.getPrograma().getImperativoEstrategico().getPat().getFechaFinal(),entidad.getPrograma().getImperativoEstrategico().getPat().getFechaRegistro(),
                                        Usuario.of(entidad.getPrograma().getImperativoEstrategico().getPat().getUsuario().getNombreUsuario(),entidad.getPrograma().getImperativoEstrategico().getPat().getUsuario().getNombre(),
                                                entidad.getPrograma().getImperativoEstrategico().getPat().getUsuario().getApellidos(),entidad.getPrograma().getImperativoEstrategico().getPat().getUsuario().getPassword(),
                                                entidad.getPrograma().getImperativoEstrategico().getPat().getUsuario().getCorreo(),entidad.getPrograma().getImperativoEstrategico().getPat().getUsuario().getRoles().stream().map(rol -> new Rol(rol.getNombre())).toList(),
                                                Cargo.of(entidad.getPrograma().getImperativoEstrategico().getPat().getUsuario().getCargo().getNombre(),
                                                        Area.of(entidad.getPrograma().getImperativoEstrategico().getPat().getUsuario().getCargo().getArea().getNombre())))),
                                Usuario.of(entidad.getPrograma().getImperativoEstrategico().getUsuario().getNombreUsuario(),entidad.getPrograma().getImperativoEstrategico().getUsuario().getNombre(),
                                        entidad.getPrograma().getImperativoEstrategico().getUsuario().getApellidos(),entidad.getPrograma().getImperativoEstrategico().getUsuario().getPassword(),
                                        entidad.getPrograma().getImperativoEstrategico().getUsuario().getCorreo(),entidad.getPrograma().getImperativoEstrategico().getUsuario().getRoles().stream().map(rol ->
                                                new Rol(rol.getNombre())).toList(),Cargo.of(entidad.getPrograma().getImperativoEstrategico().getUsuario().getCargo().getNombre(),
                                                Area.of(entidad.getPrograma().getImperativoEstrategico().getUsuario().getCargo().getArea().getNombre())))),
                        Usuario.of(entidad.getPrograma().getUsuario().getNombreUsuario(),entidad.getPrograma().getUsuario().getNombre(),entidad.getPrograma().getUsuario().getApellidos(),entidad.getPrograma().getUsuario().getPassword(),
                                entidad.getPrograma().getUsuario().getCorreo(),entidad.getPrograma().getUsuario().getRoles().stream().map(rol -> new Rol(rol.getNombre())).toList(),
                                Cargo.of(entidad.getPrograma().getUsuario().getCargo().getNombre(),Area.of(entidad.getPrograma().getUsuario().getCargo().getArea().getNombre()))),
                        Area.of(entidad.getPrograma().getArea().getNombre())),
                Usuario.of(entidad.getUsuario().getNombreUsuario(),entidad.getUsuario().getNombre(),entidad.getUsuario().getApellidos(),entidad.getUsuario().getPassword(),
                        entidad.getUsuario().getCorreo(),entidad.getUsuario().getRoles().stream().map(rol -> new Rol(rol.getNombre())).toList(),
                        Cargo.of(entidad.getUsuario().getCargo().getNombre(),Area.of(entidad.getUsuario().getCargo().getArea().getNombre()))))).toList();
    }

    @Override
    public LineaEstrategica consultarPorId(Long id) {
        return this.repositorioLineaEstrategicaJpa
                .findById(id)
                .map(entidad -> LineaEstrategica.of(entidad.getNombre(),entidad.getEntregable(),entidad.getFechaInicio(),entidad.getFechaFinal(),
                        entidad.getFechaRegistro(),entidad.getIndicadorResultado(),
                        Programa.of(entidad.getPrograma().getNombre(), entidad.getPrograma().getCodigo(), entidad.getPrograma().getVersion(),entidad.getPrograma().getFechaInicio(),
                                entidad.getPrograma().getFechaFinal(),entidad.getPrograma().getFechaRegistro(), entidad.getPrograma().getPresupuestoIngreso(), entidad.getPrograma().getPresupuestoGasto(),
                                ImperativoEstrategico.of(entidad.getPrograma().getImperativoEstrategico().getNombre(),entidad.getPrograma().getImperativoEstrategico().getFechaInicio(),
                                        entidad.getPrograma().getImperativoEstrategico().getFechaFinal(),entidad.getPrograma().getImperativoEstrategico().getFechaRegistro(),
                                        Pat.of(entidad.getPrograma().getImperativoEstrategico().getPat().getNombre(),entidad.getPrograma().getImperativoEstrategico().getPat().getFechaInicio(),
                                                entidad.getPrograma().getImperativoEstrategico().getPat().getFechaFinal(),entidad.getPrograma().getImperativoEstrategico().getPat().getFechaRegistro(),
                                                Usuario.of(entidad.getPrograma().getImperativoEstrategico().getPat().getUsuario().getNombreUsuario(),entidad.getPrograma().getImperativoEstrategico().getPat().getUsuario().getNombre(),
                                                        entidad.getPrograma().getImperativoEstrategico().getPat().getUsuario().getApellidos(),entidad.getPrograma().getImperativoEstrategico().getPat().getUsuario().getPassword(),
                                                        entidad.getPrograma().getImperativoEstrategico().getPat().getUsuario().getCorreo(),entidad.getPrograma().getImperativoEstrategico().getPat().getUsuario().getRoles().stream().map(rol -> new Rol(rol.getNombre())).toList(),
                                                        Cargo.of(entidad.getPrograma().getImperativoEstrategico().getPat().getUsuario().getCargo().getNombre(),
                                                                Area.of(entidad.getPrograma().getImperativoEstrategico().getPat().getUsuario().getCargo().getArea().getNombre())))),
                                        Usuario.of(entidad.getPrograma().getImperativoEstrategico().getUsuario().getNombreUsuario(),entidad.getPrograma().getImperativoEstrategico().getUsuario().getNombre(),
                                                entidad.getPrograma().getImperativoEstrategico().getUsuario().getApellidos(),entidad.getPrograma().getImperativoEstrategico().getUsuario().getPassword(),
                                                entidad.getPrograma().getImperativoEstrategico().getUsuario().getCorreo(),entidad.getPrograma().getImperativoEstrategico().getUsuario().getRoles().stream().map(rol ->
                                                        new Rol(rol.getNombre())).toList(),Cargo.of(entidad.getPrograma().getImperativoEstrategico().getUsuario().getCargo().getNombre(),
                                                        Area.of(entidad.getPrograma().getImperativoEstrategico().getUsuario().getCargo().getArea().getNombre())))),
                                Usuario.of(entidad.getPrograma().getUsuario().getNombreUsuario(),entidad.getPrograma().getUsuario().getNombre(),entidad.getPrograma().getUsuario().getApellidos(),entidad.getPrograma().getUsuario().getPassword(),
                                        entidad.getPrograma().getUsuario().getCorreo(),entidad.getPrograma().getUsuario().getRoles().stream().map(rol -> new Rol(rol.getNombre())).toList(),
                                        Cargo.of(entidad.getPrograma().getUsuario().getCargo().getNombre(),Area.of(entidad.getPrograma().getUsuario().getCargo().getArea().getNombre()))),
                                Area.of(entidad.getPrograma().getArea().getNombre())),
                        Usuario.of(entidad.getUsuario().getNombreUsuario(),entidad.getUsuario().getNombre(),entidad.getUsuario().getApellidos(),entidad.getUsuario().getPassword(),
                                entidad.getUsuario().getCorreo(),entidad.getUsuario().getRoles().stream().map(rol -> new Rol(rol.getNombre())).toList(),
                                Cargo.of(entidad.getUsuario().getCargo().getNombre(),Area.of(entidad.getUsuario().getCargo().getArea().getNombre()))))).orElse(null);
    }

    @Override
    public Long guardar(LineaEstrategica lineaEstrategica) {
        EntidadPrograma entidadPrograma = this.repositorioProgramaJpa.findByNombre(lineaEstrategica.getPrograma().getNombre());
        EntidadUsuario entidadUsuario = this.repositorioUsuarioJpa.findByNombreAndApellidos(lineaEstrategica.getUsuario().getNombre(),
                lineaEstrategica.getUsuario().getApellidos());

        EntidadLineaEstrategica entidadLineaEstrategica = new EntidadLineaEstrategica(lineaEstrategica.getNombre(), lineaEstrategica.getEntregable(),
                lineaEstrategica.getFechaInicio(),lineaEstrategica.getFechaFinal(),lineaEstrategica.getFechaRegistro(),lineaEstrategica.getIndicardorResultado(),
                entidadUsuario,entidadPrograma);

        return this.repositorioProgramaJpa.save(entidadPrograma).getId();
    }

    @Override
    public boolean existe(LineaEstrategica lineaEstrategica) {
        return this.repositorioLineaEstrategicaJpa.findByNombre(lineaEstrategica.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioLineaEstrategicaJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(LineaEstrategica lineaEstrategica, Long id) {
        EntidadPrograma entidadPrograma = this.repositorioProgramaJpa.findByNombre(lineaEstrategica.getPrograma().getNombre());
        EntidadUsuario entidadUsuario = this.repositorioUsuarioJpa.findByNombreAndApellidos(lineaEstrategica.getUsuario().getNombre(),
                lineaEstrategica.getUsuario().getApellidos());

        repositorioLineaEstrategicaJpa.findById(id);
        EntidadLineaEstrategica entidadLineaEstrategica = new EntidadLineaEstrategica();
        entidadLineaEstrategica.setId(id);
        entidadLineaEstrategica.setNombre(lineaEstrategica.getNombre());

        entidadLineaEstrategica.setPrograma(entidadPrograma);
        entidadLineaEstrategica.setUsuario(entidadUsuario);

        repositorioLineaEstrategicaJpa.save(entidadLineaEstrategica);
        return id;
    }
}
