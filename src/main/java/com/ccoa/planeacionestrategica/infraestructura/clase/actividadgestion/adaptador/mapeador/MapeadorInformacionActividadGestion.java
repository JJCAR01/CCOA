package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.InformacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.EEstado;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.ETipoASE;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.entidad.EntidadInformacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.mapeador.MapeadorPat;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.adaptador.entidad.EntidadTarea;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.adaptador.repositorio.jpa.RepositorioTareaJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MapeadorInformacionActividadGestion implements MapeadorInfraestructura<EntidadInformacionActividadGestion, InformacionActividadGestion> {
    private final RepositorioTareaJpa repositorioTareaJpa;
    private final MapeadorPat mapeadorPat;
    private final MapeadorActividadGestion mapeadorActividadGestion;

    public MapeadorInformacionActividadGestion(RepositorioTareaJpa repositorioTareaJpa, MapeadorPat mapeadorPat, MapeadorActividadGestion mapeadorActividadGestion) {
        this.repositorioTareaJpa = repositorioTareaJpa;
        this.mapeadorPat = mapeadorPat;
        this.mapeadorActividadGestion = mapeadorActividadGestion;
    }

    @Override
    public InformacionActividadGestion mapeadorDominio(EntidadInformacionActividadGestion entidad) {
        return new InformacionActividadGestion(entidad.getIdInformacionActividadGestion(), entidad.getFechaRegistro(), entidad.getDuracion(), entidad.getDiasRestantes(),entidad.getAvance());
    }

    @Override
    public EntidadInformacionActividadGestion mapeadorEntidad(InformacionActividadGestion dominio) {
        return new EntidadInformacionActividadGestion(dominio.getFechaRegistro(),dominio.getDuracion(),dominio.getDiasRestantes(), dominio.getAvance());
    }

    public void actualizarPorcentajeAvance(EntidadInformacionActividadGestion entidad, InformacionActividadGestion actividadGestion) {
        List<EntidadTarea> actividades = this.repositorioTareaJpa.findByIdASEAndTipoASE(actividadGestion.getIdInformacionActividad(), ETipoASE.ACTIVIDAD_GESTION);
        long totalActividades = actividades.size();
        long tareasTerminadas = actividades.stream().filter(tarea -> tarea.getEstado() == EEstado.TERMINADO).count();

        if (totalActividades > 0) {
            int nuevoAvance = (int) ((tareasTerminadas * 100) / totalActividades);
            entidad.setAvance((double) nuevoAvance);
            mapeadorPat.actualizarPorcentajeAvance(mapeadorActividadGestion.obtenerGestion(entidad));
        }
    }
}
