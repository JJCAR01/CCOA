package com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoTarea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.InformacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionInformacionTarea implements MapeadorAplicacion<DtoTarea, InformacionTarea> {
    @Override
    public InformacionTarea mapeadorAplicacion(DtoTarea dto) {
        return InformacionTarea.of(dto.getIdTarea(), dto.getObservacion(), dto.getPeriodicidad(), Mensaje.POR_DEFECTO_AVANCE);
    }

    public InformacionTarea actualizarTarea(DtoTarea dto) {
        return new InformacionTarea(dto.getIdTarea(), dto.getObservacion(), dto.getPeriodicidad(), dto.getPorcentaje());
    }
    public InformacionTarea actualizarEstado(DtoTarea dto) {
        return new InformacionTarea(dto.getIdTarea(), dto.getObservacion(), dto.getPeriodicidad(), dto.getPorcentaje());
    }
}
