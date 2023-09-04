package com.ccoa.planeacionestrategica.aplicacion.servicio.programa;

import com.ccoa.planeacionestrategica.aplicacion.dto.programa.DtoPrograma;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.programa.DetallePrograma;
import com.ccoa.planeacionestrategica.dominio.modelo.programa.InformacionPrograma;
import com.ccoa.planeacionestrategica.dominio.modelo.programa.Programa;
import com.ccoa.planeacionestrategica.dominio.servicio.ServicioObtenerHoraActual;
import com.ccoa.planeacionestrategica.dominio.servicio.programa.ServicioModificarPrograma;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarPrograma {

    private final ServicioModificarPrograma servicioModificarPrograma;
    private final ServicioObtenerHoraActual servicioObtenerHoraActual;

    public ServicioAplicacionModificarPrograma(ServicioModificarPrograma servicioModificarPrograma, ServicioObtenerHoraActual servicioObtenerHoraActual) {
        this.servicioModificarPrograma = servicioModificarPrograma;
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
    }
    public DtoRespuesta<Long> ejecutarModificar(DtoPrograma dto, Long codigo){

        Programa programa = Programa.of(dto.getNombre(), dto.getCodigo(), dto.getVersion(),dto.getFechaInicio(),dto.getFechaFinal(), servicioObtenerHoraActual.ejecutar());

        return new DtoRespuesta<>(this.servicioModificarPrograma.ejecutarModificar(programa,codigo));
    }
}
