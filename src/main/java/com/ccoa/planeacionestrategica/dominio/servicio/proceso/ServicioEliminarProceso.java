package com.ccoa.planeacionestrategica.dominio.servicio.proceso;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioProceso;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_EL_PROCESO_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;
@Service
public class ServicioEliminarProceso {

    private final RepositorioProceso repositorioProceso;

    public ServicioEliminarProceso(RepositorioProceso repositorioProceso) {
        this.repositorioProceso = repositorioProceso;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioProceso.consultarPorId(id)== null) throw new ValorObligatorioExcepcion(NO_EXISTE_EL_PROCESO_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioProceso.eliminar(id);
    }
}
