package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.observacion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionactividadestrategica.DtoObservacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.observacion.ObservacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.observacion.adaptador.entidad.EntidadObservacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorObservacionActividadGestionActividadEstrategica implements MapeadorInfraestructura<EntidadObservacionActividadGestionActividadEstrategica, ObservacionActividadGestionActividadEstrategica> {

    @Override
    public ObservacionActividadGestionActividadEstrategica mapeadorDominio(EntidadObservacionActividadGestionActividadEstrategica entidad) {
        return new ObservacionActividadGestionActividadEstrategica(entidad.getIdObservacionActividadGestionActividadEstrategica(), entidad.getIdActividadGestionActividadEstrategica(), entidad.getFecha(),
                entidad.getNombre());
    }
    @Override
    public EntidadObservacionActividadGestionActividadEstrategica mapeadorEntidad(ObservacionActividadGestionActividadEstrategica dominio) {
        return new EntidadObservacionActividadGestionActividadEstrategica(dominio.getIdActividadGestionActividadEstrategica(), dominio.getFecha(), dominio.getNombre());
    }
    public List<DtoObservacionActividadGestionActividadEstrategica> listarDominio(List<EntidadObservacionActividadGestionActividadEstrategica> entidades){
        List<DtoObservacionActividadGestionActividadEstrategica> listaDto = new ArrayList<>();
        for (EntidadObservacionActividadGestionActividadEstrategica entidad : entidades) {

            DtoObservacionActividadGestionActividadEstrategica dto = new DtoObservacionActividadGestionActividadEstrategica();
            dto.setIdObservacionActividadGestionActividadEstrategica(entidad.getIdObservacionActividadGestionActividadEstrategica());
            dto.setIdActividadGestionActividadEstrategica(entidad.getIdActividadGestionActividadEstrategica());
            dto.setFecha(entidad.getFecha());
            dto.setNombre(entidad.getNombre());

            listaDto.add(dto);
        }
        return listaDto;
    }
}
