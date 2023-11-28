package com.ccoa.planeacionestrategica.infraestructura.seguridad.filtro;

import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Usuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class FirebaseFilter extends OncePerRequestFilter {
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;

    public FirebaseFilter(RepositorioUsuarioJpa repositorioUsuarioJpa) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String idToken = request.getHeader(HttpHeaders.AUTHORIZATION);

            if (idToken != null) {
                FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);

                System.out.println("UID: " + decodedToken.getUid());
                System.out.println("Correo electrónico: " + decodedToken.getEmail());

                // Aquí puedes realizar operaciones adicionales, como verificar si el usuario existe en tu base de datos
                String uid = decodedToken.getUid();
                String email = decodedToken.getEmail();
                // Otros datos del usuario según tus necesidades

                EntidadUsuario usuario = repositorioUsuarioJpa.findByCorreo(email);

                Collection<? extends GrantedAuthority> authorities = usuario.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role.getRol())) // Supongo que tu entidad EntidadUsuarioRol tiene un campo "nombre" que representa el nombre del rol
                        .toList();

                // Crear la autenticación de Spring Security
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(uid, email, authorities);

                // Establecer la autenticación en el contexto de seguridad de Spring
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        } catch (FirebaseAuthException e) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }

        filterChain.doFilter(request, response);
    }
}
