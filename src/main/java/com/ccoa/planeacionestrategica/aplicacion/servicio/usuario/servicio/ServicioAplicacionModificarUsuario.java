package com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.usuario.DtoUsuario;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.adaptador.MapeadorAplicacionInformacionUsuario;
import com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.adaptador.MapeadorAplicacionUsuario;
import com.ccoa.planeacionestrategica.dominio.servicio.usuario.ServicioModificarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarUsuario {

    private final ServicioModificarUsuario servicioModificarUsuario;
    private final MapeadorAplicacionUsuario mapeadorAplicacionUsuario;
    private final MapeadorAplicacionInformacionUsuario mapeadorAplicacionInformacionUsuario;

    public ServicioAplicacionModificarUsuario(ServicioModificarUsuario servicioModificarUsuario, MapeadorAplicacionUsuario mapeadorAplicacionUsuario, MapeadorAplicacionInformacionUsuario mapeadorAplicacionInformacionUsuario) {
        this.servicioModificarUsuario = servicioModificarUsuario;
        this.mapeadorAplicacionUsuario = mapeadorAplicacionUsuario;
        this.mapeadorAplicacionInformacionUsuario = mapeadorAplicacionInformacionUsuario;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoUsuario dto, Long codigo){
        var usuario = mapeadorAplicacionUsuario.actualizarAplicacion(dto);
        var informacionUsuario = mapeadorAplicacionInformacionUsuario.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarUsuario.ejecutarModificar(usuario,informacionUsuario,codigo));
    }
}
