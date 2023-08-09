package com.ccoa.planeacionestrategica.aplicacion.servicio.tipoactividad;

import com.ccoa.planeacionestrategica.dominio.modelo.RubroIngreso;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoActividad;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroIngreso;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoActividad;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarTipoActividad {

    private final RepositorioTipoActividad repositorioTipoActividad;

    public ServicioAplicacionListarTipoActividad(RepositorioTipoActividad repositorioTipoActividad) {
        this.repositorioTipoActividad = repositorioTipoActividad;
    }

    public List<TipoActividad> ejecutar(){return this.repositorioTipoActividad.listar();}

    public TipoActividad consultarById(Long id){return this.repositorioTipoActividad.consultarPorId(id);}
}
