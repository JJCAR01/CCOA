package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionestrategica.DtoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.ActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioObtenerHoraActual;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionActividadGestionEstrategica implements MapeadorAplicacion<DtoActividadGestionEstrategica, ActividadGestionEstrategica> {
    private final ServicioObtenerHoraActual servicioObtenerHoraActual;

    public MapeadorAplicacionActividadGestionEstrategica(ServicioObtenerHoraActual servicioObtenerHoraActual) {
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
    }

    @Override
    public ActividadGestionEstrategica mapeadorAplicacion(DtoActividadGestionEstrategica dto) {
        return ActividadGestionEstrategica.of(dto.getIdActividadGestionEstrategica(),dto.getNombre(), dto.getFechaInicial(),dto.getFechaFinal(),
                servicioObtenerHoraActual.calcular(dto.getFechaRegistro()), dto.getIdUsuario(), dto.getIdActividadEstrategica());
    }
}
