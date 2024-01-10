package com.ccoa.planeacionestrategica.infraestructura.clase.proceso.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.modelo.proceso.Proceso;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioProceso;
import com.ccoa.planeacionestrategica.infraestructura.clase.proceso.adaptador.mapeador.MapeadorProceso;
import com.ccoa.planeacionestrategica.infraestructura.clase.proceso.adaptador.repositorio.jpa.RepositorioProcesoJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RepositorioProcesoMySQL implements RepositorioProceso {

    private final RepositorioProcesoJpa repositorioProcesoJpa;
    private final MapeadorProceso mapeadorProceso;

    public RepositorioProcesoMySQL(RepositorioProcesoJpa repositorioProcesoJpa, MapeadorProceso mapeadorProceso) {
        this.repositorioProcesoJpa = repositorioProcesoJpa;
        this.mapeadorProceso = mapeadorProceso;
    }

    @Override
    public List<Proceso> listar() {
        var entidad =this.repositorioProcesoJpa.findAll();
        return this.mapeadorProceso.listarDominio(entidad);
    }

    @Override
    public Proceso consultarPorId(Long id) {
        var entidad = this.repositorioProcesoJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorProceso.mapeadorDominio(entidad);
    }

    @Override
    public Long guardar(Proceso proceso) {
        return this.repositorioProcesoJpa.save(this.mapeadorProceso.mapeadorEntidad(proceso)).getIdProceso();
    }

    @Override
    public boolean existe(Proceso proceso)  {
        return this.repositorioProcesoJpa.findByNombre(proceso.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioProcesoJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Proceso proceso, Long id) {
        var entidad = this.repositorioProcesoJpa.findById(id).orElse(null);
        assert entidad != null;
        this.mapeadorProceso.actualizarEntidad(entidad, proceso);
        return this.repositorioProcesoJpa.save(entidad).getIdProceso();
    }
}
