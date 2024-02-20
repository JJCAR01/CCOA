package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.DetalleActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.InformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadDetalleActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadInformacionActividadEstrategica;
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
        return new DetalleActividadEstrategica(entidad.getUnidad(), entidad.getMeta(), entidad.getPeriodicidadMeta(), entidad.getResultadoMeta(), entidad.getPorcentajeMeta(),entidad.getEntregable());
    }

    @Override
    public EntidadDetalleActividadEstrategica mapeadorEntidad(DetalleActividadEstrategica dominio) {
        return new EntidadDetalleActividadEstrategica(dominio.getUnidad(), dominio.getMeta(),dominio.getPeriodicidadMeta(), dominio.getResultadoMeta(), dominio.getPorcentajeMeta(),
                dominio.getEntregable());
    }
    public void actualizarEntregbale(EntidadDetalleActividadEstrategica entidadDetalleActividadEstrategica,
                                    DetalleActividadEstrategica detalleActividadEstrategica) {
        entidadDetalleActividadEstrategica.setEntregable(detalleActividadEstrategica.getEntregable());
    }
    public void actualizarResultadoMeta(EntidadDetalleActividadEstrategica entidadDetalleActividadEstrategica,
                                        DetalleActividadEstrategica detalleActividadEstrategica,
                                        EntidadInformacionActividadEstrategica entidadInformacionActividadEstrategica,
                                        InformacionActividadEstrategica informacionActividadEstrategica) {
        entidadDetalleActividadEstrategica.setResultadoMeta(detalleActividadEstrategica.getResultadoMeta());
        entidadDetalleActividadEstrategica.setPorcentajeMeta(
                servicioCalcularPorcentaje.calcularPorcentajeMeta(detalleActividadEstrategica.getMeta(), detalleActividadEstrategica.getResultadoMeta()));
        entidadInformacionActividadEstrategica.setPorcentajePat(
                servicioCalcularPorcentaje.obtenerPorcentajePat(informacionActividadEstrategica.getPorcentajeCumplimiento(),
                        detalleActividadEstrategica.getPorcentajeMeta()));



    }
}
