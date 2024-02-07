package com.ccoa.planeacionestrategica.infraestructura.clase.sprint.observacion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoObservacionSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.ObservacionSprint;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.observacion.adaptador.entidad.EntidadObservacionSprint;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorObservacionSprint implements MapeadorInfraestructura<EntidadObservacionSprint, ObservacionSprint> {

    @Override
    public ObservacionSprint mapeadorDominio(EntidadObservacionSprint entidad) {
        return new ObservacionSprint(entidad.getIdObservacionSprint(), entidad.getIdSprint(), entidad.getFecha(),
                entidad.getNombre());
    }
    @Override
    public EntidadObservacionSprint mapeadorEntidad(ObservacionSprint dominio) {
        return new EntidadObservacionSprint(dominio.getIdSprint(), dominio.getFecha(), dominio.getNombre());
    }
    public List<DtoObservacionSprint> listarDominio(List<EntidadObservacionSprint> entidades){
        List<DtoObservacionSprint> listaDto = new ArrayList<>();
        for (EntidadObservacionSprint entidad : entidades) {

            DtoObservacionSprint dto = new DtoObservacionSprint();
            dto.setIdObservacionSprint(entidad.getIdObservacionSprint());
            dto.setIdSprint(entidad.getIdSprint());
            dto.setFecha(entidad.getFecha());
            dto.setNombre(entidad.getNombre());

            listaDto.add(dto);
        }
        return listaDto;
    }
}
