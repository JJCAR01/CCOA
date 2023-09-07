package com.ccoa.planeacionestrategica.dominio.servicio.registroactividad;

import com.ccoa.planeacionestrategica.dominio.modelo.registroactividad.RegistroActividad;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRegistroActividad;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarRegistroActividad {

    private static final String MENSAJE_YA_EXISTE = "Ya existe el Registro de Actividad con los datos ingresados";

    private final RepositorioRegistroActividad registroActividad;

    public ServicioGuardarRegistroActividad(RepositorioRegistroActividad registroActividad) {
        this.registroActividad = registroActividad;
    }

    public Long ejecutarGuardar(RegistroActividad registroActividad){

        if(this.registroActividad.existe(registroActividad)) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.registroActividad.guardar(registroActividad);
    }
}
