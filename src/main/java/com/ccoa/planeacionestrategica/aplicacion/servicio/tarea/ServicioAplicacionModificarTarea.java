package com.ccoa.planeacionestrategica.aplicacion.servicio.tarea;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoTarea;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.Tarea;
import com.ccoa.planeacionestrategica.dominio.servicio.transversal.ServicioObtenerHoraActual;
import com.ccoa.planeacionestrategica.dominio.servicio.tarea.ServicioModificarTarea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarTarea {

    private final ServicioModificarTarea servicioModificarTarea;
    private final ServicioObtenerHoraActual servicioObtenerHoraActual;

    public ServicioAplicacionModificarTarea(ServicioModificarTarea servicioModificarTarea, ServicioObtenerHoraActual servicioObtenerHoraActual) {
        this.servicioModificarTarea = servicioModificarTarea;
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoTarea dto, Long codigo){

        Tarea tarea = Tarea.of(dto.getIdTarea(), dto.getNombre(), dto.getFechaInicio(),dto.getFechaFinal(),servicioObtenerHoraActual.ejecutar(),
                dto.getIdUsuario(), dto.getIdPat());


        return new DtoRespuesta<>(this.servicioModificarTarea.ejecutarModificar(tarea,codigo));
    }
}
