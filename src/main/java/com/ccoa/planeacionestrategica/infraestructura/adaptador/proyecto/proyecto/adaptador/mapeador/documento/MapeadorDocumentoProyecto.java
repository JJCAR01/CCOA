package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.mapeador.documento;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.documento.DocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.documento.DocumentoProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadDocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.entidad.EntidadDocumentoProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.repositorio.jpa.RepositorioDocumentoProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.repositorio.jpa.RepositorioProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorDocumentoProyecto implements MapeadorInfraestructura<EntidadDocumentoProyecto, DocumentoProyecto> {
    private final RepositorioDocumentoProyectoJpa repositorioDocumentoProyectoJpa;

    public MapeadorDocumentoProyecto(RepositorioDocumentoProyectoJpa repositorioDocumentoProyectoJpa) {
        this.repositorioDocumentoProyectoJpa = repositorioDocumentoProyectoJpa;
    }

    @Override
    public DocumentoProyecto mapeadorDominio(EntidadDocumentoProyecto entidad) {
        return new DocumentoProyecto(entidad.getIdDocumentoProyecto(), entidad.getIdProyecto(), entidad.getRutaDocumento(),entidad.getFecha());
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
            dto.setIdDocumentoProyecto(entidadActual.getIdDocumentoProyecto());
            dto.setIdProyecto(entidadActual.getIdProyecto());
            dto.setRutaDocumento(entidadActual.getRutaDocumento());
            dto.setFecha(entidadActual.getFecha());

            listaDto.add(dto);
        }
        return listaDto;
    }
    public void actualizarEntidad(EntidadDocumentoProyecto entidad, DocumentoProyecto documentoProyecto){
        entidad.setRutaDocumento(documentoProyecto.getRutaDocumento());
    }

    public EntidadDocumentoProyecto obtenerEntidadDocumento(Long id){
        return repositorioDocumentoProyectoJpa.findById(id).orElseThrow();
    }
}
