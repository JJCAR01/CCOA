package com.ccoa.planeacionestrategica.dominio.modelo.registroactividad;

public class Documento {

    private final String documento;
    private final Long idRegistroActividad;

    public static Documento of(String documento, Long idRegistroActividad){

        return new Documento(documento,idRegistroActividad);
    }

    public Documento(String documento, Long idRegistroActividad) {
        this.documento = documento;
        this.idRegistroActividad = idRegistroActividad;
    }
}
