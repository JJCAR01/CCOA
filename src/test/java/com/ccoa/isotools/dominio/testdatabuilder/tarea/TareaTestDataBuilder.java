package com.ccoa.isotools.dominio.testdatabuilder.tarea;

import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.EEstado;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.ETipoASE;
public class TareaTestDataBuilder {
    private final long idTarea;
    private final String nombre;
    private final EEstado estado;
    private final String observacion;
    private final ETipoASE tipoASE;
    private final long idASE;
    public TareaTestDataBuilder() {
        this.idTarea = 1;
        this.nombre = "Tarea test";
        this.estado = EEstado.TERMINADO;
        this.observacion = "En finalizacion";
        this.tipoASE = ETipoASE.SPRINT;
        this.idASE = 1;
    }
}
