package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.adaptador.MapeadorAplicacionInformacionProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.adaptador.MapeadorAplicacionProyecto;
import com.ccoa.planeacionestrategica.dominio.servicio.proyecto.ServicioModificarProyecto;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarProyecto {
    private final ServicioModificarProyecto servicioModificarProyecto;
    private final MapeadorAplicacionProyecto mapeadorAplicacionProyecto;
    private final MapeadorAplicacionInformacionProyecto mapeadorAplicacionInformacionProyecto;

    public ServicioAplicacionModificarProyecto(ServicioModificarProyecto servicioModificarProyecto, MapeadorAplicacionProyecto mapeadorAplicacionProyecto, MapeadorAplicacionInformacionProyecto mapeadorAplicacionInformacionProyecto) {
        this.servicioModificarProyecto = servicioModificarProyecto;
        this.mapeadorAplicacionProyecto = mapeadorAplicacionProyecto;
        this.mapeadorAplicacionInformacionProyecto = mapeadorAplicacionInformacionProyecto;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoProyecto dto, Long codigo){
        var proyecto = this.mapeadorAplicacionProyecto.mapeadorAplicacion(dto);
        var proyectoInf = this.mapeadorAplicacionInformacionProyecto.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarProyecto.ejecutarModificar(proyecto,proyectoInf,codigo));
    }
}
