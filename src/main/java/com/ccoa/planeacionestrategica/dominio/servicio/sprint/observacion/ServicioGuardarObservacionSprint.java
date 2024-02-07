package com.ccoa.planeacionestrategica.dominio.servicio.sprint.observacion;

import com.ccoa.planeacionestrategica.dominio.modelo.sprint.observacion.ObservacionSprint;
import com.ccoa.planeacionestrategica.dominio.puerto.tarea.RepositorioObservacionSprint;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarObservacionSprint {

    private final RepositorioObservacionSprint repositorioObservacionSprint;
    public ServicioGuardarObservacionSprint(RepositorioObservacionSprint repositorioObservacionSprint) {
        this.repositorioObservacionSprint = repositorioObservacionSprint;
    }
    public Long ejecutarGuardar(ObservacionSprint observacionSprint){
        return this.repositorioObservacionSprint.guardar(observacionSprint);
    }
}
