package com.ccoa.planeacionestrategica.dominio.servicio.sprintproyectoarea.observacion;

import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.observacion.ObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.puerto.sprintproyectoarea.RepositorioObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_OBSERVACION_DEL_SPRINT_PROYECTO_AREA_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioModificarObservacionSprintProyectoArea {
    private final RepositorioObservacionSprintProyectoArea repositorioObservacionSprintProyectoArea;

    public ServicioModificarObservacionSprintProyectoArea(RepositorioObservacionSprintProyectoArea repositorioObservacionSprintProyectoArea) {
        this.repositorioObservacionSprintProyectoArea = repositorioObservacionSprintProyectoArea;
    }
    public Long ejecutarModificar(ObservacionSprintProyectoArea observacionSprintProyectoArea, Long codigo){
        if(this.repositorioObservacionSprintProyectoArea.consultarPorId(codigo)==null) throw new
                ExcepcionValidadorInvalido(NO_EXISTE_LA_OBSERVACION_DEL_SPRINT_PROYECTO_AREA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioObservacionSprintProyectoArea.modificar(observacionSprintProyectoArea,codigo);
    }


}
