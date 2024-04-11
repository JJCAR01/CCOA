package com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprintproyectoarea.DtoSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.InformacionSprintProyectoArea;
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
public class MapeadorAplicacionInformacionSprintProyectoArea implements MapeadorAplicacion<DtoSprintProyectoArea, InformacionSprintProyectoArea> {
    private final ServicioObtenerPorcentaje servicioObtenerPorcentaje;
    private final ServicioCalcularDuracionDias servicioCalcularDuracionDias;
    private final ServicioCalcularPorcentaje servicioCalcularPorcentaje;

    public MapeadorAplicacionInformacionSprintProyectoArea(ServicioObtenerPorcentaje servicioObtenerPorcentaje, ServicioCalcularDuracionDias servicioCalcularDuracionDias, ServicioCalcularPorcentaje servicioCalcularPorcentaje) {
        this.servicioObtenerPorcentaje = servicioObtenerPorcentaje;
        this.servicioCalcularDuracionDias = servicioCalcularDuracionDias;
        this.servicioCalcularPorcentaje = servicioCalcularPorcentaje;
    }
    @Override
    public InformacionSprintProyectoArea mapeadorAplicacion(DtoSprintProyectoArea dto) {
        List<Tarea> tarea = new ArrayList<>();
        var duracion = servicioCalcularDuracionDias.calcular(dto.getFechaInicial(),dto.getFechaFinal());
        var porcentajeEsperado = servicioCalcularPorcentaje.obtenerPorcentajeEsperado(dto.getFechaInicial(),duracion);

        return InformacionSprintProyectoArea.of(servicioObtenerPorcentaje.calcularPorcentaje(tarea),
                porcentajeEsperado,Mensaje.POR_DEFECTO_AVANCE);
    }
    public InformacionSprintProyectoArea mapeadorAplicacionDuplicar(LocalDate fechaInicial, LocalDate fechaFinal) {
        List<Tarea> tarea = new ArrayList<>();
        var duracion = servicioCalcularDuracionDias.calcular(fechaInicial,fechaFinal);
        var porcentajeEsperado = servicioCalcularPorcentaje.obtenerPorcentajeEsperado(fechaInicial,duracion);

        return InformacionSprintProyectoArea.of(servicioObtenerPorcentaje.calcularPorcentaje(tarea),
                porcentajeEsperado,Mensaje.POR_DEFECTO_AVANCE);
    }
}
