package com.ccoa.planeacionestrategica.dominio.servicio.proyecto.observacion;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.observacion.ObservacionProyecto;
import com.ccoa.planeacionestrategica.dominio.puerto.proyecto.RepositorioObservacionProyecto;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarObservacionProyecto {

    private final RepositorioObservacionProyecto repositorioObservacionProyecto;

    public ServicioGuardarObservacionProyecto(RepositorioObservacionProyecto repositorioObservacionProyecto) {
        this.repositorioObservacionProyecto = repositorioObservacionProyecto;
    }

    public Long ejecutarGuardar(ObservacionProyecto observacionProyecto){
        return this.repositorioObservacionProyecto.guardar(observacionProyecto);
    }
}
