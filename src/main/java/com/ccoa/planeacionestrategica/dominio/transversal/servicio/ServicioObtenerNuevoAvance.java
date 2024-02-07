package com.ccoa.planeacionestrategica.dominio.transversal.servicio;

public interface ServicioObtenerNuevoAvance {
    double obtenerNuevoAvance(long tareasTerminadas,long tareasDiferentesAUnicaVez, long totalTareas);
}
