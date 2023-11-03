package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.ActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioObtenerHoraActual;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionActividadEstrategica implements MapeadorAplicacion<DtoActividadEstrategica, ActividadEstrategica> {
    private final ServicioObtenerHoraActual servicioObtenerHoraActual;

    public MapeadorAplicacionActividadEstrategica(ServicioObtenerHoraActual servicioObtenerHoraActual) {
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
    }

    @Override
    public ActividadEstrategica mapeadorAplicacion(DtoActividadEstrategica dto) {
        return ActividadEstrategica.of(dto.getIdActividadEstrategica(), dto.getNombre(), dto.getFechaInicial(),dto.getFechaFinal(),servicioObtenerHoraActual.calcular(dto.getFechaRegistro()));
    }
}
