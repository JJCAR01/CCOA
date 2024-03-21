package com.ccoa.planeacionestrategica.dominio.servicio.sprintproyectoarea;

import com.ccoa.planeacionestrategica.dominio.puerto.sprintproyectoarea.RepositorioSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorObligatorio;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarSprintProyectoArea {

    private final RepositorioSprintProyectoArea repositorioSprintProyectoArea;

    public ServicioEliminarSprintProyectoArea(RepositorioSprintProyectoArea repositorioSprintProyectoArea) {
        this.repositorioSprintProyectoArea = repositorioSprintProyectoArea;
    }

    public Long ejecutarEliminar(Long id){
        if(this.repositorioSprintProyectoArea.consultarPorId(id)== null) throw new ExcepcionValidadorObligatorio(NO_EXISTE_EL_SPRINT_DEL_PROYECTO_DEL_AREA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioSprintProyectoArea.eliminar(id);
    }
    public Long eliminarDocumento(Long id){
        if(this.repositorioSprintProyectoArea.consultarPorId(id)== null) throw new ExcepcionValidadorInvalido(NO_EXISTE_EL_DOCUMENTO_RELACIONADO_CON_EL_SPRINT_DEL_PROYECTO_DEL_AREA,MENSAJE_DEFECTO);
        return this.repositorioSprintProyectoArea.eliminarDocumento(id);
    }
}
