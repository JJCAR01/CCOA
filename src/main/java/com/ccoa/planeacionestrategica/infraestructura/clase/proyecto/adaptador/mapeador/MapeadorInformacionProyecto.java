package com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad.EntidadInformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;




@Configuration
public class MapeadorInformacionProyecto implements MapeadorInfraestructura<EntidadInformacionProyecto, InformacionProyecto> {

    @Override
    public InformacionProyecto mapeadorDominio(EntidadInformacionProyecto entidad) {
        return new InformacionProyecto(entidad.getId(), entidad.getFechaInicial(),entidad.getFechaFinal(), entidad.getAvance(), entidad.getDuracion(),entidad.getPlaneacionSprint(),
                entidad.getTotalSprint());
    }

    @Override
    public EntidadInformacionProyecto mapeadorEntidad(InformacionProyecto dominio) {
        return new EntidadInformacionProyecto(dominio.getFechaInicial(),dominio.getFechaFinal(), dominio.getAvance(), dominio.getDuracion(),dominio.getPlaneacionSprint(),
                dominio.getTotalSprint());
    }

    /*public void actualizarPorcentajeAvance(EntidadInformacionProyecto entidad, InformacionProyecto proyecto) {
        List<EntidadSprint> sprints = this.repositorioSprintJpa .findByIdProyecto(proyecto.getIdInformacionProyecto());
        long totalSprint = sprints.size();
        double sumaAvances = sprints.stream().mapToDouble(EntidadSprint::getAvance).sum();

        if (totalSprint > 0) {
            int porcentajaPorCadaSprint = (int) ((PORCENTAJE) / totalSprint);
            double nuevoAvance = (sumaAvances * porcentajaPorCadaSprint)/PORCENTAJE;
            entidad.setAvance(nuevoAvance);
            var entidadInformacionActividadEstrategca = obtenerActividadEstrategicaRelacionado(entidad.getId());
            if (entidadInformacionActividadEstrategca != null) {
                var informacionProyecto = obtenerActividadEstrategicaDesdeEntidadActividadEstrategica(entidadInformacionActividadEstrategca);
                //mapeadorInformacionActividadEstrategica.actualizarPorcentajeAvance(entidadInformacionActividadEstrategca, informacionProyecto);
            }
        }
    }
    public long obtenerTotalSprint(Long id){
        return this.repositorioInformacionProyectoJpa.findById(id).orElseThrow().getId();
    }

    private EntidadActividadEstrategica obtenerActividadEstrategicaRelacionado(Long id) {
        return this.repositorioActividadEstrategicaJpa.findById(id).orElse(null);
    }

    private ActividadEstrategica obtenerActividadEstrategicaDesdeEntidadActividadEstrategica(EntidadActividadEstrategica actividadEstrategica) {
        return new ActividadEstrategica(actividadEstrategica.getIdActividadEstrategica(),actividadEstrategica.getNombre(),
                actividadEstrategica.getFechaInicial(),actividadEstrategica.getFechaFinal(),
                actividadEstrategica.getFechaRegistro());
    }
    public double obtenerSumaAvance(EntidadInformacionProyecto entidadInformacionProyecto,Long id){
        var lista = this.repositorioDetalleProyectoJpa.findByIdActividadEstrategica(id);
        return lista.stream().mapToDouble(e -> e.getIdDetalleProyecto().equals(entidadInformacionProyecto.getId()) ? entidadInformacionProyecto.getAvance(): 0).sum();
    }*/
}
