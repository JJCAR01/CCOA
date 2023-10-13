package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.ActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioObtenerHoraActual;
import org.springframework.stereotype.Component;

@Component
public class MapeadorAplicacionActividadEstrategica implements MapeadorAplicacion<DtoActividadEstrategica, ActividadEstrategica> {
    private final ServicioObtenerHoraActual servicioObtenerHoraActual;

    public MapeadorAplicacionActividadEstrategica(ServicioObtenerHoraActual servicioObtenerHoraActual) {
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
    }

    @Override
    public ActividadEstrategica mapeadorAplicacion(DtoActividadEstrategica dto) {
        return new ActividadEstrategica(dto.getIdEpica(), dto.getNombre(), dto.getFechaInicial(),dto.getFechaFinal(),servicioObtenerHoraActual.ejecutar(dto.getFechaRegistro()));
    }
}
