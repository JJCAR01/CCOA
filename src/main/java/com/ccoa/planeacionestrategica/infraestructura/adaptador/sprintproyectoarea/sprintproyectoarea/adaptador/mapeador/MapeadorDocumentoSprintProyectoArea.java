package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.documento.DocumentoSprintProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.entidad.EntidadDocumentoSprintProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.repositorio.jpa.RepositorioDocumentoSprintProyectoAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorDocumentoSprintProyectoArea implements MapeadorInfraestructura<EntidadDocumentoSprintProyectoArea, DocumentoSprintProyectoArea> {
    private final RepositorioDocumentoSprintProyectoAreaJpa repositorioDocumentoSprintProyectoAreaJpa;

    public MapeadorDocumentoSprintProyectoArea(RepositorioDocumentoSprintProyectoAreaJpa repositorioDocumentoSprintProyectoAreaJpa) {
        this.repositorioDocumentoSprintProyectoAreaJpa = repositorioDocumentoSprintProyectoAreaJpa;
    }

    @Override
    public DocumentoSprintProyectoArea mapeadorDominio(EntidadDocumentoSprintProyectoArea entidad) {
        return new DocumentoSprintProyectoArea(entidad.getIdDocumentoSprintProyectoArea(), entidad.getIdSprintProyectoArea(), entidad.getRutaDocumento(),entidad.getFecha());
    }

    @Override
    public EntidadDocumentoSprintProyectoArea mapeadorEntidad(DocumentoSprintProyectoArea dominio) {
        return new EntidadDocumentoSprintProyectoArea(dominio.getIdSprintProyectoArea(), dominio.getRutaDocumento(), dominio.getFecha());
    }
    public EntidadDocumentoSprintProyectoArea mapeadorEntidadDocumento(DocumentoSprintProyectoArea dominio,Long id) {
        return new EntidadDocumentoSprintProyectoArea(id,dominio.getRutaDocumento(),dominio.getFecha());
    }
    public List<DocumentoSprintProyectoArea> mapeadorListaDocumentos(List<EntidadDocumentoSprintProyectoArea> entidades) {
        List<DocumentoSprintProyectoArea> listaDto = new ArrayList<>();
        for (EntidadDocumentoSprintProyectoArea entidadActual : entidades) {
            DocumentoSprintProyectoArea dto = new DocumentoSprintProyectoArea();
            dto.setIdSprintProyectoArea(entidadActual.getIdSprintProyectoArea());
            dto.setRutaDocumento(entidadActual.getRutaDocumento());
            dto.setFecha(entidadActual.getFecha());

            listaDto.add(dto);
        }
        return listaDto;
    }
    public void actualizarEntidad(EntidadDocumentoSprintProyectoArea entidad, DocumentoSprintProyectoArea documentoSprintProyectoArea){
        entidad.setRutaDocumento(documentoSprintProyectoArea.getRutaDocumento());
    }
    public EntidadDocumentoSprintProyectoArea obtenerEntidadDocumento(Long id){
        return repositorioDocumentoSprintProyectoAreaJpa.findById(id).orElseThrow();
    }

}
