package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.dto.DtoSprintProyectoAreaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.InformacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.SprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.documento.DocumentoSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.puerto.sprintproyectoarea.RepositorioSprintProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.mapeador.MapeadorInformacionProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.entidad.EntidadSprintProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.mapeador.MapeadorDocumentoSprintProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.mapeador.MapeadorInformacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.mapeador.MapeadorSprintProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.repositorio.jpa.RepositorioDocumentoSprintProyectoAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.repositorio.jpa.RepositorioInformacionSprintProyectoAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.repositorio.jpa.RepositorioSprintProyectoAreaJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioSprintProyectoAreaMySQL implements RepositorioSprintProyectoArea {
    private final RepositorioSprintProyectoAreaJpa repositorioSprintProyectoAreaJpa;
    private final RepositorioDocumentoSprintProyectoAreaJpa repositorioDocumentoSprintProyectoAreaJpa;
    private final MapeadorSprintProyectoArea mapeadorSprintProyectoArea;
    private final MapeadorInformacionSprintProyectoArea mapeadorInformacionSprintProyectoArea;
    private final RepositorioInformacionSprintProyectoAreaJpa repositorioInformacionSprintProyectoAreaJpa;
    private final MapeadorDocumentoSprintProyectoArea mapeadorDocumentoSprintProyectoArea;
    private final MapeadorInformacionProyectoArea mapeadorInformacionProyectoArea;

    public RepositorioSprintProyectoAreaMySQL(RepositorioSprintProyectoAreaJpa repositorioSprintProyectoAreaJpa, RepositorioDocumentoSprintProyectoAreaJpa repositorioDocumentoSprintProyectoAreaJpa, MapeadorSprintProyectoArea mapeadorSprintProyectoArea, MapeadorInformacionSprintProyectoArea mapeadorInformacionSprintProyectoArea, RepositorioInformacionSprintProyectoAreaJpa repositorioInformacionSprintProyectoAreaJpa,
                                              MapeadorDocumentoSprintProyectoArea mapeadorDocumentoSprintProyectoArea, MapeadorInformacionProyectoArea mapeadorInformacionProyectoArea) {
        this.repositorioSprintProyectoAreaJpa = repositorioSprintProyectoAreaJpa;
        this.repositorioDocumentoSprintProyectoAreaJpa = repositorioDocumentoSprintProyectoAreaJpa;
        this.mapeadorSprintProyectoArea = mapeadorSprintProyectoArea;
        this.mapeadorInformacionSprintProyectoArea = mapeadorInformacionSprintProyectoArea;
        this.repositorioInformacionSprintProyectoAreaJpa = repositorioInformacionSprintProyectoAreaJpa;
        this.mapeadorDocumentoSprintProyectoArea = mapeadorDocumentoSprintProyectoArea;
        this.mapeadorInformacionProyectoArea = mapeadorInformacionProyectoArea;
    }

    @Override
    public List<DtoSprintProyectoAreaResumen> listar() {
        var entidad = this.repositorioSprintProyectoAreaJpa.findAll();
        return this.mapeadorSprintProyectoArea.listarDominio(entidad);
    }

    @Override
    public SprintProyectoArea consultarPorId(Long id) {
        var entidad = this.repositorioSprintProyectoAreaJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorSprintProyectoArea.mapeadorDominio(entidad);
    }

    @Override
    public List<DocumentoSprintProyectoArea>  consultarPorIdParaObtenerDocumento(Long id) {
        var entidad = this.repositorioDocumentoSprintProyectoAreaJpa.findByIdSprintProyectoArea(id);
        assert entidad != null;
        return this.mapeadorDocumentoSprintProyectoArea.mapeadorListaDocumentos(entidad);
    }

    @Override
    public Long guardar(SprintProyectoArea sprintProyectoArea, InformacionSprintProyectoArea informacionSprintProyectoArea)   {
        var sprintProyectoAreaEntidad = this.mapeadorSprintProyectoArea.mapeadorEntidad(sprintProyectoArea);
        long totalSprintProyectoAreasProyecto = mapeadorInformacionProyectoArea.obtenerTotalSprintProyectoAreas(sprintProyectoArea.getIdProyectoArea());
        long totalSprintProyectoAreaActuales = mapeadorSprintProyectoArea.obtenerTotalSprintProyectoAreas(sprintProyectoArea.getIdProyectoArea());

        if ( totalSprintProyectoAreaActuales < totalSprintProyectoAreasProyecto ) {
            var id = this.repositorioSprintProyectoAreaJpa.save(sprintProyectoAreaEntidad).getIdSprintProyectoArea();
            var informacionSprintProyectoAreaEntidad = this.mapeadorInformacionSprintProyectoArea.mapeadorEntidad(informacionSprintProyectoArea);
            informacionSprintProyectoAreaEntidad.setIdInformacionSprintProyectoArea(id);
            var informacionEntidad = this.repositorioInformacionSprintProyectoAreaJpa.save(informacionSprintProyectoAreaEntidad);
            var entidad = this.repositorioSprintProyectoAreaJpa.findById(id).orElse(null);

            if (entidad != null) {
                mapeadorInformacionSprintProyectoArea.actualizarPorcentajeAvance(informacionEntidad,id);
                return id;
            } else {
                throw new IllegalArgumentException("No se pudo encontrar la entidad después de guardar.");
            }
        } else {
            throw new IllegalArgumentException("El total de SprintProyectoAreas en el proyecto ya es mayor que el actual.");
        }
    }

    @Override
    public Long guardarDocumento(DocumentoSprintProyectoArea documentoSprintProyectoArea, Long codigo) {
        var docSprintProyectoAreaEntidad = this.mapeadorDocumentoSprintProyectoArea.mapeadorEntidadDocumento(documentoSprintProyectoArea,codigo);
        return this.repositorioDocumentoSprintProyectoAreaJpa.save(docSprintProyectoAreaEntidad).getIdDocumentoSprintProyectoArea();
    }

    @Override
    public boolean existe(SprintProyectoArea sprintProyectoArea) {
        return this.repositorioSprintProyectoAreaJpa.findByDescripcion(sprintProyectoArea.getDescripcion())!=null;
    }

    @Override
    public boolean existeDocumento(DocumentoSprintProyectoArea sprintProyectoArea) {
        return this.repositorioDocumentoSprintProyectoAreaJpa.findById(sprintProyectoArea.getIdSprintProyectoArea()).isPresent();
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioSprintProyectoAreaJpa.deleteById(id);
        this.repositorioDocumentoSprintProyectoAreaJpa.deleteById(id);
        this.repositorioInformacionSprintProyectoAreaJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(SprintProyectoArea sprintProyectoArea, InformacionSprintProyectoArea informacionSprintProyectoArea, Long id) {
        var entidad = this.repositorioSprintProyectoAreaJpa.findById(id).orElse(null);
        var informacionEntidad = this.repositorioInformacionSprintProyectoAreaJpa.findById(id).orElse(null);
        assert informacionEntidad != null;
        assert entidad != null;
        this.mapeadorSprintProyectoArea.actualizarEntidad(entidad, sprintProyectoArea,informacionEntidad);
        this.repositorioInformacionSprintProyectoAreaJpa.save(informacionEntidad);
        return this.repositorioSprintProyectoAreaJpa.save(entidad).getIdSprintProyectoArea();
    }

    @Override
    public List<DtoSprintProyectoAreaResumen> consultarPorIdProyectoArea(Long idProyecto) {
        List<EntidadSprintProyectoArea> entidades = this.repositorioSprintProyectoAreaJpa.findByIdProyectoArea(idProyecto);
        return this.mapeadorSprintProyectoArea.listarDominio(entidades);
    }

    @Override
    public Long modificarDocumento(DocumentoSprintProyectoArea documentoSprintProyectoArea, Long id) {
        var entidad = mapeadorDocumentoSprintProyectoArea.obtenerEntidadDocumento(id);
        this.mapeadorDocumentoSprintProyectoArea.actualizarEntidad(entidad, documentoSprintProyectoArea);
        return this.repositorioDocumentoSprintProyectoAreaJpa.save(entidad).getIdDocumentoSprintProyectoArea();
    }

    @Override
    public Long eliminarDocumento(Long id) {
        this.repositorioDocumentoSprintProyectoAreaJpa.deleteById(id);
        return id;
    }

}
