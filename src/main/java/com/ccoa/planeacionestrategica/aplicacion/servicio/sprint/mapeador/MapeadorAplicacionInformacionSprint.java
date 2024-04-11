package com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoSprint;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.InformacionSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.Tarea;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentaje;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDuracionDias;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularPorcentaje;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorAplicacionInformacionSprint implements MapeadorAplicacion<DtoSprint, InformacionSprint> {
    private final ServicioObtenerPorcentaje servicioObtenerPorcentaje;
    private final ServicioCalcularDuracionDias servicioCalcularDuracionDias;
    private final ServicioCalcularPorcentaje servicioCalcularPorcentaje;

    public MapeadorAplicacionInformacionSprint(ServicioObtenerPorcentaje servicioObtenerPorcentaje, ServicioCalcularDuracionDias servicioCalcularDuracionDias, ServicioCalcularPorcentaje servicioCalcularPorcentaje) {
        this.servicioObtenerPorcentaje = servicioObtenerPorcentaje;
        this.servicioCalcularDuracionDias = servicioCalcularDuracionDias;
        this.servicioCalcularPorcentaje = servicioCalcularPorcentaje;
    }
    @Override
    public InformacionSprint mapeadorAplicacion(DtoSprint dto) {
        List<Tarea> tarea = new ArrayList<>();
        var duracion = servicioCalcularDuracionDias.calcular(dto.getFechaInicial(),dto.getFechaFinal());
        var porcentajeEsperado = servicioCalcularPorcentaje.obtenerPorcentajeEsperado(dto.getFechaInicial(),duracion);

        return InformacionSprint.of(servicioObtenerPorcentaje.calcularPorcentaje(tarea),
                porcentajeEsperado,Mensaje.POR_DEFECTO_AVANCE);
    }
    public InformacionSprint mapeadorAplicacionDuplicar(LocalDate fechaInicial, LocalDate fechaFinal) {
        List<Tarea> tarea = new ArrayList<>();
        var duracion = servicioCalcularDuracionDias.calcular(fechaInicial,fechaFinal);
        var porcentajeEsperado = servicioCalcularPorcentaje.obtenerPorcentajeEsperado(fechaInicial,duracion);

        return InformacionSprint.of(servicioObtenerPorcentaje.calcularPorcentaje(tarea),
                porcentajeEsperado,Mensaje.POR_DEFECTO_AVANCE);
    }
}
