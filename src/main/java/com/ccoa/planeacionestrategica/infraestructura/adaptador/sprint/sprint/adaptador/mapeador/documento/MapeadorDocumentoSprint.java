package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.mapeador.documento;

import com.ccoa.planeacionestrategica.dominio.modelo.sprint.documento.DocumentoSprint;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.entidad.EntidadDocumentoSprint;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.repositorio.jpa.RepositorioDocumentoSprintJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorDocumentoSprint implements MapeadorInfraestructura<EntidadDocumentoSprint, DocumentoSprint> {
    private final RepositorioDocumentoSprintJpa repositorioDocumentoSprintJpa;

    public MapeadorDocumentoSprint(RepositorioDocumentoSprintJpa repositorioDocumentoSprintJpa) {
        this.repositorioDocumentoSprintJpa = repositorioDocumentoSprintJpa;
    }

    @Override
    public DocumentoSprint mapeadorDominio(EntidadDocumentoSprint entidad) {
        return new DocumentoSprint(entidad.getIdDocumentoSprint(), entidad.getIdSprint(), entidad.getRutaDocumento(),entidad.getFecha());
    }

    @Override
    public EntidadDocumentoSprint mapeadorEntidad(DocumentoSprint dominio) {
        return new EntidadDocumentoSprint(dominio.getIdSprint(), dominio.getRutaDocumento(),dominio.getFecha());
    }
    public EntidadDocumentoSprint mapeadorEntidadDocumento(DocumentoSprint dominio,Long id) {
        return new EntidadDocumentoSprint(id,dominio.getRutaDocumento(),dominio.getFecha());
    }
    public List<DocumentoSprint> mapeadorListaDocumentos(List<EntidadDocumentoSprint> entidades) {
        List<DocumentoSprint> listaDto = new ArrayList<>();
        for (EntidadDocumentoSprint entidadActual : entidades) {
            DocumentoSprint dto = new DocumentoSprint();
            dto.setIdDocumentoSprint(entidadActual.getIdDocumentoSprint());
            dto.setIdSprint(entidadActual.getIdSprint());
            dto.setRutaDocumento(entidadActual.getRutaDocumento());
            dto.setFecha(entidadActual.getFecha());

            listaDto.add(dto);
        }
        return listaDto;
    }
    public void actualizarEntidad(EntidadDocumentoSprint entidad, DocumentoSprint documentoSprint){
        entidad.setRutaDocumento(documentoSprint.getRutaDocumento());
    }
    public EntidadDocumentoSprint obtenerEntidadDocumento(Long id){
        return repositorioDocumentoSprintJpa.findById(id).orElseThrow();
    }

}
