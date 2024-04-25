package com.ccoa.planeacionestrategica.dominio.servicio.clasificacion;

import com.ccoa.planeacionestrategica.dominio.modelo.clasificacion.Clasificacion;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioClasificacion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_CLASIFICACION_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;
@Service
public class ServicioModificarClasificacion {

    private final RepositorioClasificacion repositorioClasificacion;

    public ServicioModificarClasificacion(RepositorioClasificacion repositorioClasificacion) {
        this.repositorioClasificacion = repositorioClasificacion;
    }

    public Long ejecutarModificar(Clasificacion clasificacion, Long codigo){

        if(this.repositorioClasificacion.consultarPorId(codigo)==null) throw new ExcepcionValidadorInvalido(NO_EXISTE_LA_CLASIFICACION_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioClasificacion.modificar(clasificacion,codigo);
    }
}
