package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.DetalleActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadDetalleActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.stereotype.Component;

@Component
public class MapeadorDetalleActividadEstrategica implements MapeadorInfraestructura<EntidadDetalleActividadEstrategica, DetalleActividadEstrategica> {
    @Override
    public DetalleActividadEstrategica mapeadorDominio(EntidadDetalleActividadEstrategica entidad) {
        return new DetalleActividadEstrategica(entidad.getMeta(),entidad.getResultadoMeta(), entidad.getPromedioMeta(),entidad.getEntregable());
    }

    @Override
    public EntidadDetalleActividadEstrategica mapeadorEntidad(DetalleActividadEstrategica dominio) {
        return new EntidadDetalleActividadEstrategica(dominio.getMeta(), dominio.getResultadoMeta(), dominio.getPorcentajeMeta(),
                dominio.getEntregable());
    }
    public void actualizarResultado(EntidadDetalleActividadEstrategica entidadDetalleActividadEstrategica,
                                    DetalleActividadEstrategica detalleActividadEstrategica) {
        entidadDetalleActividadEstrategica.setEntregable(detalleActividadEstrategica.getEntregable());
    }
}
