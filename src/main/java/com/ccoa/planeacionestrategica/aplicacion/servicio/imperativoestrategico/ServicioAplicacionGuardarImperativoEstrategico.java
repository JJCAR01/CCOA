package com.ccoa.planeacionestrategica.aplicacion.servicio.imperativoestrategico;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoImperativoEstrategico;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.*;
import com.ccoa.planeacionestrategica.dominio.servicio.ServicioObtenerHoraActual;
import com.ccoa.planeacionestrategica.dominio.servicio.imperativoestrategico.ServicioGuardarImperativoEstrategico;
import com.ccoa.planeacionestrategica.dominio.transversal.formateador.FormateadorHora;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarImperativoEstrategico {

    private final ServicioGuardarImperativoEstrategico servicioGuardarImperativoEstrategico;
    private final ServicioObtenerHoraActual servicioObtenerHoraActual;

    public ServicioAplicacionGuardarImperativoEstrategico(ServicioGuardarImperativoEstrategico servicioGuardarImperativoEstrategico, ServicioObtenerHoraActual servicioObtenerHoraActual) {
        this.servicioGuardarImperativoEstrategico = servicioGuardarImperativoEstrategico;
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
    }

    public DtoRespuesta<Long> ejecutar(DtoImperativoEstrategico dto){

        ImperativoEstrategico imperativoEstrategico = ImperativoEstrategico.of(dto.getIdImperativoEstrategico(), dto.getNombre(),
                dto.getFechaInicio(),dto.getFechaFinal(),
                servicioObtenerHoraActual.ejecutar(),dto.getPorcentajeReal(),dto.getPorcentajeEsperado(),
                dto.getCumplimiento(), dto.getIdPat(), dto.getIdUsuario());

        return new DtoRespuesta<>(this.servicioGuardarImperativoEstrategico.ejecutarGuardar(imperativoEstrategico));
    }
}
