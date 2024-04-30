package com.ccoa.planeacionestrategica.aplicacion.servicio.pat.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.pat.DtoPat;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.direccion.Direccion;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.InformacionPat;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioCambiarFecha;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionInformacionPat implements MapeadorAplicacion<DtoPat, InformacionPat> {
    private final ServicioCambiarFecha servicioCambiarFecha;

    public MapeadorAplicacionInformacionPat(ServicioCambiarFecha servicioCambiarFecha) {
        this.servicioCambiarFecha = servicioCambiarFecha;
    }

    @Override
    public InformacionPat mapeadorAplicacion(DtoPat dto) {
        Direccion direccion = Direccion.of(dto.getDireccion().getNombre());
        return InformacionPat.of(direccion, Mensaje.POR_DEFECTO_AVANCE,
                Mensaje.POR_DEFECTO_AVANCE,Mensaje.POR_DEFECTO_AVANCE,
                Mensaje.POR_DEFECTO_AVANCE,dto.getFechaInicial(),dto.getFechaFinal());
    }
    public InformacionPat mapeadorActualizar(DtoPat dto) {
        Direccion direccion = Direccion.of(dto.getDireccion().getNombre());
        var fechaInicial = servicioCambiarFecha.calcular(dto.getFechaInicial(),dto.getFechaAnual());
        var fechaFinal = servicioCambiarFecha.calcular(dto.getFechaFinal(),dto.getFechaAnual());
        return new InformacionPat (direccion, dto.getPorcentajeReal(),
                dto.getPorcentajeEsperado(), dto.getPorcentajeCumplimiento(),
                dto.getPorcentajeKPI(), fechaInicial,fechaFinal);
    }
}
