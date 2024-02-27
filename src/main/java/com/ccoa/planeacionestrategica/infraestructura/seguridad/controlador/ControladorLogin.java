package com.ccoa.planeacionestrategica.infraestructura.seguridad.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.login.DtoLogin;
import com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.servicio.ServicioAplicacionListarUsuario;
import com.ccoa.planeacionestrategica.infraestructura.seguridad.AuthResponse;
import com.ccoa.planeacionestrategica.infraestructura.seguridad.utilidad.JwtUtil;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
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
        try {
            UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(dtoLogin.getCorreo(),
                    dtoLogin.getPassword());
            Authentication authentication = this.authenticationManager.authenticate(login);

            String jwt = this.jwtUtil.create(dtoLogin.getCorreo(),obtenerIdUsuario(dtoLogin.getCorreo()),getTipo((List<GrantedAuthority>) authentication.getAuthorities()),
                    obtenerDireccionesDelUsuario(dtoLogin.getCorreo()),obtenerPatsDelUsuario(dtoLogin.getCorreo()));

            return ResponseEntity.ok(new AuthResponse(jwt));
        } catch (BadCredentialsException ex) {
            // Si las credenciales son incorrectas, Spring Security lanzará una BadCredentialsException
            // Aquí puedes manejar el error según tus necesidades, como devolver un error 401 Unauthorized
            throw new BadCredentialsException(Mensaje.USUARIO_O_CLAVE_INCORRECTOS);
        }
    }

    private String getTipo(List<GrantedAuthority> authorities){
        return authorities.stream().filter(aut -> aut.getAuthority().startsWith("ROLE_")).findFirst().
                map(aut ->
                     switch (aut.getAuthority()) {
                        case "ROLE_ADMIN" -> "ADMIN";
                        case "ROLE_DIRECTOR" -> "DIRECTOR";
                        case "ROLE_OPERADOR" -> "OPERADOR";
                        case "ROLE_CONSULTOR" -> "CONSULTOR";
                        default -> "O";
        })
                .orElse("O");
    }
    private Long obtenerIdUsuario(String correo) {
        return servicioAplicacionListarUsuario.consultarByCorreoParaIdUsuario(correo);
    }
    private List<String> obtenerDireccionesDelUsuario(String correo) {
        return servicioAplicacionListarUsuario.consultarByCorreoParaDirecciones(correo);
    }
    private List<String> obtenerPatsDelUsuario(String correo) {
        return servicioAplicacionListarUsuario.consultarByCorreoParaPats(correo);
    }


}
