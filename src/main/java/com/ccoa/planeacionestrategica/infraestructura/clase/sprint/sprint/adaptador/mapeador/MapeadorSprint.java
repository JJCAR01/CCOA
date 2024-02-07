package com.ccoa.planeacionestrategica.infraestructura.clase.sprint.sprint.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoSprintResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.Sprint;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.EEstado;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.ETipoASE;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObjetoExcepcion;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentajeAvance;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.proyecto.adaptador.entidad.EntidadDetalleProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.proyecto.adaptador.mapeador.MapeadorDetalleProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.proyecto.adaptador.mapeador.MapeadorInformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.proyecto.adaptador.repositorio.jpa.RepositorioDetalleProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.proyecto.adaptador.repositorio.jpa.RepositorioProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.sprint.adaptador.entidad.EntidadSprint;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.sprint.adaptador.repositorio.jpa.RepositorioSprintJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.tarea.adaptador.entidad.EntidadInformacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.tarea.adaptador.entidad.EntidadTarea;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.tarea.adaptador.repositorio.jpa.RepositorioInformacionTareaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.tarea.adaptador.repositorio.jpa.RepositorioTareaJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;
import static com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje.EL_NUMERO_DE_SPRINTS_NO_PUEDE_SER_MAYOR_AL_CALCULADO;


@Configuration
public class MapeadorSprint implements MapeadorInfraestructura<EntidadSprint, Sprint> {

    private final RepositorioProyectoJpa repositorioProyectoJpa;
    private final RepositorioDetalleProyectoJpa repositorioDetalleProyectoJpa;
    private final RepositorioTareaJpa repositorioTareaJpa;
    private final RepositorioInformacionTareaJpa repositorioInformacionTareaJpa;
    private final RepositorioSprintJpa repositorioSprintJpa;
    private final MapeadorInformacionProyecto mapeadorInformacionProyecto;
    private final MapeadorDetalleProyecto mapeadorDetalleProyecto;
    private final ServicioObtenerPorcentajeAvance servicioObtenerPorcentajeAvance;

    public MapeadorSprint(RepositorioProyectoJpa repositorioProyectoJpa, RepositorioDetalleProyectoJpa repositorioDetalleProyectoJpa, RepositorioTareaJpa repositorioTareaJpa,
                          RepositorioInformacionTareaJpa repositorioInformacionTareaJpa, RepositorioSprintJpa repositorioSprintJpa, MapeadorInformacionProyecto mapeadorInformacionProyecto, MapeadorDetalleProyecto mapeadorDetalleProyecto,ServicioObtenerPorcentajeAvance servicioObtenerPorcentajeAvance) {
        this.repositorioProyectoJpa = repositorioProyectoJpa;
        this.repositorioDetalleProyectoJpa = repositorioDetalleProyectoJpa;
        this.repositorioTareaJpa = repositorioTareaJpa;
        this.repositorioInformacionTareaJpa = repositorioInformacionTareaJpa;
        this.repositorioSprintJpa = repositorioSprintJpa;
        this.mapeadorInformacionProyecto = mapeadorInformacionProyecto;
        this.mapeadorDetalleProyecto = mapeadorDetalleProyecto;
        this.servicioObtenerPorcentajeAvance = servicioObtenerPorcentajeAvance;
    }

    @Override
    public Sprint mapeadorDominio(EntidadSprint entidad) {
        return new Sprint(entidad.getIdSprint(), entidad.getDescripcion(),entidad.getFechaInicial(),entidad.getFechaFinal(),
                entidad.getAvance(), entidad.getEstado(), entidad.getIdProyecto());
    }

    @Override
    public EntidadSprint mapeadorEntidad(Sprint dominio) {
        var proyecto = this.repositorioProyectoJpa.findById(dominio.getIdProyecto()).orElseThrow().getIdProyecto();

        long totalSprintEnProyecto = mapeadorInformacionProyecto.obtenerTotalSprint(dominio.getIdProyecto());
        long totalSprintCreados = obtenerTotalSprints(dominio.getIdProyecto());

        if(totalSprintCreados <= totalSprintEnProyecto ){
            return new EntidadSprint(dominio.getDescripcion(),dominio.getFechaInicial(),dominio.getFechaFinal(), dominio.getAvance(),
                    dominio.getEstado(), proyecto);
        }
        else {
            throw new ValorObjetoExcepcion(EL_NUMERO_DE_SPRINTS_NO_PUEDE_SER_MAYOR_AL_CALCULADO,MENSAJE_DEFECTO);
        }
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

            listaDto.add(dto);
        }
        return listaDto;
    }

    public void actualizarEntidad(EntidadSprint entidad, Sprint sprint) {
        entidad.setDescripcion(sprint.getDescripcion());
        entidad.setFechaInicial(sprint.getFechaInicial());
        entidad.setFechaFinal(sprint.getFechaFinal());
    }
    public void actualizarPorcentajeAvance(EntidadSprint entidad, Sprint sprint) {
        List<EntidadTarea> sprints = this.repositorioTareaJpa.findByIdASEAndTipoASE(sprint.getIdSprint(), ETipoASE.SPRINT);
        List<EntidadInformacionTarea> informacionTareasSprint = this.repositorioInformacionTareaJpa.
                findAll()
                .stream()
                .filter(e -> sprints.stream()
                        .anyMatch(actividad -> actividad.getIdTarea().equals(e.getIdInformacionTarea())))
                .toList();


        long totalTareas = sprints.size();
        long tareasTerminadas = sprints.stream().filter(tarea -> tarea.getEstado() == EEstado.TERMINADO).count();

        if (totalTareas > 0) {
            double porcentajesDiferentesATareasUnicaVez = servicioObtenerPorcentajeAvance.obtenerPorcentajesDiferentesATareasUnicaVez(informacionTareasSprint, tareasTerminadas, totalTareas);
            double nuevoAvance = servicioObtenerPorcentajeAvance.obtenerNuevoAvance(tareasTerminadas,porcentajesDiferentesATareasUnicaVez,totalTareas);
            entidad.setAvance(nuevoAvance);
            mapeadorDetalleProyecto.actualizarPorcentajeAvance(obtenerProyectoRelacionado(sprint.getIdProyecto()));
        }
    }
    public long obtenerTotalSprints(Long id){
        var entidad = this.repositorioSprintJpa.findByIdProyecto(id);
        return entidad.stream().map(EntidadSprint::getIdSprint).count();
    }
    public EntidadDetalleProyecto obtenerProyectoRelacionado(Long id){
        return this.repositorioDetalleProyectoJpa.findById(id).orElseThrow();
    }
}
