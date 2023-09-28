package com.ccoa.planeacionestrategica.aplicacion.servicio.tarea;

import com.ccoa.planeacionestrategica.dominio.modelo.tarea.Tarea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTarea;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarTarea {

    private final RepositorioTarea repositorioTarea;

    public ServicioAplicacionListarTarea(RepositorioTarea repositorioTarea) {
        this.repositorioTarea = repositorioTarea;
    }

    public List<Tarea> ejecutar(){return this.repositorioTarea.listar();}
    public List<Tarea> ejecutarInformacion(){return this.repositorioTarea.listar();}

    public Tarea consultarById(Long id){return this.repositorioTarea.consultarPorId(id);}
}
