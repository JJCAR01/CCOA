package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.InformacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.adaptador.entidad.EntidadInformacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MapeadorInformacionActividadGestionActividadEstrategica implements MapeadorInfraestructura<EntidadInformacionActividadGestionActividadEstrategica,
        InformacionActividadGestionActividadEstrategica> {

    @Override
    public InformacionActividadGestionActividadEstrategica mapeadorDominio(EntidadInformacionActividadGestionActividadEstrategica entidad) {
        return new InformacionActividadGestionActividadEstrategica(entidad.getIdInformacionActividadActividadEstrategica(), entidad.getFechaRegistro(), entidad.getDuracion(), entidad.getDiasRestantes());
    }

    @Override
    public EntidadInformacionActividadGestionActividadEstrategica mapeadorEntidad(InformacionActividadGestionActividadEstrategica dominio) {
        return new EntidadInformacionActividadGestionActividadEstrategica(dominio.getFechaRegistro(),dominio.getDuracion(),dominio.getDiasRestantes());
    }

}
