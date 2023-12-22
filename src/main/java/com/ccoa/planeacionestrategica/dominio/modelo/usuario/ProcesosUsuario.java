package com.ccoa.planeacionestrategica.dominio.modelo.usuario;

import com.ccoa.planeacionestrategica.dominio.modelo.pat.enums.EProceso;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProcesosUsuario {
    private final Long idProcesoUsuario;
    private final EProceso proceso;

    public static ProcesosUsuario of(Long idProcesoUsuario, EProceso proceso) {
        return new ProcesosUsuario(idProcesoUsuario,proceso);
    }

    public ProcesosUsuario(Long idProcesoUsuario, EProceso proceso) {
        this.idProcesoUsuario = idProcesoUsuario;
        this.proceso = proceso;
    }
}
