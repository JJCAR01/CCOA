package com.ccoa.planeacionestrategica.dominio.servicio.pat.observacion;

import com.ccoa.planeacionestrategica.dominio.modelo.pat.ObservacionPat;
import com.ccoa.planeacionestrategica.dominio.puerto.pat.RepositorioObservacionPat;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarObservacionPat {

    private final RepositorioObservacionPat repositorioObservacionPat;

    public ServicioGuardarObservacionPat(RepositorioObservacionPat repositorioObservacionPat) {
        this.repositorioObservacionPat = repositorioObservacionPat;
    }
    public Long ejecutarGuardar(ObservacionPat observacionPat){
        return this.repositorioObservacionPat.guardar(observacionPat);
    }
}
