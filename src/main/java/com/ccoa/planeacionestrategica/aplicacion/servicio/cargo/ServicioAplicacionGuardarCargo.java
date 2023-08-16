package com.ccoa.planeacionestrategica.aplicacion.servicio.cargo;


import com.ccoa.planeacionestrategica.aplicacion.dto.DtoCargo;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;

import com.ccoa.planeacionestrategica.dominio.servicio.cargo.ServicioGuardarCargo;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarCargo {

    private final ServicioGuardarCargo servicioGuardarCargo;

    public ServicioAplicacionGuardarCargo(ServicioGuardarCargo servicioGuardarCargo) {
        this.servicioGuardarCargo = servicioGuardarCargo;
    }

    public DtoRespuesta<Long> ejecutar(DtoCargo dto){

        Area area = Area.of(dto.getDtoArea().getNombre());

        Cargo cargo = Cargo.of(dto.getNombre(),area);
        return new DtoRespuesta<>(this.servicioGuardarCargo.ejecutarGuardar(cargo));
    }
}
