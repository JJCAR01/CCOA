package com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyectoarea.DtoProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.DetalleProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDuracionDias;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularPorcentaje;
import org.springframework.context.annotation.Configuration;

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
        return DetalleProyectoArea.of(servicioCalcularDuracionDias.calcular(dto.getFechaInicial(),dto.getFechaFinal()) , Mensaje.POR_DEFECTO_AVANCE,
                servicioCalcularPorcentaje.obtenerPorcentajeEsperado(dto.getFechaInicial(),servicioCalcularDuracionDias.calcular(dto.getFechaInicial(),dto.getFechaFinal())),
                Mensaje.POR_DEFECTO_AVANCE);
    }
}
