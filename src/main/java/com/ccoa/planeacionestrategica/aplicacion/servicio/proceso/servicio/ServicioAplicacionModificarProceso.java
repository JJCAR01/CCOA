package com.ccoa.planeacionestrategica.aplicacion.servicio.proceso.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.proceso.DtoProceso;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proceso.mapeador.MapeadorAplicacionProceso;
import com.ccoa.planeacionestrategica.dominio.servicio.proceso.ServicioModificarProceso;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarProceso {
    private final ServicioModificarProceso servicioModificarProceso;
    private final MapeadorAplicacionProceso mapeadorAplicacionProceso;

    public ServicioAplicacionModificarProceso(ServicioModificarProceso servicioModificarProceso, MapeadorAplicacionProceso mapeadorAplicacionProceso) {
        this.servicioModificarProceso = servicioModificarProceso;
        this.mapeadorAplicacionProceso = mapeadorAplicacionProceso;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoProceso dto, Long codigo){
        var proceso = this.mapeadorAplicacionProceso.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarProceso.ejecutarModificar(proceso,codigo));
    }
}
