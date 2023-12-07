package com.ccoa.planeacionestrategica.infraestructura.clase.area.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.area.Area;
import com.ccoa.planeacionestrategica.infraestructura.clase.area.adaptador.entidad.EntidadArea;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MapeadorArea implements MapeadorInfraestructura<EntidadArea, Area> {

    @Override
    public Area mapeadorDominio(EntidadArea entidad) {
        return new Area(entidad.getIdArea(), entidad.getNombre(), entidad.getDireccion());
    }
    @Override
    public EntidadArea mapeadorEntidad(Area dominio) {
        return new EntidadArea(dominio.getNombre(),dominio.getDireccion());
    }

    public void actualizarEntidad(EntidadArea entidad, Area area) {
        entidad.setNombre(area.getNombre());
    }

    public List<Area> listarDominio(List<EntidadArea> entidades){
        return entidades.stream().map(entidad -> new Area(entidad.getIdArea(), entidad.getNombre(), entidad.getDireccion())).toList();
    }
}
