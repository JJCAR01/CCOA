package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.InformacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioObtenerHoraActual;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionInformacionActividadGestion implements MapeadorAplicacion<DtoActividadGestion, InformacionActividadGestion> {
    private final ServicioObtenerHoraActual servicioObtenerHoraActual;

    public MapeadorAplicacionInformacionActividadGestion(ServicioObtenerHoraActual servicioObtenerHoraActual) {
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
    }

    @Override
    public InformacionActividadGestion mapeadorAplicacion(DtoActividadGestion dto) {
        return new InformacionActividadGestion(servicioObtenerHoraActual.ejecutar(dto.getFechaRegistro()),dto.getDuracion(),dto.getDiasRestantes(),dto.getAvance());
    }
}
