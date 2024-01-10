package com.ccoa.planeacionestrategica.aplicacion.servicio.proceso.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.proceso.DtoProceso;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.proceso.Proceso;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionProceso implements MapeadorAplicacion<DtoProceso, Proceso> {
    @Override
    public Proceso mapeadorAplicacion(DtoProceso dto) {
        return Proceso.of(dto.getNombre());
    }
}
