package com.ccoa.planeacionestrategica.aplicacion.servicio.rubro;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoRubro;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.Rubro;
import com.ccoa.planeacionestrategica.dominio.servicio.rubro.ServicioModificarRubro;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarRubro {
    private final ServicioModificarRubro servicioModificarRubro;

    public ServicioAplicacionModificarRubro(ServicioModificarRubro servicioModificarRubro) {
        this.servicioModificarRubro = servicioModificarRubro;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoRubro dto, Long codigo){
        Rubro rubro = Rubro.of(dto.getIdRubro(),dto.getNombre(), dto.getClasificacion(), dto.getIdTipoGI());

        return new DtoRespuesta<>(this.servicioModificarRubro.ejecutarModificar(rubro,codigo));
    }


}
