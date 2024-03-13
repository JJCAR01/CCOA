package com.ccoa.planeacionestrategica.dominio.servicio.proceso;

import com.ccoa.planeacionestrategica.dominio.modelo.proceso.Proceso;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioProceso;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_EL_PROCESO_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;
@Service
public class ServicioModificarProceso {

    private final RepositorioProceso repositorioProceso;

    public ServicioModificarProceso(RepositorioProceso repositorioProceso) {
        this.repositorioProceso = repositorioProceso;
    }

    public Long ejecutarModificar(Proceso proceso, Long codigo){

        if(this.repositorioProceso.consultarPorId(codigo)==null) throw new ExcepcionValidadorInvalido(NO_EXISTE_EL_PROCESO_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioProceso.modificar(proceso,codigo);
    }
}
