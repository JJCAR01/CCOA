package com.ccoa.planeacionestrategica.dominio.servicio.actividadestrategica.observacion;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.observacion.ObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadestrategica.RepositorioObservacionActividadEstrategica;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarObservacionActividadEstrategica {

    private final RepositorioObservacionActividadEstrategica repositorioObservacionActividadEstrategica;

    public ServicioGuardarObservacionActividadEstrategica(RepositorioObservacionActividadEstrategica repositorioObservacionActividadEstrategica) {
        this.repositorioObservacionActividadEstrategica = repositorioObservacionActividadEstrategica;
    }

    public Long ejecutarGuardar(ObservacionActividadEstrategica observacionActividadEstrategica){
        return this.repositorioObservacionActividadEstrategica.guardar(observacionActividadEstrategica);
    }
}
