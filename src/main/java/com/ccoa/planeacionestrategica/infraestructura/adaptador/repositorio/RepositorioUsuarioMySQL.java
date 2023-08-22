package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio;

import com.ccoa.planeacionestrategica.dominio.dto.DtoUsuarioResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.Rol;
import com.ccoa.planeacionestrategica.dominio.modelo.Usuario;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadCargo;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadRol;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioCargoJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioRolJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RepositorioUsuarioMySQL implements RepositorioUsuario {

    private static final String MENSAJE_NO_EXISTE = "No existe algunos de los componentes con los datos ingresados";
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioCargoJpa repositorioCargoJpa;
    private final RepositorioRolJpa repositorioRolJpa;

    public RepositorioUsuarioMySQL(RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioCargoJpa repositorioCargoJpa, RepositorioRolJpa repositorioRolJpa) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioCargoJpa = repositorioCargoJpa;
        this.repositorioRolJpa = repositorioRolJpa;
    }

    @Override
    public List<DtoUsuarioResumen> listar() {
        List<EntidadUsuario> entidadUsuarios =this.repositorioUsuarioJpa.findAll();
        return entidadUsuarios.stream().map(entidad -> new DtoUsuarioResumen(entidad.getNombreUsuario(),entidad.getNombre(), entidad.getApellido(),
                entidad.getPassword(),entidad.getCorreo(), entidad.getIdCargo())).toList();

    }

    @Override
    public DtoUsuarioResumen consultarPorId(Long id) {

        return this.repositorioUsuarioJpa
                .findById(id)
                .map(entidad -> new DtoUsuarioResumen(entidad.getNombreUsuario(),entidad.getNombre(), entidad.getApellido(),
                        entidad.getPassword(),entidad.getCorreo(), entidad.getIdCargo()))
                .orElse(null);
    }


    @Override
    public Long guardar(Usuario usuario) {
        //List<EntidadRol> roles = usuario.getIdRol().stream().map(rol -> new EntidadRol(rol.getRol())).toList();
        Optional<EntidadCargo> entidadCargo = this.repositorioCargoJpa.findById(usuario.getIdCargo());
        Optional<EntidadRol> entidadRol = this.repositorioRolJpa.findById(usuario.getIdCargo());

        EntidadUsuario entidadUsuario = new EntidadUsuario(usuario.getNombreUsuario(), usuario.getNombre(), usuario.getApellido(),
                usuario.getPassword(), usuario.getCorreo(), entidadCargo.get().getId_cargo() ,entidadRol.get().getId_rol());

        return this.repositorioUsuarioJpa.save(entidadUsuario).getId_usuario();
    }

    @Override
    public boolean existe(Usuario usuario) {

        return this.repositorioUsuarioJpa.findByNombreAndApellido(usuario.getNombre(), usuario.getApellido()) != null;    }

    @Override
    public Long eliminar(Long id) {

        this.repositorioUsuarioJpa.deleteById(id);
        return id;
    }

    @Override
    public Usuario consultar(String nombreUsuario, String password) {
        EntidadUsuario entidadUsuario = this.repositorioUsuarioJpa.findByNombreUsuarioAndPassword(nombreUsuario, password);

        //List<Rol> roles = entidadUsuario.getIdRol().stream().map(rol -> Rol.of(rol.getRol())).collect(Collectors.toList());
        return Usuario.of(entidadUsuario.getNombreUsuario(),entidadUsuario.getNombre(), entidadUsuario.getApellido(), entidadUsuario.getPassword(),
                entidadUsuario.getCorreo(),entidadUsuario.getIdCargo(),entidadUsuario.getIdRol());
    }

    @Override
    public Long modificar(Usuario usuario, Long id) {

        Optional<EntidadCargo> entidadCargo =this.repositorioCargoJpa.findById(usuario.getIdCargo());

        repositorioUsuarioJpa.findById(id);
        EntidadUsuario entidadUsuario = new EntidadUsuario();
        entidadUsuario.setId_usuario(id);
        entidadUsuario.setNombre(usuario.getNombre());
        entidadUsuario.setApellido(usuario.getApellido());
        entidadUsuario.setPassword(usuario.getPassword());

        entidadUsuario.setIdCargo(entidadCargo.get().getIdArea());

        repositorioUsuarioJpa.save(entidadUsuario);
        return id;
    }
}
