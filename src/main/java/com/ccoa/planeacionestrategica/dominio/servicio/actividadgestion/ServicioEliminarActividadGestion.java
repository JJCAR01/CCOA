package com.ccoa.planeacionestrategica.dominio.servicio.actividadgestion;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividadGestion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarActividadGestion {

    private static final String MENSAJE_YA_EXISTE = "No existe la Gestion del area con los datos ingresados";

    private final RepositorioActividadGestion repositorioActividadGestion;

    public ServicioEliminarActividadGestion(RepositorioActividadGestion repositorioActividadGestion) {
        this.repositorioActividadGestion = repositorioActividadGestion;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioActividadGestion.consultarPorId(id)== null) throw new ValorInvalidoExcepcion(MENSAJE_YA_EXISTE,MENSAJE_DEFECTO);

        return this.repositorioActividadGestion.eliminar(id);
    }
}
