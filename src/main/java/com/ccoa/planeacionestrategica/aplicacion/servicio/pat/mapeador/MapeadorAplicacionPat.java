package com.ccoa.planeacionestrategica.aplicacion.servicio.pat.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoPat;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.Pat;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioObtenerHoraActual;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionPat implements MapeadorAplicacion<DtoPat, Pat> {
    private final ServicioObtenerHoraActual servicioObtenerHoraActual;

    public MapeadorAplicacionPat(ServicioObtenerHoraActual servicioObtenerHoraActual) {
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
    }

    @Override
    public Pat mapeadorAplicacion(DtoPat dto) {
        return Pat.of(dto.getIdPat(), dto.getNombre(), dto.getFechaAnual(), servicioObtenerHoraActual.calcular(dto.getFechaRegistro()),
                Mensaje.POR_DEFECTO_AVANCE, dto.getProceso(), dto.getIdUsuario());
    }
}
