package com.ccoa.planeacionestrategica.dominio.servicio.actividadgestion;

import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestion.RepositorioActividadGestion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarActividadGestion {

    private final RepositorioActividadGestion repositorioActividadGestion;

    public ServicioEliminarActividadGestion(RepositorioActividadGestion repositorioActividadGestion) {
        this.repositorioActividadGestion = repositorioActividadGestion;
    }

    public Long ejecutarEliminar(Long id){
        if(this.repositorioActividadGestion.consultarPorId(id)== null) throw new ExcepcionValidadorInvalido(NO_EXISTE_LA_ACTIVIDAD_GESTION_DEL_AREA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioActividadGestion.eliminar(id);
    }
    public void ejecutarEliminarPorPat(Long id){
        if(this.repositorioActividadGestion.consultarPorIdPatAEliminar(id)== null) throw new ExcepcionValidadorInvalido(NO_EXISTE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        this.repositorioActividadGestion.eliminarPorPat(id);
    }
    public Long eliminarDocumento(Long id){
        return this.repositorioActividadGestion.eliminarDocumento(id);
    }
}
