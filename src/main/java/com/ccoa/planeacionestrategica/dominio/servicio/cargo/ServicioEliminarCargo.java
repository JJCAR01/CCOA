package com.ccoa.planeacionestrategica.dominio.servicio.cargo;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioCargo;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarCargo {

    private static final String MENSAJE_YA_EXISTE = "No existe el Cargo con los datos ingresados";

    private final RepositorioCargo repositorioCargo;

    public ServicioEliminarCargo(RepositorioCargo repositorioCargo) {
        this.repositorioCargo = repositorioCargo;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioCargo.consultarPorId(id)== null) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioCargo.eliminar(id);
    }
}
