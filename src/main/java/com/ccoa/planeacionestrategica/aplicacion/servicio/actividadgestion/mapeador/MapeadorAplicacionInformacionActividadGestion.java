package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.InformacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDiasRestantes;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDuracionDias;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularPorcentaje;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionInformacionActividadGestion implements MapeadorAplicacion<DtoActividadGestion, InformacionActividadGestion> {

    private final ServicioCalcularDuracionDias servicioCalcularDuracionDias;
    private final ServicioCalcularDiasRestantes servicioCalcularDiasRestantes;
    private final ServicioCalcularPorcentaje servicioCalcularPorcentaje;

    public MapeadorAplicacionInformacionActividadGestion(ServicioCalcularDuracionDias servicioCalcularDuracionDias, ServicioCalcularDiasRestantes servicioCalcularDiasRestantes, ServicioCalcularPorcentaje servicioCalcularPorcentaje) {
        this.servicioCalcularDuracionDias = servicioCalcularDuracionDias;
        this.servicioCalcularDiasRestantes = servicioCalcularDiasRestantes;
        this.servicioCalcularPorcentaje = servicioCalcularPorcentaje;
    }

    @Override
    public InformacionActividadGestion mapeadorAplicacion(DtoActividadGestion dto) {
        return InformacionActividadGestion.of(servicioCalcularDuracionDias.calcular(dto.getFechaInicial(),dto.getFechaFinal()),
                servicioCalcularDiasRestantes.calcular(dto.getFechaFinal()), Mensaje.POR_DEFECTO_AVANCE,
                servicioCalcularPorcentaje.obtenerPorcentajeEsperado(dto.getFechaInicial(),
                        servicioCalcularDuracionDias.calcular(dto.getFechaInicial(),dto.getFechaFinal()))
                ,Mensaje.POR_DEFECTO_AVANCE);
    }
}
