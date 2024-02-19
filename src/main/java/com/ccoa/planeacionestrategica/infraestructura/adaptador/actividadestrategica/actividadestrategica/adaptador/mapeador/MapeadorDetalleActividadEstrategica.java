package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.DetalleActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadDetalleActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularPorcentaje;
import org.springframework.stereotype.Component;

@Component
public class MapeadorDetalleActividadEstrategica implements MapeadorInfraestructura<EntidadDetalleActividadEstrategica, DetalleActividadEstrategica> {
    private final ServicioCalcularPorcentaje servicioCalcularPorcentaje;

    public MapeadorDetalleActividadEstrategica(ServicioCalcularPorcentaje servicioCalcularPorcentaje) {
        this.servicioCalcularPorcentaje = servicioCalcularPorcentaje;
    }

    @Override
    public DetalleActividadEstrategica mapeadorDominio(EntidadDetalleActividadEstrategica entidad) {
        return new DetalleActividadEstrategica(entidad.getMeta(),entidad.getResultadoMeta(), entidad.getPromedioMeta(),entidad.getEntregable());
    }

    @Override
    public EntidadDetalleActividadEstrategica mapeadorEntidad(DetalleActividadEstrategica dominio) {
        return new EntidadDetalleActividadEstrategica(dominio.getMeta(), dominio.getResultadoMeta(), dominio.getPorcentajeMeta(),
                dominio.getEntregable());
    }
    public void actualizarEntregbale(EntidadDetalleActividadEstrategica entidadDetalleActividadEstrategica,
                                    DetalleActividadEstrategica detalleActividadEstrategica) {
        entidadDetalleActividadEstrategica.setEntregable(detalleActividadEstrategica.getEntregable());
    }
    public void actualizarResultadoMeta(EntidadDetalleActividadEstrategica entidadDetalleActividadEstrategica,
                                    DetalleActividadEstrategica detalleActividadEstrategica) {
        entidadDetalleActividadEstrategica.setResultadoMeta(detalleActividadEstrategica.getResultadoMeta());
        entidadDetalleActividadEstrategica.setPromedioMeta(
                servicioCalcularPorcentaje.calcularPorcentajeMeta(detalleActividadEstrategica.getMeta(), detalleActividadEstrategica.getResultadoMeta()));
    }
}
