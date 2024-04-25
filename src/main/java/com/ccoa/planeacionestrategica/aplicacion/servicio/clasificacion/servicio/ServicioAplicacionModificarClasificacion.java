package com.ccoa.planeacionestrategica.aplicacion.servicio.clasificacion.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.clasificacion.DtoClasificacion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.clasificacion.mapeador.MapeadorAplicacionClasificacion;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.clasificacion.ServicioModificarClasificacion;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarClasificacion {
    private final ServicioModificarClasificacion servicioModificarClasificacion;
    private final MapeadorAplicacionClasificacion mapeadorAplicacionClasificacion;

    public ServicioAplicacionModificarClasificacion(ServicioModificarClasificacion servicioModificarProceso, MapeadorAplicacionClasificacion mapeadorAplicacionClasificacion) {
        this.servicioModificarClasificacion = servicioModificarProceso;
        this.mapeadorAplicacionClasificacion = mapeadorAplicacionClasificacion;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoClasificacion dto, Long codigo){
        var clasificacion = this.mapeadorAplicacionClasificacion.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarClasificacion.ejecutarModificar(clasificacion,codigo));
    }
}
