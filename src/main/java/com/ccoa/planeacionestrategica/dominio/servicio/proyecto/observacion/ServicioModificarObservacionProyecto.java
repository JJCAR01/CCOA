package com.ccoa.planeacionestrategica.dominio.servicio.proyecto.observacion;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.observacion.ObservacionProyecto;
import com.ccoa.planeacionestrategica.dominio.puerto.proyecto.RepositorioObservacionProyecto;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_OBSERVACION_DEL_PROYECTO_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioModificarObservacionProyecto {
    private final RepositorioObservacionProyecto repositorioObservacionProyecto;

    public ServicioModificarObservacionProyecto(RepositorioObservacionProyecto repositorioObservacionProyecto) {
        this.repositorioObservacionProyecto = repositorioObservacionProyecto;
    }
    public Long ejecutarModificar(ObservacionProyecto observacionProyecto, Long codigo){
        if(this.repositorioObservacionProyecto.consultarPorId(codigo)==null) throw new
                ExcepcionValidadorInvalido(NO_EXISTE_LA_OBSERVACION_DEL_PROYECTO_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioObservacionProyecto.modificar(observacionProyecto,codigo);
    }


}
