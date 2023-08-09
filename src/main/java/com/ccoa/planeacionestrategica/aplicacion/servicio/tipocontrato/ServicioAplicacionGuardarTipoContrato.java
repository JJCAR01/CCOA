package com.ccoa.planeacionestrategica.aplicacion.servicio.tipocontrato;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoTipoActividad;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoTipoContrato;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoActividad;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoContrato;
import com.ccoa.planeacionestrategica.dominio.servicio.tipoactividad.ServicioGuardarTipoActvidad;
import com.ccoa.planeacionestrategica.dominio.servicio.tipocontrato.ServicioGuardarTipoContrato;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarTipoContrato {

    private final ServicioGuardarTipoContrato servicioGuardarTipoContrato;

    public ServicioAplicacionGuardarTipoContrato(ServicioGuardarTipoContrato servicioGuardarTipoContrato) {
        this.servicioGuardarTipoContrato = servicioGuardarTipoContrato;
    }

    public DtoRespuesta<Long> ejecutar(DtoTipoContrato dto){
        TipoContrato tipoContrato = TipoContrato.of(dto.getNombre());
        return new DtoRespuesta<>(this.servicioGuardarTipoContrato.ejecutarGuardar(tipoContrato));
    }
}
