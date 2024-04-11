package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.ActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioObtenerHoraActual;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class MapeadorAplicacionActividadGestion implements MapeadorAplicacion<DtoActividadGestion, ActividadGestion> {
    private final ServicioObtenerHoraActual servicioObtenerHoraActual;
    public MapeadorAplicacionActividadGestion(ServicioObtenerHoraActual servicioObtenerHoraActual) {
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
    }
    @Override
    public ActividadGestion mapeadorAplicacion(DtoActividadGestion dto) {
        return ActividadGestion.of(dto.getIdActividadGestion(),dto.getNombre(), dto.getFechaInicial(),dto.getFechaFinal(),
                servicioObtenerHoraActual.calcular(dto.getFechaRegistro()),dto.getIdUsuario(), dto.getIdPat());
    }
    public ActividadGestion mapeadorAplicacionDuplicar(DtoActividadGestion dto, Long idPat, LocalDate fechaInicial, LocalDate fechaFinal) {
        return ActividadGestion.of(dto.getIdActividadGestion(),dto.getNombre(), fechaInicial,fechaFinal,
                servicioObtenerHoraActual.calcular(dto.getFechaRegistro()),dto.getIdUsuario(), idPat);
    }
}
