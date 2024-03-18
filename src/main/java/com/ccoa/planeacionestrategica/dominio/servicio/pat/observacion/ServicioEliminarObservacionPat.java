package com.ccoa.planeacionestrategica.dominio.servicio.pat.observacion;

import com.ccoa.planeacionestrategica.dominio.puerto.pat.RepositorioObservacionPat;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorObligatorio;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_OBSERVACION_DEL_PAT_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarObservacionPat {

    private final RepositorioObservacionPat repositorioObservacionPat;

    public ServicioEliminarObservacionPat(RepositorioObservacionPat repositorioObservacionPat) {
        this.repositorioObservacionPat = repositorioObservacionPat;
    }

    public Long ejecutarEliminar(Long id){
        if(this.repositorioObservacionPat.consultarPorId(id)== null) throw new ExcepcionValidadorObligatorio(NO_EXISTE_LA_OBSERVACION_DEL_PAT_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioObservacionPat.eliminar(id);
    }
}
