package com.ccoa.planeacionestrategica.infraestructura.clase.actividad.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.actividad.InformacionActividad;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividad.adaptador.entidad.EntidadInformacionActividad;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorInformacionActividad implements MapeadorInfraestructura<EntidadInformacionActividad, InformacionActividad> {


    @Override
    public InformacionActividad mapeadorDominio(EntidadInformacionActividad entidad) {
        return new InformacionActividad(entidad.getIdInformacionActividad(), entidad.getDuracion(),entidad.getDiasRestantes(),
                entidad.getAvance(), entidad.getIdEpica(), entidad.getIdGestion());
    }

    @Override
    public EntidadInformacionActividad mapeadorEntidad(InformacionActividad dominio) {
        return new EntidadInformacionActividad(dominio.getDuracion(),dominio.getDiasRestantes(),dominio.getAvance(),
                dominio.getIdEpica(), dominio.getIdGestion());
    }
}
