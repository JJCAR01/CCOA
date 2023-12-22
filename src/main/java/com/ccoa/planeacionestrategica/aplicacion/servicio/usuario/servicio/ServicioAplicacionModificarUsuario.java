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
    public DtoRespuesta<Long> ejecutarModificarDirecciones(DtoUsuario dto, Long codigo){
        var informacionUsuario = mapeadorAplicacionInformacionUsuario.actualizarDireccion(dto);
        return new DtoRespuesta<>(this.servicioModificarUsuario.ejecutarModificarDirecciones(informacionUsuario,codigo));
    }
    public DtoRespuesta<Long> ejecutarEliminarDirecciones(DtoUsuario dto, Long codigo){
        var informacionUsuario = mapeadorAplicacionInformacionUsuario.actualizarDireccion(dto);
        return new DtoRespuesta<>(this.servicioModificarUsuario.ejecutarEliminarDirecciones(informacionUsuario,codigo));
    }
    public DtoRespuesta<Long> ejecutarModificarProcesos(DtoUsuario dto, Long codigo){
        var informacionUsuario = mapeadorAplicacionInformacionUsuario.actualizarProceso(dto);
        return new DtoRespuesta<>(this.servicioModificarUsuario.ejecutarModificarProcesos(informacionUsuario,codigo));
    }
    public DtoRespuesta<Long> ejecutarEliminarProcesos(DtoUsuario dto, Long codigo){
        var informacionUsuario = mapeadorAplicacionInformacionUsuario.actualizarProceso(dto);
        return new DtoRespuesta<>(this.servicioModificarUsuario.ejecutarEliminarProcesos(informacionUsuario,codigo));
    }

}
