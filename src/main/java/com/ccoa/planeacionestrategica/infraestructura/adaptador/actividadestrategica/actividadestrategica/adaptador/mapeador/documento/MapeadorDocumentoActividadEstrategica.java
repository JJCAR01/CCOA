package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.mapeador.documento;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.documento.DocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadDocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioDocumentoActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorDocumentoActividadEstrategica implements MapeadorInfraestructura<EntidadDocumentoActividadEstrategica, DocumentoActividadEstrategica> {
    private final RepositorioDocumentoActividadEstrategicaJpa repositorioDocumentoActividadEstrategicaJpa;

    public MapeadorDocumentoActividadEstrategica(RepositorioDocumentoActividadEstrategicaJpa repositorioDocumentoActividadEstrategicaJpa) {
        this.repositorioDocumentoActividadEstrategicaJpa = repositorioDocumentoActividadEstrategicaJpa;
    }

    @Override
    public DocumentoActividadEstrategica mapeadorDominio(EntidadDocumentoActividadEstrategica entidad) {
        return new DocumentoActividadEstrategica(entidad.getIdDocumentoActividadEstrategica(), entidad.getIdActividadEstrategica(),entidad.getRutaDocumento(),entidad.getFecha());
    }

    @Override
    public EntidadDocumentoActividadEstrategica mapeadorEntidad(DocumentoActividadEstrategica dominio) {
        return new EntidadDocumentoActividadEstrategica(dominio.getIdActividadEstrategica(),dominio.getRutaDocumento(),dominio.getFecha());
    }
    public EntidadDocumentoActividadEstrategica mapeadorEntidadDocumento(DocumentoActividadEstrategica dominio, Long id) {
        return new EntidadDocumentoActividadEstrategica(id,dominio.getRutaDocumento(),dominio.getFecha());
    }
    public List<DocumentoActividadEstrategica> mapeadorListaDocumentos(List<EntidadDocumentoActividadEstrategica> entidades) {
        List<DocumentoActividadEstrategica> listaDto = new ArrayList<>();
        for (EntidadDocumentoActividadEstrategica entidadActual : entidades) {
            DocumentoActividadEstrategica dto = new DocumentoActividadEstrategica();
            dto.setIdDocumentoActividadEstrategica(entidadActual.getIdDocumentoActividadEstrategica());
            dto.setIdActividadEstrategica(entidadActual.getIdActividadEstrategica());
            dto.setRutaDocumento(entidadActual.getRutaDocumento());
            dto.setFecha(entidadActual.getFecha());

            listaDto.add(dto);
        }
        return listaDto;
    }

    public void actualizarEntidad(EntidadDocumentoActividadEstrategica entidad, DocumentoActividadEstrategica documentoActividadEstrategica){
        entidad.setRutaDocumento(documentoActividadEstrategica.getRutaDocumento());
    }

    public EntidadDocumentoActividadEstrategica obtenerEntidadDocumento(Long id){
        return repositorioDocumentoActividadEstrategicaJpa.findById(id).orElseThrow();
    }
}
