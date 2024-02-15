package com.ccoa.planeacionestrategica.dominio.servicio.sprintproyectoarea.observacion;

import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.observacion.ObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.puerto.sprintproyectoarea.RepositorioObservacionSprintProyectoArea;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarObservacionSprintProyectoArea {

    private final RepositorioObservacionSprintProyectoArea repositorioObservacionSprintProyectoArea;

    public ServicioGuardarObservacionSprintProyectoArea(RepositorioObservacionSprintProyectoArea repositorioObservacionSprintProyectoArea) {
        this.repositorioObservacionSprintProyectoArea = repositorioObservacionSprintProyectoArea;
    }

    public Long ejecutarGuardar(ObservacionSprintProyectoArea observacionSprintProyectoArea){
        return this.repositorioObservacionSprintProyectoArea.guardar(observacionSprintProyectoArea);
    }
}
