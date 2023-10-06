package com.ccoa.planeacionestrategica.aplicacion.servicio.epica.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.epica.DtoEpica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.epica.mapeador.MapeadorAplicacionEpica;
import com.ccoa.planeacionestrategica.dominio.servicio.epica.ServicioModificarEpica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarEpica {
    private final ServicioModificarEpica servicioModificarEpica;
    private final MapeadorAplicacionEpica mapeadorAplicacionEpica;
    public ServicioAplicacionModificarEpica(ServicioModificarEpica servicioModificarEpica, MapeadorAplicacionEpica mapeadorAplicacionEpica) {
        this.servicioModificarEpica = servicioModificarEpica;
        this.mapeadorAplicacionEpica = mapeadorAplicacionEpica;
    }
    public DtoRespuesta<Long> ejecutarModificar(DtoEpica dto, Long codigo){
        var epica = this.mapeadorAplicacionEpica.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarEpica.ejecutarModificar(epica,codigo));
    }
}
