package com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.observacion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.observacion.ObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.observacion.adaptador.entidad.EntidadObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorObservacionActividadEstrategica implements MapeadorInfraestructura<EntidadObservacionActividadEstrategica, ObservacionActividadEstrategica> {

    @Override
    public ObservacionActividadEstrategica mapeadorDominio(EntidadObservacionActividadEstrategica entidad) {
        return new ObservacionActividadEstrategica(entidad.getIdObservacionActividadEstrategica(), entidad.getIdActividadEstrategica(), entidad.getFecha(),
                entidad.getNombre());
    }
    @Override
    public EntidadObservacionActividadEstrategica mapeadorEntidad(ObservacionActividadEstrategica dominio) {
        return new EntidadObservacionActividadEstrategica(dominio.getIdActividadEstrategica(), dominio.getFecha(), dominio.getNombre());
    }
    public List<DtoObservacionActividadEstrategica> listarDominio(List<EntidadObservacionActividadEstrategica> entidades){
        List<DtoObservacionActividadEstrategica> listaDto = new ArrayList<>();
        for (EntidadObservacionActividadEstrategica entidad : entidades) {

            DtoObservacionActividadEstrategica dto = new DtoObservacionActividadEstrategica();
            dto.setIdObservacionActividadEstrategica(entidad.getIdObservacionActividadEstrategica());
            dto.setIdActividadEstrategica(entidad.getIdActividadEstrategica());
            dto.setFecha(entidad.getFecha());
            dto.setNombre(entidad.getNombre());

            listaDto.add(dto);
        }
        return listaDto;
    }
}
