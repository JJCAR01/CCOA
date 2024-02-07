package com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.pat.DtoPat;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.mapeador.MapeadorAplicacionInformacionPat;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.mapeador.MapeadorAplicacionPat;
import com.ccoa.planeacionestrategica.dominio.servicio.pat.ServicioModificarPat;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarPat {

    private final ServicioModificarPat servicioModificarPat;
    private final MapeadorAplicacionPat mapeadorAplicacionPat;
    private final MapeadorAplicacionInformacionPat mapeadorAplicacionInformacionPat;
    public ServicioAplicacionModificarPat(ServicioModificarPat servicioModificarPat, MapeadorAplicacionPat mapeadorAplicacionPat, MapeadorAplicacionInformacionPat mapeadorAplicacionInformacionPat) {
        this.servicioModificarPat = servicioModificarPat;
        this.mapeadorAplicacionPat = mapeadorAplicacionPat;
        this.mapeadorAplicacionInformacionPat = mapeadorAplicacionInformacionPat;
    }
    public DtoRespuesta<Long> ejecutarModificar(DtoPat dto, Long codigo){
        var pat = this.mapeadorAplicacionPat.mapeadorAplicacion(dto);
        var informacionPat = this.mapeadorAplicacionInformacionPat.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarPat.ejecutarModificar(pat,informacionPat,codigo));
    }
}
