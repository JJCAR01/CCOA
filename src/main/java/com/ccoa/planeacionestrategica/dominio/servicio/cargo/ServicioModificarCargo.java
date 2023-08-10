package com.ccoa.planeacionestrategica.dominio.servicio.cargo;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioCargo;
import org.springframework.stereotype.Service;

@Service
public class ServicioModificarCargo {

    private static final String MENSAJE_NO_EXISTE = "No existe el Cargo con los datos ingresados";

    private final RepositorioCargo repositorioCargo;

    public ServicioModificarCargo(RepositorioCargo repositorioCargo) {
        this.repositorioCargo = repositorioCargo;
    }

    public Long ejecutarModificar(Cargo cargo, Long codigo){

        if(this.repositorioCargo.consultarPorId(codigo)==null) throw new IllegalStateException(MENSAJE_NO_EXISTE);

        return this.repositorioCargo.modificar(cargo,codigo);
    }
}
