package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionestrategica.DtoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.InformacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDiasRestantes;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDuracionDias;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularPorcentaje;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class MapeadorAplicacionInformacionActividadGestionEstrategica implements MapeadorAplicacion<DtoActividadGestionEstrategica,
        InformacionActividadGestionEstrategica> {

    private final ServicioCalcularDuracionDias servicioCalcularDuracionDias;
    private final ServicioCalcularDiasRestantes servicioCalcularDiasRestantes;
    private final ServicioCalcularPorcentaje servicioCalcularPorcentaje;

    public MapeadorAplicacionInformacionActividadGestionEstrategica(ServicioCalcularDuracionDias servicioCalcularDuracionDias, ServicioCalcularDiasRestantes servicioCalcularDiasRestantes, ServicioCalcularPorcentaje servicioCalcularPorcentaje) {
        this.servicioCalcularDuracionDias = servicioCalcularDuracionDias;
        this.servicioCalcularDiasRestantes = servicioCalcularDiasRestantes;
        this.servicioCalcularPorcentaje = servicioCalcularPorcentaje;
    }

    @Override
    public InformacionActividadGestionEstrategica mapeadorAplicacion(DtoActividadGestionEstrategica dto) {
        var duracion = servicioCalcularDuracionDias.calcular(dto.getFechaInicial(),dto.getFechaFinal());
        var diasRestantes = servicioCalcularDiasRestantes.calcular(dto.getFechaFinal());
        var porcentajeEsperado = servicioCalcularPorcentaje.obtenerPorcentajeEsperado(dto.getFechaInicial(),duracion);

        return InformacionActividadGestionEstrategica.of(duracion,diasRestantes, Mensaje.POR_DEFECTO_AVANCE,
                porcentajeEsperado,Mensaje.POR_DEFECTO_AVANCE);
    }
    public InformacionActividadGestionEstrategica mapeadorAplicacionDuplicar(LocalDate fechaInicial, LocalDate fechaFinal) {
        var duracion = servicioCalcularDuracionDias.calcular(fechaInicial,fechaFinal);
        var diasRestantes = servicioCalcularDiasRestantes.calcular(fechaFinal);
        var porcentajeEsperado = servicioCalcularPorcentaje.obtenerPorcentajeEsperado(fechaInicial,duracion);

        return InformacionActividadGestionEstrategica.of(duracion,diasRestantes,Mensaje.POR_DEFECTO_AVANCE,porcentajeEsperado
                ,Mensaje.POR_DEFECTO_AVANCE);
    }
}
