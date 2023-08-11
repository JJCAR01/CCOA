package com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio;

import com.ccoa.planeacionestrategica.dominio.dto.DtoUsuarioResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.*;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioPat;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.*;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio.jpa.RepositorioAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio.jpa.RepositorioPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio.jpa.RepositorioUsuarioJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioPatMySQL implements RepositorioPat {

    private final RepositorioPatJpa repositorioPatJpa;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioAreaJpa repositorioAreaJpa;

    public RepositorioPatMySQL(RepositorioPatJpa repositorioPatJpa, RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioAreaJpa repositorioAreaJpa) {
        this.repositorioPatJpa = repositorioPatJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioAreaJpa = repositorioAreaJpa;
    }

    @Override
    public List<Pat> listar() {
        List<EntidadPat> entidadPats =this.repositorioPatJpa.findAll();
        return entidadPats.stream().map(entidad -> Pat.of(entidad.getNombre(),entidad.getFechaInicio(),entidad.getFechaFinal(),
                entidad.getFechaRegistro(),Usuario.of(entidad.getUsuario().getNombreUsuario(),entidad.getUsuario().getNombre(),
                entidad.getUsuario().getApellidos(),entidad.getUsuario().getPassword(),entidad.getUsuario().getCorreo(),
                entidad.getUsuario().getRoles().stream().map(rol -> new Rol(rol.getNombre())).toList(),
                Cargo.of(entidad.getUsuario().getCargo().getNombre(), Area.of(entidad.getUsuario().getCargo().getArea().getNombre()))))).toList();
    }

    @Override
    public Pat consultarPorId(Long id) {
        return this.repositorioPatJpa
                .findById(id)
                .map(entidad ->  Pat.of(entidad.getNombre(),entidad.getFechaInicio(),entidad.getFechaFinal(),
                        entidad.getFechaRegistro(),Usuario.of(entidad.getUsuario().getNombreUsuario(),entidad.getUsuario().getNombre(),
                                entidad.getUsuario().getApellidos(),entidad.getUsuario().getPassword(),entidad.getUsuario().getCorreo(),
                                entidad.getUsuario().getRoles().stream().map(rol -> new Rol(rol.getNombre())).toList(),
                                Cargo.of(entidad.getUsuario().getCargo().getNombre(), Area.of(entidad.getUsuario().getCargo().getArea().getNombre())))))
                .orElse(null);
    }

    @Override
    public Long guardar(Pat pat) {
        //List<EntidadRol> roles = pat.getRoles().stream().map(rol -> new EntidadRol(rol.getRol())).toList();
        EntidadUsuario entidadUsuario = this.repositorioUsuarioJpa.findByNombreAndApellidos(pat.getUsuario().getNombre(),
                pat.getUsuario().getApellidos());

        EntidadPat entidadPat = new EntidadPat(pat.getNombre(), pat.getFechaInicio(), pat.getFechaFinal(),
                pat.getFechaRegistro(), entidadUsuario);

        return this.repositorioPatJpa.save(entidadPat).getId();
    }

    @Override
    public boolean existe(Pat pat) {
        return this.repositorioPatJpa.findByNombre(pat.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioPatJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Pat pat, Long id) {

        EntidadUsuario entidadUsuario = this.repositorioUsuarioJpa.findByNombreAndApellidos(pat.getUsuario().getNombre(),
                pat.getUsuario().getApellidos());

        repositorioPatJpa.findById(id);
        EntidadPat entidadPat = new EntidadPat();
        entidadPat.setId(id);
        entidadPat.setNombre(pat.getNombre());
        entidadPat.setUsuario(entidadUsuario);

        repositorioPatJpa.save(entidadPat);
        return id;
    }

}
