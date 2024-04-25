package com.ccoa.planeacionestrategica.aplicacion.servicio.clasificacion.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.clasificacion.DtoClasificacion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.clasificacion.mapeador.MapeadorAplicacionClasificacion;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.clasificacion.ServicioGuardarClasificacion;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarClasificacion {
    private final ServicioGuardarClasificacion servicioGuardarClasificacion;
    private final MapeadorAplicacionClasificacion mapeadorAplicacionClasificacion;

    public ServicioAplicacionGuardarClasificacion(ServicioGuardarClasificacion servicioGuardarClasificacion, MapeadorAplicacionClasificacion mapeadorAplicacionClasificacion) {
        this.servicioGuardarClasificacion = servicioGuardarClasificacion;
        this.mapeadorAplicacionClasificacion = mapeadorAplicacionClasificacion;
    }

    public DtoRespuesta<Long> ejecutar(DtoClasificacion dto){
        var clasificacion = this.mapeadorAplicacionClasificacion.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarClasificacion.ejecutarGuardar(clasificacion));
    }
}
