package com.ccoa.planeacionestrategica.infraestructura.seguridad.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoLoginGoogle;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.seguridad.AuthResponse;
import com.ccoa.planeacionestrategica.infraestructura.seguridad.utilidad.JwtUtil;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/ccoa/auth")
public class ControladorGoogle {
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Autowired
    public ControladorGoogle(RepositorioUsuarioJpa repositorioUsuarioJpa, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }


    @PostMapping("/google")
    public ResponseEntity<AuthResponse> loginWithGoogle(@RequestBody DtoLoginGoogle dtoGoogleLogin) {
        try {
                FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(dtoGoogleLogin.getGoogleToken());

                EntidadUsuario usuario = repositorioUsuarioJpa.findByCorreo(decodedToken.getEmail());

                UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(decodedToken.getEmail(),
                        usuario.getPassword());

                Authentication authentication = this.authenticationManager.authenticate(login);

                String jwt = this.jwtUtil.create(decodedToken.getEmail(), getTipo((List<GrantedAuthority>) authentication.getAuthorities()));

                return ResponseEntity.ok(new AuthResponse(jwt));

        } catch (FirebaseAuthException e) {
            return (ResponseEntity<AuthResponse>) ResponseEntity.internalServerError();
        }
    }
    private String getTipo(List<GrantedAuthority> authorities){
        return authorities.stream().filter(aut -> aut.getAuthority().startsWith("ROLE_")).findFirst().
                map(aut -> aut.getAuthority().equals("ROLE_ADMIN")?"ADMIN":"OPERADOR").orElse("O");
    }


}
