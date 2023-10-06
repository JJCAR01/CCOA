package com.ccoa.planeacionestrategica.infraestructura.clase.area.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.infraestructura.clase.area.adaptador.entidad.EntidadArea;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorArea implements MapeadorInfraestructura<EntidadArea, Area> {

    @Override
    public Area mapeadorDominio(EntidadArea entidad) {
        return new Area(entidad.getIdArea(), entidad.getNombre());
    }
    @Override
    public EntidadArea mapeadorEntidad(Area dominio) {
        return new EntidadArea(dominio.getNombre());
    }

    public void actualizarEntidad(EntidadArea entidad, Area area) {
        entidad.setNombre(area.getNombre());
    }
}
