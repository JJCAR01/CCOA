package com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.usuario.DtoUsuario;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.adaptador.MapeadorAplicacionInformacionUsuario;
import com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.adaptador.MapeadorAplicacionRol;
import com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.adaptador.MapeadorAplicacionUsuario;
import com.ccoa.planeacionestrategica.dominio.servicio.usuario.ServicioGuardarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarUsuario {

    private final ServicioGuardarUsuario servicioGuardarUsuario;
    private final MapeadorAplicacionUsuario mapeadorAplicacionUsuario;
    private final MapeadorAplicacionRol mapeadorAplicacionRol;
    private final MapeadorAplicacionInformacionUsuario mapeadorAplicacionInformacionUsuario;


    public ServicioAplicacionGuardarUsuario(ServicioGuardarUsuario servicioGuardarUsuario, MapeadorAplicacionUsuario mapeadorAplicacionUsuario,
                                            MapeadorAplicacionRol mapeadorAplicacionRol,MapeadorAplicacionInformacionUsuario mapeadorAplicacionInformacionUsuario) {
        this.servicioGuardarUsuario = servicioGuardarUsuario;
        this.mapeadorAplicacionUsuario = mapeadorAplicacionUsuario;
        this.mapeadorAplicacionRol = mapeadorAplicacionRol;
        this.mapeadorAplicacionInformacionUsuario = mapeadorAplicacionInformacionUsuario;
    }

    public DtoRespuesta<Long> ejecutar(DtoUsuario dto){
        var usuario = this.mapeadorAplicacionUsuario.mapeadorAplicacion(dto);
        var rol = this.mapeadorAplicacionRol.mapeadorAplicacion(dto);
        var informacionUsuario = this.mapeadorAplicacionInformacionUsuario.mapeadorAplicacion(dto);

        return new DtoRespuesta<>(this.servicioGuardarUsuario.ejecutarGuardar(usuario,rol,informacionUsuario));
    }

}
