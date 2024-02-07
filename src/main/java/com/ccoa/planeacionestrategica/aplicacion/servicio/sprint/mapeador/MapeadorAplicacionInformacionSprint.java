package com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoSprint;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.InformacionSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.Tarea;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentajeAvance;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorAplicacionInformacionSprint implements MapeadorAplicacion<DtoSprint, InformacionSprint> {
    private final ServicioObtenerPorcentajeAvance servicioObtenerPorcentajeAvance;

    public MapeadorAplicacionInformacionSprint(ServicioObtenerPorcentajeAvance servicioObtenerPorcentajeAvance) {
        this.servicioObtenerPorcentajeAvance = servicioObtenerPorcentajeAvance;
    }
    @Override
    public InformacionSprint mapeadorAplicacion(DtoSprint dto) {
        List<Tarea> tarea = new ArrayList<>();
        return InformacionSprint.of(servicioObtenerPorcentajeAvance.calcularPorcentaje(tarea), Mensaje.POR_DEFECTO_AVANCE,
                Mensaje.POR_DEFECTO_AVANCE);
    }
}
