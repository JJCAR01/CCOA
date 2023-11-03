package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.adaptador;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.Proyecto;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionProyecto implements MapeadorAplicacion<DtoProyecto, Proyecto> {
    @Override
    public Proyecto mapeadorAplicacion(DtoProyecto dto) {
        return Proyecto.of(dto.getIdProyecto(),dto.getNombre(), dto.getPresupuesto(),dto.getModalidad(),
                dto.getValorEjecutado(), dto.getEstado());
    }
}
