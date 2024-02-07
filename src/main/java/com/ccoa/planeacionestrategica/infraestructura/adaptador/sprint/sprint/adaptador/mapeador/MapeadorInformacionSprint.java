package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.sprint.InformacionSprint;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.entidad.EntidadInformacionSprint;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorInformacionSprint implements MapeadorInfraestructura<EntidadInformacionSprint, InformacionSprint> {
    @Override
    public InformacionSprint mapeadorDominio(EntidadInformacionSprint entidad) {
        return new InformacionSprint(entidad.getPorcentajeReal(), entidad.getPorcentajeEsperado(), entidad.getPorcentajeCumplimiento());
    }

    @Override
    public EntidadInformacionSprint mapeadorEntidad(InformacionSprint dominio) {
        return new EntidadInformacionSprint(dominio.getPorcentajeReal(), dominio.getPorcentajeEsperado(), dominio.getPorcentajeCumplimiento());
    }
}
