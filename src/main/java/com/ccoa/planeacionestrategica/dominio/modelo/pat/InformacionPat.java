package com.ccoa.planeacionestrategica.dominio.modelo.pat;

import com.ccoa.planeacionestrategica.dominio.modelo.direccion.Direccion;
import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;


import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;

@Getter
public class InformacionPat {

    private final Long idInformacionPat;
    private final Direccion direccion;

    public static InformacionPat of(Long idInformacionPat,Direccion direccion ){
        ValidadorDominio.validarObligatorio(direccion,LA_DIRECCION_NO_PUEDE_ESTAR_VACIA);
        return new InformacionPat(idInformacionPat, direccion);
    }

    public InformacionPat(Long idInformacionPat, Direccion direccion) {
        this.idInformacionPat = idInformacionPat;
        this.direccion = direccion;
    }
}
