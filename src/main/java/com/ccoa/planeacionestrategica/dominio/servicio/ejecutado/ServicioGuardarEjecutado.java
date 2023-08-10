package com.ccoa.planeacionestrategica.dominio.servicio.ejecutado;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.Ejecutado;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioEjecutado;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarEjecutado {

    private static final String MENSAJE_YA_EXISTE = "Ya existe el Ejecutado con los datos ingresados";

    private final RepositorioEjecutado repositorioEjecutado;

    public ServicioGuardarEjecutado(RepositorioEjecutado repositorioEjecutado) {
        this.repositorioEjecutado = repositorioEjecutado;
    }

    public Long ejecutarGuardar(Ejecutado ejecutado){

        if(this.repositorioEjecutado.existe(ejecutado)) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioEjecutado.guardar(ejecutado);
    }
}
