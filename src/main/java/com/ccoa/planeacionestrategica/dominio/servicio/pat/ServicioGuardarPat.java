package com.ccoa.planeacionestrategica.dominio.servicio.pat;

import com.ccoa.planeacionestrategica.dominio.modelo.pat.DetallePat;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.InformacionPat;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.Pat;
import com.ccoa.planeacionestrategica.dominio.puerto.pat.RepositorioDuplicar;
import com.ccoa.planeacionestrategica.dominio.puerto.pat.RepositorioPat;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.YA_EXISTE_EL_PAT_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioGuardarPat {
    private final RepositorioPat repositorioPat;
    private final RepositorioDuplicar repositorioDuplicar;

    public ServicioGuardarPat(RepositorioPat repositorioPat, RepositorioDuplicar repositorioDuplicar) {
        this.repositorioPat = repositorioPat;
        this.repositorioDuplicar = repositorioDuplicar;
    }

    public Long ejecutarGuardar(Pat pat, InformacionPat informacionPat, DetallePat detallePat)  {
        if(this.repositorioPat.existe(pat)) throw new ExcepcionValidadorInvalido(YA_EXISTE_EL_PAT_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioPat.guardar(pat,informacionPat,detallePat );
    }
    public Long guardarDuplicado(Pat pat, InformacionPat informacionPat,DetallePat detallePat, long codigo)  {
        return this.repositorioDuplicar.guardarDuplicado(pat,informacionPat, detallePat, codigo);
    }
}
