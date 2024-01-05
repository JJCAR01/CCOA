package com.ccoa.planeacionestrategica.dominio.modelo.pat;

import com.ccoa.planeacionestrategica.dominio.modelo.area.enums.EDireccion;
import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad.EntidadDireccion;
import lombok.Getter;


import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;

@Getter
public class InformacionPat {

    private final Long idInformacionPat;
    private final EDireccion direccion;

    public static InformacionPat of(Long idInformacionPat,EDireccion direccion ){
        ValidadorDominio.validarObligatorio(direccion,LA_DIRECCION_NO_PUEDE_ESTAR_VACIA);
        return new InformacionPat(idInformacionPat, direccion);
    }

    public InformacionPat(Long idInformacionPat, EDireccion direccion) {
        this.idInformacionPat = idInformacionPat;
        this.direccion = direccion;
    }
}
