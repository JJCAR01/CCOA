package com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.pat.InformacionPat;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad.EntidadInformacionPat;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorInformacionPat implements MapeadorInfraestructura<EntidadInformacionPat, InformacionPat> {
    @Override
    public InformacionPat mapeadorDominio(EntidadInformacionPat entidad) {
        return new InformacionPat(entidad.getIdInformacionPat(), entidad.getDireccion());
    }

    @Override
    public EntidadInformacionPat mapeadorEntidad(InformacionPat dominio) {
        return new EntidadInformacionPat(dominio.getDireccion());
    }
}
