package com.ccoa.planeacionestrategica.infraestructura.transversal.servicio;

import com.ccoa.planeacionestrategica.dominio.transversal.enums.EPeriodicidad;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentajeAvance;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.entidad.EntidadInformacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ServicioCalcularPorcentajeAvance implements ServicioObtenerPorcentajeAvance {
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
        /*double porcentajeDiferenteAUnicaVez = 0;

        for (EntidadInformacionTarea informacionTarea : informacionTareas) {
            if(EPeriodicidad.UNICA_VEZ != informacionTarea.getPeriodicidad() && (informacionTarea.getPorcentaje() != Mensaje.PORCENTAJE)) {
                porcentajeDiferenteAUnicaVez += informacionTarea.getPorcentaje();
            }
        }
        return porcentajeDiferenteAUnicaVez;*/
        return 0;
    }

    @Override
    public double obtenerNuevoAvance(long tareasTerminadas, double tareasDiferentesAUnicaVez, long totalTareas) {
        return (((tareasTerminadas * 100) + tareasDiferentesAUnicaVez) / totalTareas);
    }
}
