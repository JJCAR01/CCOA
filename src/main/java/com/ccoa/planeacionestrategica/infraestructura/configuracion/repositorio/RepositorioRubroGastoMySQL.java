package com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.RubroGasto;
import com.ccoa.planeacionestrategica.dominio.modelo.RubroIngreso;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroGasto;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadRubroGasto;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadRubroIngreso;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio.jpa.RepositorioRubroGastoJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioRubroGastoMySQL implements RepositorioRubroGasto {

    private final RepositorioRubroGastoJpa repositorioRubroGastoJpa;

    public RepositorioRubroGastoMySQL(RepositorioRubroGastoJpa repositorioRubroGastoJpa) {
        this.repositorioRubroGastoJpa = repositorioRubroGastoJpa;
    }

    @Override
    public List<RubroGasto> listar() {
        List<EntidadRubroGasto> entidadRubroGastos =this.repositorioRubroGastoJpa.findAll();
        return entidadRubroGastos.stream().map(entidadRubroGasto -> RubroGasto.of(entidadRubroGasto.getNombre())).toList();
    }

    @Override
    public RubroGasto consultarPorId(Long id) {
        return this.repositorioRubroGastoJpa.findById(id).map(entidadRubroGasto -> RubroGasto.of(entidadRubroGasto.getNombre())).orElse(null);

    }

    @Override
    public Long guardar(RubroGasto rubroGasto) {
        EntidadRubroGasto entidadRubroGasto = new EntidadRubroGasto(rubroGasto.getNombre());
        return this.repositorioRubroGastoJpa.save(entidadRubroGasto).getId();
    }

    @Override
    public boolean existe(RubroGasto rubroGasto) {
        return this.repositorioRubroGastoJpa.findByNombre(rubroGasto.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioRubroGastoJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(RubroGasto rubroGasto, Long id) {
        repositorioRubroGastoJpa.findById(id);
        EntidadRubroGasto entidadRubroGasto = new EntidadRubroGasto();
        entidadRubroGasto.setId(id);
        entidadRubroGasto.setNombre(rubroGasto.getNombre());
        repositorioRubroGastoJpa.save(entidadRubroGasto);
        return id;
    }
}
