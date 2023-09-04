package com.ccoa.planeacionestrategica.dominio.servicio.cargo;

import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioCargo;
import com.ccoa.planeacionestrategica.dominio.validador.excepcion.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioGuardarCargo {

    private static final String MENSAJE_YA_EXISTE = "Ya existe el Cargo con los datos ingresados";

    private final RepositorioCargo repositorioCargo;

    public ServicioGuardarCargo(RepositorioCargo repositorioCargo) {
        this.repositorioCargo = repositorioCargo;
    }

    public Long ejecutarGuardar(Cargo cargo){

        if(this.repositorioCargo.existe(cargo)) throw new ValorInvalidoExcepcion(MENSAJE_YA_EXISTE,MENSAJE_DEFECTO);

        return this.repositorioCargo.guardar(cargo);}
}
