package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.observacion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionestrategica.DtoObservacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.observacion.ObservacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.observacion.adaptador.entidad.EntidadObservacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorObservacionActividadGestionEstrategica implements MapeadorInfraestructura<EntidadObservacionActividadGestionEstrategica, ObservacionActividadGestionEstrategica> {

    @Override
    public ObservacionActividadGestionEstrategica mapeadorDominio(EntidadObservacionActividadGestionEstrategica entidad) {
        return new ObservacionActividadGestionEstrategica(entidad.getIdObservacionActividadGestionEstrategica(), entidad.getIdActividadGestionEstrategica(), entidad.getFecha(),
                entidad.getDescripcion());
    }
    @Override
    public EntidadObservacionActividadGestionEstrategica mapeadorEntidad(ObservacionActividadGestionEstrategica dominio) {
        return new EntidadObservacionActividadGestionEstrategica(dominio.getIdActividadGestionEstrategica(), dominio.getFecha(), dominio.getDescripcion());
    }
    public List<DtoObservacionActividadGestionEstrategica> listarDominio(List<EntidadObservacionActividadGestionEstrategica> entidades){
        List<DtoObservacionActividadGestionEstrategica> listaDto = new ArrayList<>();
        for (EntidadObservacionActividadGestionEstrategica entidad : entidades) {

            DtoObservacionActividadGestionEstrategica dto = new DtoObservacionActividadGestionEstrategica();
            dto.setIdObservacionActividadGestionEstrategica(entidad.getIdObservacionActividadGestionEstrategica());
            dto.setIdActividadGestionEstrategica(entidad.getIdActividadGestionEstrategica());
            dto.setFecha(entidad.getFecha());
            dto.setDescripcion(entidad.getDescripcion());

            listaDto.add(dto);
        }
        return listaDto;
    }
    public void actualizarEntidad(EntidadObservacionActividadGestionEstrategica entidad, ObservacionActividadGestionEstrategica observacionActividadGestionEstrategica) {
        entidad.setDescripcion(observacionActividadGestionEstrategica.getDescripcion());
    }
}
