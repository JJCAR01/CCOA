package com.ccoa.planeacionestrategica.aplicacion.servicio.proceso.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.proceso.DtoProceso;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proceso.mapeador.MapeadorAplicacionProceso;
import com.ccoa.planeacionestrategica.dominio.servicio.proceso.ServicioGuardarProceso;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarProceso {
    private final ServicioGuardarProceso servicioGuardarProceso;
    private final MapeadorAplicacionProceso mapeadorAplicacionProceso;

    public ServicioAplicacionGuardarProceso(ServicioGuardarProceso servicioGuardarProceso, MapeadorAplicacionProceso mapeadorAplicacionProceso) {
        this.servicioGuardarProceso = servicioGuardarProceso;
        this.mapeadorAplicacionProceso = mapeadorAplicacionProceso;
    }

    public DtoRespuesta<Long> ejecutar(DtoProceso dto){
        var proceso = this.mapeadorAplicacionProceso.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarProceso.ejecutarGuardar(proceso));
    }
}
