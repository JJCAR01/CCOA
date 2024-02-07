package com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoObservacionSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.observacion.ObservacionSprint;
import com.ccoa.planeacionestrategica.dominio.puerto.tarea.RepositorioObservacionSprint;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarObservacionSprint {

    private final RepositorioObservacionSprint repositorioObservacionSprint;

    public ServicioAplicacionListarObservacionSprint(RepositorioObservacionSprint repositorioObservacionSprint) {
        this.repositorioObservacionSprint = repositorioObservacionSprint;
    }
    public List<DtoObservacionSprint> ejecutar(){return this.repositorioObservacionSprint.listar();}

    public ObservacionSprint consultarById(Long id){return this.repositorioObservacionSprint.consultarPorId(id);}
    public List<DtoObservacionSprint> consultarPorIdSprint(Long id){return this.repositorioObservacionSprint.consultarPorIdSprint(id);}
}
