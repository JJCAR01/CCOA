package com.ccoa.planeacionestrategica.aplicacion.servicio.proceso.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.proceso.ServicioEliminarProceso;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarProceso {
    private final ServicioEliminarProceso servicioEliminarProceso;

    public ServicioAplicacionEliminarProceso(ServicioEliminarProceso servicioEliminarProceso) {
        this.servicioEliminarProceso = servicioEliminarProceso;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarProceso.ejecutarEliminar(codigo));
    }
}
