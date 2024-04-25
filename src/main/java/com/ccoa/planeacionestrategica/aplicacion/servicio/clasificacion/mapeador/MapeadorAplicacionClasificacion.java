package com.ccoa.planeacionestrategica.aplicacion.servicio.clasificacion.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.clasificacion.DtoClasificacion;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.clasificacion.Clasificacion;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionClasificacion implements MapeadorAplicacion<DtoClasificacion, Clasificacion> {
    @Override
    public Clasificacion mapeadorAplicacion(DtoClasificacion dto) {
        return Clasificacion.of(dto.getNombre(), dto.isEstado());
    }
}
