package com.ccoa.planeacionestrategica.aplicacion.servicio.pat;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoPat;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.*;
import com.ccoa.planeacionestrategica.dominio.servicio.ServicioObtenerHoraActual;
import com.ccoa.planeacionestrategica.dominio.servicio.pat.ServicioGuardarPat;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarPat {

    private final ServicioGuardarPat servicioGuardarPat;
    private final ServicioObtenerHoraActual servicioObtenerHoraActual;

    public ServicioAplicacionGuardarPat(ServicioGuardarPat servicioGuardarPat, ServicioObtenerHoraActual servicioObtenerHoraActual) {
        this.servicioGuardarPat = servicioGuardarPat;
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
    }

    public DtoRespuesta<Long> ejecutar(DtoPat dto){
        Pat pat = Pat.of(dto.getNombre(),dto.getFechaInicio(),dto.getFechaFinal(),servicioObtenerHoraActual.ejecutar(),
                dto.getPorcentajeReal(), dto.getPorcentajeEsperado(), dto.getCumplimiento(), dto.getIdUsuario());
        return new DtoRespuesta<>(this.servicioGuardarPat.ejecutarGuardar(pat));
    }
}
