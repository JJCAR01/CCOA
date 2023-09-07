package com.ccoa.planeacionestrategica.infraestructura.seguridad.servicio;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.usuario.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.usuario.EntidadUsuarioRol;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.excepcion.AutorizacionExcepcion;
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

    @Autowired
    public ServicioSeguridadUsuario(RepositorioUsuarioJpa repositorioUsuarioJpa) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            EntidadUsuario entidadUsuario = this.repositorioUsuarioJpa.findByCorreo(username);

        if (entidadUsuario == null) throw new AutorizacionExcepcion("Usuario o clave incorrectos");

        String[] roles = entidadUsuario.getRoles().stream().map(EntidadUsuarioRol::getRol).toArray(String[]::new);
        return User.builder()
                .username(entidadUsuario.getCorreo())
                .password(entidadUsuario.getPassword())
                .authorities(this.grantedAuthorities(roles))
                .build();
    }

    private String[] getAuthorities(String rol) {
        if ("ADMIN".equals(rol) || "OPERADOR".equals(rol)) {
            return new String[] {"areas"};
        }

        return new String[] {};
    }

    private List<GrantedAuthority> grantedAuthorities(String[] roles) {
        List<GrantedAuthority> authorities = new ArrayList<>(roles.length);

        for (String role: roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));

            for (String authority: this.getAuthorities(role)) {
                authorities.add(new SimpleGrantedAuthority(authority));
            }
        }

        return authorities;
    }
}



