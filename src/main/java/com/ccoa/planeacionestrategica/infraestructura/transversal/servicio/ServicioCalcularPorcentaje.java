package com.ccoa.planeacionestrategica.infraestructura.transversal.servicio;

import com.ccoa.planeacionestrategica.dominio.transversal.enums.EPeriodicidad;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentaje;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.entidad.EntidadInformacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Component
public class ServicioCalcularPorcentaje implements ServicioObtenerPorcentaje {
    @Override
    public double calcularPorcentaje(List<?> objecto) {
        int total = objecto.size();
        if (total > 0) {
            return (total / 100.0) * 100.0; // Suponiendo que 1000 es el número base
        } else {
            return 0.0;
        }
    }

    @Override
    public double obtenerPorcentajesDiferentesATareasUnicaVez(List<EntidadInformacionTarea> informacionTareas, long tareasTerminadas, long totalTareas) {
        double porcentajeDiferenteAUnicaVez = 0;

        for (EntidadInformacionTarea informacionTarea : informacionTareas) {
            if(EPeriodicidad.UNICA_VEZ != informacionTarea.getPeriodicidad() && (informacionTarea.getPorcentajeReal() != Mensaje.PORCENTAJE)) {
                porcentajeDiferenteAUnicaVez += informacionTarea.getPorcentajeReal();
            }
        }
        return porcentajeDiferenteAUnicaVez;
    }

    @Override
    public double obtenerNuevoAvance(long tareasTerminadas, double tareasDiferentesAUnicaVez, long totalTareas) {
        return (((tareasTerminadas * 100) + tareasDiferentesAUnicaVez) / totalTareas);
    }

    @Override
    public double obtenerPorcentajeEsperado(LocalDate fechaInicial,long totalDias) {
        LocalDate fechaActual = LocalDate.now();
        long diasTranscurridos = fechaInicial.until(fechaActual).getDays(); // Calcula el valor de I4

        return (diasTranscurridos * Mensaje.PORCENTAJE) / totalDias;
    }
}
