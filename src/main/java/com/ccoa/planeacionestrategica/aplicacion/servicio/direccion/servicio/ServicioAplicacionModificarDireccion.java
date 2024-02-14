package com.ccoa.planeacionestrategica.aplicacion.servicio.direccion.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.direccion.DtoDireccion;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.direccion.mapeador.MapeadorAplicacionDireccion;
import com.ccoa.planeacionestrategica.dominio.servicio.direccion.ServicioModificarDireccion;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarDireccion {
    private final ServicioModificarDireccion servicioModificarDireccion;
    private final MapeadorAplicacionDireccion mapeadorAplicacionDireccion;

    public ServicioAplicacionModificarDireccion(ServicioModificarDireccion servicioModificarDireccion, MapeadorAplicacionDireccion mapeadorAplicacionDireccion) {
        this.servicioModificarDireccion = servicioModificarDireccion;
        this.mapeadorAplicacionDireccion = mapeadorAplicacionDireccion;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoDireccion dto, Long codigo){
        var direccion = this.mapeadorAplicacionDireccion.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarDireccion.ejecutarModificar(direccion,codigo));
    }
}
