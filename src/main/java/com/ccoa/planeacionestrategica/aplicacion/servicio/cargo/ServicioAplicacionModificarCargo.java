package com.ccoa.planeacionestrategica.aplicacion.servicio.cargo;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoArea;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoCargo;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import com.ccoa.planeacionestrategica.dominio.servicio.area.ServicioModificarArea;
import com.ccoa.planeacionestrategica.dominio.servicio.cargo.ServicioModificarCargo;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarCargo {

    private final ServicioModificarCargo servicioModificarCargo;

    public ServicioAplicacionModificarCargo(ServicioModificarCargo servicioModificarCargo) {
        this.servicioModificarCargo = servicioModificarCargo;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoCargo dto, Long codigo){
        Cargo cargo = Cargo.of(dto.getIdCargo(),dto.getNombre(),dto.getIdArea());

        return new DtoRespuesta<>(this.servicioModificarCargo.ejecutarModificar(cargo,codigo));
    }
}
