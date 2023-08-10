package com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.RubroIngreso;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoContrato;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroIngreso;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadRubroIngreso;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadTipoContrato;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio.jpa.RepositorioRubroIngresoJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioRubroIngresoMySQL implements RepositorioRubroIngreso {

    private final RepositorioRubroIngresoJpa repositorioRubroIngresoJpa;

    public RepositorioRubroIngresoMySQL(RepositorioRubroIngresoJpa repositorioRubroIngresoJpa) {
        this.repositorioRubroIngresoJpa = repositorioRubroIngresoJpa;
    }

    @Override
    public List<RubroIngreso> listar() {
        List<EntidadRubroIngreso> entidadRubroIngresos =this.repositorioRubroIngresoJpa.findAll();
        return entidadRubroIngresos.stream().map(entidadRubroIngreso -> RubroIngreso.of(entidadRubroIngreso.getNombre())).toList();
    }

    @Override
    public RubroIngreso consultarPorId(Long id) {
        return this.repositorioRubroIngresoJpa.findById(id).map(entidadRubroIngreso -> RubroIngreso.of(entidadRubroIngreso.getNombre())).orElse(null);

    }

    @Override
    public Long guardar(RubroIngreso rubroIngreso) {
        EntidadRubroIngreso entidadRubroIngreso = new EntidadRubroIngreso(rubroIngreso.getNombre());
        return this.repositorioRubroIngresoJpa.save(entidadRubroIngreso).getId();
    }

    @Override
    public boolean existe(RubroIngreso rubroIngreso) {
        return this.repositorioRubroIngresoJpa.findByNombre(rubroIngreso.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioRubroIngresoJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(RubroIngreso rubroIngreso, Long id) {
        repositorioRubroIngresoJpa.findById(id);
        EntidadRubroIngreso entidadRubroIngreso = new EntidadRubroIngreso();
        entidadRubroIngreso.setId(id);
        entidadRubroIngreso.setNombre(rubroIngreso.getNombre());
        repositorioRubroIngresoJpa.save(entidadRubroIngreso);
        return id;
    }
}
