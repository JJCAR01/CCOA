package com.ccoa.planeacionestrategica.dominio.servicio.sprint;

import com.ccoa.planeacionestrategica.dominio.puerto.sprint.RepositorioSprint;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorObligatorio;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarSprint {

    private final RepositorioSprint repositorioSprint;

    public ServicioEliminarSprint(RepositorioSprint repositorioSprint) {
        this.repositorioSprint = repositorioSprint;
    }

    public Long ejecutarEliminar(Long id){
        if(this.repositorioSprint.consultarPorId(id)== null) throw new ExcepcionValidadorObligatorio(NO_EXISTE_EL_SPRINT_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioSprint.eliminar(id);
    }
    public void ejecutarEliminarPorProyecto(Long id){
        if(this.repositorioSprint.consultarPorIdProyectoAEliminar(id)== null) throw new ExcepcionValidadorObligatorio(NO_EXISTE_EL_PROYECTO_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        this.repositorioSprint.eliminarPorProyecto(id);
    }
    public Long eliminarDocumento(Long id){
        return this.repositorioSprint.eliminarDocumento(id);
    }
}
