package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.observacion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoObservacionSprint;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprintproyectoarea.DtoObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.observacion.ObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.observacion.adaptador.entidad.EntidadObservacionSprint;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.observacion.adaptador.entidad.EntidadObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorObservacionSprintProyectoArea implements MapeadorInfraestructura<EntidadObservacionSprintProyectoArea, ObservacionSprintProyectoArea> {

    @Override
    public ObservacionSprintProyectoArea mapeadorDominio(EntidadObservacionSprintProyectoArea entidad) {
        return new ObservacionSprintProyectoArea(entidad.getIdObservacionSprintProyectoArea(), entidad.getIdSprintProyectoArea(), entidad.getFecha(),
                entidad.getNombre());
    }
    @Override
    public EntidadObservacionSprintProyectoArea mapeadorEntidad(ObservacionSprintProyectoArea dominio) {
        return new EntidadObservacionSprintProyectoArea(dominio.getIdSprintProyectoArea(), dominio.getFecha(), dominio.getNombre());
    }
    public List<DtoObservacionSprintProyectoArea> listarDominio(List<EntidadObservacionSprintProyectoArea> entidades){
        List<DtoObservacionSprintProyectoArea> listaDto = new ArrayList<>();
        for (EntidadObservacionSprintProyectoArea entidad : entidades) {

            DtoObservacionSprintProyectoArea dto = new DtoObservacionSprintProyectoArea();
            dto.setIdObservacionSprintProyectoArea(entidad.getIdObservacionSprintProyectoArea());
            dto.setIdSprintProyectoArea(entidad.getIdSprintProyectoArea());
            dto.setFecha(entidad.getFecha());
            dto.setNombre(entidad.getNombre());

            listaDto.add(dto);
        }
        return listaDto;
    }
}
