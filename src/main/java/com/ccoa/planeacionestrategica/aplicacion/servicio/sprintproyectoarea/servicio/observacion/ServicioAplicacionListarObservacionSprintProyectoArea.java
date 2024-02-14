package com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoObservacionSprint;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprintproyectoarea.DtoObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.observacion.ObservacionSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.observacion.ObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.puerto.sprint.RepositorioObservacionSprint;
import com.ccoa.planeacionestrategica.dominio.puerto.sprintproyectoarea.RepositorioObservacionSprintProyectoArea;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarObservacionSprintProyectoArea {

    private final RepositorioObservacionSprintProyectoArea repositorioObservacionSprintProyectoArea;

    public ServicioAplicacionListarObservacionSprintProyectoArea(RepositorioObservacionSprintProyectoArea repositorioObservacionSprintProyectoArea) {
        this.repositorioObservacionSprintProyectoArea = repositorioObservacionSprintProyectoArea;
    }

    public List<DtoObservacionSprintProyectoArea> ejecutar(){return this.repositorioObservacionSprintProyectoArea.listar();}
    public ObservacionSprintProyectoArea consultarById(Long id){return this.repositorioObservacionSprintProyectoArea.consultarPorId(id);}
    public List<DtoObservacionSprintProyectoArea> consultarPorIdSprintProyectoArea(Long id){return this.repositorioObservacionSprintProyectoArea.consultarPorIdSprintProyectoArea(id);}
}
