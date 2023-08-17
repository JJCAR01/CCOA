package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio;

import com.ccoa.planeacionestrategica.dominio.dto.DtoUsuarioResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import com.ccoa.planeacionestrategica.dominio.modelo.Usuario;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadCargo;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadRol;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioCargoJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioRolJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import org.springframework.stereotype.Repository;

import java.lang.ref.PhantomReference;
import java.util.List;
import java.util.Optional;

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
        return entidadUsuarios.stream().map(entidad -> new DtoUsuarioResumen(entidad.getNombreUsuario(),entidad.getNombre(), entidad.getApellidos(),
                entidad.getPassword(),entidad.getCorreo(), entidad.getIdCargo())).toList();

    }

    @Override
    public DtoUsuarioResumen consultarPorId(Long id) {

        return this.repositorioUsuarioJpa
                .findById(id)
                .map(entidad -> new DtoUsuarioResumen(entidad.getNombreUsuario(),entidad.getNombre(), entidad.getApellidos(),
                        entidad.getPassword(),entidad.getCorreo(), entidad.getIdCargo()))
                .orElse(null);
    }


    @Override
    public Long guardar(Usuario usuario) {
        Optional<EntidadCargo> entidadCargo = this.repositorioCargoJpa.findById(usuario.getIdCargo());
        Optional<EntidadRol> entidadRol = this.repositorioRolJpa.findById(usuario.getIdCargo());

        EntidadUsuario entidadUsuario = new EntidadUsuario(usuario.getNombreUsuario(), usuario.getNombre(), usuario.getApellidos(),
                usuario.getPassword(), usuario.getCorreo(), entidadRol.get().getId(), entidadCargo.get().getId() );

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

        Optional<EntidadCargo> entidadCargo =this.repositorioCargoJpa.findById(usuario.getIdCargo());

        repositorioUsuarioJpa.findById(id);
        EntidadUsuario entidadUsuario = new EntidadUsuario();
        entidadUsuario.setId(id);
        entidadUsuario.setNombre(usuario.getNombre());
        entidadUsuario.setApellidos(usuario.getApellidos());
        entidadUsuario.setPassword(usuario.getPassword());

        entidadUsuario.setIdCargo(entidadCargo.get().getIdArea());

        repositorioUsuarioJpa.save(entidadUsuario);
        return id;
    }
}
