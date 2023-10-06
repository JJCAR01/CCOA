package com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.epica.InformacionEpica;
import com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.entidad.EntidadInformacionEpica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.stereotype.Component;

@Component
public class MapeadorInformacionEpica implements MapeadorInfraestructura<EntidadInformacionEpica, InformacionEpica> {
    @Override
    public InformacionEpica mapeadorDominio(EntidadInformacionEpica entidad) {
        return new InformacionEpica(entidad.getIdInformacionEpica(), entidad.getDuracion(), entidad.getDiasRestantes(),entidad.getEstado(),
                entidad.getAvance());
    }

    @Override
    public EntidadInformacionEpica mapeadorEntidad(InformacionEpica dominio) {
        return new EntidadInformacionEpica(dominio.getDuracion(),dominio.getDiasRestantes(),dominio.getEstado(), dominio.getAvance());
    }
}
