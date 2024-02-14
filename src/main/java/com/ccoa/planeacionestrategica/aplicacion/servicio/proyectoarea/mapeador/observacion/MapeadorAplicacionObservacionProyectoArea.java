package com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.mapeador.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoObservacionProyecto;
import com.ccoa.planeacionestrategica.aplicacion.dto.proyectoarea.DtoObservacionProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.observacion.ObservacionProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.observacion.ObservacionProyectoArea;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionObservacionProyectoArea implements MapeadorAplicacion<DtoObservacionProyectoArea, ObservacionProyectoArea> {
    @Override
    public ObservacionProyectoArea mapeadorAplicacion(DtoObservacionProyectoArea dto) {
            return new ObservacionProyectoArea(dto.getIdObservacionProyectoArea(), dto.getIdProyectoaArea(),dto.getFecha(), dto.getNombre());
    }
}
