package com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.dto.DtoUsuarioResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Rol;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Usuario;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioUsuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad.EntidadUsuarioRol;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.mapeador.MapeadorUsuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioRolJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioUsuarioMySQL implements RepositorioUsuario {

    private final RepositorioUsuarioJpa repositorioUsuarioJpa;

    private final RepositorioRolJpa repositorioRolJpa;
    private final MapeadorUsuario mapeadorUsuario;

    public RepositorioUsuarioMySQL(RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioRolJpa repositorioRolJpa, MapeadorUsuario mapeadorUsuario) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
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
    public Long guardar(Usuario usuario, Rol rol) {
        var usuarioEntidad = this.mapeadorUsuario.mapeadorEntidad(usuario);

        this.repositorioUsuarioJpa.save(usuarioEntidad);

        EntidadUsuarioRol entidadUsuarioRol = new EntidadUsuarioRol();
        entidadUsuarioRol.setUsuario(usuarioEntidad);
        entidadUsuarioRol.setIdUsuario(usuarioEntidad.getIdUsuario());  // Utilizar el ID generado
        entidadUsuarioRol.setRol(rol.getNombreRol());

        this.repositorioRolJpa.save(entidadUsuarioRol);
        return usuarioEntidad.getIdUsuario();
    }


    @Override
    public boolean existe(Usuario usuario) {
        return this.repositorioUsuarioJpa.findByCorreo(usuario.getCorreo()) != null;
    }

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
        var entidad = this.repositorioUsuarioJpa.findById(id).orElse(null);
        assert entidad != null;
        this.mapeadorUsuario.actualizarEntidad(entidad, usuario);
        return this.repositorioUsuarioJpa.save(entidad).getIdUsuario();
    }
}
