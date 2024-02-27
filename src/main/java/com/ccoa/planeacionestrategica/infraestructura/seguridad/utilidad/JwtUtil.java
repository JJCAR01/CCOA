package com.ccoa.planeacionestrategica.infraestructura.seguridad.utilidad;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.ccoa.planeacionestrategica.infraestructura.seguridad.utilidad.ConstantesSeguridad.CLAVE;

@Component
public class JwtUtil {

    private static final Algorithm ALGORITHM = Algorithm.HMAC256(CLAVE);

    public String create(String username,Long user ,String type, List<String> direcciones, List<String> procesos) {
        String direccionesString = String.join(",", direcciones);
        String procesosString = String.join(",", procesos);
        // Obtén la fecha actual
        Calendar calendar = Calendar.getInstance();

        // Reinicia la hora, minuto, segundo y milisegundo a 0 para representar la medianoche
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        // Agrega un día a la fecha actual para obtener la medianoche del día siguiente
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        // Configura la expiración del token JWT para la medianoche del día actual
        Date expiracion = calendar.getTime();

        return JWT.create()
                .withSubject(username)
                .withClaim("idUser", user)
                .withClaim("type", type)
                .withClaim("direcciones", direccionesString)
                .withClaim("pats", procesosString)
                .withIssuer("CCOA")
                .withIssuedAt(new Date())
                .withExpiresAt(expiracion)
                .sign(ALGORITHM);
    }

    public boolean esValido(String jwt){
        try {
            JWT.require(ALGORITHM).build().verify(jwt);
            return true;
        } catch (JWTVerificationException e){
            return false;
        }
    }


    public String getUsername(String jwt){
        return JWT.require(ALGORITHM).build().verify(jwt)
                .getSubject();
    }

    public List<String> getDirecciones(String jwt) {
        String direccionesString = JWT.require(ALGORITHM).build().verify(jwt)
                .getClaim("direcciones").asString();

        // Convierte la cadena de direcciones nuevamente a una lista si es necesario
        return Arrays.asList(direccionesString.split(","));
    }

    public List<String> getPats(String jwt) {
        String patsString = JWT.require(ALGORITHM).build().verify(jwt)
                .getClaim("pats").asString();

        // Convierte la cadena de procesos nuevamente a una lista si es necesario
        return Arrays.asList(patsString.split(","));
    }
}
