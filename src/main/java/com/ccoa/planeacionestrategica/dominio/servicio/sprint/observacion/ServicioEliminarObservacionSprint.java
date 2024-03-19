package com.ccoa.planeacionestrategica.dominio.servicio.sprint.observacion;

import com.ccoa.planeacionestrategica.dominio.puerto.sprint.RepositorioObservacionSprint;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorObligatorio;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_OBSERVACION_DEL_SPRINT_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarObservacionSprint {

    private final RepositorioObservacionSprint repositorioObservacionSprint;

    public ServicioEliminarObservacionSprint(RepositorioObservacionSprint repositorioObservacionSprint) {
        this.repositorioObservacionSprint = repositorioObservacionSprint;
    }

    public Long ejecutarEliminar(Long id){
        if(this.repositorioObservacionSprint.consultarPorId(id)== null) throw new ExcepcionValidadorObligatorio(NO_EXISTE_LA_OBSERVACION_DEL_SPRINT_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioObservacionSprint.eliminar(id);
    }
}
