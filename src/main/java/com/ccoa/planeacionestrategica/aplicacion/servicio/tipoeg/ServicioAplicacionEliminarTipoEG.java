package com.ccoa.planeacionestrategica.aplicacion.servicio.tipoeg;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.tipoeg.ServicioEliminarTipoEG;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarTipoEG {

    private final ServicioEliminarTipoEG servicioEliminarTipoEG;

    public ServicioAplicacionEliminarTipoEG(ServicioEliminarTipoEG servicioEliminarTipoEG) {
        this.servicioEliminarTipoEG = servicioEliminarTipoEG;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarTipoEG.ejecutarEliminar(codigo));
    }
}
