package com.ccoa.planeacionestrategica.infraestructura.seguridad.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.login.DtoLogin;
import com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.servicio.ServicioAplicacionListarUsuario;
import com.ccoa.planeacionestrategica.infraestructura.seguridad.AuthResponse;
import com.ccoa.planeacionestrategica.infraestructura.seguridad.utilidad.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final ServicioAplicacionListarUsuario servicioAplicacionListarUsuario;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Autowired
    public ControladorLogin(ServicioAplicacionListarUsuario servicioAplicacionListarUsuario, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.servicioAplicacionListarUsuario = servicioAplicacionListarUsuario;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody DtoLogin dtoLogin){
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(dtoLogin.getCorreo(),
                dtoLogin.getPassword());
        Authentication authentication = this.authenticationManager.authenticate(login);

        String jwt = this.jwtUtil.create(dtoLogin.getCorreo(),getTipo((List<GrantedAuthority>) authentication.getAuthorities()),
                obtenerDireccionDelUsuario(dtoLogin.getCorreo()),obtenerProcesoDelUsuario(dtoLogin.getCorreo()));

        return ResponseEntity.ok(new AuthResponse(jwt));
    }

    private String getTipo(List<GrantedAuthority> authorities){
        return authorities.stream().filter(aut -> aut.getAuthority().startsWith("ROLE_")).findFirst().
                map(aut -> aut.getAuthority().equals("ROLE_ADMIN")?"ADMIN":"OPERADOR").orElse("O");
    }

    private String obtenerDireccionDelUsuario(String correo) {
        return servicioAplicacionListarUsuario.consultarByCorreoParaDireccion(correo);
    }
    private String obtenerProcesoDelUsuario(String correo) {
        return servicioAplicacionListarUsuario.consultarByCorreoParaProceso(correo);
    }


}
