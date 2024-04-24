package com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.pat.DetallePat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.entidad.EntidadDetallePat;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorDetallePat implements MapeadorInfraestructura<EntidadDetallePat, DetallePat> {
    @Override
    public DetallePat mapeadorDominio(EntidadDetallePat entidad) {
        return new DetallePat(entidad.isEstrategica(), entidad.isDeProceso());
    }

    @Override
    public EntidadDetallePat mapeadorEntidad(DetallePat dominio) {
        return new EntidadDetallePat(dominio.isEstrategica(), dominio.isDeProceso());
    }
    public void actualizarEntidad(EntidadDetallePat entidad, DetallePat detallePat) {

        entidad.setEstrategica(detallePat.isEstrategica());
        entidad.setDeProceso(detallePat.isDeProceso());
    }
}
