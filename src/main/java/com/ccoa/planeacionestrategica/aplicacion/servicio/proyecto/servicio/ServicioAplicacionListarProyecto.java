package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.servicio;

import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsProyecto;
import com.ccoa.planeacionestrategica.dominio.dto.DtoProyectoResumen;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioProyecto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarProyecto {
    private final RepositorioProyecto repositorioProyecto;

    public ServicioAplicacionListarProyecto(RepositorioProyecto repositorioProyecto) {
        this.repositorioProyecto = repositorioProyecto;
    }

    public List<DtoProyectoResumen> ejecutar(){return this.repositorioProyecto.listar();}

    public DtoProyectoResumen consultarById(Long id){return this.repositorioProyecto.consultarPorId(id);}
    public List<DtoProyectoResumen> consultarByIdActividadEstrategica(Long id){return this.repositorioProyecto.consultarPorIdActividadEstrategica(id);}

    public List<DtoIdsProyecto> consultarByIdActividadEstrategicaAEliminar(Long id){return this.repositorioProyecto.consultarPorIdActividadEstrategicaAEliminar(id);}
}
