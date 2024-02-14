package com.ccoa.planeacionestrategica.aplicacion.servicio.cargo.servicio;


import com.ccoa.planeacionestrategica.aplicacion.dto.cargo.DtoCargo;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.cargo.mapeador.MapeadorAplicacionCargo;
import com.ccoa.planeacionestrategica.dominio.servicio.cargo.ServicioGuardarCargo;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarCargo {
    private final ServicioGuardarCargo servicioGuardarCargo;
    private final MapeadorAplicacionCargo mapeadorAplicacionCargo;

    public ServicioAplicacionGuardarCargo(ServicioGuardarCargo servicioGuardarCargo, MapeadorAplicacionCargo mapeadorAplicacionCargo) {
        this.servicioGuardarCargo = servicioGuardarCargo;
        this.mapeadorAplicacionCargo = mapeadorAplicacionCargo;
    }
    public DtoRespuesta<Long> ejecutar(DtoCargo dto){
        var cargo = this.mapeadorAplicacionCargo.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarCargo.ejecutarGuardar(cargo));
    }
}
