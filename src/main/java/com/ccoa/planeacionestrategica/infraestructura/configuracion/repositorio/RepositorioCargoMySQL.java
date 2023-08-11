package com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioCargo;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadArea;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadCargo;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio.jpa.RepositorioAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio.jpa.RepositorioCargoJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        return entidadCargos.stream().map(entidadCargo -> Cargo.of(entidadCargo.getNombre(), Area.of(entidadCargo.getArea().getNombre()))).toList();    }

    @Override
    public Cargo consultarPorId(Long id) {
        return this.repositorioCargoJpa.findById(id).map(entidadCargo -> Cargo.of(entidadCargo.getNombre(),Area.of(entidadCargo.getNombre()))).orElse(null);

    }

    @Override
    public Long guardar(Cargo cargo) {
        EntidadArea entidadArea = this.repositorioAreaJpa.findByNombre(cargo.getArea().getNombre());

        if(entidadArea == null){
            throw new IllegalStateException(MENSAJE_NO_EXISTE);
        }

        EntidadCargo entidadCargo = new EntidadCargo(cargo.getNombre(),entidadArea);
        return this.repositorioCargoJpa.save(entidadCargo).getId();
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
        EntidadArea area = this.repositorioAreaJpa.findByNombre(cargo.getArea().getNombre());


        EntidadCargo entidadCargo = new EntidadCargo();
        entidadCargo.setId(id);
        entidadCargo.setNombre(cargo.getNombre());

        entidadCargo.setArea(area);

        repositorioCargoJpa.save(entidadCargo);
        return id;
    }
}
