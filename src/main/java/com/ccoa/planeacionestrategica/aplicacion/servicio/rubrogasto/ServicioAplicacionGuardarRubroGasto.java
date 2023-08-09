package com.ccoa.planeacionestrategica.aplicacion.servicio.rubrogasto;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoArea;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoRubroGasto;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.RubroGasto;
import com.ccoa.planeacionestrategica.dominio.servicio.area.ServicioGuardarArea;
import com.ccoa.planeacionestrategica.dominio.servicio.rubrogasto.ServicioGuardarRubroGasto;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarRubroGasto {

    private final ServicioGuardarRubroGasto servicioGuardarRubroGasto;

    public ServicioAplicacionGuardarRubroGasto(ServicioGuardarRubroGasto servicioGuardarRubroGasto) {
        this.servicioGuardarRubroGasto = servicioGuardarRubroGasto;
    }

    public DtoRespuesta<Long> ejecutar(DtoRubroGasto dto){
        RubroGasto rubroGasto = RubroGasto.of(dto.getNombre());
        return new DtoRespuesta<>(this.servicioGuardarRubroGasto.ejecutarGuardar(rubroGasto));
    }

}
