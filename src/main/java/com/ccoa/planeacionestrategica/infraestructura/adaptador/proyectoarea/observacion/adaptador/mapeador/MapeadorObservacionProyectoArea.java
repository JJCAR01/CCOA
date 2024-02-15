package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.observacion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyectoarea.DtoObservacionProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.observacion.ObservacionProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.observacion.adaptador.entidad.EntidadObservacionProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorObservacionProyectoArea implements MapeadorInfraestructura<EntidadObservacionProyectoArea, ObservacionProyectoArea> {

    @Override
    public ObservacionProyectoArea mapeadorDominio(EntidadObservacionProyectoArea entidad) {
        return new ObservacionProyectoArea(entidad.getIdObservacionProyectoArea(), entidad.getIdProyectoArea(), entidad.getFecha(),
                entidad.getNombre());
    }
    @Override
    public EntidadObservacionProyectoArea mapeadorEntidad(ObservacionProyectoArea dominio) {
        return new EntidadObservacionProyectoArea(dominio.getIdProyectoArea(), dominio.getFecha(), dominio.getNombre());
    }
    public List<DtoObservacionProyectoArea> listarDominio(List<EntidadObservacionProyectoArea> entidades){
        List<DtoObservacionProyectoArea> listaDto = new ArrayList<>();
        for (EntidadObservacionProyectoArea entidad : entidades) {

            DtoObservacionProyectoArea dto = new DtoObservacionProyectoArea();
            dto.setIdObservacionProyectoArea(entidad.getIdObservacionProyectoArea());
            dto.setIdProyectoArea(entidad.getIdProyectoArea());
            dto.setFecha(entidad.getFecha());
            dto.setNombre(entidad.getNombre());

            listaDto.add(dto);
        }
        return listaDto;
    }


}
