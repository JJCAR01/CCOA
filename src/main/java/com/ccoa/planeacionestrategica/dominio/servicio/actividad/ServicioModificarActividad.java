package com.ccoa.planeacionestrategica.dominio.servicio.actividad;

import com.ccoa.planeacionestrategica.dominio.modelo.actividad.Actividad;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividad;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioModificarActividad {
    private static final String MENSAJE_NO_EXISTE = "No existe la actividad con los datos ingresados";

    private final RepositorioActividad repositorioActividad;

    public ServicioModificarActividad(RepositorioActividad repositorioActividad) {
        this.repositorioActividad = repositorioActividad;
    }
    public Long ejecutarModificar(Actividad actividad, Long codigo){

        if(this.repositorioActividad.consultarPorId(codigo)==null) throw new ValorInvalidoExcepcion(MENSAJE_NO_EXISTE,MENSAJE_DEFECTO);

        return this.repositorioActividad.modificar(actividad,codigo);
    }
}
