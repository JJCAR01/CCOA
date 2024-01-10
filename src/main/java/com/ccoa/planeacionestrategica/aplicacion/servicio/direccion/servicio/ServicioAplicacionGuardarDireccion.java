package com.ccoa.planeacionestrategica.aplicacion.servicio.direccion.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.direccion.DtoDireccion;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.direccion.mapeador.MapeadorAplicacionDireccion;
import com.ccoa.planeacionestrategica.dominio.servicio.direccion.ServicioGuardarDireccion;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarDireccion {
    private final ServicioGuardarDireccion servicioGuardarDireccion;
    private final MapeadorAplicacionDireccion mapeadorAplicacionDireccion;

    public ServicioAplicacionGuardarDireccion(ServicioGuardarDireccion servicioGuardarDireccion, MapeadorAplicacionDireccion mapeadorAplicacionDireccion) {
        this.servicioGuardarDireccion = servicioGuardarDireccion;
        this.mapeadorAplicacionDireccion = mapeadorAplicacionDireccion;
    }

    public DtoRespuesta<Long> ejecutar(DtoDireccion dto){
        var direccion = this.mapeadorAplicacionDireccion.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarDireccion.ejecutarGuardar(direccion));
    }
}
