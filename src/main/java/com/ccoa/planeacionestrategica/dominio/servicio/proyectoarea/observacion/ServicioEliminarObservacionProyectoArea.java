package com.ccoa.planeacionestrategica.dominio.servicio.proyectoarea.observacion;

import com.ccoa.planeacionestrategica.dominio.puerto.proyectoarea.RepositorioObservacionProyectoArea;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorObligatorio;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_OBSERVACION_DEL_PROYECTO_DEL_AREA_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarObservacionProyectoArea {

    private final RepositorioObservacionProyectoArea repositorioObservacionProyectoArea;

    public ServicioEliminarObservacionProyectoArea(RepositorioObservacionProyectoArea repositorioObservacionProyectoArea) {
        this.repositorioObservacionProyectoArea = repositorioObservacionProyectoArea;
    }
    public Long ejecutarEliminar(Long id){
        if(this.repositorioObservacionProyectoArea.consultarPorId(id)== null) throw new
                ExcepcionValidadorObligatorio(NO_EXISTE_LA_OBSERVACION_DEL_PROYECTO_DEL_AREA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioObservacionProyectoArea.eliminar(id);
    }
}
