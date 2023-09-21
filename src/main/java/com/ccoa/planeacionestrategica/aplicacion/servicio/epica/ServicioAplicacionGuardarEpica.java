package com.ccoa.planeacionestrategica.aplicacion.servicio.epica;

import com.ccoa.planeacionestrategica.aplicacion.dto.programa.DtoEpica;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.epica.InformacionEpica;
import com.ccoa.planeacionestrategica.dominio.modelo.epica.Epica;
import com.ccoa.planeacionestrategica.dominio.servicio.ServicioObtenerHoraActual;
import com.ccoa.planeacionestrategica.dominio.servicio.epica.ServicioGuardarEpica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarEpica {

    private final ServicioGuardarEpica servicioGuardarEpica;
    private final ServicioObtenerHoraActual servicioObtenerHoraActual;

    public ServicioAplicacionGuardarEpica(ServicioGuardarEpica servicioGuardarEpica, ServicioObtenerHoraActual servicioObtenerHoraActual) {
        this.servicioGuardarEpica = servicioGuardarEpica;
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
    }

    public DtoRespuesta<Long> ejecutar(DtoEpica dto){

        Epica epica = Epica.of(dto.getIdEpica(), dto.getNombre(),dto.getFechaInicio(),dto.getFechaFinal(), servicioObtenerHoraActual.ejecutar(),dto.getIdUsuario());
            InformacionEpica informacionEpica = InformacionEpica.of(dto.getDuracion(), dto.getDiasRestantes(), dto.getEstado(),dto.getAvance());
        return new DtoRespuesta<>(this.servicioGuardarEpica.ejecutarGuardar(epica,informacionEpica));
    }
}
