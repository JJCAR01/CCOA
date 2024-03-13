package com.ccoa.planeacionestrategica.dominio.servicio.cargo;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioCargo;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorObligatorio;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_EL_CARGO_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarCargo {
    private final RepositorioCargo repositorioCargo;

    public ServicioEliminarCargo(RepositorioCargo repositorioCargo) {
        this.repositorioCargo = repositorioCargo;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioCargo.consultarPorId(id)== null) throw new ExcepcionValidadorObligatorio(NO_EXISTE_EL_CARGO_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioCargo.eliminar(id);
    }
}
