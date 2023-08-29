package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioCargo;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadCargo;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioCargoJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadArea;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioCargoMySQL implements RepositorioCargo {

    private static final String MENSAJE_NO_EXISTE = "No existe algunos de los componentes con los datos ingresados";
    private final RepositorioCargoJpa repositorioCargoJpa;
    private final RepositorioAreaJpa repositorioAreaJpa;

    public RepositorioCargoMySQL(RepositorioCargoJpa repositorioCargoJpa, RepositorioAreaJpa repositorioAreaJpa) {
        this.repositorioCargoJpa = repositorioCargoJpa;
        this.repositorioAreaJpa = repositorioAreaJpa;
    }

    @Override
    public List<Cargo> listar() {
        List<EntidadCargo> entidadCargos =this.repositorioCargoJpa.findAll();
        return entidadCargos.stream().map(entidadCargo -> Cargo.of(entidadCargo.getNombre(), entidadCargo.getIdArea())).toList();    }

    @Override
    public Cargo consultarPorId(Long id) {
        return this.repositorioCargoJpa.findById(id).map(entidadCargo -> Cargo.of(entidadCargo.getNombre(), entidadCargo.getIdArea())).orElse(null);

    }

    @Override
    public Long guardar(Cargo cargo) {
        Optional<EntidadArea> entidadArea = this.repositorioAreaJpa.findById(cargo.getIdArea());

        EntidadCargo entidadCargo = new EntidadCargo(cargo.getNombre(), entidadArea.get().getIdArea());
        return this.repositorioCargoJpa.save(entidadCargo).getIdCargo();
    }

    @Override
    public boolean existe(Cargo cargo) {
        return this.repositorioCargoJpa.findByNombre(cargo.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioCargoJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Cargo cargo, Long id) {
        repositorioCargoJpa.findById(id);
        Optional<EntidadArea> area = this.repositorioAreaJpa.findById(cargo.getIdArea());


        EntidadCargo entidadCargo = new EntidadCargo();
        entidadCargo.setIdCargo(id);
        entidadCargo.setNombre(cargo.getNombre());

        entidadCargo.setIdArea(area.get().getIdArea());

        repositorioCargoJpa.save(entidadCargo);
        return id;
    }
}
