package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.adaptador.MapeadorAplicacionInformacionProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.adaptador.MapeadorAplicacionProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.adaptador.MapeadorAplicacionDetalleProyecto;
import com.ccoa.planeacionestrategica.dominio.servicio.proyecto.ServicioModificarProyecto;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarProyecto {
    private final ServicioModificarProyecto servicioModificarProyecto;
    private final MapeadorAplicacionProyecto mapeadorAplicacionProyecto;
    private final MapeadorAplicacionInformacionProyecto mapeadorAplicacionInformacionProyecto;
    private final MapeadorAplicacionDetalleProyecto mapeadorAplicacionDetalleProyecto;

    public ServicioAplicacionModificarProyecto(ServicioModificarProyecto servicioModificarProyecto, MapeadorAplicacionProyecto mapeadorAplicacionProyecto, MapeadorAplicacionInformacionProyecto mapeadorAplicacionInformacionProyecto, MapeadorAplicacionDetalleProyecto mapeadorAplicacionDetalleProyecto) {
        this.servicioModificarProyecto = servicioModificarProyecto;
        this.mapeadorAplicacionProyecto = mapeadorAplicacionProyecto;
        this.mapeadorAplicacionInformacionProyecto = mapeadorAplicacionInformacionProyecto;
        this.mapeadorAplicacionDetalleProyecto = mapeadorAplicacionDetalleProyecto;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoProyecto dto, Long codigo){
        var proyecto = this.mapeadorAplicacionProyecto.mapeadorAplicacion(dto);
        var informacionProyecto = this.mapeadorAplicacionInformacionProyecto.mapeadorAplicacion(dto);
        var deatalleProyecto = this.mapeadorAplicacionDetalleProyecto.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarProyecto.ejecutarModificar(proyecto,informacionProyecto,deatalleProyecto,codigo));
    }
}
