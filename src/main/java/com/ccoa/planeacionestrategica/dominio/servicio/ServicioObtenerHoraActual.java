package com.ccoa.planeacionestrategica.dominio.servicio;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class ServicioObtenerHoraActual {

    public LocalDateTime ejecutar(){
        return LocalDateTime.now();
    }


}
