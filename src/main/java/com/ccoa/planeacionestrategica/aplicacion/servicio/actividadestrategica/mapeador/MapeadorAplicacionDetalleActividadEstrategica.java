package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.DetalleActividadEstrategica;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionDetalleActividadEstrategica implements MapeadorAplicacion<DtoActividadEstrategica, DetalleActividadEstrategica> {
    @Override
    public DetalleActividadEstrategica mapeadorAplicacion(DtoActividadEstrategica dto) {
        return DetalleActividadEstrategica.of(dto.getMeta(),dto.getResultadoMeta(),dto.getPromedioMeta(), dto.getEntregable());
    }
    public DetalleActividadEstrategica mapeadorModificarResultado(DtoActividadEstrategica dto) {
        return DetalleActividadEstrategica.modificarResultado(dto.getMeta(), dto.getResultadoMeta(),dto.getPromedioMeta(),dto.getEntregable());
    }
}
