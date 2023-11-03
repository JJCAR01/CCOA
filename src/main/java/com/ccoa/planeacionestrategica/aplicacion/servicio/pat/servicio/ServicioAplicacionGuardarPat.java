package com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoPat;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.mapeador.MapeadorAplicacionPat;
import com.ccoa.planeacionestrategica.dominio.servicio.pat.ServicioGuardarPat;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarPat {
    private final ServicioGuardarPat servicioGuardarPat;
    private final MapeadorAplicacionPat mapeadorAplicacionPat;
    public ServicioAplicacionGuardarPat(ServicioGuardarPat servicioGuardarPat, MapeadorAplicacionPat mapeadorAplicacionPat) {
        this.servicioGuardarPat = servicioGuardarPat;
        this.mapeadorAplicacionPat = mapeadorAplicacionPat;
    }
    public DtoRespuesta<Long> ejecutar(DtoPat dto){
        var pat = this.mapeadorAplicacionPat.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarPat.ejecutarGuardar(pat));
    }
}
