package com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.dto.proyectoarea.DtoProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.Proyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.ProyectoArea;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionProyectoArea implements MapeadorAplicacion<DtoProyectoArea, ProyectoArea> {
    @Override
    public ProyectoArea mapeadorAplicacion(DtoProyectoArea dto) {
        return new ProyectoArea(dto.getIdProyectoArea(),dto.getNombre(), dto.getPresupuesto(),dto.getModalidad(),
                dto.getValorEjecutado(), dto.getIdPat(), dto.getIdUsuario());
    }

    public ProyectoArea mapeadorAplicacionValorEjecutado(DtoProyectoArea dto) {
        return ProyectoArea.ofValorEjecutado(dto.getIdProyectoArea(),dto.getNombre(), dto.getPresupuesto(),dto.getModalidad(),
                dto.getValorEjecutado(), dto.getIdPat(), dto.getIdUsuario());
    }

}
