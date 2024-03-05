package com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.direccion.DtoDireccion;
import com.ccoa.planeacionestrategica.aplicacion.dto.usuario.DtoPatUsuario;
import com.ccoa.planeacionestrategica.dominio.dto.DtoUsuarioResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Rol;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Usuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.cargo.adaptador.repositorio.jpa.RepositorioCargoJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.direccion.adaptador.entidad.EntidadDireccion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.entidad.EntidadPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.entidad.EntidadInformacionUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.entidad.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa.RepositorioInformacionUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCifrarTextoEncoder;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public void actualizarPass(EntidadUsuario entidad, Usuario usuario) {
        entidad.setPassword(passwordEncoder.ejecutar(usuario.getPassword()));
    }

    public void actualizarEntidad(EntidadUsuario entidad, Usuario usuario) {
        entidad.setNombre(usuario.getNombre());
        entidad.setApellido(usuario.getApellido());
        entidad.setCorreo(usuario.getCorreo());
        entidad.setIdCargo(usuario.getIdCargo());
    }

    public List<DtoUsuarioResumen> listarDominio(List<EntidadUsuario> entidades) {
        List<DtoUsuarioResumen> listaDto = new ArrayList<>();
        for (EntidadUsuario entidad : entidades) {
            DtoUsuarioResumen dto = new DtoUsuarioResumen();
            dto.setIdUsuario(entidad.getIdUsuario());
            dto.setNombre(entidad.getNombre());
            dto.setApellidos(entidad.getApellido());
            dto.setCorreo(entidad.getCorreo());
            dto.setIdCargo(entidad.getIdCargo());

            var infEntidadOptional = this.repositorioInformacionUsuarioJpa.findById(entidad.getIdUsuario());

            if (infEntidadOptional.isPresent()) {
                var infEntidad = infEntidadOptional.get();

                List<DtoDireccion> dtoDirecciones = infEntidad.getDireccion()
                        .stream()
                        .map(this::mapearDireccion)
                        .toList();
                dto.setDirecciones(dtoDirecciones);

                List<DtoPatUsuario> dtoPats = infEntidad.getPats()
                        .stream()
                        .map(this::mapearPat)
                        .toList();
                dto.setPats(dtoPats);

                listaDto.add(dto);
            }
        }
        return listaDto;
    }

    public DtoUsuarioResumen mapeadorDominioUsuario(EntidadUsuario entidad, EntidadInformacionUsuario informacionUsuario) {
        // Mapear la lista de DtoDireccion
        List<DtoDireccion> dtoDirecciones = informacionUsuario.getDireccion()
                .stream()
                .map(this::mapearDireccion)
                .toList();

        // Mapear la lista de DtoProceso
        List<DtoPatUsuario> dtoPats = informacionUsuario.getPats()
                .stream()
                .map(this::mapearPat)
                .toList();
        return new DtoUsuarioResumen(entidad.getIdUsuario(), entidad.getNombre(), entidad.getApellido(),entidad.getCorreo(),
                dtoDirecciones, dtoPats, entidad.getIdCargo());
    }

    public DtoDireccion mapearDireccion(EntidadDireccion entidadDireccion) {
        DtoDireccion dtoDireccion = new DtoDireccion();
        dtoDireccion.setNombre(entidadDireccion.getNombre());
        // Mapear otros atributos según sea necesario
        return dtoDireccion;
    }

    public DtoPatUsuario mapearPat(EntidadPat entidadPat) {
        DtoPatUsuario dtoPat = new DtoPatUsuario();
        dtoPat.setNombre(entidadPat.getNombre());
        // Mapear otros atributos según sea necesario
        return dtoPat;
    }
}
