package com.ccoa.planeacionestrategica.dominio.transversal.servicio;

import com.ccoa.planeacionestrategica.dominio.transversal.enums.EPlaneacionSprint;
public interface ServicioObtenerSprint {

    Integer calcular(Integer duracion, EPlaneacionSprint planeacionSprint);
}
