package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.observacion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoObservacionProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.observacion.ObservacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.observacion.adaptador.entidad.EntidadObservacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorObservacionProyecto implements MapeadorInfraestructura<EntidadObservacionProyecto, ObservacionProyecto> {

    @Override
    public ObservacionProyecto mapeadorDominio(EntidadObservacionProyecto entidad) {
        return new ObservacionProyecto(entidad.getIdObservacionProyecto(), entidad.getIdProyecto(), entidad.getFecha(),
                entidad.getDescripcion());
    }
    @Override
    public EntidadObservacionProyecto mapeadorEntidad(ObservacionProyecto dominio) {
        return new EntidadObservacionProyecto(dominio.getIdProyecto(), dominio.getFecha(), dominio.getDescripcion());
    }
    public List<DtoObservacionProyecto> listarDominio(List<EntidadObservacionProyecto> entidades){
        List<DtoObservacionProyecto> listaDto = new ArrayList<>();
        for (EntidadObservacionProyecto entidad : entidades) {

            DtoObservacionProyecto dto = new DtoObservacionProyecto();
            dto.setIdObservacionProyecto(entidad.getIdObservacionProyecto());
            dto.setIdProyecto(entidad.getIdProyecto());
            dto.setFecha(entidad.getFecha());
            dto.setDescripcion(entidad.getDescripcion());

            listaDto.add(dto);
        }
        return listaDto;
    }
}
