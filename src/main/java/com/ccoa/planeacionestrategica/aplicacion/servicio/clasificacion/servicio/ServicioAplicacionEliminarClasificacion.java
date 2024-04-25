package com.ccoa.planeacionestrategica.aplicacion.servicio.clasificacion.servicio;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.clasificacion.ServicioEliminarClasificacion;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarClasificacion {
    private final ServicioEliminarClasificacion servicioEliminarClasificacion;

    public ServicioAplicacionEliminarClasificacion(ServicioEliminarClasificacion servicioEliminarClasificacion) {
        this.servicioEliminarClasificacion = servicioEliminarClasificacion;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarClasificacion.ejecutarEliminar(codigo));
    }
}
