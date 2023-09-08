package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.Rubro;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubro;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.rubro.EntidadRubro;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioRubroJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioRubroMySQL implements RepositorioRubro {

    private final RepositorioRubroJpa repositorioRubroJpa;

    public RepositorioRubroMySQL(RepositorioRubroJpa repositorioRubroJpa) {
        this.repositorioRubroJpa = repositorioRubroJpa;
    }

    @Override
    public List<Rubro> listar() {
        List<EntidadRubro> entidadRubros =this.repositorioRubroJpa.findAll();
        return entidadRubros.stream().map(entidadRubro -> Rubro.of(entidadRubro.getIdRubro(), entidadRubro.getNombre(), String.valueOf(entidadRubro.getClasificacion()), entidadRubro.getIdTipoGI())).toList();
    }

    @Override
    public Rubro consultarPorId(Long id) {
        return this.repositorioRubroJpa.findById(id).map(entidadRubro -> Rubro.of(entidadRubro.getIdRubro(), entidadRubro.getNombre(), String.valueOf(entidadRubro.getClasificacion()),entidadRubro.getIdTipoGI())).orElse(null);

    }

    @Override
    public Long guardar(Rubro rubro) {
        EntidadRubro entidadRubro = new EntidadRubro(rubro.getNombre(),rubro.getClasificacion() ,rubro.getIdTipoGI());
        return this.repositorioRubroJpa.save(entidadRubro).getIdRubro();
    }

    @Override
    public boolean existe(Rubro rubro) {
        return this.repositorioRubroJpa.findById(rubro.getIdRubro()).isPresent();
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioRubroJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Rubro rubro, Long id) {
        repositorioRubroJpa.findById(id);
        EntidadRubro entidadRubro = new EntidadRubro();
        entidadRubro.setIdRubro(id);
        entidadRubro.setNombre(rubro.getNombre());
        repositorioRubroJpa.save(entidadRubro);
        return id;
    }
}
