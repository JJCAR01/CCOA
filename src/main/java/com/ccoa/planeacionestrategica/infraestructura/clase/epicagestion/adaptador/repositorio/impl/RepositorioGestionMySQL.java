package com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.modelo.Gestion;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.entidad.EntidadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.mapeador.MapeadorGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.repositorio.jpa.RepositorioGestionJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioGestionMySQL implements RepositorioGestion {

    private final RepositorioGestionJpa repositorioGestionJpa;
    private final MapeadorGestion mapeadorGestion;

    public RepositorioGestionMySQL(RepositorioGestionJpa repositorioGestionJpa, MapeadorGestion mapeadorGestion) {
        this.repositorioGestionJpa = repositorioGestionJpa;
        this.mapeadorGestion = mapeadorGestion;
    }

    @Override
    public List<Gestion> listar() {
        var entidad = this.repositorioGestionJpa.findAll();
        return this.mapeadorGestion.listarDominio(entidad);
    }

    @Override
    public Gestion consultarPorId(Long id) {
        var entidad = this.repositorioGestionJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorGestion.mapeadorDominio(entidad);
    }

    @Override
    public List<Gestion> consultarPorIdPat(Long idPat) {
        List<EntidadGestion> entidades = this.repositorioGestionJpa.findByIdPat(idPat);
        return this.mapeadorGestion.listarDominio(entidades);
    }

    @Override
    public Long guardar(Gestion gestion) {
        var gestionEntidad = this.mapeadorGestion.mapeadorEntidad(gestion);
        return this.repositorioGestionJpa.save(gestionEntidad).getIdGestion();
    }

    @Override
    public boolean existe(Gestion gestion) {
        return this.repositorioGestionJpa.findByNombre(gestion.getNombre())!=null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioGestionJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Gestion gestion, Long id) {
        var entidad = this.repositorioGestionJpa.findById(id).orElse(null);
        assert entidad != null;
        this.mapeadorGestion.actualizarEntidad(entidad, gestion);
        return this.repositorioGestionJpa.save(entidad).getIdGestion();
    }
}
