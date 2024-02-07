package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionestrategica.DtoObservacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.observacion.ObservacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestionestrategica.RepositorioObservacionActividadGestionEstrategica;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarObservacionActividadGestionEstrategica {

    private final RepositorioObservacionActividadGestionEstrategica repositorioObservacionActividadGestionEstrategica;

    public ServicioAplicacionListarObservacionActividadGestionEstrategica(RepositorioObservacionActividadGestionEstrategica
                                                                                  repositorioObservacionActividadGestionEstrategica) {
        this.repositorioObservacionActividadGestionEstrategica = repositorioObservacionActividadGestionEstrategica;
    }
    public List<DtoObservacionActividadGestionEstrategica> ejecutar(){return this.repositorioObservacionActividadGestionEstrategica.listar();}
    public ObservacionActividadGestionEstrategica consultarById(Long id){return this.repositorioObservacionActividadGestionEstrategica.consultarPorId(id);}
    public List<DtoObservacionActividadGestionEstrategica> consultarPorIdActividadGestionEstrategica(Long id){return this.repositorioObservacionActividadGestionEstrategica.consultarPorIdActividadGestionEstrategica(id);}
}
