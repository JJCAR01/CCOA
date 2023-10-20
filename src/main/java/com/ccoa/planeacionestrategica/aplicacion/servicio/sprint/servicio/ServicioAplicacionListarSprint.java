package com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio;

import com.ccoa.planeacionestrategica.dominio.dto.DtoSprintResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.Sprint;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioSprint;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarSprint {
    private final RepositorioSprint repositorioSprint;
    public ServicioAplicacionListarSprint(RepositorioSprint repositorioSprint) {
        this.repositorioSprint = repositorioSprint;
    }

    public List<DtoSprintResumen> ejecutar(){return this.repositorioSprint.listar();}

    public Sprint consultarById(Long id){return this.repositorioSprint.consultarPorId(id);}
    public List<DtoSprintResumen> consultarByIdProyecto(Long id){return this.repositorioSprint.consultarPorIdProyecto(id);}
}
