package com.ccoa.planeacionestrategica.aplicacion.servicio.clasificacion.servicio;

import com.ccoa.planeacionestrategica.dominio.dto.DtoClasificacionResumen;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioClasificacion;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ServicioAplicacionListarClasificacion {

    private final RepositorioClasificacion repositorioClasificacion;

    public ServicioAplicacionListarClasificacion(RepositorioClasificacion repositorioClasificacion) {
        this.repositorioClasificacion = repositorioClasificacion;
    }

    public List<DtoClasificacionResumen> ejecutar(){return this.repositorioClasificacion.listar();}

    public DtoClasificacionResumen consultarById(Long id){return this.repositorioClasificacion.consultarPorId(id);}
}
