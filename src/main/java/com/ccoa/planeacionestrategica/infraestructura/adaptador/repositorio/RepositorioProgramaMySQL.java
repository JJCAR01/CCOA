package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.*;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioPrograma;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadImperativoEstrategico;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadPrograma;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioProgramaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.*;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioImperativoEstrategicoJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioProgramaMySQL implements RepositorioPrograma {

    private final RepositorioProgramaJpa repositorioProgramaJpa;
    private final RepositorioImperativoEstrategicoJpa repositorioImperativoEstrategicoJpa;
    private final RepositorioAreaJpa repositorioAreaJpa;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;

    public RepositorioProgramaMySQL(RepositorioProgramaJpa repositorioProgramaJpa, RepositorioImperativoEstrategicoJpa repositorioImperativoEstrategicoJpa,
                                    RepositorioAreaJpa repositorioAreaJpa, RepositorioUsuarioJpa repositorioUsuarioJpa) {
        this.repositorioProgramaJpa = repositorioProgramaJpa;
        this.repositorioImperativoEstrategicoJpa = repositorioImperativoEstrategicoJpa;
        this.repositorioAreaJpa = repositorioAreaJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
    }

    @Override
    public List<Programa> listar() {
        List<EntidadPrograma> programas = this.repositorioProgramaJpa.findAll();
        return programas.stream().map(entidad -> Programa.of(entidad.getNombre(), entidad.getCodigo(), entidad.getVersion(),entidad.getFechaInicio(),
                entidad.getFechaFinal(),entidad.getFechaRegistro(), entidad.getPresupuestoIngreso(), entidad.getPresupuestoGasto(),
                ImperativoEstrategico.of(entidad.getImperativoEstrategico().getNombre(),entidad.getImperativoEstrategico().getFechaInicio(),
                        entidad.getImperativoEstrategico().getFechaFinal(),entidad.getImperativoEstrategico().getFechaRegistro(),
                        Pat.of(entidad.getImperativoEstrategico().getPat().getNombre(),entidad.getImperativoEstrategico().getPat().getFechaInicio(),
                            entidad.getImperativoEstrategico().getPat().getFechaFinal(),entidad.getImperativoEstrategico().getPat().getFechaRegistro(),
                            Usuario.of(entidad.getImperativoEstrategico().getPat().getUsuario().getNombreUsuario(),entidad.getImperativoEstrategico().getPat().getUsuario().getNombre(),
                                entidad.getImperativoEstrategico().getPat().getUsuario().getApellidos(),entidad.getImperativoEstrategico().getPat().getUsuario().getPassword(),
                                entidad.getImperativoEstrategico().getPat().getUsuario().getCorreo(),entidad.getImperativoEstrategico().getPat().getUsuario().getRoles().stream().map(rol -> new Rol(rol.getNombre())).toList(),
                                Cargo.of(entidad.getImperativoEstrategico().getPat().getUsuario().getCargo().getNombre(),
                                    Area.of(entidad.getImperativoEstrategico().getPat().getUsuario().getCargo().getArea().getNombre())))),
                        Usuario.of(entidad.getImperativoEstrategico().getUsuario().getNombreUsuario(),entidad.getImperativoEstrategico().getUsuario().getNombre(),
                                entidad.getImperativoEstrategico().getUsuario().getApellidos(),entidad.getImperativoEstrategico().getUsuario().getPassword(),
                                entidad.getImperativoEstrategico().getUsuario().getCorreo(),entidad.getImperativoEstrategico().getUsuario().getRoles().stream().map(rol ->
                                        new Rol(rol.getNombre())).toList(),Cargo.of(entidad.getImperativoEstrategico().getUsuario().getCargo().getNombre(),
                                        Area.of(entidad.getImperativoEstrategico().getUsuario().getCargo().getArea().getNombre())))),
                Usuario.of(entidad.getUsuario().getNombreUsuario(),entidad.getUsuario().getNombre(),entidad.getUsuario().getApellidos(),entidad.getUsuario().getPassword(),
                        entidad.getUsuario().getCorreo(),entidad.getUsuario().getRoles().stream().map(rol -> new Rol(rol.getNombre())).toList(),
                        Cargo.of(entidad.getUsuario().getCargo().getNombre(),Area.of(entidad.getUsuario().getCargo().getArea().getNombre()))),
                Area.of(entidad.getArea().getNombre()))).toList();
    }

    @Override
    public Programa consultarPorId(Long id) {
        return this.repositorioProgramaJpa
                .findById(id)
                .map(entidad ->  Programa.of(entidad.getNombre(), entidad.getCodigo(), entidad.getVersion(),entidad.getFechaInicio(),
                        entidad.getFechaFinal(),entidad.getFechaRegistro(), entidad.getPresupuestoIngreso(),entidad.getPresupuestoGasto(),
                                    ImperativoEstrategico.of(entidad.getImperativoEstrategico().getNombre(),entidad.getImperativoEstrategico().getFechaInicio(),
                                        entidad.getImperativoEstrategico().getFechaFinal(),entidad.getImperativoEstrategico().getFechaRegistro(),
                                        Pat.of(entidad.getImperativoEstrategico().getPat().getNombre(),entidad.getImperativoEstrategico().getPat().getFechaInicio(),
                                                entidad.getImperativoEstrategico().getPat().getFechaFinal(),entidad.getImperativoEstrategico().getPat().getFechaRegistro(),
                                                Usuario.of(entidad.getImperativoEstrategico().getPat().getUsuario().getNombreUsuario(),entidad.getImperativoEstrategico().getPat().getUsuario().getNombre(),
                                                        entidad.getImperativoEstrategico().getPat().getUsuario().getApellidos(),entidad.getImperativoEstrategico().getPat().getUsuario().getPassword(),
                                                        entidad.getImperativoEstrategico().getPat().getUsuario().getCorreo(),entidad.getImperativoEstrategico().getPat().getUsuario().getRoles().stream().map(rol -> new Rol(rol.getNombre())).toList(),
                                                        Cargo.of(entidad.getImperativoEstrategico().getPat().getUsuario().getCargo().getNombre(),
                                                                Area.of(entidad.getImperativoEstrategico().getPat().getUsuario().getCargo().getArea().getNombre())))),
                                        Usuario.of(entidad.getImperativoEstrategico().getUsuario().getNombreUsuario(),entidad.getImperativoEstrategico().getUsuario().getNombre(),
                                                entidad.getImperativoEstrategico().getUsuario().getApellidos(),entidad.getImperativoEstrategico().getUsuario().getPassword(),
                                                entidad.getImperativoEstrategico().getUsuario().getCorreo(),entidad.getImperativoEstrategico().getUsuario().getRoles().stream().map(rol ->
                                                        new Rol(rol.getNombre())).toList(),Cargo.of(entidad.getImperativoEstrategico().getUsuario().getCargo().getNombre(),
                                                        Area.of(entidad.getImperativoEstrategico().getUsuario().getCargo().getArea().getNombre())))),
                                Usuario.of(entidad.getUsuario().getNombreUsuario(),entidad.getUsuario().getNombre(),entidad.getUsuario().getApellidos(),entidad.getUsuario().getPassword(),
                                        entidad.getUsuario().getCorreo(),entidad.getUsuario().getRoles().stream().map(rol -> new Rol(rol.getNombre())).toList(),
                                        Cargo.of(entidad.getUsuario().getCargo().getNombre(),Area.of(entidad.getUsuario().getCargo().getArea().getNombre()))),
                                Area.of(entidad.getArea().getNombre()))).orElse(null);
    }

    @Override
    public Long guardar(Programa programa) {
        EntidadImperativoEstrategico entidadImperativoEstrategico = this.repositorioImperativoEstrategicoJpa.findByNombre(programa.getImperativoEstrategico().getNombre());
        EntidadArea entidadArea = this.repositorioAreaJpa.findByNombre(programa.getArea().getNombre());
        EntidadUsuario entidadUsuario = this.repositorioUsuarioJpa.findByNombreAndApellidos(programa.getUsuario().getNombre(),
                programa.getUsuario().getApellidos());

        EntidadPrograma entidadPrograma = new EntidadPrograma(programa.getNombre(), programa.getCodigo(), programa.getVersion(), programa.getFechaInicio(),
                programa.getFechaFinal(),programa.getFechaRegistro(),programa.getPresupuestoIngreso(),programa.getPresupuestoGasto(),entidadArea,entidadUsuario,
                entidadImperativoEstrategico);

        return this.repositorioProgramaJpa.save(entidadPrograma).getId();
    }

    @Override
    public boolean existe(Programa programa) {
        return this.repositorioProgramaJpa.findByNombre(programa.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioProgramaJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Programa programa, Long id) {

        EntidadImperativoEstrategico entidadImperativoEstrategico = this.repositorioImperativoEstrategicoJpa.findByNombre(programa.getImperativoEstrategico().getNombre());
        EntidadArea entidadArea = this.repositorioAreaJpa.findByNombre(programa.getArea().getNombre());
        EntidadUsuario entidadUsuario = this.repositorioUsuarioJpa.findByNombreAndApellidos(programa.getUsuario().getNombre(),
                programa.getUsuario().getApellidos());

        repositorioProgramaJpa.findById(id);
        EntidadPrograma entidadPrograma = new EntidadPrograma();
        entidadPrograma.setId(id);
        entidadPrograma.setNombre(programa.getNombre());

        entidadPrograma.setArea(entidadArea);
        entidadPrograma.setUsuario(entidadUsuario);
        entidadPrograma.setImperativoEstrategico(entidadImperativoEstrategico);

        repositorioProgramaJpa.save(entidadPrograma);
        return id;
    }
}
