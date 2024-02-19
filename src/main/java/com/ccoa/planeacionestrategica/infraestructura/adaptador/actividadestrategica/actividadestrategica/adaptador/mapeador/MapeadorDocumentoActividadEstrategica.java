package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.documento.DocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadDocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorDocumentoActividadEstrategica implements MapeadorInfraestructura<EntidadDocumentoActividadEstrategica, DocumentoActividadEstrategica> {
    @Override
    public DocumentoActividadEstrategica mapeadorDominio(EntidadDocumentoActividadEstrategica entidad) {
        return new DocumentoActividadEstrategica(entidad.getIdActividadEstrategica(),entidad.getRutaDocumento());
    }

    @Override
    public EntidadDocumentoActividadEstrategica mapeadorEntidad(DocumentoActividadEstrategica dominio) {
        return new EntidadDocumentoActividadEstrategica(dominio.getRutaDocumento());
    }
    public EntidadDocumentoActividadEstrategica mapeadorEntidadDocumento(DocumentoActividadEstrategica dominio, Long id) {
        return new EntidadDocumentoActividadEstrategica(id,dominio.getRutaDocumento());
    }
    public List<DocumentoActividadEstrategica> mapeadorListaDocumentos(List<EntidadDocumentoActividadEstrategica> entidades) {
        List<DocumentoActividadEstrategica> listaDto = new ArrayList<>();
        for (EntidadDocumentoActividadEstrategica entidadActual : entidades) {
            DocumentoActividadEstrategica dto = new DocumentoActividadEstrategica();
            dto.setIdActividadEstrategica(entidadActual.getIdActividadEstrategica());
            dto.setRutaDocumento(entidadActual.getRutaDocumento());

            listaDto.add(dto);
        }
        return listaDto;
    }

}
