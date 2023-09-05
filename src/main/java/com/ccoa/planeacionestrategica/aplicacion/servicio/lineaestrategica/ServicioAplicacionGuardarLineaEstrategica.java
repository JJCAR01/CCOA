package com.ccoa.planeacionestrategica.aplicacion.servicio.lineaestrategica;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoLineaEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.*;
import com.ccoa.planeacionestrategica.dominio.servicio.ServicioObtenerHoraActual;
import com.ccoa.planeacionestrategica.dominio.servicio.lineaestrategica.ServicioGuardarLineaEstrategica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarLineaEstrategica {

    private final ServicioGuardarLineaEstrategica servicioGuardarLineaEstrategica;
    private final ServicioObtenerHoraActual servicioObtenerHoraActual;

    public ServicioAplicacionGuardarLineaEstrategica(ServicioGuardarLineaEstrategica servicioGuardarLineaEstrategica, ServicioObtenerHoraActual servicioObtenerHoraActual) {
        this.servicioGuardarLineaEstrategica = servicioGuardarLineaEstrategica;
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
    }

    public DtoRespuesta<Long> ejecutar(DtoLineaEstrategica dto){

        LineaEstrategica lineaEstrategica = LineaEstrategica.of(dto.getNombre(), dto.getEntregable(),dto.getFechaInicio(),dto.getFechaFinal(),
                servicioObtenerHoraActual.ejecutar(),
                dto.getIndicadorResultado(), dto.getIdPrograma(), dto.getIdUsuario());
        return new DtoRespuesta<>(this.servicioGuardarLineaEstrategica.ejecutarGuardar(lineaEstrategica));
    }
}
