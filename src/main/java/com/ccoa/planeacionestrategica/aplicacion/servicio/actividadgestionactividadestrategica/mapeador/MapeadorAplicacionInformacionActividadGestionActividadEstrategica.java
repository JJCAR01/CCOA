package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionactividadestrategica.DtoActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.InformacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioObtenerHoraActual;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionInformacionActividadGestionActividadEstrategica implements MapeadorAplicacion<DtoActividadGestionActividadEstrategica,
        InformacionActividadGestionActividadEstrategica> {
    private final ServicioObtenerHoraActual servicioObtenerHoraActual;

    public MapeadorAplicacionInformacionActividadGestionActividadEstrategica(ServicioObtenerHoraActual servicioObtenerHoraActual) {
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
    }

    @Override
    public InformacionActividadGestionActividadEstrategica mapeadorAplicacion(DtoActividadGestionActividadEstrategica dto) {
        return new InformacionActividadGestionActividadEstrategica(servicioObtenerHoraActual.ejecutar(dto.getFechaRegistro()),dto.getDuracion(),dto.getDiasRestantes(),dto.getAvance());
    }
}
