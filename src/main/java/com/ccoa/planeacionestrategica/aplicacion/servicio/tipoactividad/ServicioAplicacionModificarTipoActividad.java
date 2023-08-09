package com.ccoa.planeacionestrategica.aplicacion.servicio.tipoactividad;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoRubroGasto;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoTipoActividad;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.RubroGasto;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoActividad;
import com.ccoa.planeacionestrategica.dominio.servicio.rubrogasto.ServicioModificarRubroGasto;
import com.ccoa.planeacionestrategica.dominio.servicio.tipoactividad.ServicioModificarTipoActividad;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarTipoActividad {

    private final ServicioModificarTipoActividad servicioModificarTipoActividad;

    public ServicioAplicacionModificarTipoActividad(ServicioModificarTipoActividad servicioModificarTipoActividad) {
        this.servicioModificarTipoActividad = servicioModificarTipoActividad;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoTipoActividad dto, Long codigo){
        TipoActividad tipoActividad = TipoActividad.of(dto.getNombre());

        return new DtoRespuesta<>(this.servicioModificarTipoActividad.ejecutarModificar(tipoActividad,codigo));
    }
}
