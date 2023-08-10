package com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioCargo;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadArea;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadCargo;
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
        return null;
    }

    @Override
    public Cargo consultarPorId(Long id) {
        return null;
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
        return false;
    }

    @Override
    public Long eliminar(Long id) {
        return null;
    }

    @Override
    public Long modificar(Cargo cargo, Long id) {
        return null;
    }
}
