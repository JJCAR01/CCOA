package com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad.EntidadInformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorInformacionProyecto implements MapeadorInfraestructura<EntidadInformacionProyecto, InformacionProyecto> {
    @Override
    public InformacionProyecto mapeadorDominio(EntidadInformacionProyecto entidad) {
        return new InformacionProyecto(entidad.getFechaInicial(),entidad.getFechaFinal(),entidad.getDuracion(),entidad.getPlaneacionSprint(),
                entidad.getTotalSprint());
    }

    @Override
    public EntidadInformacionProyecto mapeadorEntidad(InformacionProyecto dominio) {
        return new EntidadInformacionProyecto(dominio.getFechaInicial(),dominio.getFechaFinal(),dominio.getDuracion(),dominio.getPlaneacionSprint(),
                dominio.getTotalSprint());
    }
}
