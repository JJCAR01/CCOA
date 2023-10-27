package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.InformacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.EEstado;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.ETipoASE;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.adaptador.entidad.EntidadInformacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.adaptador.entidad.EntidadTarea;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.adaptador.repositorio.jpa.RepositorioTareaJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MapeadorInformacionActividadGestionActividadEstrategica implements MapeadorInfraestructura<EntidadInformacionActividadGestionActividadEstrategica,
        InformacionActividadGestionActividadEstrategica> {

    private final RepositorioTareaJpa repositorioTareaJpa;

    public MapeadorInformacionActividadGestionActividadEstrategica(RepositorioTareaJpa repositorioTareaJpa) {
        this.repositorioTareaJpa = repositorioTareaJpa;
    }

    @Override
    public InformacionActividadGestionActividadEstrategica mapeadorDominio(EntidadInformacionActividadGestionActividadEstrategica entidad) {
        return new InformacionActividadGestionActividadEstrategica(entidad.getIdInformacionActividadActividadEstrategica(), entidad.getFechaRegistro(), entidad.getDuracion(), entidad.getDiasRestantes(),entidad.getAvance());
    }

    @Override
    public EntidadInformacionActividadGestionActividadEstrategica mapeadorEntidad(InformacionActividadGestionActividadEstrategica dominio) {
        return new EntidadInformacionActividadGestionActividadEstrategica(dominio.getFechaRegistro(),dominio.getDuracion(),dominio.getDiasRestantes(),dominio.getAvance());
    }
    public void actualizarPorcentajeAvance(EntidadInformacionActividadGestionActividadEstrategica entidad, InformacionActividadGestionActividadEstrategica actividadGestionActividadEstrategicaactividadGestion) {
        List<EntidadTarea> actividades = this.repositorioTareaJpa.findByIdASEAndTipoASE(actividadGestionActividadEstrategicaactividadGestion.getIdInformacionActividad(),
                ETipoASE.ACTIVIDAD_GESTION_ACTIVIDAD_ESTRATEGICA);
        long totalActividades = actividades.size();
        long tareasTerminadas = actividades.stream().filter(tarea -> tarea.getEstado() == EEstado.TERMINADO).count();

        if (totalActividades > 0) {
            int nuevoAvance = (int) ((tareasTerminadas * 100) / totalActividades);
            entidad.setAvance((double) nuevoAvance);
        }
    }
}
