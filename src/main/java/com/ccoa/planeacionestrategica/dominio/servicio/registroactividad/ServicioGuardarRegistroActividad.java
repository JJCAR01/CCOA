package com.ccoa.planeacionestrategica.dominio.servicio.registroactividad;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.RegistroActividad;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRegistroActividad;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarRegistroActividad {

    private static final String MENSAJE_YA_EXISTE = "Ya existe el Registro de Actividad con los datos ingresados";

    private final RepositorioRegistroActividad repositorioRegistroActividad;

    public ServicioGuardarRegistroActividad(RepositorioRegistroActividad repositorioRegistroActividad) {
        this.repositorioRegistroActividad = repositorioRegistroActividad;
    }

    public Long ejecutarGuardar(RegistroActividad registroActividad){

        if(this.repositorioRegistroActividad.existe(registroActividad)) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioRegistroActividad.guardar(registroActividad);
    }
}
