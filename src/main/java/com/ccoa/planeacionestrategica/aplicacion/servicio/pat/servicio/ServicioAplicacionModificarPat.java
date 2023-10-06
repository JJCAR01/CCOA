package com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoPat;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.mapeador.MapeadorAplicacionPat;
import com.ccoa.planeacionestrategica.dominio.servicio.pat.ServicioModificarPat;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarPat {

    private final ServicioModificarPat servicioModificarPat;
    private final MapeadorAplicacionPat mapeadorAplicacionPat;
    public ServicioAplicacionModificarPat(ServicioModificarPat servicioModificarPat, MapeadorAplicacionPat mapeadorAplicacionPat) {
        this.servicioModificarPat = servicioModificarPat;
        this.mapeadorAplicacionPat = mapeadorAplicacionPat;
    }
    public DtoRespuesta<Long> ejecutarModificar(DtoPat dto, Long codigo){
        var pat = this.mapeadorAplicacionPat.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarPat.ejecutarModificar(pat,codigo));
    }
}
