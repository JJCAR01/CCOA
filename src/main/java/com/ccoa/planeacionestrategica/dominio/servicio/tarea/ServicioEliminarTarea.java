package com.ccoa.planeacionestrategica.dominio.servicio.tarea;

import com.ccoa.planeacionestrategica.dominio.puerto.tarea.RepositorioTarea;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorObligatorio;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarTarea {

    private final RepositorioTarea repositorioTarea;

    public ServicioEliminarTarea(RepositorioTarea repositorioTarea) {
        this.repositorioTarea = repositorioTarea;
    }

    public Long ejecutarEliminar(Long id){
        if(this.repositorioTarea.consultarPorId(id)== null) throw new ExcepcionValidadorObligatorio(NO_EXISTE_LA_TAREA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioTarea.eliminar(id);
    }
    public void ejecutarEliminarPorActividadGestionEstrategica(Long id){
        if(this.repositorioTarea.consultarPorIdActividadGestionEstrategicaAEliminar(id)== null) throw new ExcepcionValidadorObligatorio(NO_EXISTE_EL_PROYECTO_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        this.repositorioTarea.eliminarPorActividadGestionEstrategica(id);
    }
    public void ejecutarEliminarPorActividadGestion(Long id){
        if(this.repositorioTarea.consultarPorIdActividadGestionAEliminar(id)== null) throw new ExcepcionValidadorObligatorio(NO_EXISTE_EL_PROYECTO_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        this.repositorioTarea.eliminarPorActividadGestion(id);
    }
    public Long eliminarDocumento(Long id){
        return this.repositorioTarea.eliminarDocumento(id);
    }
}
