package com.ccoa.planeacionestrategica.dominio.servicio.proyecto;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioProyecto;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarProyecto {
    private static final String MENSAJE_YA_EXISTE = "No existe el proyecto con los datos ingresados";

    private final RepositorioProyecto repositorioProyecto;

    public ServicioEliminarProyecto(RepositorioProyecto repositorioProyecto) {
        this.repositorioProyecto = repositorioProyecto;
    }

    public Long ejecutarEliminar(Long id){
        if(this.repositorioProyecto.consultarPorId(id)== null) throw new ValorObligatorioExcepcion(MENSAJE_YA_EXISTE,MENSAJE_DEFECTO);
        return this.repositorioProyecto.eliminar(id);
    }
}
