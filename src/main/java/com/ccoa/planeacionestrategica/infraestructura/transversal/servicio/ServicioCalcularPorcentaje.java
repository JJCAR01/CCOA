package com.ccoa.planeacionestrategica.infraestructura.transversal.servicio;

import com.ccoa.planeacionestrategica.dominio.transversal.enums.EPeriodicidad;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentaje;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.entidad.EntidadInformacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    public double calcularPorcentajeMeta(Double meta, Double resultadoMeta) {
        return resultadoMeta >= 0 ? (resultadoMeta/meta) * Mensaje.PORCENTAJE : Mensaje.PORCENTAJE_CERO;
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
        if(fechaInicial.isBefore(fechaActual)) {
            long diasTranscurridos = ChronoUnit.DAYS.between(fechaInicial, fechaActual);
            return (diasTranscurridos * Mensaje.PORCENTAJE) / totalDias;
        } else {
            return Mensaje.PORCENTAJE_CERO;
        }
    }

    @Override
    public double obtenerPorcentajeDeCumplimiento(double porcentajeReal, double porcentajeEsperado) {
        return !(porcentajeReal == Mensaje.PORCENTAJE_CERO || porcentajeEsperado == Mensaje.PORCENTAJE_CERO) ?
                (porcentajeReal/porcentajeEsperado)* Mensaje.PORCENTAJE : Mensaje.PORCENTAJE_CERO;
    }
}
