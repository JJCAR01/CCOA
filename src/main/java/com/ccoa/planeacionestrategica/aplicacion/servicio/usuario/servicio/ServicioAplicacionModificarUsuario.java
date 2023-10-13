package com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.usuario.DtoUsuario;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.adaptador.MapeadorAplicacionUsuario;
import com.ccoa.planeacionestrategica.dominio.servicio.usuario.ServicioModificarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarUsuario {

    private final ServicioModificarUsuario servicioModificarUsuario;
    private final MapeadorAplicacionUsuario mapeadorAplicacionUsuario;

    public ServicioAplicacionModificarUsuario(ServicioModificarUsuario servicioModificarUsuario, MapeadorAplicacionUsuario mapeadorAplicacionUsuario) {
        this.servicioModificarUsuario = servicioModificarUsuario;
        this.mapeadorAplicacionUsuario = mapeadorAplicacionUsuario;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoUsuario dto, Long codigo){
        var usuario = mapeadorAplicacionUsuario.actualizarAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarUsuario.ejecutarModificar(usuario,codigo));
    }
}
