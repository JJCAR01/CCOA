package com.ccoa.planeacionestrategica.infraestructura.clase.direccion.adaptador.mapeador;

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

    public List<Direccion> listarDominio(List<EntidadDireccion> entidades){
        return entidades.stream().map(entidad -> new Direccion( entidad.getNombre())).toList();
    }

    public void actualizarEntidad(EntidadDireccion entidad, Direccion  direccion) {
        entidad.setNombre(direccion.getNombre());
    }
}
