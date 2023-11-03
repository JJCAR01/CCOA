package com.ccoa.planeacionestrategica.infraestructura.clase.sprint.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoSprintResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.Sprint;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.EEstado;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.ETipoASE;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObjetoExcepcion;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad.EntidadInformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.mapeador.MapeadorInformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.repositorio.jpa.RepositorioInformacionProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.repositorio.jpa.RepositorioProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.adaptador.entidad.EntidadSprint;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.adaptador.repositorio.jpa.RepositorioDocumentoSprintJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.adaptador.repositorio.jpa.RepositorioSprintJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.adaptador.entidad.EntidadTarea;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.adaptador.repositorio.jpa.RepositorioTareaJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class MapeadorSprint implements MapeadorInfraestructura<EntidadSprint, Sprint> {

    private final RepositorioProyectoJpa repositorioProyectoJpa;
    private final RepositorioTareaJpa repositorioTareaJpa;
    private final RepositorioDocumentoSprintJpa repositorioDocumentoSprintJpa;
    private final MapeadorInformacionProyecto mapeadorInformacionProyecto;
    private final RepositorioInformacionProyectoJpa repositorioInformacionProyectoJpa;
    private final RepositorioSprintJpa repositorioSprintJpa;

    public MapeadorSprint(RepositorioProyectoJpa repositorioProyectoJpa, RepositorioTareaJpa repositorioTareaJpa, RepositorioDocumentoSprintJpa repositorioDocumentoSprintJpa, MapeadorInformacionProyecto mapeadorInformacionProyecto,
                          RepositorioInformacionProyectoJpa repositorioInformacionProyectoJpa,
                          RepositorioSprintJpa repositorioSprintJpa) {
        this.repositorioProyectoJpa = repositorioProyectoJpa;
        this.repositorioTareaJpa = repositorioTareaJpa;
        this.repositorioDocumentoSprintJpa = repositorioDocumentoSprintJpa;
        this.mapeadorInformacionProyecto = mapeadorInformacionProyecto;
        this.repositorioInformacionProyectoJpa = repositorioInformacionProyectoJpa;
        this.repositorioSprintJpa = repositorioSprintJpa;
    }

    @Override
    public Sprint mapeadorDominio(EntidadSprint entidad) {
        return new Sprint(entidad.getIdSprint(), entidad.getDescripcion(),entidad.getFechaInicial(),entidad.getFechaFinal(),
                entidad.getAvance(), entidad.getEstado(), entidad.getIdProyecto());
    }

    @Override
    public EntidadSprint mapeadorEntidad(Sprint dominio) {
        var proyecto = this.repositorioProyectoJpa.findById(dominio.getIdProyecto()).orElseThrow().getIdProyecto();

        //long totalSprintEnProyecto = mapeadorInformacionProyecto.obtenerTotalSprint(dominio.getIdProyecto());
        long totalSprintCreados = obtenerTotalSprints(dominio.getIdProyecto());

        //if(totalSprintCreados < totalSprintEnProyecto ){
            return new EntidadSprint(dominio.getDescripcion(),dominio.getFechaInicial(),dominio.getFechaFinal(), dominio.getAvance(),
                    dominio.getEstado(), proyecto);
        //}
        //else {
          //  throw new ValorObjetoExcepcion(EL_NUMERO_DE_SPRINTS_NO_PUEDE_SER_MAYOR_AL_CALCULADO,MENSAJE_DEFECTO);
        //}
    }
    public List<DtoSprintResumen> listarDominio(List<EntidadSprint> entidades){
        List<DtoSprintResumen> listaDto = new ArrayList<>();
        for (EntidadSprint entidad : entidades) {
            DtoSprintResumen dto = new DtoSprintResumen();
            dto.setIdSprint(entidad.getIdSprint());
            dto.setDescripcion(entidad.getDescripcion());
            dto.setFechaInicial(entidad.getFechaInicial());
            dto.setFechaFinal(entidad.getFechaFinal());
            dto.setAvance(entidad.getAvance());
            dto.setEstado(entidad.getEstado());
            dto.setIdProyecto(entidad.getIdProyecto());

            var infEntidad = repositorioDocumentoSprintJpa.findById(entidad.getIdSprint());

            dto.setRutaArchivo(infEntidad.orElseThrow().getRutaArchivo());

            listaDto.add(dto);
        }
        return listaDto;
    }

    public void actualizarEntidad(EntidadSprint entidad, Sprint sprint) {
        entidad.setFechaInicial(sprint.getFechaInicial());
        entidad.setFechaFinal(sprint.getFechaFinal());
    }
    public void actualizarPorcentajeAvance(EntidadSprint entidad, Sprint sprint) {
        List<EntidadTarea> tareasSprint = this.repositorioTareaJpa.findByIdASEAndTipoASE(sprint.getIdSprint(), ETipoASE.SPRINT);
        long totalTareas = tareasSprint.size();
        long tareasTerminadas = tareasSprint.stream().filter(tarea -> tarea.getEstado() == EEstado.TERMINADO).count();

        if (totalTareas > 0) {
            int nuevoAvance = (int) ((tareasTerminadas * 100) / totalTareas);
            entidad.setAvance((double) nuevoAvance);
            var entidadInformacionProyecto = obtenerProyectoRelacionado(entidad.getIdProyecto());
            if (entidadInformacionProyecto != null) {
                var informacionProyecto = obtenerproyectoDesdeEntidadProyecto(entidadInformacionProyecto);
                //mapeadorInformacionProyecto.actualizarPorcentajeAvance(entidadInformacionProyecto, informacionProyecto);
            }
        }
    }

    private EntidadInformacionProyecto obtenerProyectoRelacionado(Long id) {
        return this.repositorioInformacionProyectoJpa.findById(id).orElse(null);
    }

    private InformacionProyecto obtenerproyectoDesdeEntidadProyecto(EntidadInformacionProyecto proyecto) {
        return new InformacionProyecto(proyecto.getId(), proyecto.getFechaInicial(), proyecto.getFechaFinal(), proyecto.getAvance(),
                proyecto.getDuracion(), proyecto.getPlaneacionSprint(),proyecto.getTotalSprint());
    }

    public long obtenerTotalSprints(Long id){
        var e = this.repositorioSprintJpa.findByIdProyecto(id);
        return e.stream().map(EntidadSprint::getIdSprint).count();
    }


}
