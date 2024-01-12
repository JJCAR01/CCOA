package com.ccoa.planeacionestrategica.infraestructura.clase.direccion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoDireccionResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.direccion.Direccion;
import com.ccoa.planeacionestrategica.infraestructura.clase.direccion.adaptador.entidad.EntidadDireccion;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class MapeadorDireccion implements MapeadorInfraestructura<EntidadDireccion, Direccion> {
    @Override
    public Direccion mapeadorDominio(EntidadDireccion entidad) {
        return new Direccion(entidad.getNombre());
    }

    @Override
    public EntidadDireccion mapeadorEntidad(Direccion dominio) {
        return new EntidadDireccion(dominio.getNombre());
    }

    public List<DtoDireccionResumen> listarDominio(List<EntidadDireccion> entidades){
        return entidades.stream().map(entidad -> new DtoDireccionResumen(entidad.getIdDireccion() ,entidad.getNombre())).toList();
    }

    public DtoDireccionResumen listarDtoResumen(EntidadDireccion entidad) {
        return new DtoDireccionResumen(entidad.getIdDireccion(), entidad.getNombre());
    }

    public void actualizarEntidad(EntidadDireccion entidad, Direccion  direccion) {
        entidad.setNombre(direccion.getNombre());
    }
}
