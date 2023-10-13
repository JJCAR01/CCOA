package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.adaptador;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionInformacionProyecto implements MapeadorAplicacion<DtoProyecto, InformacionProyecto> {
    @Override
    public InformacionProyecto mapeadorAplicacion(DtoProyecto dto) {
        return new InformacionProyecto(dto.getFechaInicial(),dto.getFechaFinal(),dto.getDuracion(),dto.getPlaneacionSprint(),
                dto.getTotalSprint());
    }
}
