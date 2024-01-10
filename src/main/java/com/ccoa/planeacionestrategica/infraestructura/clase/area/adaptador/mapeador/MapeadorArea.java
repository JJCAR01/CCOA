package com.ccoa.planeacionestrategica.infraestructura.clase.area.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.area.Area;
import com.ccoa.planeacionestrategica.infraestructura.clase.area.adaptador.entidad.EntidadArea;
import com.ccoa.planeacionestrategica.infraestructura.clase.direccion.adaptador.repositorio.jpa.RepositorioDireccionJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MapeadorArea implements MapeadorInfraestructura<EntidadArea, Area> {
    private final RepositorioDireccionJpa repositorioDireccionJpa;

    public MapeadorArea(RepositorioDireccionJpa repositorioDireccionJpa) {
        this.repositorioDireccionJpa = repositorioDireccionJpa;
    }


    @Override
    public Area mapeadorDominio(EntidadArea entidad) {
        return new Area(entidad.getIdArea(), entidad.getNombre(), entidad.getIdDireccion());
    }
    @Override
    public EntidadArea mapeadorEntidad(Area dominio) {
        var idDireccion = this.repositorioDireccionJpa.findById(dominio.getIdDireccion()).orElseThrow().getIdDireccion();
        return new EntidadArea(dominio.getNombre(),idDireccion);
    }

    public void actualizarEntidad(EntidadArea entidad, Area area) {
        entidad.setNombre(area.getNombre());
        entidad.setIdDireccion(area.getIdDireccion());
    }

    public List<Area> listarDominio(List<EntidadArea> entidades){
        return entidades.stream().map(entidad -> new Area(entidad.getIdArea(), entidad.getNombre(), entidad.getIdDireccion())).toList();
    }
}
