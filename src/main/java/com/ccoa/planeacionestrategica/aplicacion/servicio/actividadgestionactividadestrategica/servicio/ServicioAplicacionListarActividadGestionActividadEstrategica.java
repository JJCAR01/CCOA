package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.servicio;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadGestionActividadEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.ActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividadGestionActividadEstrategica;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarActividadGestionActividadEstrategica  {

    private final RepositorioActividadGestionActividadEstrategica repositorioActividadGestionActividadEstrategica;

    public ServicioAplicacionListarActividadGestionActividadEstrategica(RepositorioActividadGestionActividadEstrategica repositorioActividadGestionActividadEstrategica) {
        this.repositorioActividadGestionActividadEstrategica = repositorioActividadGestionActividadEstrategica;
    }

    public List<DtoActividadGestionActividadEstrategicaResumen> ejecutar(){return this.repositorioActividadGestionActividadEstrategica.listar();}
    public ActividadGestionActividadEstrategica consultarById(Long id){return this.repositorioActividadGestionActividadEstrategica.consultarPorId(id);}
    public List<DtoActividadGestionActividadEstrategicaResumen> consultarByIdActividadEstrategica(Long id){return this.repositorioActividadGestionActividadEstrategica.consultarPorIdActividadEstrategica(id);}
}
