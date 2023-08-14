package com.ccoa.planeacionestrategica.aplicacion.servicio.imperativoestrategico;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.imperativoestrategico.ServicioEliminarImperativoEstrategico;
import com.ccoa.planeacionestrategica.dominio.servicio.pat.ServicioEliminarPat;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarImperativoEstrategico {


    private final ServicioEliminarImperativoEstrategico servicioEliminarImperativoEstrategico;

    public ServicioAplicacionEliminarImperativoEstrategico(ServicioEliminarImperativoEstrategico servicioEliminarImperativoEstrategico) {
        this.servicioEliminarImperativoEstrategico = servicioEliminarImperativoEstrategico;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarImperativoEstrategico.ejecutarEliminar(codigo));
    }
}
