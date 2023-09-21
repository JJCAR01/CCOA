package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.TipoEG;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoEG;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.epicagestion.EntidadTipoEG;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioTipoEGJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioTipoEGMySQL implements RepositorioTipoEG {

    private final RepositorioTipoEGJpa repositorioTipoEGJpa;

    public RepositorioTipoEGMySQL(RepositorioTipoEGJpa repositorioTipoEGJpa) {
        this.repositorioTipoEGJpa = repositorioTipoEGJpa;
    }

    @Override
    public List<TipoEG> listar() {
        List<EntidadTipoEG> entidadTipoGIS = this.repositorioTipoEGJpa.findAll();
        return entidadTipoGIS.stream().map(entidad -> TipoEG.of(entidad.getIdTipoGI(), String.valueOf(entidad.getNombre()))).toList();

    }

    @Override
    public TipoEG consultarPorId(Long id) {
        return this.repositorioTipoEGJpa.findById(id).map(entidad -> TipoEG.of(entidad.getIdTipoGI(), String.valueOf(entidad.getNombre()))).orElse(null);

    }

    @Override
    public boolean existe(TipoEG tipoEG) {
        return this.repositorioTipoEGJpa.findById(tipoEG.getIdTipoEG()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioTipoEGJpa.deleteById(id);
        return id;
    }

}
