package com.ccoa.planeacionestrategica.dominio.servicio.registroactividad;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRegistroActividad;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarRegistroActividad {

    private static final String MENSAJE_YA_EXISTE = "No existe el Registro de Actividad con los datos ingresados";

    private final RepositorioRegistroActividad repositorioRegistroActividad;

    public ServicioEliminarRegistroActividad(RepositorioRegistroActividad repositorioRegistroActividad) {
        this.repositorioRegistroActividad = repositorioRegistroActividad;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioRegistroActividad.consultarPorId(id)== null) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioRegistroActividad.eliminar(id);
    }
}
