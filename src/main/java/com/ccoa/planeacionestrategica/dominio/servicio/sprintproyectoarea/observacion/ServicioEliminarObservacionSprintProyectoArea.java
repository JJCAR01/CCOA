package com.ccoa.planeacionestrategica.dominio.servicio.sprintproyectoarea.observacion;

import com.ccoa.planeacionestrategica.dominio.puerto.sprintproyectoarea.RepositorioObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorObligatorio;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_OBSERVACION_DEL_SPRINT_PROYECTO_AREA_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarObservacionSprintProyectoArea {

    private final RepositorioObservacionSprintProyectoArea repositorioObservacionSprintProyectoArea;

    public ServicioEliminarObservacionSprintProyectoArea(RepositorioObservacionSprintProyectoArea repositorioObservacionSprintProyectoArea) {
        this.repositorioObservacionSprintProyectoArea = repositorioObservacionSprintProyectoArea;
    }

    public Long ejecutarEliminar(Long id){
        if(this.repositorioObservacionSprintProyectoArea.consultarPorId(id)== null) throw new
                ExcepcionValidadorObligatorio(NO_EXISTE_LA_OBSERVACION_DEL_SPRINT_PROYECTO_AREA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioObservacionSprintProyectoArea.eliminar(id);
    }
}
