package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividadEstrategica;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarActividadEstrategica {

    private final RepositorioActividadEstrategica repositorioActividadEstrategica;

    public ServicioAplicacionListarActividadEstrategica(RepositorioActividadEstrategica repositorioActividadEstrategica) {
        this.repositorioActividadEstrategica = repositorioActividadEstrategica;
    }

    public List<DtoActividadEstrategicaResumen> ejecutar(){return this.repositorioActividadEstrategica.listar();}

    public DtoActividadEstrategicaResumen consultarById(Long id){return this.repositorioActividadEstrategica.consultarPorId(id);}

    public List<DtoActividadEstrategicaResumen> consultarByIdpat(Long id){return this.repositorioActividadEstrategica.consultarPorIdPat(id);}
}
