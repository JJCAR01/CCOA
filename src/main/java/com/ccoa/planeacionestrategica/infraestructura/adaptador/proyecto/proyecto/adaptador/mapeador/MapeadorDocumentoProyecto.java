package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.documento.DocumentoProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.entidad.EntidadDocumentoProyecto;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorDocumentoProyecto implements MapeadorInfraestructura<EntidadDocumentoProyecto, DocumentoProyecto> {
    @Override
    public DocumentoProyecto mapeadorDominio(EntidadDocumentoProyecto entidad) {
        return new DocumentoProyecto(entidad.getIdDocumentoProyecto(), entidad.getRutaDocumento());
    }
    @Override
    public EntidadDocumentoProyecto mapeadorEntidad(DocumentoProyecto dominio) {
        return new EntidadDocumentoProyecto(dominio.getRutaDocumento());
    }
    public EntidadDocumentoProyecto mapeadorEntidadDocumento(DocumentoProyecto dominio, Long id) {
        return new EntidadDocumentoProyecto(id,dominio.getRutaDocumento());
    }
}
