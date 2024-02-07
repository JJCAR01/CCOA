package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.actividadgestionactividadestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.InformacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.actividadgestionactividadestrategica.adaptador.entidad.EntidadInformacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorInformacionActividadGestionActividadEstrategica implements MapeadorInfraestructura<EntidadInformacionActividadGestionActividadEstrategica,
        InformacionActividadGestionActividadEstrategica> {

    @Override
    public InformacionActividadGestionActividadEstrategica mapeadorDominio(EntidadInformacionActividadGestionActividadEstrategica entidad) {
        return new InformacionActividadGestionActividadEstrategica(entidad.getDuracion(), entidad.getDiasRestantes(),
                entidad.getPorcentajeReal(),entidad.getPorcentajeEsperado(),entidad.getPorcentajeCumplimiento());
    }

    @Override
    public EntidadInformacionActividadGestionActividadEstrategica mapeadorEntidad(InformacionActividadGestionActividadEstrategica dominio) {
        return new EntidadInformacionActividadGestionActividadEstrategica(dominio.getDuracion(),dominio.getDiasRestantes(),
                dominio.getPorcentajeReal(), dominio.getPorcentajeEsperado(), dominio.getPorcentajeCumplimiento());
    }

}
