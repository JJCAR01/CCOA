package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.sprint.documento.DocumentoSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.documento.DocumentoSprintProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.entidad.EntidadDocumentoSprint;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.entidad.EntidadDocumentoSprintProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorDocumentoSprintProyectoArea implements MapeadorInfraestructura<EntidadDocumentoSprintProyectoArea, DocumentoSprintProyectoArea> {
    @Override
    public DocumentoSprintProyectoArea mapeadorDominio(EntidadDocumentoSprintProyectoArea entidad) {
        return new DocumentoSprintProyectoArea(entidad.getIdDocumentoSprintProyectoArea(), entidad.getRutaArchivo());
    }

    @Override
    public EntidadDocumentoSprintProyectoArea mapeadorEntidad(DocumentoSprintProyectoArea dominio) {
        return new EntidadDocumentoSprintProyectoArea(dominio.getRutaArchivo());
    }
    public EntidadDocumentoSprintProyectoArea mapeadorEntidadDocumento(DocumentoSprintProyectoArea dominio,Long id) {
        return new EntidadDocumentoSprintProyectoArea(id,dominio.getRutaArchivo());
    }

}
