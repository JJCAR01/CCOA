package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.observacion.ObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadestrategica.RepositorioObservacionActividadEstrategica;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarObservacionActividadEstrategica {

    private final RepositorioObservacionActividadEstrategica repositorioObservacionActividadEstrategica;

    public ServicioAplicacionListarObservacionActividadEstrategica(RepositorioObservacionActividadEstrategica repositorioObservacionActividadEstrategica) {
        this.repositorioObservacionActividadEstrategica = repositorioObservacionActividadEstrategica;
    }

    public List<DtoObservacionActividadEstrategica> ejecutar(){return this.repositorioObservacionActividadEstrategica.listar();}
    public ObservacionActividadEstrategica consultarById(Long id){return this.repositorioObservacionActividadEstrategica.consultarPorId(id);}
    public List<DtoObservacionActividadEstrategica> consultarPorIdActividadEstrategica(Long id){return this.repositorioObservacionActividadEstrategica.consultarPorIdActividadEstrategica(id);}
}
