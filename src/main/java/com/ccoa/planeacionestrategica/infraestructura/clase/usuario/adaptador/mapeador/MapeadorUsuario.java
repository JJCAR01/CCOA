package com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Rol;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Usuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.cargo.adaptador.repositorio.jpa.RepositorioCargoJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCifrarTextoEncoder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorUsuario implements MapeadorInfraestructura<EntidadUsuario,Usuario> {

    private final ServicioCifrarTextoEncoder passwordEncoder;
    private final RepositorioCargoJpa repositorioCargoJpa;

    public MapeadorUsuario(ServicioCifrarTextoEncoder passwordEncoder, RepositorioCargoJpa repositorioCargoJpa) {
        this.passwordEncoder = passwordEncoder;
        this.repositorioCargoJpa = repositorioCargoJpa;
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
}
