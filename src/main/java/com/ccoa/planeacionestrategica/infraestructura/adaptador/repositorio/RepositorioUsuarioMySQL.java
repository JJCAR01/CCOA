package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio;

import com.ccoa.planeacionestrategica.dominio.dto.DtoUsuarioResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Rol;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Usuario;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadCargo;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.usuario.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.usuario.EntidadUsuarioRol;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioCargoJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioRolJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioUsuarioMySQL implements RepositorioUsuario {

    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioCargoJpa repositorioCargoJpa;
    private final RepositorioRolJpa repositorioRolJpa;
    private final PasswordEncoder passwordEncoder;

    public RepositorioUsuarioMySQL(RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioCargoJpa repositorioCargoJpa, RepositorioRolJpa repositorioRolJpa, PasswordEncoder passwordEncoder) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioCargoJpa = repositorioCargoJpa;
        this.repositorioRolJpa = repositorioRolJpa;
        this.passwordEncoder = passwordEncoder;
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
        Optional<EntidadCargo> entidadCargo = this.repositorioCargoJpa.findById(usuario.getIdCargo());

        // Paso 1: Guardar al usuario
        EntidadUsuario entidadUsuario = new EntidadUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(),
                passwordEncoder.encode(usuario.getPassword()), entidadCargo.orElseThrow().getIdCargo());

        entidadUsuario = this.repositorioUsuarioJpa.save(entidadUsuario);

        // Paso 2: Obtener el ID del usuario y asignarlo a los roles
        Long idUsuario = entidadUsuario.getIdUsuario();

        List<EntidadUsuarioRol> roles = usuario.getRoles().stream()
                .map(rol -> new EntidadUsuarioRol(idUsuario, rol.getRol())).toList();

        // Guardar los roles en la tabla rol_usuario
        repositorioRolJpa.saveAll(roles);

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
