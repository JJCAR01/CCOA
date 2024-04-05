package com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.tarea.InformacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.entidad.EntidadInformacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorInformacionTarea implements MapeadorInfraestructura<EntidadInformacionTarea, InformacionTarea> {
    @Override
    public InformacionTarea mapeadorDominio(EntidadInformacionTarea entidad) {
        return new InformacionTarea(entidad.getPeriodicidad(),entidad.getPorcentajeReal());
    }

    @Override
    public EntidadInformacionTarea mapeadorEntidad(InformacionTarea dominio) {
        return new  EntidadInformacionTarea( dominio.getPeriodicidad(), dominio.getPorcentajeReal());
    }
}
