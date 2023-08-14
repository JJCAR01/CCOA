package com.ccoa.planeacionestrategica.aplicacion.servicio.lineaestrategica;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.imperativoestrategico.ServicioEliminarImperativoEstrategico;
import com.ccoa.planeacionestrategica.dominio.servicio.lineaestrategica.ServicioEliminarLineaEstrategica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarLineaEstrategica {

    private final ServicioEliminarLineaEstrategica servicioEliminarLineaEstrategica;

    public ServicioAplicacionEliminarLineaEstrategica(ServicioEliminarLineaEstrategica servicioEliminarLineaEstrategica) {
        this.servicioEliminarLineaEstrategica = servicioEliminarLineaEstrategica;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarLineaEstrategica.ejecutarEliminar(codigo));
    }
}
