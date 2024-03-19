package com.ccoa.planeacionestrategica.dominio.servicio.proyecto.observacion;

import com.ccoa.planeacionestrategica.dominio.puerto.proyecto.RepositorioObservacionProyecto;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorObligatorio;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_OBSERVACION_DEL_PROYECTO_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarObservacionProyecto {

    private final RepositorioObservacionProyecto repositorioObservacionProyecto;

    public ServicioEliminarObservacionProyecto(RepositorioObservacionProyecto repositorioObservacionProyecto) {
        this.repositorioObservacionProyecto = repositorioObservacionProyecto;
    }
    public Long ejecutarEliminar(Long id){
        if(this.repositorioObservacionProyecto.consultarPorId(id)== null) throw new
                ExcepcionValidadorObligatorio(NO_EXISTE_LA_OBSERVACION_DEL_PROYECTO_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioObservacionProyecto.eliminar(id);
    }
}
