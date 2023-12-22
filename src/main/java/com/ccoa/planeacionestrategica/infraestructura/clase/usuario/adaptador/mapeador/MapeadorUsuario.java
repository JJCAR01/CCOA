package com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoProyectoResumen;
import com.ccoa.planeacionestrategica.dominio.dto.DtoUsuarioResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Rol;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Usuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.cargo.adaptador.repositorio.jpa.RepositorioCargoJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad.EntidadDetalleProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad.EntidadInformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad.EntidadProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad.EntidadInformacionUsuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioInformacionUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCifrarTextoEncoder;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorUsuario implements MapeadorInfraestructura<EntidadUsuario,Usuario> {

    private final ServicioCifrarTextoEncoder passwordEncoder;
    private final RepositorioCargoJpa repositorioCargoJpa;
    private final RepositorioInformacionUsuarioJpa repositorioInformacionUsuarioJpa;

    public MapeadorUsuario(ServicioCifrarTextoEncoder passwordEncoder, RepositorioCargoJpa repositorioCargoJpa,
                           RepositorioInformacionUsuarioJpa repositorioInformacionUsuarioJpa) {
        this.passwordEncoder = passwordEncoder;
        this.repositorioCargoJpa = repositorioCargoJpa;
        this.repositorioInformacionUsuarioJpa = repositorioInformacionUsuarioJpa;
    }

    @Override
    public Usuario mapeadorDominio(EntidadUsuario entidad) {
        return Usuario.of(entidad.getIdUsuario(), entidad.getNombre(), entidad.getApellido(), entidad.getPassword(),
                entidad.getCorreo(), entidad.getIdCargo(), entidad.getRoles().stream().map(rol -> Rol.of(rol.getIdUsuario(), rol.getRol())).toList());
    }

    @Override
    public EntidadUsuario mapeadorEntidad(Usuario dominio) {
        var idCargo = this.repositorioCargoJpa.findById(dominio.getIdCargo()).orElseThrow().getIdCargo();
        return new EntidadUsuario(dominio.getNombre(), dominio.getApellido(), dominio.getCorreo(),passwordEncoder.ejecutar(dominio.getPassword()),
                idCargo);
    }

    public void actualizarEntidad(EntidadUsuario entidad, Usuario usuario) {
        entidad.setNombre(usuario.getNombre());
        entidad.setApellido(usuario.getApellido());
        entidad.setPassword(usuario.getPassword());
    }

    public List<DtoUsuarioResumen> listarDominio(List<EntidadUsuario> entidades){
        List<DtoUsuarioResumen> listaDto = new ArrayList<>();
        for (EntidadUsuario entidad : entidades) {
            DtoUsuarioResumen dto = new DtoUsuarioResumen();
            dto.setIdUsuario(entidad.getIdUsuario());
            dto.setNombre(entidad.getNombre());
            dto.setApellidos(entidad.getApellido());
            dto.setCorreo(entidad.getCorreo());
            dto.setIdCargo(entidad.getIdCargo());

            var infEntidad = this.repositorioInformacionUsuarioJpa.findById(entidad.getIdUsuario());

            dto.setDirecciones(infEntidad.orElseThrow().getDireccion());
            dto.setProcesos(infEntidad.orElseThrow().getProcesos());

            listaDto.add(dto);
        }
        return listaDto;
    }

    public DtoUsuarioResumen mapeadorDominioUsuario(EntidadUsuario entidad, EntidadInformacionUsuario informacionUsuario) {
        return new DtoUsuarioResumen(entidad.getIdUsuario(), entidad.getNombre(), entidad.getApellido(),entidad.getCorreo(),
                informacionUsuario.getDireccion(), informacionUsuario.getProcesos(), entidad.getIdCargo());
    }
}
