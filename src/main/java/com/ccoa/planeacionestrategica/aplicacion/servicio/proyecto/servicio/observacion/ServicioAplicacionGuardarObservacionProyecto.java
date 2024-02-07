package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoObservacionProyecto;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.mapeador.observacion.MapeadorAplicacionObservacionProyecto;
import com.ccoa.planeacionestrategica.dominio.servicio.proyecto.observacion.ServicioGuardarObservacionProyecto;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarObservacionProyecto {
    private final ServicioGuardarObservacionProyecto servicioGuardarObservacionProyecto;
    private final MapeadorAplicacionObservacionProyecto mapeadorAplicacionObservacionProyecto;

    public ServicioAplicacionGuardarObservacionProyecto(ServicioGuardarObservacionProyecto servicioGuardarObservacionProyecto, MapeadorAplicacionObservacionProyecto mapeadorAplicacionObservacionProyecto) {
        this.servicioGuardarObservacionProyecto = servicioGuardarObservacionProyecto;
        this.mapeadorAplicacionObservacionProyecto = mapeadorAplicacionObservacionProyecto;
    }

    public DtoRespuesta<Long> ejecutar(DtoObservacionProyecto dto){
        var observacion = this.mapeadorAplicacionObservacionProyecto.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarObservacionProyecto.ejecutarGuardar(observacion));
    }
}
