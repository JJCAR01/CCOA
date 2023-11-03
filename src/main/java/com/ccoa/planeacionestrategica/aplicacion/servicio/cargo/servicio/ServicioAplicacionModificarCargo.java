package com.ccoa.planeacionestrategica.aplicacion.servicio.cargo.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoCargo;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.cargo.mapeador.MapeadorAplicacionCargo;
import com.ccoa.planeacionestrategica.dominio.servicio.cargo.ServicioModificarCargo;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarCargo {

    private final ServicioModificarCargo servicioModificarCargo;
    private final MapeadorAplicacionCargo mapeadorAplicacionCargo;

    public ServicioAplicacionModificarCargo(ServicioModificarCargo servicioModificarCargo, MapeadorAplicacionCargo mapeadorAplicacionCargo) {
        this.servicioModificarCargo = servicioModificarCargo;
        this.mapeadorAplicacionCargo = mapeadorAplicacionCargo;
    }
    public DtoRespuesta<Long> ejecutarModificar(DtoCargo dto, Long codigo){
        var cargo = this.mapeadorAplicacionCargo.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarCargo.ejecutarModificar(cargo,codigo));
    }
}
