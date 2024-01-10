package com.ccoa.planeacionestrategica.dominio.servicio.proceso;

import com.ccoa.planeacionestrategica.dominio.modelo.proceso.Proceso;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioProceso;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.YA_EXISTE_EL_PROCESO_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;
@Service
public class ServicioGuardarProceso {
    private final RepositorioProceso repositorioProceso;

    public ServicioGuardarProceso(RepositorioProceso repositorioProceso) {
        this.repositorioProceso = repositorioProceso;
    }

    public Long ejecutarGuardar(Proceso proceso)  {

        if(this.repositorioProceso.existe(proceso)) throw new ValorInvalidoExcepcion(YA_EXISTE_EL_PROCESO_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioProceso.guardar(proceso);
    }
}
