package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.adaptador.MapeadorAplicacionProyecto;
import com.ccoa.planeacionestrategica.dominio.servicio.proyecto.ServicioModificarProyecto;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarProyecto {
    private final ServicioModificarProyecto servicioModificarProyecto;
    private final MapeadorAplicacionProyecto mapeadorAplicacionProyecto;

    public ServicioAplicacionModificarProyecto(ServicioModificarProyecto servicioModificarProyecto, MapeadorAplicacionProyecto mapeadorAplicacionProyecto) {
        this.servicioModificarProyecto = servicioModificarProyecto;
        this.mapeadorAplicacionProyecto = mapeadorAplicacionProyecto;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoProyecto dto, Long codigo){
        var proyecto = this.mapeadorAplicacionProyecto.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarProyecto.ejecutarModificar(proyecto,codigo));
    }
}
