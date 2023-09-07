package com.ccoa.planeacionestrategica.aplicacion.servicio.pat;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoPat;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.*;
import com.ccoa.planeacionestrategica.dominio.servicio.pat.ServicioModificarPat;
import com.ccoa.planeacionestrategica.dominio.transversal.formateador.FormateadorHora;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarPat {

    private final ServicioModificarPat servicioModificarPat;

    public ServicioAplicacionModificarPat(ServicioModificarPat servicioModificarPat) {
        this.servicioModificarPat = servicioModificarPat;
    }
    public DtoRespuesta<Long> ejecutarModificar(DtoPat dto, Long codigo){

        Pat pat = Pat.of(dto.getIdPat(), dto.getNombre(),dto.getFechaInicio(),dto.getFechaFinal(),
                FormateadorHora.obtenerFechaTexto(dto.getFechaRegistro())
                ,dto.getPorcentajeReal(), dto.getPorcentajeEsperado(), dto.getCumplimiento(), dto.getIdUsuario());

        return new DtoRespuesta<>(this.servicioModificarPat.ejecutarModificar(pat,codigo));
    }
}
