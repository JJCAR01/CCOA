package com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.dto.DtoUsuarioResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Rol;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Usuario;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioUsuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.cargo.adaptador.entidad.EntidadCargo;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.cargo.adaptador.repositorio.jpa.RepositorioCargoJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad.EntidadUsuarioRol;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.mapeador.MapeadorUsuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioRolJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioUsuarioMySQL implements RepositorioUsuario {

    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioCargoJpa repositorioCargoJpa;
    private final RepositorioRolJpa repositorioRolJpa;
    private final MapeadorUsuario mapeadorUsuario;

    public RepositorioUsuarioMySQL(RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioCargoJpa repositorioCargoJpa, RepositorioRolJpa repositorioRolJpa, MapeadorUsuario mapeadorUsuario) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioCargoJpa = repositorioCargoJpa;
        this.repositorioRolJpa = repositorioRolJpa;
        this.mapeadorUsuario = mapeadorUsuario;
    }

    public List<DtoUsuarioResumen> listar() {
        List<EntidadUsuario> entidadUsuarios =this.repositorioUsuarioJpa.findAll();
        return entidadUsuarios.stream().map(entidad -> new DtoUsuarioResumen(entidad.getIdUsuario(), entidad.getNombre(), entidad.getApellido(),entidad.getCorreo(), entidad.getIdCargo())).toList();

    }
    @Override
    public DtoUsuarioResumen consultarPorId(Long id) {

        return this.repositorioUsuarioJpa
                .findById(id)
                .map(entidad -> new DtoUsuarioResumen(entidad.getIdUsuario(), entidad.getNombre(), entidad.getApellido(), entidad.getCorreo(), entidad.getIdCargo()))
                .orElse(null);
    }

    @Override
    public Long guardar(Usuario usuario) {
        Long idUsuario = this.repositorioUsuarioJpa.save(this.mapeadorUsuario.mapeadorEntidad(usuario)).getIdUsuario();
        usuario.getRoles().stream()
                .map(rol -> {
                    EntidadUsuarioRol entidadUsuarioRol = new EntidadUsuarioRol();
                    entidadUsuarioRol.setIdUsuario(idUsuario);
                    entidadUsuarioRol.setRol(rol.getNombre());
                    return entidadUsuarioRol;
                })
                .forEach(repositorioRolJpa::save);
        return idUsuario;
    }


    @Override
    public boolean existe(Usuario usuario) {

        return this.repositorioUsuarioJpa.findByCorreo(usuario.getCorreo()) != null;    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioRolJpa.deleteById(id);
        this.repositorioUsuarioJpa.deleteById(id);
        return id;
    }

    @Override
    public Usuario consultar(String correo, String password) {
        EntidadUsuario entidadUsuario = this.repositorioUsuarioJpa.findByCorreoAndPassword(correo, password);

        if(entidadUsuario == null) {
            return null;
        }

        List<Rol> roles = entidadUsuario.getRoles().stream().map(rol -> Rol.of(rol.getIdUsuario(), rol.getRol())).toList();

        return Usuario.of(entidadUsuario.getIdUsuario(), entidadUsuario.getNombre(), entidadUsuario.getApellido(), entidadUsuario.getCorreo(), entidadUsuario.getPassword(),
                entidadUsuario.getIdCargo(),roles);
    }

    @Override
    public Long modificar(Usuario usuario, Long id) {

        Optional<EntidadCargo> entidadCargo =this.repositorioCargoJpa.findById(usuario.getIdCargo());

        repositorioUsuarioJpa.findById(id);
        EntidadUsuario entidadUsuario = new EntidadUsuario();
        entidadUsuario.setIdUsuario(id);
        entidadUsuario.setNombre(usuario.getNombre());
        entidadUsuario.setApellido(usuario.getApellido());
        entidadUsuario.setPassword(usuario.getPassword());

        entidadUsuario.setIdCargo(entidadCargo.get().getIdCargo());

        repositorioUsuarioJpa.save(entidadUsuario);
        return id;
    }
}
