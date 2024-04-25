package com.ccoa.planeacionestrategica.dominio.servicio.clasificacion;

import com.ccoa.planeacionestrategica.dominio.modelo.clasificacion.Clasificacion;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioClasificacion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.YA_EXISTE_LA_CLASIFICACION_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;
@Service
public class ServicioGuardarClasificacion {
    private final RepositorioClasificacion repositorioClasificacion;

    public ServicioGuardarClasificacion(RepositorioClasificacion repositorioProceso) {
        this.repositorioClasificacion = repositorioProceso;
    }

    public Long ejecutarGuardar(Clasificacion clasificacion)  {

        if(this.repositorioClasificacion.existe(clasificacion)) throw new ExcepcionValidadorInvalido(YA_EXISTE_LA_CLASIFICACION_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioClasificacion.guardar(clasificacion);
    }
}
