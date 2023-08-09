package com.ccoa.planeacionestrategica.dominio.servicio.tipoactividad;

import com.ccoa.planeacionestrategica.dominio.modelo.RubroGasto;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoActividad;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroGasto;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoActividad;
import org.springframework.stereotype.Service;

@Service
public class ServicioModificarTipoActividad {

    private static final String MENSAJE_NO_EXISTE = "No existe el Tipo de Actividad con los datos ingresados";

    private final RepositorioTipoActividad repositorioTipoActividad;

    public ServicioModificarTipoActividad(RepositorioTipoActividad repositorioTipoActividad) {
        this.repositorioTipoActividad = repositorioTipoActividad;
    }

    public Long ejecutarModificar(TipoActividad tipoActividad, Long codigo){

        if(this.repositorioTipoActividad.consultarPorId(codigo)==null) throw new IllegalStateException(MENSAJE_NO_EXISTE);

        return this.repositorioTipoActividad.modificar(tipoActividad,codigo);
    }
}
