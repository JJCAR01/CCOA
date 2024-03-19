package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoObservacionProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.mapeador.observacion.MapeadorAplicacionObservacionProyecto;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.proyecto.observacion.ServicioModificarObservacionProyecto;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarObservacionProyecto {

    private final ServicioModificarObservacionProyecto servicioModificarObservacionProyecto;
    private final MapeadorAplicacionObservacionProyecto mapeadorAplicacionObservacionProyecto;

    public ServicioAplicacionModificarObservacionProyecto(ServicioModificarObservacionProyecto servicioModificarObservacionProyecto,
                                                          MapeadorAplicacionObservacionProyecto mapeadorAplicacionObservacionProyecto) {
        this.servicioModificarObservacionProyecto = servicioModificarObservacionProyecto;
        this.mapeadorAplicacionObservacionProyecto = mapeadorAplicacionObservacionProyecto;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoObservacionProyecto dto, Long codigo){
        var observacionProyecto = this.mapeadorAplicacionObservacionProyecto.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarObservacionProyecto.ejecutarModificar(observacionProyecto,codigo));
    }
}
