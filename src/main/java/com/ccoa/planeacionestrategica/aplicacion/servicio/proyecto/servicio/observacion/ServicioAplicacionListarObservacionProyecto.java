package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoObservacionProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.ObservacionProyecto;
import com.ccoa.planeacionestrategica.dominio.puerto.proyecto.RepositorioObservacionProyecto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarObservacionProyecto {

    private final RepositorioObservacionProyecto repositorioObservacionProyecto;

    public ServicioAplicacionListarObservacionProyecto(RepositorioObservacionProyecto repositorioObservacionProyecto) {
        this.repositorioObservacionProyecto = repositorioObservacionProyecto;
    }

    public List<DtoObservacionProyecto> ejecutar(){return this.repositorioObservacionProyecto.listar();}

    public ObservacionProyecto consultarById(Long id){return this.repositorioObservacionProyecto.consultarPorId(id);}
    public List<DtoObservacionProyecto> consultarPorIdProyecto(Long id){return this.repositorioObservacionProyecto.consultarPorIdProyecto(id);}
}
