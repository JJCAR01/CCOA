package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.mapeador.documento;

import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.documento.DocumentoProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.entidad.EntidadDocumentoProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.repositorio.jpa.RepositorioDocumentoProyectoAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorDocumentoProyectoArea implements MapeadorInfraestructura<EntidadDocumentoProyectoArea, DocumentoProyectoArea> {
    private final RepositorioDocumentoProyectoAreaJpa repositorioDocumentoProyectoAreaJpa;

    public MapeadorDocumentoProyectoArea(RepositorioDocumentoProyectoAreaJpa repositorioDocumentoProyectoAreaJpa) {
        this.repositorioDocumentoProyectoAreaJpa = repositorioDocumentoProyectoAreaJpa;
    }

    @Override
    public DocumentoProyectoArea mapeadorDominio(EntidadDocumentoProyectoArea entidad) {
        return new DocumentoProyectoArea(entidad.getIdDocumentoProyectoArea(), entidad.getIdProyectoArea(), entidad.getRutaDocumento(),entidad.getFecha());
    }
    @Override
    public EntidadDocumentoProyectoArea mapeadorEntidad(DocumentoProyectoArea dominio) {
        return new EntidadDocumentoProyectoArea(dominio.getIdProyectoArea(), dominio.getRutaDocumento(),dominio.getFecha());
    }
    public EntidadDocumentoProyectoArea mapeadorEntidadDocumento(DocumentoProyectoArea dominio, Long id) {
        return new EntidadDocumentoProyectoArea(id,dominio.getRutaDocumento(),dominio.getFecha());
    }
    public List<DocumentoProyectoArea> mapeadorListaDocumentos(List<EntidadDocumentoProyectoArea> entidades) {
        List<DocumentoProyectoArea> listaDto = new ArrayList<>();
        for (EntidadDocumentoProyectoArea entidadActual : entidades) {
            DocumentoProyectoArea dto = new DocumentoProyectoArea();
            dto.setIdDocumentoProyectoArea(entidadActual.getIdDocumentoProyectoArea());
            dto.setIdProyectoArea(entidadActual.getIdDocumentoProyectoArea());
            dto.setRutaDocumento(entidadActual.getRutaDocumento());
            dto.setFecha(entidadActual.getFecha());

            listaDto.add(dto);
        }
        return listaDto;
    }
    public void actualizarEntidad(EntidadDocumentoProyectoArea entidad, DocumentoProyectoArea documentoProyectoArea){
        entidad.setRutaDocumento(documentoProyectoArea.getRutaDocumento());
    }
    public EntidadDocumentoProyectoArea obtenerEntidadDocumento(Long id){
        return repositorioDocumentoProyectoAreaJpa.findById(id).orElseThrow();
    }
}
