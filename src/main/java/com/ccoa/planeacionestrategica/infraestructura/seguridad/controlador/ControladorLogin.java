package com.ccoa.planeacionestrategica.infraestructura.seguridad.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoLogin;
import com.ccoa.planeacionestrategica.infraestructura.seguridad.AuthResponse;
import com.ccoa.planeacionestrategica.infraestructura.seguridad.utilidad.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/auth")
public class ControladorLogin {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Autowired
    public ControladorLogin(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody DtoLogin dtoLogin){
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(dtoLogin.getCorreo(),
                dtoLogin.getPassword());
        Authentication authentication = this.authenticationManager.authenticate(login);

        System.out.println(authentication.isAuthenticated());
        System.out.println(authentication.getPrincipal());

        String jwt = this.jwtUtil.create(dtoLogin.getCorreo(),getTipo((List<GrantedAuthority>) authentication.getAuthorities()));

        return ResponseEntity.ok(new AuthResponse(jwt));
    }

    private String getTipo(List<GrantedAuthority> authorities){
        return authorities.stream().filter(aut -> aut.getAuthority().startsWith("ROLE_")).findFirst().
                map(aut -> aut.getAuthority().equals("ROLE_ADMIN")?"A":"O").orElse("O");
    }
}
