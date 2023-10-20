package com.ccoa.planeacionestrategica.infraestructura.clase.sprint.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.sprint.DocumentoSprint;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.adaptador.entidad.EntidadDocumentoSprint;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorDocumentoSprint implements MapeadorInfraestructura<EntidadDocumentoSprint, DocumentoSprint> {
    @Override
    public DocumentoSprint mapeadorDominio(EntidadDocumentoSprint entidad) {
        return new DocumentoSprint(entidad.getRutaArchivo());
    }

    @Override
    public EntidadDocumentoSprint mapeadorEntidad(DocumentoSprint dominio) {
        return new EntidadDocumentoSprint(dominio.getRutaArchivo());
    }
}
