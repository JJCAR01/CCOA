package com.ccoa.planeacionestrategica.aplicacion.servicio.rubroingreso;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoRubroGasto;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoRubroIngreso;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.RubroGasto;
import com.ccoa.planeacionestrategica.dominio.modelo.RubroIngreso;
import com.ccoa.planeacionestrategica.dominio.servicio.rubrogasto.ServicioModificarRubroGasto;
import com.ccoa.planeacionestrategica.dominio.servicio.rubroingreso.ServicioModificarRubroIngreso;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarRubroIngreso {

    private final ServicioModificarRubroIngreso servicioModificarRubroIngreso;

    public ServicioAplicacionModificarRubroIngreso(ServicioModificarRubroIngreso servicioModificarRubroIngreso) {
        this.servicioModificarRubroIngreso = servicioModificarRubroIngreso;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoRubroIngreso dto, Long codigo){
        RubroIngreso rubroIngreso = RubroIngreso.of(dto.getNombre());

        return new DtoRespuesta<>(this.servicioModificarRubroIngreso.ejecutarModificar(rubroIngreso,codigo));
    }
}
