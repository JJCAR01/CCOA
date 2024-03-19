package com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.observacion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.pat.DtoObservacionPat;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.observacion.ObservacionPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.observacion.adaptador.entidad.EntidadObservacionPat;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorObservacionPat implements MapeadorInfraestructura<EntidadObservacionPat, ObservacionPat> {

    @Override
    public ObservacionPat mapeadorDominio(EntidadObservacionPat entidad) {
        return new ObservacionPat(entidad.getIdObservacionPat(), entidad.getIdPat(), entidad.getFecha(),
                entidad.getDescripcion());
    }
    @Override
    public EntidadObservacionPat mapeadorEntidad(ObservacionPat dominio) {
        return new EntidadObservacionPat(dominio.getIdPat(), dominio.getFecha(), dominio.getDescripcion());
    }
    public List<DtoObservacionPat> listarDominio(List<EntidadObservacionPat> entidades){
        List<DtoObservacionPat> listaDto = new ArrayList<>();
        for (EntidadObservacionPat entidad : entidades) {

            DtoObservacionPat dto = new DtoObservacionPat();
            dto.setIdObservacionPat(entidad.getIdObservacionPat());
            dto.setIdPat(entidad.getIdPat());
            dto.setFecha(entidad.getFecha());
            dto.setDescripcion(entidad.getDescripcion());

            listaDto.add(dto);
        }
        return listaDto;
    }
    public void actualizarEntidad(EntidadObservacionPat entidad, ObservacionPat observacionPat) {
        entidad.setDescripcion(observacionPat.getDescripcion());
    }
}
