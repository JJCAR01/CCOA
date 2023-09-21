package com.ccoa.planeacionestrategica.aplicacion.servicio.epica;

import com.ccoa.planeacionestrategica.aplicacion.dto.programa.DtoEpica;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.epica.Epica;
import com.ccoa.planeacionestrategica.dominio.servicio.ServicioObtenerHoraActual;
import com.ccoa.planeacionestrategica.dominio.servicio.epica.ServicioModificarPrograma;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarEpica {

    private final ServicioModificarPrograma servicioModificarPrograma;
    private final ServicioObtenerHoraActual servicioObtenerHoraActual;

    public ServicioAplicacionModificarEpica(ServicioModificarPrograma servicioModificarPrograma, ServicioObtenerHoraActual servicioObtenerHoraActual) {
        this.servicioModificarPrograma = servicioModificarPrograma;
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoEpica dto, Long codigo){

        Epica programa = Epica.of(dto.getIdEpica(),dto.getNombre(),dto.getFechaInicio(),dto.getFechaFinal(), servicioObtenerHoraActual.ejecutar(),dto.getIdUsuario());

        return new DtoRespuesta<>(this.servicioModificarPrograma.ejecutarModificar(programa,codigo));
    }
}
