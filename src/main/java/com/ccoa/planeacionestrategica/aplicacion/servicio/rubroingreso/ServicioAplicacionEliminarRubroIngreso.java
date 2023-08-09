package com.ccoa.planeacionestrategica.aplicacion.servicio.rubroingreso;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.area.ServicioEliminarArea;
import com.ccoa.planeacionestrategica.dominio.servicio.rubroingreso.ServicioEliminarRubroIngreso;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarRubroIngreso {
    private final ServicioEliminarRubroIngreso servicioEliminarRubroIngreso;

    public ServicioAplicacionEliminarRubroIngreso(ServicioEliminarRubroIngreso servicioEliminarRubroIngreso) {
        this.servicioEliminarRubroIngreso = servicioEliminarRubroIngreso;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarRubroIngreso.ejecutarEliminar(codigo));
    }
}
