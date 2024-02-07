package com.ccoa.planeacionestrategica.infraestructura.clase.sprint.sprint.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.dto.DtoSprintResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.DocumentoSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.Sprint;
import com.ccoa.planeacionestrategica.dominio.puerto.sprint.RepositorioSprint;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.proyecto.adaptador.mapeador.MapeadorInformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.sprint.adaptador.entidad.EntidadSprint;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.sprint.adaptador.mapeador.MapeadorDocumentoSprint;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.sprint.adaptador.mapeador.MapeadorSprint;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.sprint.adaptador.repositorio.jpa.RepositorioDocumentoSprintJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.sprint.adaptador.repositorio.jpa.RepositorioSprintJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioSprintMySQL implements RepositorioSprint {
    private final RepositorioSprintJpa repositorioSprintJpa;
    private final RepositorioDocumentoSprintJpa repositorioDocumentoSprintJpa;
    private final MapeadorSprint mapeadorSprint;
    private final MapeadorDocumentoSprint mapeadorDocumentoSprint;
    private final MapeadorInformacionProyecto mapeadorInformacionProyecto;

    public RepositorioSprintMySQL(RepositorioSprintJpa repositorioSprintJpa, RepositorioDocumentoSprintJpa repositorioDocumentoSprintJpa,
                                  MapeadorSprint mapeadorSprint, MapeadorDocumentoSprint mapeadorDocumentoSprint, MapeadorInformacionProyecto mapeadorInformacionProyecto) {
        this.repositorioSprintJpa = repositorioSprintJpa;
        this.repositorioDocumentoSprintJpa = repositorioDocumentoSprintJpa;
        this.mapeadorSprint = mapeadorSprint;
        this.mapeadorDocumentoSprint = mapeadorDocumentoSprint;
        this.mapeadorInformacionProyecto = mapeadorInformacionProyecto;
    }
    @Override
    public List<DtoSprintResumen> listar() {
        var entidad = this.repositorioSprintJpa.findAll();
        return this.mapeadorSprint.listarDominio(entidad);
    }

    @Override
    public Sprint consultarPorId(Long id) {
        var entidad = this.repositorioSprintJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorSprint.mapeadorDominio(entidad);
    }

    @Override
    public DocumentoSprint consultarPorIdParaObtenerDocumento(Long id) {
        var entidad = this.repositorioDocumentoSprintJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorDocumentoSprint.mapeadorDominio(entidad);
    }

    @Override
    public Long guardar(Sprint sprint)   {
        var sprintEntidad = this.mapeadorSprint.mapeadorEntidad(sprint);

            long totalSprintsProyecto = mapeadorInformacionProyecto.obtenerTotalSprints(sprint.getIdProyecto());
            long totalSprintActuales = mapeadorSprint.obtenerTotalSprints(sprint.getIdProyecto());

            if ( totalSprintActuales < totalSprintsProyecto ) {
                var id = this.repositorioSprintJpa.save(sprintEntidad).getIdSprint();
                var entidad = this.repositorioSprintJpa.findById(id).orElse(null);

                if (entidad != null) {
                    this.mapeadorSprint.actualizarPorcentajeAvance(sprintEntidad, sprint);
                    return this.repositorioSprintJpa.save(sprintEntidad).getIdSprint();
                } else {
                    throw new IllegalArgumentException("No se pudo encontrar la entidad después de guardar.");
                }
            } else {
                throw new IllegalArgumentException("El total de sprints en el proyecto ya es mayor que el actual.");
            }
    }

    @Override
    public Long guardarDocumento(DocumentoSprint documentoSprint, Long codigo) {
        var docSprintEntidad = this.mapeadorDocumentoSprint.mapeadorEntidadDocumento(documentoSprint,codigo);
        return this.repositorioDocumentoSprintJpa.save(docSprintEntidad).getIdDocumentoSprint();
    }

    @Override
    public boolean existe(Sprint sprint) {
        return this.repositorioSprintJpa.findByDescripcion(sprint.getDescripcion())!=null;
    }

    @Override
    public boolean existeDocumento(DocumentoSprint sprint) {
        return this.repositorioDocumentoSprintJpa.findById(sprint.getIdRutaArchivo()).isPresent();
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioSprintJpa.deleteById(id);
        this.repositorioDocumentoSprintJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Sprint sprint, Long id) {
        var entidad = this.repositorioSprintJpa.findById(id).orElse(null);
        assert entidad != null;
        this.mapeadorSprint.actualizarEntidad(entidad, sprint);
        return this.repositorioSprintJpa.save(entidad).getIdSprint();
    }

    @Override
    public List<DtoSprintResumen> consultarPorIdProyecto(Long idProyecto) {
        List<EntidadSprint> entidades = this.repositorioSprintJpa.findByIdProyecto(idProyecto);
        return this.mapeadorSprint.listarDominio(entidades);
    }

}
