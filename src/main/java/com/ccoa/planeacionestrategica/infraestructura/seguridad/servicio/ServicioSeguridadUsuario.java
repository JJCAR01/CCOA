package com.ccoa.planeacionestrategica.infraestructura.seguridad.servicio;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.direccion.adaptador.entidad.EntidadDireccion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.entidad.EntidadPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.entidad.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.entidad.EntidadUsuarioRol;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa.RepositorioInformacionUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
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

        List<EntidadDireccion> direcciones = new ArrayList<>();
        List<EntidadPat> pats = new ArrayList<>();

        var todasLasInformaciones = this.repositorioInformacionUsuarioJpa.findAll();

        for (var informacionUsuario : todasLasInformaciones) {
            if (entidadUsuario.getIdUsuario().equals(informacionUsuario.getIdInformacionUsuario())) {
                direcciones.addAll(informacionUsuario.getDireccion());
                pats.addAll(informacionUsuario.getPats());
            }
        }
        String[] roles = entidadUsuario.getRoles().stream().map(EntidadUsuarioRol::getNombreRol).toArray(String[]::new);
        return User.builder()
                .username(entidadUsuario.getCorreo())
                .password(entidadUsuario.getPassword())
                .authorities(this.grantedAuthorities(roles,direcciones,pats))
                .build();
    }

    private List<GrantedAuthority> grantedAuthorities(String[] roles, List<EntidadDireccion> direcciones, List<EntidadPat> pats) {
        List<GrantedAuthority> authorities = new ArrayList<>(roles.length);

        for (String role: roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));

            for (String authority: this.getDirecciones(direcciones)) {
                authorities.add(new SimpleGrantedAuthority(authority));
            }
            for (String authority: this.getPats(pats)) {
                authorities.add(new SimpleGrantedAuthority(authority));
            }
        }
        return authorities;
    }
    private String[] getDirecciones(List<EntidadDireccion> direcciones) {
        if (direcciones == null || direcciones.isEmpty()) {
            return new String[]{};
        }

        List<String> nombresDirecciones = direcciones.stream()
                .map(EntidadDireccion::getNombre)
                .toList();

        return nombresDirecciones.toArray(new String[0]);
    }


    private String[] getPats(List<EntidadPat> pats) {
        if (pats == null || pats.isEmpty()) {
            return new String[]{};
        }

        List<String> nombrePats = pats.stream()
                .map(EntidadPat::getNombre)
                .toList();

        return nombrePats.toArray(new String[0]);
    }



}



