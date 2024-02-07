package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.InformacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.entidad.EntidadInformacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorInformacionActividadGestionEstrategica implements MapeadorInfraestructura<EntidadInformacionActividadGestionEstrategica,
        InformacionActividadGestionEstrategica> {

    @Override
    public InformacionActividadGestionEstrategica mapeadorDominio(EntidadInformacionActividadGestionEstrategica entidad) {
        return new InformacionActividadGestionEstrategica(entidad.getDuracion(), entidad.getDiasRestantes(),
                entidad.getPorcentajeReal(),entidad.getPorcentajeEsperado(),entidad.getPorcentajeCumplimiento());
    }

    @Override
    public EntidadInformacionActividadGestionEstrategica mapeadorEntidad(InformacionActividadGestionEstrategica dominio) {
        return new EntidadInformacionActividadGestionEstrategica(dominio.getDuracion(),dominio.getDiasRestantes(),
                dominio.getPorcentajeReal(), dominio.getPorcentajeEsperado(), dominio.getPorcentajeCumplimiento());
    }

}
