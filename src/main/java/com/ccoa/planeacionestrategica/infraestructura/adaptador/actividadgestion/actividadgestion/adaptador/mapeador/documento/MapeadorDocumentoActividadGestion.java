package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.mapeador.documento;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.documento.DocumentoActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.entidad.EntidadDocumentoActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.repositorio.jpa.RepositorioDocumentoActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorDocumentoActividadGestion implements MapeadorInfraestructura<EntidadDocumentoActividadGestion, DocumentoActividadGestion> {
    private final RepositorioDocumentoActividadGestionJpa repositorioDocumentoActividadGestionJpa;

    public MapeadorDocumentoActividadGestion(RepositorioDocumentoActividadGestionJpa repositorioDocumentoActividadGestionJpa) {
        this.repositorioDocumentoActividadGestionJpa = repositorioDocumentoActividadGestionJpa;
    }

    @Override
    public DocumentoActividadGestion mapeadorDominio(EntidadDocumentoActividadGestion entidad) {
        return new DocumentoActividadGestion(entidad.getIdDocumentoActividadGestion(), entidad.getIdActividadGestion(), entidad.getRutaDocumento(),entidad.getFecha());
    }

    @Override
    public EntidadDocumentoActividadGestion mapeadorEntidad(DocumentoActividadGestion dominio) {
        return new EntidadDocumentoActividadGestion(dominio.getIdActividadGestion(), dominio.getRutaDocumento(),dominio.getFecha());
    }
    public EntidadDocumentoActividadGestion mapeadorEntidadDocumento(DocumentoActividadGestion dominio, Long id) {
        return new EntidadDocumentoActividadGestion(id,dominio.getRutaDocumento(),dominio.getFecha());
    }
    public List<DocumentoActividadGestion> mapeadorListaDocumentos(List<EntidadDocumentoActividadGestion> entidades) {
        List<DocumentoActividadGestion> listaDto = new ArrayList<>();
        for (EntidadDocumentoActividadGestion entidadActual : entidades) {
            DocumentoActividadGestion dto = new DocumentoActividadGestion();
            dto.setIdActividadGestion(entidadActual.getIdActividadGestion());
            dto.setRutaDocumento(entidadActual.getRutaDocumento());
            dto.setFecha(entidadActual.getFecha());

            listaDto.add(dto);
        }
        return listaDto;
    }
    public void actualizarEntidad(EntidadDocumentoActividadGestion entidad, DocumentoActividadGestion documentoActividadGestion){
        entidad.setRutaDocumento(documentoActividadGestion.getRutaDocumento());
    }

    public EntidadDocumentoActividadGestion obtenerEntidadDocumento(Long id){
        return repositorioDocumentoActividadGestionJpa.findById(id).orElseThrow();
    }
}
