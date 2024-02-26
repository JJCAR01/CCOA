package com.ccoa.planeacionestrategica.dominio.modelo.usuario;

import com.ccoa.planeacionestrategica.dominio.modelo.direccion.Direccion;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;
import java.util.List;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.LA_DIRECCION_NO_PUEDE_ESTAR_VACIA;

@Data
public class    InformacionUsuario {
    private final Long idInformacionUsuario;
    private final List<Direccion> direcciones;
    private final List<PatUsuario> pats;

    public static InformacionUsuario of(Long idInformacionUsuario, List<Direccion> direcciones, List<PatUsuario> pats ){
        ValidadorDominio.validarObligatorio(direcciones,LA_DIRECCION_NO_PUEDE_ESTAR_VACIA);
        return new InformacionUsuario(idInformacionUsuario, direcciones,pats);
    }
    public static InformacionUsuario pats(Long idInformacionUsuario, List<Direccion> direcciones, List<PatUsuario> pats ){
        return new InformacionUsuario(idInformacionUsuario, direcciones,pats);
    }

    public InformacionUsuario(Long idInformacionUsuario, List<Direccion> direcciones, List<PatUsuario> pats) {
        this.idInformacionUsuario = idInformacionUsuario;
        this.direcciones = direcciones;
        this.pats = pats;
    }
}
