package com.ccoa.planeacionestrategica.aplicacion.servicio.area.servicio;

import com.ccoa.planeacionestrategica.dominio.modelo.area.Area;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarArea {

    private final RepositorioArea repositorioArea;

    public ServicioAplicacionListarArea(RepositorioArea repositorioArea) {
        this.repositorioArea = repositorioArea;
    }

    public List<Area> ejecutar(){return this.repositorioArea.listar();}

    public Area consultarById(Long id){return this.repositorioArea.consultarPorId(id);}
}
