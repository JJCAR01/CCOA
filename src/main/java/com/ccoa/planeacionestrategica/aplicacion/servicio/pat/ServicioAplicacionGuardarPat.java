package com.ccoa.planeacionestrategica.aplicacion.servicio.pat;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoPat;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.*;
import com.ccoa.planeacionestrategica.dominio.servicio.ServicioObtenerHoraActual;
import com.ccoa.planeacionestrategica.dominio.servicio.pat.ServicioGuardarPat;
import com.ccoa.planeacionestrategica.dominio.transversal.formateador.FormateadorHora;
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
        Pat pat = Pat.of(dto.getIdPat(), dto.getNombre(),FormateadorHora.obtenerFechaAnual(dto.getFechaAnual()),
                FormateadorHora.obtenerFechaTexto(servicioObtenerHoraActual.ejecutar()),
                dto.getPorcentaje(), dto.getProceso(), dto.getIdUsuario());
        return new DtoRespuesta<>(this.servicioGuardarPat.ejecutarGuardar(pat));
    }
}
