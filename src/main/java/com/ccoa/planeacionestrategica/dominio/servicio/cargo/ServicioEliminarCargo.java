package com.ccoa.planeacionestrategica.dominio.servicio.cargo;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioCargo;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarCargo {

    private static final String MENSAJE_YA_EXISTE = "No existe el Cargo con los datos ingresados";

    private final RepositorioCargo repositorioCargo;

    public ServicioEliminarCargo(RepositorioCargo repositorioCargo) {
        this.repositorioCargo = repositorioCargo;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioCargo.consultarPorId(id)== null) throw new ValorObligatorioExcepcion(MENSAJE_YA_EXISTE,MENSAJE_DEFECTO);

        return this.repositorioCargo.eliminar(id);
    }
}
