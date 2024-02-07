package com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionactividadestrategica.observacion;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.observacion.ObservacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestionactividadestrategica.RepositorioObservacionActividadGestionActividadEstrategica;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarObservacionActividadGestionActividadEstrategica {

    private final RepositorioObservacionActividadGestionActividadEstrategica repositorioObservacionActividadGestionActividadEstrategica;
    public ServicioGuardarObservacionActividadGestionActividadEstrategica(RepositorioObservacionActividadGestionActividadEstrategica
                                                                                  repositorioObservacionActividadGestionActividadEstrategica) {
        this.repositorioObservacionActividadGestionActividadEstrategica = repositorioObservacionActividadGestionActividadEstrategica;
    }
    public Long ejecutarGuardar(ObservacionActividadGestionActividadEstrategica observacionActividadGestionActividadEstrategica){
        return this.repositorioObservacionActividadGestionActividadEstrategica.guardar(observacionActividadGestionActividadEstrategica);
    }
}
