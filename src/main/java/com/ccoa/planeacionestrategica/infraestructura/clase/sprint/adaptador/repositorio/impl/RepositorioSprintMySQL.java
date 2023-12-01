package com.ccoa.planeacionestrategica.infraestructura.clase.sprint.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.dto.DtoSprintResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.DocumentoSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.Sprint;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioSprint;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.adaptador.entidad.EntidadSprint;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.adaptador.mapeador.MapeadorDocumentoSprint;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.adaptador.mapeador.MapeadorSprint;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.adaptador.repositorio.jpa.RepositorioDocumentoSprintJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.adaptador.repositorio.jpa.RepositorioSprintJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioSprintMySQL implements RepositorioSprint {
    private final RepositorioSprintJpa repositorioSprintJpa;
    private final RepositorioDocumentoSprintJpa repositorioDocumentoSprintJpa;
    private final MapeadorSprint mapeadorSprint;
    private final MapeadorDocumentoSprint mapeadorDocumentoSprint;

    public RepositorioSprintMySQL(RepositorioSprintJpa repositorioSprintJpa, RepositorioDocumentoSprintJpa repositorioDocumentoSprintJpa,
                                  MapeadorSprint mapeadorSprint, MapeadorDocumentoSprint mapeadorDocumentoSprint) {
        this.repositorioSprintJpa = repositorioSprintJpa;
        this.repositorioDocumentoSprintJpa = repositorioDocumentoSprintJpa;
        this.mapeadorSprint = mapeadorSprint;
        this.mapeadorDocumentoSprint = mapeadorDocumentoSprint;
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
    public Long guardar(Sprint sprint) {
        var sprintEntidad = this.mapeadorSprint.mapeadorEntidad(sprint);
        var id = this.repositorioSprintJpa.save(sprintEntidad).getIdSprint();
        var entidad = this.repositorioSprintJpa.findById(id).orElse(null);
        assert entidad != null;
        this.mapeadorSprint.actualizarPorcentajeAvance(sprintEntidad, sprint);
        return this.repositorioSprintJpa.save(sprintEntidad).getIdSprint();
    }

    @Override
    public Long guardarDocumento(DocumentoSprint documentoSprint) {
        var docSprintEntidad = this.mapeadorDocumentoSprint.mapeadorEntidad(documentoSprint);
        return this.repositorioDocumentoSprintJpa.save(docSprintEntidad).getIdDocumentoSprint();
    }

    @Override
    public boolean existe(Sprint sprint) {
        return this.repositorioSprintJpa.findByDescripcion(sprint.getDescripcion())!=null;
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
