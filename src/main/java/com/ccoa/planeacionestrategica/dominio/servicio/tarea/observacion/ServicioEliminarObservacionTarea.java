package com.ccoa.planeacionestrategica.dominio.servicio.tarea.observacion;

import com.ccoa.planeacionestrategica.dominio.puerto.tarea.RepositorioObservacionTarea;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorObligatorio;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_OBSERVACION_DE_LA_TAREA_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarObservacionTarea {

    private final RepositorioObservacionTarea repositorioObservacionTarea;

    public ServicioEliminarObservacionTarea(RepositorioObservacionTarea repositorioObservacionTarea) {
        this.repositorioObservacionTarea = repositorioObservacionTarea;
    }

    public Long ejecutarEliminar(Long id){
        if(this.repositorioObservacionTarea.consultarPorId(id)== null) throw new ExcepcionValidadorObligatorio(NO_EXISTE_LA_OBSERVACION_DE_LA_TAREA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioObservacionTarea.eliminar(id);
    }
}
