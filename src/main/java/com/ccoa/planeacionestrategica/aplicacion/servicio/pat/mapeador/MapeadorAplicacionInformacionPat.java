package com.ccoa.planeacionestrategica.aplicacion.servicio.pat.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.pat.DtoPat;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.InformacionPat;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionInformacionPat implements MapeadorAplicacion<DtoPat, InformacionPat> {
    @Override
    public InformacionPat mapeadorAplicacion(DtoPat dto) {
        return InformacionPat.of(dto.getIdPat(), dto.getDireccion());
    }
}
