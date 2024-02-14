package com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyectoarea.DtoObservacionProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.mapeador.observacion.MapeadorAplicacionObservacionProyectoArea;
import com.ccoa.planeacionestrategica.dominio.servicio.proyectoarea.observacion.ServicioGuardarObservacionProyectoArea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarObservacionProyectoArea {
    private final ServicioGuardarObservacionProyectoArea servicioGuardarObservacionProyectoArea;
    private final MapeadorAplicacionObservacionProyectoArea mapeadorAplicacionObservacionProyectoArea;

    public ServicioAplicacionGuardarObservacionProyectoArea(ServicioGuardarObservacionProyectoArea servicioGuardarObservacionProyectoArea, MapeadorAplicacionObservacionProyectoArea mapeadorAplicacionObservacionProyectoArea) {
        this.servicioGuardarObservacionProyectoArea = servicioGuardarObservacionProyectoArea;
        this.mapeadorAplicacionObservacionProyectoArea = mapeadorAplicacionObservacionProyectoArea;
    }

    public DtoRespuesta<Long> ejecutar(DtoObservacionProyectoArea dto){
        var observacion = this.mapeadorAplicacionObservacionProyectoArea.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarObservacionProyectoArea.ejecutarGuardar(observacion));
    }
}
