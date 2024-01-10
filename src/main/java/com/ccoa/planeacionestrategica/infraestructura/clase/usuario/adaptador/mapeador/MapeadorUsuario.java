package com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.direccion.DtoDireccion;
import com.ccoa.planeacionestrategica.aplicacion.dto.proceso.DtoProceso;
import com.ccoa.planeacionestrategica.dominio.dto.DtoUsuarioResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Rol;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Usuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.cargo.adaptador.repositorio.jpa.RepositorioCargoJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.direccion.adaptador.entidad.EntidadDireccion;
import com.ccoa.planeacionestrategica.infraestructura.clase.proceso.adaptador.entidad.EntidadProceso;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad.EntidadInformacionUsuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioInformacionUsuarioJpa;
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

    public void actualizarEntidad(EntidadUsuario entidad, Usuario usuario) {
        entidad.setNombre(usuario.getNombre());
        entidad.setApellido(usuario.getApellido());
        entidad.setPassword(usuario.getPassword());
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

                List<DtoProceso> dtoProcesos = infEntidad.getProcesos()
                        .stream()
                        .map(this::mapearProceso)
                        .toList();
                dto.setProcesos(dtoProcesos);

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
        List<DtoProceso> dtoProcesos = informacionUsuario.getProcesos()
                .stream()
                .map(this::mapearProceso)
                .collect(Collectors.toList());
        return new DtoUsuarioResumen(entidad.getIdUsuario(), entidad.getNombre(), entidad.getApellido(),entidad.getCorreo(),
                dtoDirecciones, dtoProcesos, entidad.getIdCargo());
    }

    public DtoDireccion mapearDireccion(EntidadDireccion entidadDireccion) {
        DtoDireccion dtoDireccion = new DtoDireccion();
        dtoDireccion.setNombre(entidadDireccion.getNombre());
        // Mapear otros atributos según sea necesario
        return dtoDireccion;
    }

    public DtoProceso mapearProceso(EntidadProceso entidadProceso) {
        DtoProceso dtoProceso = new DtoProceso();
        dtoProceso.setNombre(entidadProceso.getNombre());
        // Mapear otros atributos según sea necesario
        return dtoProceso;
    }
}
