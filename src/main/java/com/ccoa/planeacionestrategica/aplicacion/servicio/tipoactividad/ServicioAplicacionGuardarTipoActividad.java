package com.ccoa.planeacionestrategica.aplicacion.servicio.tipoactividad;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoRubroGasto;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoTipoActividad;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.RubroGasto;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoActividad;
import com.ccoa.planeacionestrategica.dominio.servicio.rubrogasto.ServicioGuardarRubroGasto;
import com.ccoa.planeacionestrategica.dominio.servicio.tipoactividad.ServicioGuardarTipoActvidad;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarTipoActividad {

    private final ServicioGuardarTipoActvidad servicioGuardarTipoActvidad;

    public ServicioAplicacionGuardarTipoActividad(ServicioGuardarTipoActvidad servicioGuardarTipoActvidad) {
        this.servicioGuardarTipoActvidad = servicioGuardarTipoActvidad;
    }

    public DtoRespuesta<Long> ejecutar(DtoTipoActividad dto){
        TipoActividad tipoActividad = TipoActividad.of(dto.getNombre());
        return new DtoRespuesta<>(this.servicioGuardarTipoActvidad.ejecutarGuardar(tipoActividad));
    }
}
