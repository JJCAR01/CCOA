package com.ccoa.planeacionestrategica.infraestructura.seguridad.utilidad;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.ccoa.planeacionestrategica.infraestructura.seguridad.utilidad.ConstantesSeguridad.CLAVE;

@Component
public class JwtUtil {

    private static final Algorithm ALGORITHM = Algorithm.HMAC256(CLAVE);

    public String create(String username, String type, String direcciones,String procesos){
        return JWT.create()
                .withSubject(username)
                .withClaim("type",type)
                .withClaim("direccion", direcciones)
                .withClaim("proceso", procesos)
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
}
