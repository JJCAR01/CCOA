package com.ccoa.planeacionestrategica.dominio.servicio.tarea.observacion;

import com.ccoa.planeacionestrategica.dominio.modelo.tarea.ObservacionTarea;
import com.ccoa.planeacionestrategica.dominio.puerto.tarea.RepositorioObservacionTarea;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_OBSERVACION_DE_LA_TAREA_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioModificarObservacionTarea {
    private final RepositorioObservacionTarea repositorioObservacionTarea;

    public ServicioModificarObservacionTarea(RepositorioObservacionTarea repositorioObservacionTarea) {
        this.repositorioObservacionTarea = repositorioObservacionTarea;
    }

    public Long ejecutarModificar(ObservacionTarea observacionTarea, Long codigo){
        if(this.repositorioObservacionTarea.consultarPorId(codigo)==null) throw new ExcepcionValidadorInvalido(NO_EXISTE_LA_OBSERVACION_DE_LA_TAREA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioObservacionTarea.modificar(observacionTarea,codigo);
    }


}
