package com.ccoa.planeacionestrategica.dominio.servicio.transversal;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ServicioObtenerHoraActual {

    public LocalDate ejecutar(){
        return LocalDate.now();
    }


}
