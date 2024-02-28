package com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.documento.DocumentoSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.documento.DocumentoTarea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.entidad.EntidadDocumentoSprintProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.entidad.EntidadDocumentoTarea;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorDocumentoTarea implements MapeadorInfraestructura<EntidadDocumentoTarea, DocumentoTarea> {
    @Override
    public DocumentoTarea mapeadorDominio(EntidadDocumentoTarea entidad) {
        return new DocumentoTarea(entidad.getIdTarea(), entidad.getRutaDocumento(),entidad.getFecha());
    }

    @Override
    public EntidadDocumentoTarea mapeadorEntidad(DocumentoTarea dominio) {
        return new EntidadDocumentoTarea(dominio.getIdTarea(), dominio.getRutaDocumento(), dominio.getFecha());
    }
    public EntidadDocumentoTarea mapeadorEntidadDocumento(DocumentoTarea dominio,Long id) {
        return new EntidadDocumentoTarea(id,dominio.getRutaDocumento(),dominio.getFecha());
    }
    public List<DocumentoTarea> mapeadorListaDocumentos(List<EntidadDocumentoTarea> entidades) {
        List<DocumentoTarea> listaDto = new ArrayList<>();
        for (EntidadDocumentoTarea entidadActual : entidades) {
            DocumentoTarea dto = new DocumentoTarea();
            dto.setIdTarea(entidadActual.getIdTarea());
            dto.setRutaDocumento(entidadActual.getRutaDocumento());
            dto.setFecha(entidadActual.getFecha());

            listaDto.add(dto);
        }
        return listaDto;
    }

}