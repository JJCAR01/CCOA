package com.ccoa.planeacionestrategica.dominio.servicio.cargo;

import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioCargo;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.YA_EXISTE_EL_CARGO_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioGuardarCargo {
    private final RepositorioCargo repositorioCargo;

    public ServicioGuardarCargo(RepositorioCargo repositorioCargo) {
        this.repositorioCargo = repositorioCargo;
    }
    public Long ejecutarGuardar(Cargo cargo){
        if(this.repositorioCargo.existe(cargo)) throw new ValorInvalidoExcepcion(YA_EXISTE_EL_CARGO_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioCargo.guardar(cargo);}
}
