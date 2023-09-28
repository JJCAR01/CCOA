package com.ccoa.planeacionestrategica.aplicacion.servicio.tarea;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoTarea;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.InformacionTarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.Tarea;
import com.ccoa.planeacionestrategica.dominio.servicio.transversal.ServicioObtenerDiasRestantes;
import com.ccoa.planeacionestrategica.dominio.servicio.transversal.ServicioObtenerDuracion;
import com.ccoa.planeacionestrategica.dominio.servicio.transversal.ServicioObtenerHoraActual;
import com.ccoa.planeacionestrategica.dominio.servicio.tarea.ServicioGuardarTarea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarTarea {

    private final ServicioGuardarTarea servicioGuardarTarea;
    private final ServicioObtenerHoraActual servicioObtenerHoraActual;
    private final ServicioObtenerDuracion servicioObtenerDuracion;
    private final ServicioObtenerDiasRestantes servicioObtenerDiasRestantes;

    public ServicioAplicacionGuardarTarea(ServicioGuardarTarea servicioGuardarTarea, ServicioObtenerHoraActual servicioObtenerHoraActual, ServicioObtenerDuracion servicioObtenerDuracion, ServicioObtenerDiasRestantes servicioObtenerDiasRestantes) {
        this.servicioGuardarTarea = servicioGuardarTarea;
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
        this.servicioObtenerDuracion = servicioObtenerDuracion;
        this.servicioObtenerDiasRestantes = servicioObtenerDiasRestantes;
    }

    public DtoRespuesta<Long> ejecutar(DtoTarea dto){
        Tarea tarea = Tarea.of(dto.getIdTarea(), dto.getNombre(), dto.getFechaInicio(),dto.getFechaFinal(),servicioObtenerHoraActual.ejecutar(),
                dto.getIdUsuario(), dto.getIdPat());
        InformacionTarea informacionTarea = InformacionTarea.of(servicioObtenerDuracion.ejecutar(dto.getFechaInicio(),dto.getFechaFinal()),
                servicioObtenerDiasRestantes.ejecutar(dto.getFechaInicio(),dto.getFechaFinal()),dto.getEstado(),dto.getAvance());

        return new DtoRespuesta<>(this.servicioGuardarTarea.ejecutarGuardar(tarea,informacionTarea));
    }
}
