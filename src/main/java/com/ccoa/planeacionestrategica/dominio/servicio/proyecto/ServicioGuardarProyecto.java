package com.ccoa.planeacionestrategica.dominio.servicio.proyecto;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.Proyecto;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioProyecto;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioGuardarProyecto {
    private static final String MENSAJE_YA_EXISTE = "Ya existe el proyecto con los datos ingresados";
    private final RepositorioProyecto repositorioProyecto;

    public ServicioGuardarProyecto(RepositorioProyecto repositorioProyecto) {
        this.repositorioProyecto = repositorioProyecto;
    }

    public Long ejecutarGuardar(Proyecto proyecto, InformacionProyecto informacionProyecto){
        if(this.repositorioProyecto.existe(proyecto)) throw new ValorInvalidoExcepcion(MENSAJE_YA_EXISTE,MENSAJE_DEFECTO);
        return this.repositorioProyecto.guardar(proyecto,informacionProyecto);
    }
}
