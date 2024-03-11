package com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyectoarea.DtoProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.mapeador.MapeadorAplicacionDetalleProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.mapeador.MapeadorAplicacionInformacionProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.mapeador.MapeadorAplicacionProyectoArea;
import com.ccoa.planeacionestrategica.dominio.servicio.proyectoarea.ServicioModificarProyectoArea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarProyectoArea {
    private final ServicioModificarProyectoArea servicioModificarProyectoArea;
    private final MapeadorAplicacionProyectoArea mapeadorAplicacionProyectoArea;
    private final MapeadorAplicacionInformacionProyectoArea mapeadorAplicacionInformacionProyectoArea;
    private final MapeadorAplicacionDetalleProyectoArea mapeadorAplicacionDetalleProyectoArea;

    public ServicioAplicacionModificarProyectoArea(ServicioModificarProyectoArea servicioModificarProyectoArea, MapeadorAplicacionProyectoArea mapeadorAplicacionProyectoArea,
                                                   MapeadorAplicacionInformacionProyectoArea mapeadorAplicacionInformacionProyectoArea, MapeadorAplicacionDetalleProyectoArea mapeadorAplicacionDetalleProyectoArea) {
        this.servicioModificarProyectoArea = servicioModificarProyectoArea;
        this.mapeadorAplicacionProyectoArea = mapeadorAplicacionProyectoArea;
        this.mapeadorAplicacionInformacionProyectoArea = mapeadorAplicacionInformacionProyectoArea;
        this.mapeadorAplicacionDetalleProyectoArea = mapeadorAplicacionDetalleProyectoArea;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoProyectoArea dto, Long codigo){
        var proyecto = this.mapeadorAplicacionProyectoArea.mapeadorAplicacion(dto);
        var informacionProyecto = this.mapeadorAplicacionInformacionProyectoArea.mapeadorAplicacion(dto);
        var detalleProyecto = this.mapeadorAplicacionDetalleProyectoArea.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarProyectoArea.ejecutarModificar(proyecto,informacionProyecto,detalleProyecto,codigo));
    }
    public DtoRespuesta<Long> ejecutarModificarValorEjecutado(DtoProyectoArea dto, Long codigo){
        var proyecto = this.mapeadorAplicacionProyectoArea.mapeadorAplicacionValorEjecutado(dto);
        return new DtoRespuesta<>(this.servicioModificarProyectoArea.ejecutarModificarValorEjecutado(proyecto,codigo));
    }
}
