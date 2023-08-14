package com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.*;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioImperativoEstrategico;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadImperativoEstrategico;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadPat;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio.jpa.RepositorioImperativoEstrategicoJpa;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio.jpa.RepositorioPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio.jpa.RepositorioUsuarioJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioImperativoEstrategicoMySQL implements RepositorioImperativoEstrategico {

    private final RepositorioImperativoEstrategicoJpa repositorioImperativoEstrategicoJpa;
    private final RepositorioPatJpa repositorioPatJpa;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;

    public RepositorioImperativoEstrategicoMySQL(RepositorioImperativoEstrategicoJpa repositorioImperativoEstrategicoJpa, RepositorioPatJpa repositorioPatJpa,
                                                 RepositorioUsuarioJpa repositorioUsuarioJpa) {
        this.repositorioImperativoEstrategicoJpa = repositorioImperativoEstrategicoJpa;
        this.repositorioPatJpa = repositorioPatJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
    }

    @Override
    public List<ImperativoEstrategico> listar() {
        List<EntidadImperativoEstrategico> entidadImperativoEstrategicos =this.repositorioImperativoEstrategicoJpa.findAll();
        return entidadImperativoEstrategicos.stream().map(entidad -> ImperativoEstrategico.of(entidad.getNombre(),
                entidad.getFechaInicio(),
                entidad.getFechaFinal(),
                entidad.getFechaRegistro(),
                Pat.of(entidad.getPat().getNombre(),entidad.getPat().getFechaInicio(),
                        entidad.getPat().getFechaFinal(),entidad.getPat().getFechaRegistro(), Usuario.of(entidad.getPat().getUsuario().getNombreUsuario(),
                                entidad.getPat().getUsuario().getNombre(),entidad.getPat().getUsuario().getApellidos(),entidad.getPat().getUsuario().getPassword(),
                                entidad.getPat().getUsuario().getCorreo(),entidad.getUsuario().getRoles().stream().map(rol -> new Rol(rol.getNombre())).toList(),
                                Cargo.of(entidad.getPat().getUsuario().getCargo().getNombre(),Area.of(entidad.getPat().getUsuario().getCargo().getArea().getNombre())))),
                Usuario.of(entidad.getUsuario().getNombreUsuario(),entidad.getUsuario().getNombre(),
                        entidad.getUsuario().getApellidos(),entidad.getUsuario().getPassword(),entidad.getUsuario().getCorreo(),
                        entidad.getUsuario().getRoles().stream().map(rol -> new Rol(rol.getNombre())).toList(),
                        Cargo.of(entidad.getUsuario().getCargo().getNombre(), Area.of(entidad.getUsuario().getCargo().getArea().getNombre()))))).toList();
    }

    @Override
    public ImperativoEstrategico consultarPorId(Long id) {
        return this.repositorioImperativoEstrategicoJpa
                .findById(id)
                .map(entidad -> ImperativoEstrategico.of(entidad.getNombre(),
                        entidad.getFechaInicio(),
                        entidad.getFechaFinal(),
                        entidad.getFechaRegistro(),
                        Pat.of(entidad.getPat().getNombre(),entidad.getPat().getFechaInicio(),
                                entidad.getPat().getFechaFinal(),entidad.getPat().getFechaRegistro(), Usuario.of(entidad.getPat().getUsuario().getNombreUsuario(),
                                        entidad.getPat().getUsuario().getNombre(),entidad.getPat().getUsuario().getApellidos(),entidad.getPat().getUsuario().getPassword(),
                                        entidad.getPat().getUsuario().getCorreo(),entidad.getUsuario().getRoles().stream().map(rol -> new Rol(rol.getNombre())).toList(),
                                        Cargo.of(entidad.getPat().getUsuario().getCargo().getNombre(),Area.of(entidad.getPat().getUsuario().getCargo().getArea().getNombre())))),
                        Usuario.of(entidad.getUsuario().getNombreUsuario(),entidad.getUsuario().getNombre(),
                                entidad.getUsuario().getApellidos(),entidad.getUsuario().getPassword(),entidad.getUsuario().getCorreo(),
                                entidad.getUsuario().getRoles().stream().map(rol -> new Rol(rol.getNombre())).toList(),
                                Cargo.of(entidad.getUsuario().getCargo().getNombre(), Area.of(entidad.getUsuario().getCargo().getArea().getNombre())))))
                .orElse(null);
    }


    @Override
    public Long guardar(ImperativoEstrategico imperativoEstrategico) {
        //List<EntidadRol> roles = pat.getRoles().stream().map(rol -> new EntidadRol(rol.getRol())).toList();
        EntidadPat entidadPat = this.repositorioPatJpa.findByNombre(imperativoEstrategico.getPat().getNombre());
        EntidadUsuario entidadUsuario = this.repositorioUsuarioJpa.findByNombreAndApellidos(imperativoEstrategico.getUsuario().getNombre(),
                imperativoEstrategico.getUsuario().getApellidos());

        EntidadImperativoEstrategico entidadImperativoEstrategico = new EntidadImperativoEstrategico(imperativoEstrategico.getNombre(), imperativoEstrategico.getFechaInicio(),
                imperativoEstrategico.getFechaFinal(),imperativoEstrategico.getFechaRegistro(),
                entidadPat,entidadUsuario);

        return this.repositorioImperativoEstrategicoJpa.save(entidadImperativoEstrategico).getId();
    }

    @Override
    public boolean existe(ImperativoEstrategico imperativoEstrategico) {
        return this.repositorioImperativoEstrategicoJpa.findByNombre(imperativoEstrategico.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioImperativoEstrategicoJpa.deleteById(id);
        return id;
    }


    @Override
    public Long modificar(ImperativoEstrategico imperativoEstrategico, Long id) {

        EntidadPat entidadPat = this.repositorioPatJpa.findByNombre(imperativoEstrategico.getPat().getNombre());
        EntidadUsuario entidadUsuario = this.repositorioUsuarioJpa.findByNombreAndApellidos(imperativoEstrategico.getUsuario().getNombre(),
                imperativoEstrategico.getUsuario().getApellidos());

        repositorioImperativoEstrategicoJpa.findById(id);
        EntidadImperativoEstrategico entidadImperativoEstrategico = new EntidadImperativoEstrategico();
        entidadImperativoEstrategico.setId(id);
        entidadImperativoEstrategico.setNombre(imperativoEstrategico.getNombre());

        entidadImperativoEstrategico.setPat(entidadPat);
        entidadPat.setUsuario(entidadUsuario);

        repositorioImperativoEstrategicoJpa.save(entidadImperativoEstrategico);
        return id;
    }


}
