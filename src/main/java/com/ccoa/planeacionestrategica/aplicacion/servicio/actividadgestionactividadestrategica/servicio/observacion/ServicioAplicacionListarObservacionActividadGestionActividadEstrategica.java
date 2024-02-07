package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionactividadestrategica.DtoObservacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.observacion.ObservacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestionactividadestrategica.RepositorioObservacionActividadGestionActividadEstrategica;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarObservacionActividadGestionActividadEstrategica {

    private final RepositorioObservacionActividadGestionActividadEstrategica repositorioObservacionActividadGestionActividadEstrategica;

    public ServicioAplicacionListarObservacionActividadGestionActividadEstrategica(RepositorioObservacionActividadGestionActividadEstrategica
                                                                                           repositorioObservacionActividadGestionActividadEstrategica) {
        this.repositorioObservacionActividadGestionActividadEstrategica = repositorioObservacionActividadGestionActividadEstrategica;
    }
    public List<DtoObservacionActividadGestionActividadEstrategica> ejecutar(){return this.repositorioObservacionActividadGestionActividadEstrategica.listar();}
    public ObservacionActividadGestionActividadEstrategica consultarById(Long id){return this.repositorioObservacionActividadGestionActividadEstrategica.consultarPorId(id);}
    public List<DtoObservacionActividadGestionActividadEstrategica> consultarPorIdActividadGestionActividadEstrategica(Long id){return this.repositorioObservacionActividadGestionActividadEstrategica.consultarPorIdActividadGestionActividadEstrategica(id);}
}
