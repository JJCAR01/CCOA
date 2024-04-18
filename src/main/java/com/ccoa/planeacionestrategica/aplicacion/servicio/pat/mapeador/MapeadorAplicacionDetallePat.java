package com.ccoa.planeacionestrategica.aplicacion.servicio.pat.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.pat.DtoPat;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.DetallePat;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionDetallePat implements MapeadorAplicacion<DtoPat, DetallePat> {
    @Override
    public DetallePat mapeadorAplicacion(DtoPat dto) {
        return new DetallePat(dto.isEstrategica(), dto.isDeProceso());
    }
}
