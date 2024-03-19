package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.observacion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoObservacionSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.observacion.ObservacionSprint;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.observacion.adaptador.entidad.EntidadObservacionSprint;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorObservacionSprint implements MapeadorInfraestructura<EntidadObservacionSprint, ObservacionSprint> {

    @Override
    public ObservacionSprint mapeadorDominio(EntidadObservacionSprint entidad) {
        return new ObservacionSprint(entidad.getIdObservacionSprint(), entidad.getIdSprint(), entidad.getFecha(),
                entidad.getDescripcion());
    }
    @Override
    public EntidadObservacionSprint mapeadorEntidad(ObservacionSprint dominio) {
        return new EntidadObservacionSprint(dominio.getIdSprint(), dominio.getFecha(), dominio.getDescripcion());
    }
    public List<DtoObservacionSprint> listarDominio(List<EntidadObservacionSprint> entidades){
        List<DtoObservacionSprint> listaDto = new ArrayList<>();
        for (EntidadObservacionSprint entidad : entidades) {

            DtoObservacionSprint dto = new DtoObservacionSprint();
            dto.setIdObservacionSprint(entidad.getIdObservacionSprint());
            dto.setIdSprint(entidad.getIdSprint());
            dto.setFecha(entidad.getFecha());
            dto.setDescripcion(entidad.getDescripcion());

            listaDto.add(dto);
        }
        return listaDto;
    }
    public void actualizarEntidad(EntidadObservacionSprint entidad, ObservacionSprint observacionSprint) {
        entidad.setDescripcion(observacionSprint.getDescripcion());
    }
}
