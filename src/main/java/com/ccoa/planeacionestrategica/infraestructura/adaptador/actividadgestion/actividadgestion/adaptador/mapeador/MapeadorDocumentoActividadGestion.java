package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.documento.DocumentoActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.entidad.EntidadDocumentoActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorDocumentoActividadGestion implements MapeadorInfraestructura<EntidadDocumentoActividadGestion, DocumentoActividadGestion> {
    @Override
    public DocumentoActividadGestion mapeadorDominio(EntidadDocumentoActividadGestion entidad) {
        return new DocumentoActividadGestion(entidad.getIdDocumentoActividadGestion(), entidad.getRutaDocumento());
    }

    @Override
    public EntidadDocumentoActividadGestion mapeadorEntidad(DocumentoActividadGestion dominio) {
        return new EntidadDocumentoActividadGestion(dominio.getRutaDocumento());
    }
    public EntidadDocumentoActividadGestion mapeadorEntidadDocumento(DocumentoActividadGestion dominio, Long id) {
        return new EntidadDocumentoActividadGestion(id,dominio.getRutaDocumento());
    }
}
