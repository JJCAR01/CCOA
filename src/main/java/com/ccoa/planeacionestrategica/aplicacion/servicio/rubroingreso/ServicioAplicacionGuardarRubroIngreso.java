package com.ccoa.planeacionestrategica.aplicacion.servicio.rubroingreso;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoRubroGasto;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoRubroIngreso;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.RubroGasto;
import com.ccoa.planeacionestrategica.dominio.modelo.RubroIngreso;
import com.ccoa.planeacionestrategica.dominio.servicio.rubrogasto.ServicioGuardarRubroGasto;
import com.ccoa.planeacionestrategica.dominio.servicio.rubroingreso.ServicioGuardarRubroIngreso;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarRubroIngreso {

    private final ServicioGuardarRubroIngreso servicioGuardarRubroIngreso;

    public ServicioAplicacionGuardarRubroIngreso(ServicioGuardarRubroIngreso servicioGuardarRubroIngreso) {
        this.servicioGuardarRubroIngreso = servicioGuardarRubroIngreso;
    }

    public DtoRespuesta<Long> ejecutar(DtoRubroIngreso dto){
        RubroIngreso rubroIngreso = RubroIngreso.of(dto.getNombre());
        return new DtoRespuesta<>(this.servicioGuardarRubroIngreso.ejecutarGuardar(rubroIngreso));
    }
}
