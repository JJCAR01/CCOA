package com.ccoa.planeacionestrategica.dominio.servicio.sprint.observacion;

import com.ccoa.planeacionestrategica.dominio.modelo.sprint.observacion.ObservacionSprint;
import com.ccoa.planeacionestrategica.dominio.puerto.sprint.RepositorioObservacionSprint;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_OBSERVACION_DEL_SPRINT_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioModificarObservacionSprint {
    private final RepositorioObservacionSprint repositorioObservacionSprint;
    public ServicioModificarObservacionSprint(RepositorioObservacionSprint repositorioObservacionSprint) {
        this.repositorioObservacionSprint = repositorioObservacionSprint;
    }
    public Long ejecutarModificar(ObservacionSprint observacionSprint, Long codigo){
        if(this.repositorioObservacionSprint.consultarPorId(codigo)==null) throw new
                ExcepcionValidadorInvalido(NO_EXISTE_LA_OBSERVACION_DEL_SPRINT_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioObservacionSprint.modificar(observacionSprint,codigo);
    }


}
