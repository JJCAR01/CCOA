package com.ccoa.planeacionestrategica.dominio.servicio.cargo;

import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioCargo;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_EL_CARGO_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioModificarCargo {
    private final RepositorioCargo repositorioCargo;

    public ServicioModificarCargo(RepositorioCargo repositorioCargo) {
        this.repositorioCargo = repositorioCargo;
    }

    public Long ejecutarModificar(Cargo cargo, Long codigo){
        if(this.repositorioCargo.consultarPorId(codigo)==null) throw new ExcepcionValidadorInvalido(NO_EXISTE_EL_CARGO_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioCargo.modificar(cargo,codigo);
    }
}
