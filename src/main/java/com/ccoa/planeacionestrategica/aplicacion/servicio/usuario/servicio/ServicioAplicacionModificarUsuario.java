package com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.usuario.DtoUsuario;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
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
        var informacionUsuario = mapeadorAplicacionInformacionUsuario.mapeadorActualizarPass(dto);
        return new DtoRespuesta<>(this.servicioModificarUsuario.ejecutarModificar(usuario,informacionUsuario,codigo));
    }
    public DtoRespuesta<Long> ejecutarAgregarPass(DtoUsuario dto, Long codigo){
        var usuario = mapeadorAplicacionUsuario.mapeadorAplicacionSoloPass(dto);
        var informacionUsuario = mapeadorAplicacionInformacionUsuario.mapeadorActualizarPass(dto);
        return new DtoRespuesta<>(this.servicioModificarUsuario.ejecutarAgregarPass(usuario,informacionUsuario,codigo));
    }
    public DtoRespuesta<Long> ejecutarModificarDirecciones(DtoUsuario dto, Long codigo){
        var informacionUsuario = mapeadorAplicacionInformacionUsuario.actualizarDireccion(dto);
        return new DtoRespuesta<>(this.servicioModificarUsuario.ejecutarModificarDirecciones(informacionUsuario,codigo));
    }
    public DtoRespuesta<Long> ejecutarEliminarDirecciones(DtoUsuario dto, Long codigo){
        var informacionUsuario = mapeadorAplicacionInformacionUsuario.actualizarDireccion(dto);
        return new DtoRespuesta<>(this.servicioModificarUsuario.ejecutarEliminarDirecciones(informacionUsuario,codigo));
    }
    public DtoRespuesta<Long> ejecutarModificarPats(DtoUsuario dto, Long codigo){
        var informacionUsuario = mapeadorAplicacionInformacionUsuario.actualizarPat(dto);
        return new DtoRespuesta<>(this.servicioModificarUsuario.ejecutarModificarPats(informacionUsuario,codigo));
    }
    public DtoRespuesta<Long> ejecutarEliminarPats(DtoUsuario dto, Long codigo){
        var informacionUsuario = mapeadorAplicacionInformacionUsuario.actualizarPat(dto);
        return new DtoRespuesta<>(this.servicioModificarUsuario.ejecutarEliminarPats(informacionUsuario,codigo));
    }

}
