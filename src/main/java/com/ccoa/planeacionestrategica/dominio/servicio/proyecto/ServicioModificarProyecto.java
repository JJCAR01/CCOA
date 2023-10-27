package com.ccoa.planeacionestrategica.dominio.servicio.proyecto;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.Proyecto;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioProyecto;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_EL_PROYECTO_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioModificarProyecto {
    private final RepositorioProyecto repositorioProyecto;

    public ServicioModificarProyecto(RepositorioProyecto repositorioProyecto) {
        this.repositorioProyecto = repositorioProyecto;
    }

    public Long ejecutarModificar(Proyecto proyecto, InformacionProyecto informacionProyecto, Long codigo){
        if(this.repositorioProyecto.consultarPorId(codigo)==null) throw new ValorInvalidoExcepcion(NO_EXISTE_EL_PROYECTO_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioProyecto.modificar(proyecto, informacionProyecto, codigo);
    }
}
