package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.documento.DocumentoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.entidad.EntidadDocumentoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorDocumentoActividadGestionEstrategica implements MapeadorInfraestructura<EntidadDocumentoActividadGestionEstrategica,
        DocumentoActividadGestionEstrategica> {
    @Override
    public DocumentoActividadGestionEstrategica mapeadorDominio(EntidadDocumentoActividadGestionEstrategica entidad) {
        return new DocumentoActividadGestionEstrategica(entidad.getIdDocumentoActividadGestionEstrategica(),
                entidad.getRutaDocumento());
    }
    @Override
    public EntidadDocumentoActividadGestionEstrategica mapeadorEntidad(DocumentoActividadGestionEstrategica dominio) {
        return new EntidadDocumentoActividadGestionEstrategica(dominio.getRutaDocumento());
    }
    public EntidadDocumentoActividadGestionEstrategica mapeadorEntidadDocumento(DocumentoActividadGestionEstrategica dominio, Long id) {
        return new EntidadDocumentoActividadGestionEstrategica(id,dominio.getRutaDocumento());
    }
}
