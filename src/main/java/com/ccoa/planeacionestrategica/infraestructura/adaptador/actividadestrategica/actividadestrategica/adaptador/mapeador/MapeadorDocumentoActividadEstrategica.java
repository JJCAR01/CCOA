package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.documento.DocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadDocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorDocumentoActividadEstrategica implements MapeadorInfraestructura<EntidadDocumentoActividadEstrategica, DocumentoActividadEstrategica> {
    @Override
    public DocumentoActividadEstrategica mapeadorDominio(EntidadDocumentoActividadEstrategica entidad) {
        return new DocumentoActividadEstrategica(entidad.getIdDocumentoActividadEstrategica(), entidad.getRutaDocumento());
    }

    @Override
    public EntidadDocumentoActividadEstrategica mapeadorEntidad(DocumentoActividadEstrategica dominio) {
        return new EntidadDocumentoActividadEstrategica(dominio.getRutaDocumento());
    }
    public EntidadDocumentoActividadEstrategica mapeadorEntidadDocumento(DocumentoActividadEstrategica dominio, Long id) {
        return new EntidadDocumentoActividadEstrategica(id,dominio.getRutaDocumento());
    }
}
