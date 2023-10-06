package com.ccoa.planeacionestrategica.aplicacion.servicio.actividad.servicio;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividad.Actividad;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividad;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ServicioAplicacionListarActividad {
    private final RepositorioActividad repositorioActividad;

    public ServicioAplicacionListarActividad(RepositorioActividad repositorioActividad) {
        this.repositorioActividad = repositorioActividad;
    }

    public List<DtoActividadResumen> ejecutar(){return this.repositorioActividad.listar();}

    public Actividad consultarById(Long id){return this.repositorioActividad.consultarPorId(id);}

    public List<Actividad> consultarByIdGestion(Long id){return this.repositorioActividad.consultarPorIdGestion(id);}
    public List<Actividad> consultarByIdEpica(Long id){return this.repositorioActividad.consultarPorIdEpica(id);}

}
