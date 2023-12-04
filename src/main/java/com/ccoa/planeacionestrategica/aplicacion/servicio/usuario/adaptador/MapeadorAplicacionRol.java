package com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.adaptador;

import com.ccoa.planeacionestrategica.aplicacion.dto.usuario.DtoUsuario;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Rol;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Collectors;

@Configuration
public class MapeadorAplicacionRol implements MapeadorAplicacion<DtoUsuario, Rol> {
    @Override
    public Rol mapeadorAplicacion(DtoUsuario dto) {
        String rolesString = dto.getRoles().stream().map(Rol::getNombreRol).collect(Collectors.joining(","));
        return new Rol(dto.getIdUsuario(), rolesString);
    }
}
