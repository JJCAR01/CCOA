package com.ccoa.planeacionestrategica.aplicacion.servicio.tipogi;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoTipoGI;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoGI;
import com.ccoa.planeacionestrategica.dominio.servicio.tipogi.ServicioGuardarTipoGI;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarTipoGI {

    private final ServicioGuardarTipoGI servicioGuardarTipoGI;

    public ServicioAplicacionGuardarTipoGI(ServicioGuardarTipoGI servicioGuardarTipoGI) {
        this.servicioGuardarTipoGI = servicioGuardarTipoGI;
    }

    public DtoRespuesta<Long> ejecutar(DtoTipoGI dto){
        TipoGI tipoGI = TipoGI.of(dto.getIdTipoGI(), dto.getCantidad(),dto.getClasificacion(),dto.getValorUnitario(),
                dto.getValorTotal(),dto.getObservacion());
        return new DtoRespuesta<>(this.servicioGuardarTipoGI.ejecutarGuardar(tipoGI));
    }
}
