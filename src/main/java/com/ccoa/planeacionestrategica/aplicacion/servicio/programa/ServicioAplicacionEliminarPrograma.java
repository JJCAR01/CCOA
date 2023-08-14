package com.ccoa.planeacionestrategica.aplicacion.servicio.programa;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.imperativoestrategico.ServicioEliminarImperativoEstrategico;
import com.ccoa.planeacionestrategica.dominio.servicio.programa.ServicioEliminarPrograma;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarPrograma {

    private final ServicioEliminarPrograma servicioEliminarPrograma;

    public ServicioAplicacionEliminarPrograma(ServicioEliminarPrograma servicioEliminarPrograma) {
        this.servicioEliminarPrograma = servicioEliminarPrograma;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarPrograma.ejecutarEliminar(codigo));
    }
}
