package com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.pat.DtoObservacionPat;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.ObservacionPat;
import com.ccoa.planeacionestrategica.dominio.puerto.pat.RepositorioObservacionPat;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarObservacionPat {

    private final RepositorioObservacionPat repositorioObservacionPat;

    public ServicioAplicacionListarObservacionPat(RepositorioObservacionPat repositorioObservacionPat) {
        this.repositorioObservacionPat = repositorioObservacionPat;
    }

    public List<DtoObservacionPat> ejecutar(){return this.repositorioObservacionPat.listar();}
    public ObservacionPat consultarById(Long id){return this.repositorioObservacionPat.consultarPorId(id);}
    public List<DtoObservacionPat> consultarPorIdPat(Long id){return this.repositorioObservacionPat.consultarPorIdPat(id);}
}
