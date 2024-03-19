package com.ccoa.planeacionestrategica.dominio.servicio.pat.observacion;

import com.ccoa.planeacionestrategica.dominio.modelo.pat.observacion.ObservacionPat;
import com.ccoa.planeacionestrategica.dominio.puerto.pat.RepositorioObservacionPat;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_EL_PAT_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioModificarObservacionPat {
    private final RepositorioObservacionPat repositorioObservacionPat;

    public ServicioModificarObservacionPat(RepositorioObservacionPat repositorioObservacionPat) {
        this.repositorioObservacionPat = repositorioObservacionPat;
    }
    public Long ejecutarModificar(ObservacionPat observacionPat, Long codigo){

        if(this.repositorioObservacionPat.consultarPorId(codigo)==null) throw new ExcepcionValidadorInvalido(NO_EXISTE_EL_PAT_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioObservacionPat.modificar(observacionPat,codigo);
    }


}
