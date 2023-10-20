package com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoTarea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.Tarea;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionTarea implements MapeadorAplicacion<DtoTarea, Tarea> {
    @Override
    public Tarea mapeadorAplicacion(DtoTarea dto) {

        return new Tarea(dto.getIdTarea(), dto.getNombre(), dto.getEstado(), dto.getDescripcion(),dto.getTipoASE(), dto.getIdASE(), dto.getIdUsuario());
    }
}
