package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionactividadestrategica.DtoActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.ActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioObtenerHoraActual;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionActividadGestionActividadEstrategica implements MapeadorAplicacion<DtoActividadGestionActividadEstrategica, ActividadGestionActividadEstrategica> {
    private final ServicioObtenerHoraActual servicioObtenerHoraActual;

    public MapeadorAplicacionActividadGestionActividadEstrategica(ServicioObtenerHoraActual servicioObtenerHoraActual) {
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
    }

    @Override
    public ActividadGestionActividadEstrategica mapeadorAplicacion(DtoActividadGestionActividadEstrategica dto) {
        return ActividadGestionActividadEstrategica.of(dto.getIdActividadGestionActividadEstrategica(),dto.getNombre(), dto.getFechaInicial(),dto.getFechaFinal(),
                servicioObtenerHoraActual.calcular(dto.getFechaRegistro()), dto.getIdUsuario(), dto.getIdActividadEstrategica());
    }
}
