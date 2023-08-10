package com.ccoa.planeacionestrategica.dominio.servicio.ejecutado;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.Ejecutado;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioEjecutado;
import org.springframework.stereotype.Service;

@Service
public class ServicioModificarEjecutado {

    private static final String MENSAJE_NO_EXISTE = "No existe el Ejecutado con los datos ingresados";

    private final RepositorioEjecutado repositorioEjecutado;

    public ServicioModificarEjecutado(RepositorioEjecutado repositorioEjecutado) {
        this.repositorioEjecutado = repositorioEjecutado;
    }

    public Long ejecutarModificar(Ejecutado ejecutado, Long codigo){

        if(this.repositorioEjecutado.consultarPorId(codigo)==null) throw new IllegalStateException(MENSAJE_NO_EXISTE);

        return this.repositorioEjecutado.modificar(ejecutado,codigo);
    }
}
