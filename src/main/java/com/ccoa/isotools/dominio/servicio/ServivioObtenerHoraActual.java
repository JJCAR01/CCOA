package com.ccoa.isotools.dominio.servicio;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class ServivioObtenerHoraActual {

    public LocalTime ejecutar(){
        return LocalTime.now();
    }


}
