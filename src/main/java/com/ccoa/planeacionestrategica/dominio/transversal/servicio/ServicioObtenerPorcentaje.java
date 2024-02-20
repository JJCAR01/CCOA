package com.ccoa.planeacionestrategica.dominio.transversal.servicio;


import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.entidad.EntidadInformacionTarea;

import java.time.LocalDate;
import java.util.List;

public interface ServicioObtenerPorcentaje {

    double calcularPorcentaje(List<?> objecto);
    double calcularPorcentajeMeta(Double meta,Double resultadoMeta);
    double obtenerPorcentajesDiferentesATareasUnicaVez(List<EntidadInformacionTarea> informacionTareas, long tareasTerminadas, long totalTareas);
    double obtenerNuevoAvance(long tareasTerminadas,double tareasDiferentesAUnicaVez, long totalTareas);
    double obtenerPorcentajeEsperado(LocalDate fechaInicial, long totalDias);
    double obtenerPorcentajeDeCumplimiento(double porcentajeReal, double porcentajeEsperado);
    double obtenerPorcentajePat(double porcentajeCumplimiento, double promedioMeta);
}
