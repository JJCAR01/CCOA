package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.mapeador.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoObservacionProyecto;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.observacion.ObservacionProyecto;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionObservacionProyecto implements MapeadorAplicacion<DtoObservacionProyecto, ObservacionProyecto> {
    @Override
    public ObservacionProyecto mapeadorAplicacion(DtoObservacionProyecto dto) {
            return new ObservacionProyecto(dto.getIdObservacionProyecto(), dto.getIdProyecto(),dto.getFecha(), dto.getDescripcion());
    }
}
