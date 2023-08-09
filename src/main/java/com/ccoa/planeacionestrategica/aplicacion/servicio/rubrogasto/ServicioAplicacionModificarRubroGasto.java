package com.ccoa.planeacionestrategica.aplicacion.servicio.rubrogasto;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoArea;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoRubroGasto;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.RubroGasto;
import com.ccoa.planeacionestrategica.dominio.servicio.area.ServicioModificarArea;
import com.ccoa.planeacionestrategica.dominio.servicio.rubrogasto.ServicioModificarRubroGasto;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarRubroGasto {

    private final ServicioModificarRubroGasto servicioModificarRubroGasto;

    public ServicioAplicacionModificarRubroGasto(ServicioModificarRubroGasto servicioModificarRubroGasto) {
        this.servicioModificarRubroGasto = servicioModificarRubroGasto;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoRubroGasto dto, Long codigo){
        RubroGasto rubroGasto = RubroGasto.of(dto.getNombre());

        return new DtoRespuesta<>(this.servicioModificarRubroGasto.ejecutarModificar(rubroGasto,codigo));
    }
}
