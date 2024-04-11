package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.InformacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDiasRestantes;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDuracionDias;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularPorcentaje;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

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
        var duracion = servicioCalcularDuracionDias.calcular(dto.getFechaInicial(),dto.getFechaFinal());
        var diasRestantes = servicioCalcularDiasRestantes.calcular(dto.getFechaFinal());
        var porcentajeEsperado = servicioCalcularPorcentaje.obtenerPorcentajeEsperado(dto.getFechaInicial(),duracion);

        return InformacionActividadGestion.of(duracion,diasRestantes, Mensaje.POR_DEFECTO_AVANCE,
                porcentajeEsperado,Mensaje.POR_DEFECTO_AVANCE);
    }
    public InformacionActividadGestion mapeadorAplicacionDuplicar(LocalDate fechaInicial, LocalDate fechaFinal) {
        var duracion = servicioCalcularDuracionDias.calcular(fechaInicial,fechaFinal);
        var diasRestantes = servicioCalcularDiasRestantes.calcular(fechaFinal);
        var porcentajeEsperado = servicioCalcularPorcentaje.obtenerPorcentajeEsperado(fechaInicial,duracion);

        return InformacionActividadGestion.of(duracion,diasRestantes, Mensaje.POR_DEFECTO_AVANCE, porcentajeEsperado
                ,Mensaje.POR_DEFECTO_AVANCE);
    }
}
