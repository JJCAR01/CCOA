package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.documento.DocumentoProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.entidad.EntidadDocumentoProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorDocumentoProyectoArea implements MapeadorInfraestructura<EntidadDocumentoProyectoArea, DocumentoProyectoArea> {
    @Override
    public DocumentoProyectoArea mapeadorDominio(EntidadDocumentoProyectoArea entidad) {
        return new DocumentoProyectoArea(entidad.getIdDocumentoProyectoArea(), entidad.getRutaDocumento());
    }
    @Override
    public EntidadDocumentoProyectoArea mapeadorEntidad(DocumentoProyectoArea dominio) {
        return new EntidadDocumentoProyectoArea(dominio.getRutaDocumento());
    }
    public EntidadDocumentoProyectoArea mapeadorEntidadDocumento(DocumentoProyectoArea dominio, Long id) {
        return new EntidadDocumentoProyectoArea(id,dominio.getRutaDocumento());
    }
}
