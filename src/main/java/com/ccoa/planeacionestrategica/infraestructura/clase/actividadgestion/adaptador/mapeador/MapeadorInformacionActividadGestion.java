package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.InformacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.entidad.EntidadInformacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorInformacionActividadGestion implements MapeadorInfraestructura<EntidadInformacionActividadGestion, InformacionActividadGestion> {
    @Override
    public InformacionActividadGestion mapeadorDominio(EntidadInformacionActividadGestion entidad) {
        return new InformacionActividadGestion(entidad.getFechaRegistro(), entidad.getDuracion(), entidad.getDiasRestantes(),entidad.getAvance());
    }

    @Override
    public EntidadInformacionActividadGestion mapeadorEntidad(InformacionActividadGestion dominio) {
        return new EntidadInformacionActividadGestion(dominio.getFechaRegistro(),dominio.getDuracion(),dominio.getDiasRestantes(),dominio.getAvance());
    }
}
