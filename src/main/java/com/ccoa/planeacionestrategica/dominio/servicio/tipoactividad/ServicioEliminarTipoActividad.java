package com.ccoa.planeacionestrategica.dominio.servicio.tipoactividad;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroGasto;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoActividad;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarTipoActividad {

    private static final String MENSAJE_YA_EXISTE = "No existe el Tipo de Actividad con los datos ingresados";

    private final RepositorioTipoActividad repositorioTipoActividad;

    public ServicioEliminarTipoActividad(RepositorioTipoActividad repositorioTipoActividad) {
        this.repositorioTipoActividad = repositorioTipoActividad;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioTipoActividad.consultarPorId(id)== null) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioTipoActividad.eliminar(id);
    }
}
