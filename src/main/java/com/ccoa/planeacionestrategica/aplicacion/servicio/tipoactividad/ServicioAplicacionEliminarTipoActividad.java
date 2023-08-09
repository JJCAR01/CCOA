package com.ccoa.planeacionestrategica.aplicacion.servicio.tipoactividad;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.area.ServicioEliminarArea;
import com.ccoa.planeacionestrategica.dominio.servicio.tipoactividad.ServicioEliminarTipoActividad;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarTipoActividad {

    private final ServicioEliminarTipoActividad servicioEliminarTipoActividad;

    public ServicioAplicacionEliminarTipoActividad(ServicioEliminarTipoActividad servicioEliminarTipoActividad) {
        this.servicioEliminarTipoActividad = servicioEliminarTipoActividad;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarTipoActividad.ejecutarEliminar(codigo));
    }
}
