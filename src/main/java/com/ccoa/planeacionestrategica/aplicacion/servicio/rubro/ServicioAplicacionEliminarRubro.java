package com.ccoa.planeacionestrategica.aplicacion.servicio.rubro;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.rubro.ServicioEliminarRubro;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarRubro {

    private final ServicioEliminarRubro servicioEliminarRubro;

    public ServicioAplicacionEliminarRubro(ServicioEliminarRubro servicioEliminarRubro) {
        this.servicioEliminarRubro = servicioEliminarRubro;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarRubro.ejecutarEliminar(codigo));
    }
}
