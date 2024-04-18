package com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.pat.DtoPat;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.mapeador.MapeadorAplicacionDetallePat;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.mapeador.MapeadorAplicacionInformacionPat;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.mapeador.MapeadorAplicacionPat;
import com.ccoa.planeacionestrategica.dominio.servicio.pat.ServicioGuardarPat;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarPat {
    private final ServicioGuardarPat servicioGuardarPat;
    private final MapeadorAplicacionPat mapeadorAplicacionPat;
    private final MapeadorAplicacionInformacionPat mapeadorAplicacionInformacionPat;
    private final MapeadorAplicacionDetallePat mapeadorAplicacionDetallePat;
    public ServicioAplicacionGuardarPat(ServicioGuardarPat servicioGuardarPat, MapeadorAplicacionPat mapeadorAplicacionPat, MapeadorAplicacionInformacionPat mapeadorAplicacionInformacionPat, MapeadorAplicacionDetallePat mapeadorAplicacionDetallePat) {
        this.servicioGuardarPat = servicioGuardarPat;
        this.mapeadorAplicacionPat = mapeadorAplicacionPat;
        this.mapeadorAplicacionInformacionPat = mapeadorAplicacionInformacionPat;
        this.mapeadorAplicacionDetallePat = mapeadorAplicacionDetallePat;
    }
    public DtoRespuesta<Long> ejecutar(DtoPat dto){
        var pat = this.mapeadorAplicacionPat.mapeadorAplicacion(dto);
        var informacionPat = this.mapeadorAplicacionInformacionPat.mapeadorAplicacion(dto);
        var detallePat = this.mapeadorAplicacionDetallePat.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarPat.ejecutarGuardar(pat,informacionPat,detallePat));
    }
}
