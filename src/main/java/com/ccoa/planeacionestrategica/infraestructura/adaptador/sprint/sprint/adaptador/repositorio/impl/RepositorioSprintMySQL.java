package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoSprint;
import com.ccoa.planeacionestrategica.dominio.dto.DtoSprintResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.InformacionSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.documento.DocumentoSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.Sprint;
import com.ccoa.planeacionestrategica.dominio.puerto.sprint.RepositorioSprint;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.mapeador.MapeadorInformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.entidad.EntidadSprint;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.mapeador.documento.MapeadorDocumentoSprint;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.mapeador.MapeadorInformacionSprint;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.mapeador.MapeadorSprint;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.repositorio.jpa.RepositorioDocumentoSprintJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.repositorio.jpa.RepositorioInformacionSprintJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.repositorio.jpa.RepositorioSprintJpa;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioSprintMySQL implements RepositorioSprint {
    private final RepositorioSprintJpa repositorioSprintJpa;
    private final RepositorioDocumentoSprintJpa repositorioDocumentoSprintJpa;
    private final MapeadorSprint mapeadorSprint;
    private final MapeadorInformacionSprint mapeadorInformacionSprint;
    private final RepositorioInformacionSprintJpa repositorioInformacionSprintJpa;
    private final MapeadorDocumentoSprint mapeadorDocumentoSprint;
    private final MapeadorInformacionProyecto mapeadorInformacionProyecto;

    public RepositorioSprintMySQL(RepositorioSprintJpa repositorioSprintJpa, RepositorioDocumentoSprintJpa repositorioDocumentoSprintJpa,
                                  MapeadorSprint mapeadorSprint, MapeadorInformacionSprint mapeadorInformacionSprint, RepositorioInformacionSprintJpa repositorioInformacionSprintJpa, MapeadorDocumentoSprint mapeadorDocumentoSprint, MapeadorInformacionProyecto mapeadorInformacionProyecto) {
        this.repositorioSprintJpa = repositorioSprintJpa;
        this.repositorioDocumentoSprintJpa = repositorioDocumentoSprintJpa;
        this.mapeadorSprint = mapeadorSprint;
        this.mapeadorInformacionSprint = mapeadorInformacionSprint;
        this.repositorioInformacionSprintJpa = repositorioInformacionSprintJpa;
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
    public List<DocumentoSprint> consultarPorIdParaObtenerDocumento(Long id) {
        var entidad = this.repositorioDocumentoSprintJpa.findByIdSprint(id);
        assert entidad != null;
        return this.mapeadorDocumentoSprint.mapeadorListaDocumentos(entidad);
    }

    @Override
    public Long guardar(Sprint sprint, InformacionSprint informacionSprint)   {
        var sprintEntidad = this.mapeadorSprint.mapeadorEntidad(sprint);
        long totalSprintsProyecto = mapeadorInformacionProyecto.obtenerTotalSprints(sprint.getIdProyecto());
        long totalSprintActuales = mapeadorSprint.obtenerTotalSprints(sprint.getIdProyecto());

        if ( totalSprintActuales < totalSprintsProyecto ) {
            var id = this.repositorioSprintJpa.save(sprintEntidad).getIdSprint();
            var informacionSprintEntidad = this.mapeadorInformacionSprint.mapeadorEntidad(informacionSprint);
            informacionSprintEntidad.setIdInformacionSprint(id);
            var informacionEntidad = this.repositorioInformacionSprintJpa.save(informacionSprintEntidad);
            var entidad = this.repositorioSprintJpa.findById(id).orElse(null);

            if (entidad != null) {
                    mapeadorInformacionSprint.actualizarPorcentajeAvance(informacionEntidad,id);
                    return id;
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
        return this.repositorioDocumentoSprintJpa.findById(sprint.getIdSprint()).isPresent();
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioSprintJpa.deleteById(id);
        this.repositorioDocumentoSprintJpa.deleteById(id);
        this.repositorioInformacionSprintJpa.deleteById(id);
        return id;
    }
    @Transactional
    @Override
    public void eliminarPorProyecto(Long id) {
        var entidades = consultarPorIdProyectoAEliminar(id);
        entidades.forEach(entidad -> repositorioInformacionSprintJpa.deleteById(entidad.getIdInformacionSprint()));
        repositorioSprintJpa.deleteByIdProyecto(id);
    }

    @Override
    public Long modificar(Sprint sprint, InformacionSprint informacionSprint, Long id) {
        var entidad = this.repositorioSprintJpa.findById(id).orElse(null);
        var informacionEntidad = this.repositorioInformacionSprintJpa.findById(id).orElse(null);
        assert informacionEntidad != null;
        assert entidad != null;
        this.mapeadorSprint.actualizarEntidad(entidad, sprint, informacionEntidad);
        this.repositorioInformacionSprintJpa.save(informacionEntidad);
        this.repositorioSprintJpa.save(entidad);
        this.mapeadorInformacionSprint.actualizarPorcentajeAvance(informacionEntidad,id);
        return id;
    }

    @Override
    public List<DtoSprintResumen> consultarPorIdProyecto(Long idProyecto) {
        List<EntidadSprint> entidades = this.repositorioSprintJpa.findByIdProyecto(idProyecto);
        return this.mapeadorSprint.listarDominio(entidades);
    }

    @Override
    public List<DtoSprint> consultarPorIdProyectoParaDuplicar(Long idProyecto) {
        List<EntidadSprint> entidades = this.repositorioSprintJpa.findByIdProyecto(idProyecto);
        return this.mapeadorSprint.obtenerSprintParaDuplicar(entidades);
    }

    @Override
    public List<DtoIdsSprint> consultarPorIdProyectoAEliminar(Long idProyecto) {
        List<EntidadSprint> entidades = this.repositorioSprintJpa.findByIdProyecto(idProyecto);
        return this.mapeadorSprint.listarIds(entidades);
    }

    @Override
    public Long modificarDocumento(DocumentoSprint documentoSprint, Long id) {
        var entidad = mapeadorDocumentoSprint.obtenerEntidadDocumento(id);
        this.mapeadorDocumentoSprint.actualizarEntidad(entidad, documentoSprint);
        return this.repositorioDocumentoSprintJpa.save(entidad).getIdDocumentoSprint();
    }

    @Override
    public Long eliminarDocumento(Long id) {
        this.repositorioDocumentoSprintJpa.deleteById(id);
        return id;
    }

}
