package com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.observacion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoObservacionTarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.ObservacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.observacion.adaptador.entidad.EntidadObservacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorObservacionTarea implements MapeadorInfraestructura<EntidadObservacionTarea, ObservacionTarea> {
    @Override
    public ObservacionTarea mapeadorDominio(EntidadObservacionTarea entidad) {
        return new ObservacionTarea(entidad.getIdObservacionTarea(), entidad.getIdTarea(), entidad.getFecha(),
                entidad.getDescripcion());
    }

    @Override
    public EntidadObservacionTarea mapeadorEntidad(ObservacionTarea dominio) {
        return new EntidadObservacionTarea(dominio.getIdTarea(), dominio.getFecha(), dominio.getDescripcion());
    }
    public List<DtoObservacionTarea> listarDominio(List<EntidadObservacionTarea> entidades){
        List<DtoObservacionTarea> listaDto = new ArrayList<>();
        for (EntidadObservacionTarea entidad : entidades) {

            DtoObservacionTarea dto = new DtoObservacionTarea();
            dto.setIdObservacionTarea(entidad.getIdObservacionTarea());
            dto.setIdTarea(entidad.getIdTarea());
            dto.setFecha(entidad.getFecha());
            dto.setDescripcion(entidad.getDescripcion());

            listaDto.add(dto);
        }
        return listaDto;
    }
    public void actualizarEntidad(EntidadObservacionTarea entidad, ObservacionTarea observacionTarea) {
        entidad.setDescripcion(observacionTarea.getDescripcion());
    }
}
