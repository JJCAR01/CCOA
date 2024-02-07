package com.ccoa.planeacionestrategica.infraestructura.clase.tarea.observacion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoObservacionTarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.ObservacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.observacion.adaptador.entidad.EntidadObservacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorObservacionTarea implements MapeadorInfraestructura<EntidadObservacionTarea, ObservacionTarea> {
    @Override
    public ObservacionTarea mapeadorDominio(EntidadObservacionTarea entidad) {
        return new ObservacionTarea(entidad.getIdObservacionTarea(), entidad.getIdTarea(), entidad.getFecha(),
                entidad.getNombre());
    }

    @Override
    public EntidadObservacionTarea mapeadorEntidad(ObservacionTarea dominio) {
        return new EntidadObservacionTarea(dominio.getIdTarea(), dominio.getFecha(), dominio.getNombre());
    }
    public List<DtoObservacionTarea> listarDominio(List<EntidadObservacionTarea> entidades){
        List<DtoObservacionTarea> listaDto = new ArrayList<>();
        for (EntidadObservacionTarea entidad : entidades) {

            DtoObservacionTarea dto = new DtoObservacionTarea();
            dto.setIdObservacionTarea(entidad.getIdObservacionTarea());
            dto.setIdTarea(entidad.getIdTarea());
            dto.setFecha(entidad.getFecha());
            dto.setNombre(entidad.getNombre());

            listaDto.add(dto);
        }
        return listaDto;
    }
}
