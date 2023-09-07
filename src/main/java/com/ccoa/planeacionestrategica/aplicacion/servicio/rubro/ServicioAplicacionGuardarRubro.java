package com.ccoa.planeacionestrategica.aplicacion.servicio.rubro;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoRubro;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.Rubro;
import com.ccoa.planeacionestrategica.dominio.servicio.rubro.ServicioGuardarRubro;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarRubro {

    private final ServicioGuardarRubro servicioGuardarRubro;

    public ServicioAplicacionGuardarRubro(ServicioGuardarRubro servicioGuardarRubro) {
        this.servicioGuardarRubro = servicioGuardarRubro;
    }

    public DtoRespuesta<Long> ejecutar(DtoRubro dto){
        Rubro rubro = Rubro.of(dto.getIdRubro(), dto.getNombre(),dto.getIdTipoGI());

        return new DtoRespuesta<>(this.servicioGuardarRubro.ejecutarGuardar(rubro));
    }


}
