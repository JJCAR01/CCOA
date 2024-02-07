package com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionestrategica.observacion;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.observacion.ObservacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestionestrategica.RepositorioObservacionActividadGestionEstrategica;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarObservacionActividadGestionEstrategica {

    private final RepositorioObservacionActividadGestionEstrategica repositorioObservacionActividadGestionEstrategica;
    public ServicioGuardarObservacionActividadGestionEstrategica(RepositorioObservacionActividadGestionEstrategica
                                                                         repositorioObservacionActividadGestionEstrategica) {
        this.repositorioObservacionActividadGestionEstrategica = repositorioObservacionActividadGestionEstrategica;
    }
    public Long ejecutarGuardar(ObservacionActividadGestionEstrategica observacionActividadGestionEstrategica){
        return this.repositorioObservacionActividadGestionEstrategica.guardar(observacionActividadGestionEstrategica);
    }
}
