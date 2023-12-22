package com.ccoa.planeacionestrategica.dominio.modelo.usuario;

import com.ccoa.planeacionestrategica.dominio.modelo.area.enums.EDireccion;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.enums.EProceso;
import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.EL_PROCESO_NO_PUEDE_ESTAR_VACIO;
import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.LA_DIRECCION_NO_PUEDE_ESTAR_VACIA;

@Getter
@Setter
public class InformacionUsuario {
    private final Long idInformacionUsuario;
    private final List<EDireccion> direcciones;
    private final List<EProceso> procesos;

    public static InformacionUsuario of(Long idInformacionUsuario, List<EDireccion> direcciones, List<EProceso> procesos ){
        ValidadorDominio.validarObligatorio(direcciones,LA_DIRECCION_NO_PUEDE_ESTAR_VACIA);
        ValidadorDominio.validarObligatorio(procesos,EL_PROCESO_NO_PUEDE_ESTAR_VACIO);
        return new InformacionUsuario(idInformacionUsuario, direcciones,procesos);
    }

    public static InformacionUsuario direcciones(Long idInformacionUsuario, List<EDireccion> direcciones, List<EProceso> procesos ){
        ValidadorDominio.validarObligatorio(direcciones,LA_DIRECCION_NO_PUEDE_ESTAR_VACIA);
        return new InformacionUsuario(idInformacionUsuario, direcciones,procesos);
    }

    public static InformacionUsuario procesos(Long idInformacionUsuario, List<EDireccion> direcciones, List<EProceso> procesos ){
        ValidadorDominio.validarObligatorio(procesos,EL_PROCESO_NO_PUEDE_ESTAR_VACIO);
        return new InformacionUsuario(idInformacionUsuario, direcciones,procesos);
    }


    public InformacionUsuario(Long idInformacionUsuario, List<EDireccion> direcciones, List<EProceso> procesos) {
        this.idInformacionUsuario = idInformacionUsuario;
        this.direcciones = direcciones;
        this.procesos = procesos;
    }
}
