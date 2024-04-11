package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.DetalleActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.EPeriodicidadMeta;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.EUnidad;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularPorcentaje;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionDetalleActividadEstrategica implements MapeadorAplicacion<DtoActividadEstrategica, DetalleActividadEstrategica> {
    private final ServicioCalcularPorcentaje servicioCalcularPorcentaje;

    public MapeadorAplicacionDetalleActividadEstrategica(ServicioCalcularPorcentaje servicioCalcularPorcentaje) {
        this.servicioCalcularPorcentaje = servicioCalcularPorcentaje;
    }

    @Override
    public DetalleActividadEstrategica mapeadorAplicacion(DtoActividadEstrategica dto) {
        return DetalleActividadEstrategica.of(dto.getUnidad(),dto.getMeta(),dto.getPeriodicidadMeta(),dto.getResultadoMeta(),
                Mensaje.PORCENTAJE_CERO, dto.getEntregable());
    }
    public DetalleActividadEstrategica mapeadorAplicacionDuplicar() {
        return new DetalleActividadEstrategica(EUnidad.PORCENTAJE,Mensaje.PORCENTAJE_CERO, EPeriodicidadMeta.ANUAL,Mensaje.PORCENTAJE_CERO,
                Mensaje.PORCENTAJE_CERO, Mensaje.VACIO);
    }
    public DetalleActividadEstrategica mapeadorModificarResultadoMeta(DtoActividadEstrategica dto) {
        return DetalleActividadEstrategica.modificarResultadoMeta(dto.getUnidad(),dto.getMeta(), dto.getPeriodicidadMeta(),
                dto.getResultadoMeta(),
                servicioCalcularPorcentaje.calcularPorcentajeMeta(dto.getMeta(), dto.getResultadoMeta()),dto.getEntregable());
    }
}
