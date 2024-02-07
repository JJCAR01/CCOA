package com.ccoa.planeacionestrategica.dominio.transversal.servicio;


import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.entidad.EntidadInformacionTarea;

import java.util.List;

public interface ServicioObtenerPorcentajeAvance {

    double calcularPorcentaje(List<?> objecto);
    double obtenerPorcentajesDiferentesATareasUnicaVez(List<EntidadInformacionTarea> informacionTareas, long tareasTerminadas, long totalTareas);
    double obtenerNuevoAvance(long tareasTerminadas,double tareasDiferentesAUnicaVez, long totalTareas);
}
