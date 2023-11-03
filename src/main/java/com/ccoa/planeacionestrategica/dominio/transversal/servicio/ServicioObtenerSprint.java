package com.ccoa.planeacionestrategica.dominio.transversal.servicio;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.enums.EPlaneacionSprint;
public interface ServicioObtenerSprint {

    Integer calcular(Integer duracion, EPlaneacionSprint planeacionSprint);
}
