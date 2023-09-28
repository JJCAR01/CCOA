package com.ccoa.planeacionestrategica.dominio.servicio.tarea;

import com.ccoa.planeacionestrategica.dominio.modelo.tarea.InformacionTarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.Tarea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTarea;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioGuardarTarea {

    private static final String MENSAJE_YA_EXISTE = "Ya existe el Programa con los datos ingresados";

    private final RepositorioTarea repositorioTarea;

    public ServicioGuardarTarea(RepositorioTarea repositorioTarea) {
        this.repositorioTarea = repositorioTarea;
    }

    public Long ejecutarGuardar(Tarea tarea, InformacionTarea informacionTarea){

        if(this.repositorioTarea.existe(tarea,informacionTarea)) throw new ValorInvalidoExcepcion(MENSAJE_YA_EXISTE,MENSAJE_DEFECTO);

        return this.repositorioTarea.guardar(tarea,informacionTarea);
    }


}
