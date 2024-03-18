package com.ccoa.planeacionestrategica.aplicacion.servicio.pat.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.pat.DtoObservacionPat;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.observacion.ObservacionPat;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionObservacionPat implements MapeadorAplicacion<DtoObservacionPat, ObservacionPat> {
    @Override
    public ObservacionPat mapeadorAplicacion(DtoObservacionPat dto) {
            return ObservacionPat.of(dto.getIdObservacionPat(), dto.getIdPat(),dto.getFecha(), dto.getDescripcion());
    }
}
