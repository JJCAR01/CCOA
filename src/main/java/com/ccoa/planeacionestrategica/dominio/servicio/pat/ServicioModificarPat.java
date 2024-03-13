package com.ccoa.planeacionestrategica.dominio.servicio.pat;

import com.ccoa.planeacionestrategica.dominio.modelo.pat.InformacionPat;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.Pat;
import com.ccoa.planeacionestrategica.dominio.puerto.pat.RepositorioPat;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_EL_PAT_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioModificarPat {
    private final RepositorioPat repositorioPat;

    public ServicioModificarPat(RepositorioPat repositorioPat) {
        this.repositorioPat = repositorioPat;
    }

    public Long ejecutarModificar(Pat pat, InformacionPat informacionPat ,Long codigo){

        if(this.repositorioPat.consultarPorId(codigo)==null) throw new ExcepcionValidadorInvalido(NO_EXISTE_EL_PAT_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioPat.modificar(pat,informacionPat,codigo);
    }


}
