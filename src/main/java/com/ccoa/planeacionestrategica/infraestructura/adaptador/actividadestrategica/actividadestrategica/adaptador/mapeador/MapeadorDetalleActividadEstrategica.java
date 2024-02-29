package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.DetalleActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadDetalleActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioDetalleActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularPorcentaje;
import org.springframework.stereotype.Component;

@Component
public class MapeadorDetalleActividadEstrategica implements MapeadorInfraestructura<EntidadDetalleActividadEstrategica, DetalleActividadEstrategica> {
    private final ServicioCalcularPorcentaje servicioCalcularPorcentaje;
    private final RepositorioDetalleActividadEstrategicaJpa repositorioDetalleActividadEstrategicaJpa;

    public MapeadorDetalleActividadEstrategica(ServicioCalcularPorcentaje servicioCalcularPorcentaje, RepositorioDetalleActividadEstrategicaJpa repositorioDetalleActividadEstrategicaJpa) {
        this.servicioCalcularPorcentaje = servicioCalcularPorcentaje;
        this.repositorioDetalleActividadEstrategicaJpa = repositorioDetalleActividadEstrategicaJpa;
    }

    @Override
    public DetalleActividadEstrategica mapeadorDominio(EntidadDetalleActividadEstrategica entidad) {
        return new DetalleActividadEstrategica(entidad.getUnidad(), entidad.getMeta(), entidad.getPeriodicidadMeta(), entidad.getResultadoMeta(), entidad.getPorcentajeMeta(),entidad.getEntregable());
    }

    @Override
    public EntidadDetalleActividadEstrategica mapeadorEntidad(DetalleActividadEstrategica dominio) {
        return new EntidadDetalleActividadEstrategica(dominio.getUnidad(), dominio.getMeta(),dominio.getPeriodicidadMeta(),
                dominio.getResultadoMeta(), dominio.getPorcentajeMeta(),
                dominio.getEntregable());
    }
    public void actualizarResultadoMeta(EntidadDetalleActividadEstrategica entidadDetalleActividadEstrategica,
                                        DetalleActividadEstrategica detalleActividadEstrategica,
                                        EntidadInformacionActividadEstrategica entidadInformacionActividadEstrategica) {
        entidadDetalleActividadEstrategica.setResultadoMeta(detalleActividadEstrategica.getResultadoMeta());
        entidadDetalleActividadEstrategica.setPorcentajeMeta(
                servicioCalcularPorcentaje.calcularPorcentajeMeta(detalleActividadEstrategica.getMeta(), detalleActividadEstrategica.getResultadoMeta()));
        entidadInformacionActividadEstrategica.setPorcentajePat(
                servicioCalcularPorcentaje.obtenerPorcentajePat(entidadInformacionActividadEstrategica.getPorcentajeCumplimiento(),
                        detalleActividadEstrategica.getPorcentajeMeta()));

    }

    public EntidadDetalleActividadEstrategica obtenerDetalleActividadEstrategicaRelacionadoConActividadEstrategica(Long id){
        return this.repositorioDetalleActividadEstrategicaJpa.findById(id).orElseThrow();
    }
}
