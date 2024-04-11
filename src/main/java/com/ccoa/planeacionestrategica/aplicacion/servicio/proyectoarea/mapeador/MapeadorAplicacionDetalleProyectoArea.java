package com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyectoarea.DtoProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.DetalleProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDuracionDias;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularPorcentaje;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class MapeadorAplicacionDetalleProyectoArea implements MapeadorAplicacion<DtoProyectoArea, DetalleProyectoArea> {
    private final ServicioCalcularDuracionDias servicioCalcularDuracionDias;
    private final ServicioCalcularPorcentaje servicioCalcularPorcentaje;

    public MapeadorAplicacionDetalleProyectoArea(ServicioCalcularDuracionDias servicioCalcularDuracionDias, ServicioCalcularPorcentaje servicioCalcularPorcentaje) {
        this.servicioCalcularDuracionDias = servicioCalcularDuracionDias;
        this.servicioCalcularPorcentaje = servicioCalcularPorcentaje;
    }
    @Override
    public DetalleProyectoArea mapeadorAplicacion(DtoProyectoArea dto) {
        var duracion = servicioCalcularDuracionDias.calcular(dto.getFechaInicial(),dto.getFechaFinal());
        var porcentajeEsperado = servicioCalcularPorcentaje.obtenerPorcentajeEsperado(dto.getFechaInicial(),duracion);

        return DetalleProyectoArea.of(duracion , Mensaje.POR_DEFECTO_AVANCE, porcentajeEsperado,Mensaje.POR_DEFECTO_AVANCE);
    }
    public DetalleProyectoArea mapeadorAplicacionDuplicar(LocalDate fechaInicial, LocalDate fechaFinal) {
        var duracion = servicioCalcularDuracionDias.calcular(fechaInicial,fechaFinal);
        var porcentajeEsperado = servicioCalcularPorcentaje.obtenerPorcentajeEsperado(fechaInicial,duracion);

        return DetalleProyectoArea.of(duracion, Mensaje.POR_DEFECTO_AVANCE, porcentajeEsperado,Mensaje.POR_DEFECTO_AVANCE);
    }
}
