package com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio.duplicar;

import com.ccoa.planeacionestrategica.aplicacion.dto.pat.DtoPat;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.mapeador.MapeadorAplicacionInformacionPat;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.mapeador.MapeadorAplicacionPat;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.pat.ServicioGuardarPat;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarDuplicacionPat {
    private final ServicioGuardarPat servicioGuardarPat;
    private final MapeadorAplicacionPat mapeadorAplicacionPat;
    private final MapeadorAplicacionInformacionPat mapeadorAplicacionInformacionPat;

    public ServicioAplicacionGuardarDuplicacionPat(ServicioGuardarPat servicioGuardarPat, MapeadorAplicacionPat mapeadorAplicacionPat, MapeadorAplicacionInformacionPat mapeadorAplicacionInformacionPat) {
        this.servicioGuardarPat = servicioGuardarPat;
        this.mapeadorAplicacionPat = mapeadorAplicacionPat;
        this.mapeadorAplicacionInformacionPat = mapeadorAplicacionInformacionPat;
    }
    public DtoRespuesta<Long> ejecutar(DtoPat dto, Long codigo){
        var pat = this.mapeadorAplicacionPat.mapeadorAplicacion(dto);
        var informacionPat = this.mapeadorAplicacionInformacionPat.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarPat.guardarDuplicado(pat,informacionPat, codigo));
    }
}
