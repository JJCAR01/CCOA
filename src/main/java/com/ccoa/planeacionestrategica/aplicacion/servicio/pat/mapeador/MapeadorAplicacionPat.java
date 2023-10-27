package com.ccoa.planeacionestrategica.aplicacion.servicio.pat.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoPat;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.Pat;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioObtenerHoraActual;
import org.springframework.stereotype.Component;

@Component
public class MapeadorAplicacionPat implements MapeadorAplicacion<DtoPat, Pat> {
    private final ServicioObtenerHoraActual servicioObtenerHoraActual;

    public MapeadorAplicacionPat(ServicioObtenerHoraActual servicioObtenerHoraActual) {
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
    }

    @Override
    public Pat mapeadorAplicacion(DtoPat dto) {
        return new Pat(dto.getIdPat(), dto.getNombre(), dto.getFechaAnual(), servicioObtenerHoraActual.ejecutar(dto.getFechaRegistro()),
                dto.getPorcentaje(), dto.getProceso(), dto.getIdUsuario());
    }
}
