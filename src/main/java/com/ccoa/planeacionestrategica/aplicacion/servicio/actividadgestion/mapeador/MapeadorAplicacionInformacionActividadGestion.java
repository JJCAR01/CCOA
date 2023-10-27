package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.InformacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDiasRestantes;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDuracionDias;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioObtenerHoraActual;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class MapeadorAplicacionInformacionActividadGestion implements MapeadorAplicacion<DtoActividadGestion, InformacionActividadGestion> {
    private final ServicioObtenerHoraActual servicioObtenerHoraActual;
    private final ServicioCalcularDuracionDias servicioCalcularDuracionDias;
    private final ServicioCalcularDiasRestantes servicioCalcularDiasRestantes;

    public MapeadorAplicacionInformacionActividadGestion(ServicioObtenerHoraActual servicioObtenerHoraActual, ServicioCalcularDuracionDias servicioCalcularDuracionDias, ServicioCalcularDiasRestantes servicioCalcularDiasRestantes) {
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
        this.servicioCalcularDuracionDias = servicioCalcularDuracionDias;
        this.servicioCalcularDiasRestantes = servicioCalcularDiasRestantes;
    }

    @Override
    public InformacionActividadGestion mapeadorAplicacion(DtoActividadGestion dto) {
        return new InformacionActividadGestion(dto.getIdActividadGestion(),servicioObtenerHoraActual.ejecutar(dto.getFechaRegistro()),
                servicioCalcularDuracionDias.ejecutar(dto.getFechaInicial(),dto.getFechaFinal()),
                servicioCalcularDiasRestantes.ejecutar(LocalDate.now(),dto.getFechaFinal()),dto.getAvance());
    }
}
