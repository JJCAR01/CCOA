package com.ccoa.isotools.dominio.testdatabuilder.sprint;

import com.ccoa.planeacionestrategica.dominio.modelo.sprint.DocumentoSprint;

public class DocumentoSprintTestDataBuilder {
    private final String rutaArchivo;
    public DocumentoSprintTestDataBuilder() {
        this.rutaArchivo = "ahdsvshd";
    }
    public DocumentoSprint build() {
        return DocumentoSprint.of(rutaArchivo);
    }
}
