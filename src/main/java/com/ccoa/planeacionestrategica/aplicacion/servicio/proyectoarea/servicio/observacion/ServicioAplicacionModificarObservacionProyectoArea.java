package com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyectoarea.DtoObservacionProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.mapeador.observacion.MapeadorAplicacionObservacionProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.proyectoarea.observacion.ServicioModificarObservacionProyectoArea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarObservacionProyectoArea {

    private final ServicioModificarObservacionProyectoArea servicioModificarObservacionProyectoArea;
    private final MapeadorAplicacionObservacionProyectoArea mapeadorAplicacionObservacionProyectoArea;

    public ServicioAplicacionModificarObservacionProyectoArea(ServicioModificarObservacionProyectoArea servicioModificarObservacionProyectoArea,
                                                              MapeadorAplicacionObservacionProyectoArea mapeadorAplicacionObservacionProyectoArea) {
        this.servicioModificarObservacionProyectoArea = servicioModificarObservacionProyectoArea;
        this.mapeadorAplicacionObservacionProyectoArea = mapeadorAplicacionObservacionProyectoArea;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoObservacionProyectoArea dto, Long codigo){
        var observacionProyectoArea = this.mapeadorAplicacionObservacionProyectoArea.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarObservacionProyectoArea.ejecutarModificar(observacionProyectoArea,codigo));
    }
}
