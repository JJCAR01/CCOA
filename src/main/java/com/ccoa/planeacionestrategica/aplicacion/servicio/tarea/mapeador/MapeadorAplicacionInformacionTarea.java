package com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoTarea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.InformacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDuracionDias;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularPorcentaje;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionInformacionTarea implements MapeadorAplicacion<DtoTarea, InformacionTarea> {


    @Override
    public InformacionTarea mapeadorAplicacion(DtoTarea dto) {
        return InformacionTarea.of(dto.getPeriodicidad(), Mensaje.POR_DEFECTO_AVANCE,Mensaje.POR_DEFECTO_AVANCE,
                Mensaje.POR_DEFECTO_AVANCE);
    }

    public InformacionTarea actualizarEstado(DtoTarea dto) {
        return new InformacionTarea(dto.getPeriodicidad(), Mensaje.POR_DEFECTO_AVANCE,Mensaje.POR_DEFECTO_AVANCE,
                Mensaje.POR_DEFECTO_AVANCE);
    }
    public InformacionTarea actualizarPorcentaje(DtoTarea dto) {
        return new InformacionTarea(dto.getPeriodicidad(), dto.getPorcentajeReal(), Mensaje.POR_DEFECTO_AVANCE,
                Mensaje.POR_DEFECTO_AVANCE);
    }
}
