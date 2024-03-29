package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.observacion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoObservacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.observacion.ObservacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.observacion.adaptador.entidad.EntidadObservacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorObservacionActividadGestion implements MapeadorInfraestructura<EntidadObservacionActividadGestion, ObservacionActividadGestion> {

    @Override
    public ObservacionActividadGestion mapeadorDominio(EntidadObservacionActividadGestion entidad) {
        return new ObservacionActividadGestion(entidad.getIdObservacionActividadGestion(), entidad.getIdActividadGestion(), entidad.getFecha(),
                entidad.getDescripcion());
    }
    @Override
    public EntidadObservacionActividadGestion mapeadorEntidad(ObservacionActividadGestion dominio) {
        return new EntidadObservacionActividadGestion(dominio.getIdActividadGestion(), dominio.getFecha(), dominio.getDescripcion());
    }
    public List<DtoObservacionActividadGestion> listarDominio(List<EntidadObservacionActividadGestion> entidades){
        List<DtoObservacionActividadGestion> listaDto = new ArrayList<>();
        for (EntidadObservacionActividadGestion entidad : entidades) {

            DtoObservacionActividadGestion dto = new DtoObservacionActividadGestion();
            dto.setIdObservacionActividadGestion(entidad.getIdObservacionActividadGestion());
            dto.setIdActividadGestion(entidad.getIdActividadGestion());
            dto.setFecha(entidad.getFecha());
            dto.setDescripcion(entidad.getDescripcion());

            listaDto.add(dto);
        }
        return listaDto;
    }
    public void actualizarEntidad(EntidadObservacionActividadGestion entidad, ObservacionActividadGestion observacionActividadGestion) {
        entidad.setDescripcion(observacionActividadGestion.getDescripcion());
    }
}
