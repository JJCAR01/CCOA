package com.ccoa.planeacionestrategica.dominio.servicio.proyectoarea.observacion;

import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.observacion.ObservacionProyectoArea;
import com.ccoa.planeacionestrategica.dominio.puerto.proyectoarea.RepositorioObservacionProyectoArea;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_OBSERVACION_DEL_PROYECTO_DEL_AREA_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioModificarObservacionProyectoArea {
    private final RepositorioObservacionProyectoArea repositorioObservacionProyectoArea;

    public ServicioModificarObservacionProyectoArea(RepositorioObservacionProyectoArea repositorioObservacionProyectoArea) {
        this.repositorioObservacionProyectoArea = repositorioObservacionProyectoArea;
    }
    public Long ejecutarModificar(ObservacionProyectoArea observacionProyectoArea, Long codigo){
        if(this.repositorioObservacionProyectoArea.consultarPorId(codigo)==null) throw new
                ExcepcionValidadorInvalido(NO_EXISTE_LA_OBSERVACION_DEL_PROYECTO_DEL_AREA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioObservacionProyectoArea.modificar(observacionProyectoArea,codigo);
    }


}
