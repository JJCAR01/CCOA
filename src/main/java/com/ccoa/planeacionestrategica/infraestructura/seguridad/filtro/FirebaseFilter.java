package com.ccoa.planeacionestrategica.infraestructura.seguridad.filtro;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class FirebaseFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String idToken = request.getHeader(HttpHeaders.AUTHORIZATION);

            if (idToken != null) {
                /*FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);

                Authentication authentication = new UsernamePasswordAuthenticationToken(
                        decodedToken.getUid(), null, null);

                SecurityContextHolder.getContext().setAuthentication(authentication);*/
            }
        } catch (Exception e) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }

        filterChain.doFilter(request, response);
    }
}
