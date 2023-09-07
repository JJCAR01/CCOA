package com.ccoa.planeacionestrategica.aplicacion.servicio.tipogi;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoTipoGI;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoGI;
import com.ccoa.planeacionestrategica.dominio.servicio.tipogi.ServicioModificarTipoGI;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarTipoGI {

    private final ServicioModificarTipoGI servicioModificarTipoGI;

    public ServicioAplicacionModificarTipoGI(ServicioModificarTipoGI servicioModificarTipoGI) {
        this.servicioModificarTipoGI = servicioModificarTipoGI;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoTipoGI dto, Long codigo){
        TipoGI tipoGI = TipoGI.of(dto.getIdTipoGI(),dto.getCantidad(),dto.getClasificacion(), dto.getValorUnitario(), dto.getValorUnitario(),
                dto.getObservacion());

        return new DtoRespuesta<>(this.servicioModificarTipoGI.ejecutarModificar(tipoGI,codigo));
    }
}
