package com.ccoa.planeacionestrategica.dominio.servicio.tipoactividad;

import com.ccoa.planeacionestrategica.dominio.modelo.TipoActividad;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoContrato;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoActividad;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoContrato;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarTipoActvidad {

    private static final String MENSAJE_YA_EXISTE = "Ya existe el Tipo de Actividad con los datos ingresados";

    private final RepositorioTipoActividad repositorioTipoActividad;

    public ServicioGuardarTipoActvidad(RepositorioTipoActividad repositorioTipoActividad) {
        this.repositorioTipoActividad = repositorioTipoActividad;
    }

    public Long ejecutarGuardar(TipoActividad tipoActividad){

        if(this.repositorioTipoActividad.existe(tipoActividad)) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioTipoActividad.guardar(tipoActividad);}
}
