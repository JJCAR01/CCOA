package com.ccoa.planeacionestrategica.dominio.servicio.clasificacion;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioClasificacion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorObligatorio;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_CLASIFICACION_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;
@Service
public class ServicioEliminarClasificacion {

    private final RepositorioClasificacion repositorioClasificacion;

    public ServicioEliminarClasificacion(RepositorioClasificacion repositorioClasificacion) {
        this.repositorioClasificacion = repositorioClasificacion;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioClasificacion.consultarPorId(id)== null) throw new ExcepcionValidadorObligatorio(NO_EXISTE_LA_CLASIFICACION_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioClasificacion.eliminar(id);
    }
}
