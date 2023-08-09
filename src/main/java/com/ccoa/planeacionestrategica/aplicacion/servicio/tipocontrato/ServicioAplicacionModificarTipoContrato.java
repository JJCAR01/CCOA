package com.ccoa.planeacionestrategica.aplicacion.servicio.tipocontrato;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoTipoActividad;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoTipoContrato;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoActividad;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoContrato;
import com.ccoa.planeacionestrategica.dominio.servicio.tipoactividad.ServicioModificarTipoActividad;
import com.ccoa.planeacionestrategica.dominio.servicio.tipocontrato.ServicioModificarTipoContrato;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarTipoContrato {

    private final ServicioModificarTipoContrato servicioModificarTipoContrato;

    public ServicioAplicacionModificarTipoContrato(ServicioModificarTipoContrato servicioModificarTipoContrato) {
        this.servicioModificarTipoContrato = servicioModificarTipoContrato;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoTipoContrato dto, Long codigo){
        TipoContrato tipoContrato = TipoContrato.of(dto.getNombre());

        return new DtoRespuesta<>(this.servicioModificarTipoContrato.ejecutarModificar(tipoContrato,codigo));
    }
}
