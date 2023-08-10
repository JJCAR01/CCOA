package com.ccoa.planeacionestrategica.dominio.servicio.cargo;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioCargo;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarCargo {

    private static final String MENSAJE_YA_EXISTE = "Ya existe el Area con los datos ingresados";

    private final RepositorioCargo repositorioCargo;

    public ServicioGuardarCargo(RepositorioCargo repositorioCargo) {
        this.repositorioCargo = repositorioCargo;
    }

    public Long ejecutarGuardar(Cargo cargo){

        if(this.repositorioCargo.existe(cargo)) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioCargo.guardar(cargo);}
}
