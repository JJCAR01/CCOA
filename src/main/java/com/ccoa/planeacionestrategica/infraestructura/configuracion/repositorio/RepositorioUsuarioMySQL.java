package com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio;

import com.ccoa.planeacionestrategica.dominio.dto.DtoUsuarioResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import com.ccoa.planeacionestrategica.dominio.modelo.Usuario;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioUsuario;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadCargo;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadRol;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio.jpa.RepositorioCargoJpa;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio.jpa.RepositorioUsuarioJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioUsuarioMySQL implements RepositorioUsuario {

    private static final String MENSAJE_NO_EXISTE = "No existe algunos de los componentes con los datos ingresados";
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioCargoJpa repositorioCargoJpa;

    public RepositorioUsuarioMySQL(RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioCargoJpa repositorioCargoJpa) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioCargoJpa = repositorioCargoJpa;
    }

    @Override
    public List<DtoUsuarioResumen> listar() {

        List<EntidadUsuario> entidadUsuarios =this.repositorioUsuarioJpa.findAll();
        return entidadUsuarios.stream().map(entidad -> new DtoUsuarioResumen(entidad.getNombreUsuario(),entidad.getNombre(), entidad.getApellidos(),
                entidad.getPassword(),entidad.getCorreo(),
                Cargo.of(entidad.getCargo().getArea().getNombre(), Area.of(entidad.getCargo().getArea().getNombre())))).toList();
    }

    @Override
    public DtoUsuarioResumen consultarPorId(Long id) {
        return this.repositorioUsuarioJpa
                .findById(id)
                .map(entidad -> new DtoUsuarioResumen(entidad.getNombreUsuario(),entidad.getNombre(), entidad.getApellidos(),
                        entidad.getPassword(),entidad.getCorreo(),
                        Cargo.of(entidad.getCargo().getArea().getNombre(), Area.of(entidad.getCargo().getArea().getNombre()))))
                .orElse(null);
    }

    @Override
    public Long guardar(Usuario usuario) {
        List<EntidadRol> roles = usuario.getRoles().stream().map(rol -> new EntidadRol(rol.getRol())).toList();
        EntidadCargo entidadCargo = this.repositorioCargoJpa.findByNombre(usuario.getCargo().getNombre());

        EntidadUsuario entidadUsuario = new EntidadUsuario(usuario.getNombreUsuario(), usuario.getNombre(), usuario.getApellidos(),
                usuario.getPassword(), usuario.getCorreo(),entidadCargo,roles );

        return this.repositorioUsuarioJpa.save(entidadUsuario).getId();
    }

    @Override
    public boolean existe(Usuario usuario) {

        return this.repositorioUsuarioJpa.findByNombreAndApellidos(usuario.getNombre(), usuario.getApellidos()) != null;    }

    @Override
    public Long eliminar(Long id) {

        this.repositorioUsuarioJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Usuario usuario, Long id) {

        EntidadCargo entidadCargo =this.repositorioCargoJpa.findByNombre(usuario.getCargo().getNombre());

        repositorioUsuarioJpa.findById(id);
        EntidadUsuario entidadUsuario = new EntidadUsuario();
        entidadUsuario.setId(id);
        entidadUsuario.setNombre(usuario.getNombre());
        entidadUsuario.setApellidos(usuario.getApellidos());
        entidadUsuario.setPassword(usuario.getPassword());

        entidadUsuario.setCargo(entidadCargo);

        repositorioUsuarioJpa.save(entidadUsuario);
        return id;
    }
}
