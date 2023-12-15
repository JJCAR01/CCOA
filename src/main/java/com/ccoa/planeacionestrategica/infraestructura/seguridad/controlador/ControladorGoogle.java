package com.ccoa.planeacionestrategica.infraestructura.seguridad.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.login.DtoLoginGoogle;
import com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.servicio.ServicioAplicacionListarUsuario;
import com.ccoa.planeacionestrategica.dominio.modelo.area.enums.EDireccion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.NoDatoExcepcion;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad.EntidadUsuarioRol;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.seguridad.AuthResponse;
import com.ccoa.planeacionestrategica.infraestructura.seguridad.utilidad.JwtUtil;
import com.ccoa.planeacionestrategica.infraestructura.transversal.excepcion.AccessDeniedExcepcion;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@RestController
@RequestMapping("/ccoa/auth")
public class ControladorGoogle {
    private final ServicioAplicacionListarUsuario servicioAplicacionListarUsuario;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final JwtUtil jwtUtil;

    @Autowired
    public ControladorGoogle(ServicioAplicacionListarUsuario servicioAplicacionListarUsuario, RepositorioUsuarioJpa repositorioUsuarioJpa, JwtUtil jwtUtil) {
        this.servicioAplicacionListarUsuario = servicioAplicacionListarUsuario;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.jwtUtil = jwtUtil;
    }
    @PostMapping("/google")
    public ResponseEntity<AuthResponse> loginWithGoogle(@RequestBody DtoLoginGoogle dtoGoogleLogin) {
        try {
            // Validar el token de Firebase
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(dtoGoogleLogin.getGoogleToken());

            // Verificar si el usuario existe en la base de datos
            EntidadUsuario usuario = repositorioUsuarioJpa.findByCorreo(decodedToken.getEmail());

            // El usuario no está registrado en la base de datos
            if (usuario == null) throw new NoDatoExcepcion(MENSAJE_DEFECTO, Mensaje.USUARIO_NO_ESTA_REGISTRADO);

            // Generar un JWT sin autenticar con Spring Security
            String jwt = jwtUtil.create(decodedToken.getEmail(), getTipo(usuario.getRoles()),obtenerDireccionDelUsuario(decodedToken.getEmail()),
                    obtenerProcesoDelUsuario(decodedToken.getEmail()));

            // Devolver la respuesta con el JWT
            return ResponseEntity.ok(new AuthResponse(jwt));

        } catch (FirebaseAuthException e) {
            throw new AccessDeniedExcepcion(MENSAJE_DEFECTO,Mensaje.ERROR_EN_LA_AUTENTICACION);
        }
    }

    private String getTipo(List<EntidadUsuarioRol> roles) {
         return roles.stream().anyMatch(aut -> aut.getRol().equals("OPERADOR"))? "OPERADOR" : "ADMIN";
    }
    private String obtenerDireccionDelUsuario(String correo) {
        return servicioAplicacionListarUsuario.consultarByCorreoParaDireccion(correo);
    }
    private String obtenerProcesoDelUsuario(String correo) {
        return servicioAplicacionListarUsuario.consultarByCorreoParaProceso(correo);
    }
}
