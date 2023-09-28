package com.ccoa.planeacionestrategica.dominio.servicio.tarea;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTarea;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarTarea {

    private static final String MENSAJE_YA_EXISTE = "No existe el Programa con los datos ingresados";

    private final RepositorioTarea repositorioTarea;

    public ServicioEliminarTarea(RepositorioTarea repositorioTarea) {
        this.repositorioTarea = repositorioTarea;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioTarea.consultarPorId(id)== null) throw new ValorInvalidoExcepcion(MENSAJE_YA_EXISTE,MENSAJE_DEFECTO);

        return this.repositorioTarea.eliminar(id);
    }
}
