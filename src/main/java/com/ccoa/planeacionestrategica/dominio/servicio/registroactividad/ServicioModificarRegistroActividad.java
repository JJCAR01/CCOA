package com.ccoa.planeacionestrategica.dominio.servicio.registroactividad;

import com.ccoa.planeacionestrategica.dominio.modelo.registroactividad.RegistroActividad;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRegistroActividad;
import org.springframework.stereotype.Service;

@Service
public class ServicioModificarRegistroActividad {

    private static final String MENSAJE_NO_EXISTE = "No existe el Registro de Actividades con los datos ingresados";

    private final RepositorioRegistroActividad repositorioRegistroActividad;

    public ServicioModificarRegistroActividad(RepositorioRegistroActividad repositorioRegistroActividad) {
        this.repositorioRegistroActividad = repositorioRegistroActividad;
    }

    public Long ejecutarModificar(RegistroActividad registroActividad, Long codigo){

        if(this.repositorioRegistroActividad.consultarPorId(codigo)==null) throw new IllegalStateException(MENSAJE_NO_EXISTE);

        return this.repositorioRegistroActividad.modificar(registroActividad,codigo);
    }
}