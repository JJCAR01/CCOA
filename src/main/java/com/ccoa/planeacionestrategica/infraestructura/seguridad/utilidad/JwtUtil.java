package com.ccoa.planeacionestrategica.infraestructura.seguridad.utilidad;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.ccoa.planeacionestrategica.infraestructura.seguridad.utilidad.ConstantesSeguridad.CLAVE;

@Component
public class JwtUtil {

    private static final Algorithm ALGORITHM = Algorithm.HMAC256(CLAVE);

    public String create(String username, String type, List<String> direcciones, List<String> procesos) {
        String direccionesString = String.join(",", direcciones);
        String procesosString = String.join(",", procesos);
        return JWT.create()
                .withSubject(username)
                .withClaim("type", type)
                .withClaim("direccion", direccionesString)
                .withClaim("proceso", procesosString)
                .withIssuer("CCOA")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1)))
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
                .getClaim("direccion").asString();

        // Convierte la cadena de direcciones nuevamente a una lista si es necesario
        return Arrays.asList(direccionesString.split(","));
    }

    public List<String> getProcesos(String jwt) {
        String procesosString = JWT.require(ALGORITHM).build().verify(jwt)
                .getClaim("proceso").asString();

        // Convierte la cadena de procesos nuevamente a una lista si es necesario
        return Arrays.asList(procesosString.split(","));
    }
}
