package com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.usuario.DtoUsuario;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.adaptador.MapeadorAplicacionUsuario;
import com.ccoa.planeacionestrategica.dominio.servicio.usuario.ServicioGuardarUsuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.mapeador.MapeadorUsuario;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarUsuario {

    private final ServicioGuardarUsuario servicioGuardarUsuario;
    private final MapeadorAplicacionUsuario mapeadorAplicacionUsuario;


    public ServicioAplicacionGuardarUsuario(ServicioGuardarUsuario servicioGuardarUsuario, MapeadorAplicacionUsuario mapeadorAplicacionUsuario) {
        this.servicioGuardarUsuario = servicioGuardarUsuario;
        this.mapeadorAplicacionUsuario = mapeadorAplicacionUsuario;
    }

    public DtoRespuesta<Long> ejecutar(DtoUsuario dto){
        var usuario = this.mapeadorAplicacionUsuario.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarUsuario.ejecutarGuardar(usuario));
    }

}
