package com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoSprint;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.Sprint;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.Tarea;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentajeAvance;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorAplicacionSprint implements MapeadorAplicacion<DtoSprint, Sprint> {
    @Override
    public Sprint mapeadorAplicacion(DtoSprint dto) {
        return new Sprint(dto.getIdSprint(), dto.getDescripcion(), dto.getFechaInicial(),dto.getFechaFinal(),dto.getIdProyecto());
    }
}
