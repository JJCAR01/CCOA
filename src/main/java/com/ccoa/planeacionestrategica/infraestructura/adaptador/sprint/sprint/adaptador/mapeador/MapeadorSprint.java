package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoSprint;
import com.ccoa.planeacionestrategica.dominio.dto.DtoSprintResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsProyecto;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.Sprint;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorObjeto;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerDuracion;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentaje;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.entidad.EntidadProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.repositorio.jpa.RepositorioProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.entidad.EntidadInformacionSprint;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.repositorio.jpa.RepositorioInformacionSprintJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.repositorio.jpa.RepositorioSprintJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.mapeador.MapeadorInformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.entidad.EntidadSprint;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;
import static com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje.EL_NUMERO_DE_SPRINTS_NO_PUEDE_SER_MAYOR_AL_CALCULADO;


@Configuration
public class MapeadorSprint implements MapeadorInfraestructura<EntidadSprint, Sprint> {

    private final RepositorioProyectoJpa repositorioProyectoJpa;
    private final RepositorioInformacionSprintJpa repositorioInformacionSprintJpa;
    private final RepositorioSprintJpa repositorioSprintJpa;
    private final MapeadorInformacionProyecto mapeadorInformacionProyecto;
    private final ServicioObtenerPorcentaje servicioObtenerPorcentaje;
    private final ServicioObtenerDuracion servicioObtenerDuracion;

    public MapeadorSprint(RepositorioProyectoJpa repositorioProyectoJpa, RepositorioInformacionSprintJpa repositorioInformacionSprintJpa,
                          RepositorioSprintJpa repositorioSprintJpa, MapeadorInformacionProyecto mapeadorInformacionProyecto,
                          ServicioObtenerPorcentaje servicioObtenerPorcentaje, ServicioObtenerDuracion servicioObtenerDuracion) {
        this.repositorioProyectoJpa = repositorioProyectoJpa;
        this.repositorioInformacionSprintJpa = repositorioInformacionSprintJpa;
        this.repositorioSprintJpa = repositorioSprintJpa;
        this.mapeadorInformacionProyecto = mapeadorInformacionProyecto;
        this.servicioObtenerPorcentaje = servicioObtenerPorcentaje;
        this.servicioObtenerDuracion = servicioObtenerDuracion;
    }

    @Override
    public Sprint mapeadorDominio(EntidadSprint entidad) {
        return new Sprint(entidad.getIdSprint(), entidad.getDescripcion(),entidad.getFechaInicial(),entidad.getFechaFinal(), entidad.getIdProyecto());
    }

    @Override
    public EntidadSprint mapeadorEntidad(Sprint dominio) {
        var proyecto = this.repositorioProyectoJpa.findById(dominio.getIdProyecto()).orElseThrow().getIdProyecto();

        long totalSprintEnProyecto = mapeadorInformacionProyecto.obtenerTotalSprints(dominio.getIdProyecto());
        long totalSprintCreados = obtenerTotalSprints(dominio.getIdProyecto());

        if(totalSprintCreados <= totalSprintEnProyecto ){
            return new EntidadSprint(dominio.getDescripcion(),dominio.getFechaInicial(),dominio.getFechaFinal(),proyecto);
        }
        else {
            throw new ExcepcionValidadorObjeto(EL_NUMERO_DE_SPRINTS_NO_PUEDE_SER_MAYOR_AL_CALCULADO,MENSAJE_DEFECTO);
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
            dto.setIdProyecto(entidad.getIdProyecto());

            var informacionSprint = repositorioInformacionSprintJpa.findById(entidad.getIdSprint());

            dto.setPorcentajeReal(informacionSprint.orElseThrow().getPorcentajeReal());
            dto.setPorcentajeEsperado(informacionSprint.orElseThrow().getPorcentajeEsperado());
            dto.setPorcentajeCumplimiento(servicioObtenerPorcentaje.obtenerPorcentajeDeCumplimiento(dto.getPorcentajeReal(),dto.getPorcentajeEsperado()));

            listaDto.add(dto);
        }
        return listaDto;
    }
    public List<DtoSprint> obtenerSprintParaDuplicar(List<EntidadSprint> entidades){
        List<DtoSprint> listaDto = new ArrayList<>();
        for (EntidadSprint entidad : entidades) {
            DtoSprint dto = new DtoSprint();
            dto.setIdSprint(entidad.getIdSprint());
            dto.setDescripcion(entidad.getDescripcion());
            dto.setFechaInicial(entidad.getFechaInicial());
            dto.setFechaFinal(entidad.getFechaFinal());

            listaDto.add(dto);
        }
        return listaDto;
    }

    public List<DtoIdsSprint> listarIds(List<EntidadSprint> entidades){
        List<DtoIdsSprint> listaDto = new ArrayList<>();
        for (EntidadSprint entidad : entidades) {
            DtoIdsSprint dto = new DtoIdsSprint();
            dto.setIdSprint(entidad.getIdSprint());

            var informacionEntidad = repositorioInformacionSprintJpa.findById(entidad.getIdSprint());
            dto.setIdInformacionSprint(informacionEntidad.orElseThrow().getIdInformacionSprint());

            listaDto.add(dto);
        }
        return listaDto;
    }

    public void actualizarEntidad(EntidadSprint entidad, Sprint sprint, EntidadInformacionSprint entidadInformacionSprint) {
        entidad.setDescripcion(sprint.getDescripcion());
        entidad.setFechaInicial(sprint.getFechaInicial());
        entidad.setFechaFinal(sprint.getFechaFinal());
        var duracion = obtenerDuracion(entidad.getFechaInicial(),entidad.getFechaFinal());
        entidadInformacionSprint.setPorcentajeEsperado(obtenerPorcentajeEsperado(entidad.getFechaInicial(),duracion));
    }
    public long obtenerTotalSprints(Long id){
        var entidad = this.repositorioSprintJpa.findByIdProyecto(id);
        return entidad.stream().map(EntidadSprint::getIdSprint).count();
    }
    public EntidadSprint obtenerIdProyectoRelacionadoConElSprint(Long id){
        return this.repositorioSprintJpa.findById(id).orElseThrow();
    }
    public Integer obtenerDuracion(LocalDate fechaInicial, LocalDate fechaFinal){
        return servicioObtenerDuracion.calcular(fechaInicial,fechaFinal);
    }
    public double obtenerPorcentajeEsperado(LocalDate fechaInicial, long duracion){
        return Math.min(servicioObtenerPorcentaje.obtenerPorcentajeEsperado(fechaInicial,duracion), Mensaje.PORCENTAJE);
    }
}
