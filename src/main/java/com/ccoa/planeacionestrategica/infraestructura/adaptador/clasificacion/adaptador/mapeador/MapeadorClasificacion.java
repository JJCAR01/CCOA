package com.ccoa.planeacionestrategica.infraestructura.adaptador.clasificacion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoClasificacionResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.clasificacion.Clasificacion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.clasificacion.adaptador.entidad.EntidadClasificacion;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MapeadorClasificacion implements MapeadorInfraestructura<EntidadClasificacion, Clasificacion> {
    @Override
    public Clasificacion mapeadorDominio(EntidadClasificacion entidad) {
        return new Clasificacion(entidad.getNombre(),entidad.isEstado());
    }

    @Override
    public EntidadClasificacion mapeadorEntidad(Clasificacion dominio) {
        return new EntidadClasificacion(dominio.getNombre(), dominio.isEstado());
    }

    public List<DtoClasificacionResumen> listarDominio(List<EntidadClasificacion> entidades){
        return entidades.stream().map(entidad -> new DtoClasificacionResumen(entidad.getIdClasificacion() ,entidad.getNombre(),entidad.isEstado())).toList();
    }

    public DtoClasificacionResumen listarDtoResumen(EntidadClasificacion entidad) {
        return new DtoClasificacionResumen(entidad.getIdClasificacion(), entidad.getNombre(),entidad.isEstado());
    }

    public void actualizarEntidad(EntidadClasificacion entidad, Clasificacion  clasificacion) {
        entidad.setNombre(clasificacion.getNombre());
        entidad.setEstado(clasificacion.isEstado());
    }
}
