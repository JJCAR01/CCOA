package com.ccoa.planeacionestrategica.dominio.servicio.ejecutado;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioEjecutado;
import org.springframework.stereotype.Service;
@Service
public class ServicioEliminarEjecutado {

    private static final String MENSAJE_YA_EXISTE = "No existe el Ejecutado con los datos ingresados";

    private final RepositorioEjecutado repositorioEjecutado;

    public ServicioEliminarEjecutado(RepositorioEjecutado repositorioEjecutado) {
        this.repositorioEjecutado = repositorioEjecutado;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioEjecutado.consultarPorId(id)== null) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioEjecutado.eliminar(id);
    }
}
