package com.ccoa.planeacionestrategica.infraestructura.seguridad.servicio;

import com.ccoa.planeacionestrategica.dominio.modelo.area.enums.EDireccion;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.enums.EProceso;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad.EntidadUsuarioRol;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioInformacionUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.excepcion.AutorizacionExcepcion;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.ccoa.planeacionestrategica.dominio.modelo.area.enums.EDireccion.*;

@Service
@Transactional
public class ServicioSeguridadUsuario implements UserDetailsService {

    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioInformacionUsuarioJpa repositorioInformacionUsuarioJpa;

    @Autowired
    public ServicioSeguridadUsuario(RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioInformacionUsuarioJpa repositorioInformacionUsuarioJpa) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;

        this.repositorioInformacionUsuarioJpa = repositorioInformacionUsuarioJpa;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EntidadUsuario entidadUsuario = this.repositorioUsuarioJpa.findByCorreo(username);

        if (entidadUsuario == null) throw new AutorizacionExcepcion(Mensaje.USUARIO_O_CLAVE_INCORRECTOS);

        List<EDireccion> direcciones = new ArrayList<>();
        List<EProceso> procesos = new ArrayList<>();

        var todasLasInformaciones = this.repositorioInformacionUsuarioJpa.findAll();

        for (var informacionUsuario : todasLasInformaciones) {
            if (entidadUsuario.getIdUsuario().equals(informacionUsuario.getIdInformacionUsuario())) {
                direcciones.addAll(informacionUsuario.getDireccion());
                procesos.addAll(informacionUsuario.getProceso());
            }
        }
        String[] roles = entidadUsuario.getRoles().stream().map(EntidadUsuarioRol::getRol).toArray(String[]::new);
        return User.builder()
                .username(entidadUsuario.getCorreo())
                .password(entidadUsuario.getPassword())
                .authorities(this.grantedAuthorities(roles,direcciones,procesos))
                .build();
    }

    private List<GrantedAuthority> grantedAuthorities(String[] roles,List<EDireccion> direcciones,List<EProceso> procesos) {
        List<GrantedAuthority> authorities = new ArrayList<>(roles.length);

        for (String role: roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));

            for (String authority: this.getDirecciones(direcciones)) {
                authorities.add(new SimpleGrantedAuthority(authority));
            }
            for (String authority: this.getProcesos(procesos)) {
                authorities.add(new SimpleGrantedAuthority(authority));
            }
        }
        return authorities;
    }
    private String[] getDirecciones(List<EDireccion> direcciones) {
        if (direcciones == null || direcciones.isEmpty()) {
            return new String[]{};
        }

        // Suponiendo que toString() devuelve el nombre de la dirección en minúsculas
        String primeraDireccion = direcciones.get(0).toString().toLowerCase();

        return new String[]{primeraDireccion};
    }

    private String[] getProcesos(List<EProceso> procesos) {
        if (procesos == null || procesos.isEmpty()) {
            return new String[]{};
        }

        // Suponiendo que toString() devuelve el nombre de la dirección en minúsculas
        String primeraDireccion = procesos.get(0).toString().toLowerCase();

        return new String[]{primeraDireccion};
    }



}



