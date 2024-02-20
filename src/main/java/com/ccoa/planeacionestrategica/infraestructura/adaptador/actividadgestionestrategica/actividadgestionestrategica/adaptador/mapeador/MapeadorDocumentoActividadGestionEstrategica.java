package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.documento.DocumentoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.entidad.EntidadDocumentoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorDocumentoActividadGestionEstrategica implements MapeadorInfraestructura<EntidadDocumentoActividadGestionEstrategica,
        DocumentoActividadGestionEstrategica> {
    @Override
    public DocumentoActividadGestionEstrategica mapeadorDominio(EntidadDocumentoActividadGestionEstrategica entidad) {
        return new DocumentoActividadGestionEstrategica(entidad.getIdActividadGestionEstrategica(),
                entidad.getRutaDocumento(),entidad.getFecha());
    }
    @Override
    public EntidadDocumentoActividadGestionEstrategica mapeadorEntidad(DocumentoActividadGestionEstrategica dominio) {
        return new EntidadDocumentoActividadGestionEstrategica(dominio.getIdActividadGestionEstrategica(), dominio.getRutaDocumento(),
                dominio.getFecha());
    }
    public EntidadDocumentoActividadGestionEstrategica mapeadorEntidadDocumento(DocumentoActividadGestionEstrategica dominio, Long id) {
        return new EntidadDocumentoActividadGestionEstrategica(id,dominio.getRutaDocumento(),dominio.getFecha());
    }

    public List<DocumentoActividadGestionEstrategica> mapeadorListaDocumentos(List<EntidadDocumentoActividadGestionEstrategica> entidades) {
        List<DocumentoActividadGestionEstrategica> listaDto = new ArrayList<>();
        for (EntidadDocumentoActividadGestionEstrategica entidadActual : entidades) {
            DocumentoActividadGestionEstrategica dto = new DocumentoActividadGestionEstrategica();
            dto.setIdActividadGestionEstrategica(entidadActual.getIdActividadGestionEstrategica());
            dto.setRutaDocumento(entidadActual.getRutaDocumento());
            dto.setFecha(entidadActual.getFecha());

            listaDto.add(dto);
        }
        return listaDto;
    }
}
