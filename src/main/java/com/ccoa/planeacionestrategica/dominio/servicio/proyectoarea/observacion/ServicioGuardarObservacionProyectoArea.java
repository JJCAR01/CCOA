package com.ccoa.planeacionestrategica.dominio.servicio.proyectoarea.observacion;

import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.observacion.ObservacionProyectoArea;
import com.ccoa.planeacionestrategica.dominio.puerto.proyectoarea.RepositorioObservacionProyectoArea;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarObservacionProyectoArea {

    private final RepositorioObservacionProyectoArea repositorioObservacionProyectoArea;

    public ServicioGuardarObservacionProyectoArea(RepositorioObservacionProyectoArea repositorioObservacionProyectoArea) {
        this.repositorioObservacionProyectoArea = repositorioObservacionProyectoArea;
    }

    public Long ejecutarGuardar(ObservacionProyectoArea observacionProyectoArea){
        return this.repositorioObservacionProyectoArea.guardar(observacionProyectoArea);
    }
}
