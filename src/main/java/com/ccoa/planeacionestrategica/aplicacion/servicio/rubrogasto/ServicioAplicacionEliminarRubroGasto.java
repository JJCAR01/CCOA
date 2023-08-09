package com.ccoa.planeacionestrategica.aplicacion.servicio.rubrogasto;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.area.ServicioEliminarArea;
import com.ccoa.planeacionestrategica.dominio.servicio.rubrogasto.ServicioEliminarRubroGasto;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarRubroGasto {

    private final ServicioEliminarRubroGasto servicioEliminarRubroGasto;

    public ServicioAplicacionEliminarRubroGasto(ServicioEliminarRubroGasto servicioEliminarRubroGasto) {
        this.servicioEliminarRubroGasto = servicioEliminarRubroGasto;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarRubroGasto.ejecutarEliminar(codigo));
    }
}
