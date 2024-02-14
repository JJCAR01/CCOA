package com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.servicio.observacion;


import com.ccoa.planeacionestrategica.aplicacion.dto.proyectoarea.DtoObservacionProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.observacion.ObservacionProyectoArea;
import com.ccoa.planeacionestrategica.dominio.puerto.proyectoarea.RepositorioObservacionProyectoArea;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarObservacionProyectoArea {

    private final RepositorioObservacionProyectoArea repositorioObservacionProyectoArea;

    public ServicioAplicacionListarObservacionProyectoArea(RepositorioObservacionProyectoArea repositorioObservacionProyectoArea) {
        this.repositorioObservacionProyectoArea = repositorioObservacionProyectoArea;
    }

    public List<DtoObservacionProyectoArea> ejecutar(){return this.repositorioObservacionProyectoArea.listar();}

    public ObservacionProyectoArea consultarById(Long id){return this.repositorioObservacionProyectoArea.consultarPorId(id);}
    public List<DtoObservacionProyectoArea> consultarPorIdProyectoArea(Long id){return this.repositorioObservacionProyectoArea.consultarPorIdProyectoArea(id);}
}
