package com.ccoa.planeacionestrategica.dominio.servicio.proyecto;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.Proyecto;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioProyecto;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioModificarProyecto {
    private static final String MENSAJE_NO_EXISTE = "No existe el proyecto con los datos ingresados";

    private final RepositorioProyecto repositorioProyecto;

    public ServicioModificarProyecto(RepositorioProyecto repositorioProyecto) {
        this.repositorioProyecto = repositorioProyecto;
    }

    public Long ejecutarModificar(Proyecto proyecto, Long codigo){
        if(this.repositorioProyecto.consultarPorId(codigo)==null) throw new ValorInvalidoExcepcion(MENSAJE_NO_EXISTE,MENSAJE_DEFECTO);
        return this.repositorioProyecto.modificar(proyecto,codigo);
    }
}
