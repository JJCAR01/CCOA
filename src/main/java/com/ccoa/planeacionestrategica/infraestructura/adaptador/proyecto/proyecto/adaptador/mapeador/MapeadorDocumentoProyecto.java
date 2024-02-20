package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.documento.DocumentoProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.entidad.EntidadDocumentoProyecto;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorDocumentoProyecto implements MapeadorInfraestructura<EntidadDocumentoProyecto, DocumentoProyecto> {
    @Override
    public DocumentoProyecto mapeadorDominio(EntidadDocumentoProyecto entidad) {
        return new DocumentoProyecto(entidad.getIdProyecto(), entidad.getRutaDocumento(),entidad.getFecha());
    }
    @Override
    public EntidadDocumentoProyecto mapeadorEntidad(DocumentoProyecto dominio) {
        return new EntidadDocumentoProyecto(dominio.getIdProyecto(),dominio.getRutaDocumento(),dominio.getFecha());
    }
    public EntidadDocumentoProyecto mapeadorEntidadDocumento(DocumentoProyecto dominio, Long id) {
        return new EntidadDocumentoProyecto(id,dominio.getRutaDocumento(),dominio.getFecha());
    }
    public List<DocumentoProyecto> mapeadorListaDocumentos(List<EntidadDocumentoProyecto> entidades) {
        List<DocumentoProyecto> listaDto = new ArrayList<>();
        for (EntidadDocumentoProyecto entidadActual : entidades) {
            DocumentoProyecto dto = new DocumentoProyecto();
            dto.setIdProyecto(entidadActual.getIdProyecto());
            dto.setRutaDocumento(entidadActual.getRutaDocumento());
            dto.setFecha(entidadActual.getFecha());

            listaDto.add(dto);
        }
        return listaDto;
    }
}
