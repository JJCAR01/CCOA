package com.ccoa.planeacionestrategica.dominio.transversal.formateador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormateadorHora {

    public static final String DD_MM_YYYY = "yyyy/MM/dd";
    public static final String YYYY = "yyyy";

    public FormateadorHora() {
    }

    public static LocalDate obtenerFechaTexto(LocalDate fecha) {
        DateTimeFormatter patron = DateTimeFormatter.ofPattern(DD_MM_YYYY);
        String fechaFormateada = fecha.format(patron);

        return LocalDate.parse(fechaFormateada, patron);
    }

    public static int obtenerFechaAnual(LocalDate fecha) {
        return fecha.getYear();
    }

}
