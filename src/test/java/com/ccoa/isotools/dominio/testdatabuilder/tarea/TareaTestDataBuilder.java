package com.ccoa.isotools.dominio.testdatabuilder.tarea;

import com.ccoa.planeacionestrategica.dominio.modelo.tarea.Tarea;

import java.time.LocalDate;

public class TareaTestDataBuilder {
    private Long idTarea;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private LocalDate fechaRegistro;
    private Long idUsuario;
    private Long idPat;

    public TareaTestDataBuilder() {
        this.idTarea = 1L;
        this.nombre = "Tarea";
        this.fechaInicio = LocalDate.of(2023,12,12);
        this.fechaFinal = LocalDate.of(2023,12,24);
        this.fechaRegistro = LocalDate.now();
        this.idUsuario = 1L;
        this.idPat = 1L;

    }

    public TareaTestDataBuilder conIdTarea(Long idTarea) {
        this.idTarea = idTarea;
        return this;
    }
    public TareaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public TareaTestDataBuilder conIdFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
        return this;
    }
    public TareaTestDataBuilder conIdFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
        return this;
    }
    public TareaTestDataBuilder conIdFcehaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
        return this;
    }
    public TareaTestDataBuilder conIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }
    public TareaTestDataBuilder conIdPat(Long idPat) {
        this.idPat = idPat;
        return this;
    }

    public Tarea build() {
        return Tarea.of(idTarea,nombre,fechaInicio,fechaFinal,fechaRegistro,idUsuario,idPat);
    }
}
