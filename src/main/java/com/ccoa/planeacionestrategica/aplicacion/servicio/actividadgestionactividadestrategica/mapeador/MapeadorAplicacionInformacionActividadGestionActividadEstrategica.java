package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionactividadestrategica.DtoActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.InformacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDiasRestantes;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDuracionDias;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioObtenerHoraActual;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionInformacionActividadGestionActividadEstrategica implements MapeadorAplicacion<DtoActividadGestionActividadEstrategica,
        InformacionActividadGestionActividadEstrategica> {
    private final ServicioObtenerHoraActual servicioObtenerHoraActual;
    private final ServicioCalcularDuracionDias servicioCalcularDuracionDias;
    private final ServicioCalcularDiasRestantes servicioCalcularDiasRestantes;

    public MapeadorAplicacionInformacionActividadGestionActividadEstrategica(ServicioObtenerHoraActual servicioObtenerHoraActual, ServicioCalcularDuracionDias servicioCalcularDuracionDias, ServicioCalcularDiasRestantes servicioCalcularDiasRestantes) {
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
        this.servicioCalcularDuracionDias = servicioCalcularDuracionDias;
        this.servicioCalcularDiasRestantes = servicioCalcularDiasRestantes;
    }

    @Override
    public InformacionActividadGestionActividadEstrategica mapeadorAplicacion(DtoActividadGestionActividadEstrategica dto) {
        return InformacionActividadGestionActividadEstrategica.of(dto.getIdActividadGestionActividadEstrategica(), servicioObtenerHoraActual.calcular(dto.getFechaRegistro()),
                servicioCalcularDuracionDias.calcular(dto.getFechaInicial(),dto.getFechaFinal()) ,
                servicioCalcularDiasRestantes.calcular(dto.getFechaFinal()),dto.getAvance());
    }
}
