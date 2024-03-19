package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.proyecto.observacion.ServicioEliminarObservacionProyecto;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarObservacionProyecto {

    private final ServicioEliminarObservacionProyecto servicioEliminarObservacionProyecto;

    public ServicioAplicacionEliminarObservacionProyecto(ServicioEliminarObservacionProyecto servicioEliminarObservacionProyecto) {
        this.servicioEliminarObservacionProyecto = servicioEliminarObservacionProyecto;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarObservacionProyecto.ejecutarEliminar(codigo));
    }
}
