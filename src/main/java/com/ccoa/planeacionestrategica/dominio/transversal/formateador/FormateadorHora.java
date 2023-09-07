package com.ccoa.planeacionestrategica.dominio.transversal.formateador;

import org.springframework.cglib.core.Local;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FormateadorHora {

    public static final String DD_MM_YYYY = "yyyy/MM/dd";
    public static final String DD_MM_YYYY_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";

    public FormateadorHora() {
    }

    public static LocalDate obtenerFechaTexto(LocalDate fecha) {
        DateTimeFormatter patron = DateTimeFormatter.ofPattern(DD_MM_YYYY);
        String fechaFormateada = fecha.format(patron);

        return LocalDate.parse(fechaFormateada, patron);
    }

}
