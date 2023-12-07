package com.ccoa.planeacionestrategica.dominio.servicio.pat;

import com.ccoa.planeacionestrategica.dominio.modelo.pat.Pat;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioPat;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.YA_EXISTE_EL_PAT_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioGuardarPat {
    private final RepositorioPat repositorioPat;

    public ServicioGuardarPat(RepositorioPat repositorioPat) {
        this.repositorioPat = repositorioPat;
    }

    public Long ejecutarGuardar(Pat pat) {

        if(this.repositorioPat.existe(pat)) throw new ValorInvalidoExcepcion(YA_EXISTE_EL_PAT_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioPat.guardar(pat);
    }
}
