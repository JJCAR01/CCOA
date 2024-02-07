package com.ccoa.planeacionestrategica.dominio.servicio.actividadgestion.observacion;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.observacion.ObservacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestion.RepositorioObservacionActividadGestion;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarObservacionActividadGestion {

    private final RepositorioObservacionActividadGestion repositorioObservacionActividadGestion;

    public ServicioGuardarObservacionActividadGestion(RepositorioObservacionActividadGestion repositorioObservacionActividadGestion) {
        this.repositorioObservacionActividadGestion = repositorioObservacionActividadGestion;
    }

    public Long ejecutarGuardar(ObservacionActividadGestion observacionActividadGestion){
        return this.repositorioObservacionActividadGestion.guardar(observacionActividadGestion);
    }
}
