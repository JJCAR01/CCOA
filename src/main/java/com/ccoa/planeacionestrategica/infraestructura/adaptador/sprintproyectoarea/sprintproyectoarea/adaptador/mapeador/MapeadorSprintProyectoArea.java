package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoSprintProyectoAreaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.SprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObjetoExcepcion;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerDuracion;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentaje;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.mapeador.MapeadorInformacionProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.repositorio.jpa.RepositorioProyectoAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.entidad.EntidadInformacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.entidad.EntidadSprintProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.repositorio.jpa.RepositorioInformacionSprintProyectoAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.repositorio.jpa.RepositorioSprintProyectoAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;
import static com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje.EL_NUMERO_DE_SPRINTS_NO_PUEDE_SER_MAYOR_AL_CALCULADO;


@Configuration
public class MapeadorSprintProyectoArea implements MapeadorInfraestructura<EntidadSprintProyectoArea, SprintProyectoArea> {

    private final RepositorioProyectoAreaJpa repositorioProyectoAreaJpa;
    private final RepositorioInformacionSprintProyectoAreaJpa repositorioInformacionSprintProyectoAreaJpa;
    private final RepositorioSprintProyectoAreaJpa repositorioSprintProyectoAreaJpa;
    private final MapeadorInformacionProyectoArea mapeadorInformacionProyectoArea;
    private final ServicioObtenerPorcentaje servicioObtenerPorcentaje;
    private final ServicioObtenerDuracion servicioObtenerDuracion;

    public MapeadorSprintProyectoArea(RepositorioProyectoAreaJpa repositorioProyectoAreaJpa, RepositorioInformacionSprintProyectoAreaJpa repositorioInformacionSprintProyectoAreaJpa,
                                      RepositorioSprintProyectoAreaJpa repositorioSprintProyectoAreaJpa,
                                      MapeadorInformacionProyectoArea mapeadorInformacionProyectoArea,
                                      ServicioObtenerPorcentaje servicioObtenerPorcentaje, ServicioObtenerDuracion servicioObtenerDuracion) {
        this.repositorioProyectoAreaJpa = repositorioProyectoAreaJpa;
        this.repositorioInformacionSprintProyectoAreaJpa = repositorioInformacionSprintProyectoAreaJpa;
        this.repositorioSprintProyectoAreaJpa = repositorioSprintProyectoAreaJpa;
        this.mapeadorInformacionProyectoArea = mapeadorInformacionProyectoArea;
        this.servicioObtenerPorcentaje = servicioObtenerPorcentaje;
        this.servicioObtenerDuracion = servicioObtenerDuracion;
    }

    @Override
    public SprintProyectoArea mapeadorDominio(EntidadSprintProyectoArea entidad) {
        return new SprintProyectoArea(entidad.getIdSprintProyectoArea(), entidad.getDescripcion(),entidad.getFechaInicial(),entidad.getFechaFinal(), entidad.getIdProyectoArea());
    }

    @Override
    public EntidadSprintProyectoArea mapeadorEntidad(SprintProyectoArea dominio) {
        var proyecto = this.repositorioProyectoAreaJpa.findById(dominio.getIdProyectoArea()).orElseThrow().getIdProyectoArea();

        long totalSprintProyectoAreaEnProyecto = mapeadorInformacionProyectoArea.obtenerTotalSprintProyectoArea(dominio.getIdProyectoArea());
        long totalSprintProyectoAreaCreados = obtenerTotalSprintProyectoAreas(dominio.getIdProyectoArea());

        if(totalSprintProyectoAreaCreados <= totalSprintProyectoAreaEnProyecto ){
            return new EntidadSprintProyectoArea(dominio.getDescripcion(),dominio.getFechaInicial(),dominio.getFechaFinal(),proyecto);
        }
        else {
            throw new ValorObjetoExcepcion(EL_NUMERO_DE_SPRINTS_NO_PUEDE_SER_MAYOR_AL_CALCULADO,MENSAJE_DEFECTO);
        }
    }
    public List<DtoSprintProyectoAreaResumen> listarDominio(List<EntidadSprintProyectoArea> entidades){
        List<DtoSprintProyectoAreaResumen> listaDto = new ArrayList<>();
        for (EntidadSprintProyectoArea entidad : entidades) {
            DtoSprintProyectoAreaResumen dto = new DtoSprintProyectoAreaResumen();
            dto.setIdSprintProyectoArea(entidad.getIdSprintProyectoArea());
            dto.setDescripcion(entidad.getDescripcion());
            dto.setFechaInicial(entidad.getFechaInicial());
            dto.setFechaFinal(entidad.getFechaFinal());
            dto.setIdProyecto(entidad.getIdProyectoArea());

            var informacionSprintProyectoArea = repositorioInformacionSprintProyectoAreaJpa.findById(entidad.getIdSprintProyectoArea());

            dto.setPorcentajeReal(informacionSprintProyectoArea.orElseThrow().getPorcentajeReal());
            dto.setPorcentajeEsperado(informacionSprintProyectoArea.orElseThrow().getPorcentajeEsperado());
            dto.setPorcentajeCumplimiento(servicioObtenerPorcentaje.obtenerPorcentajeDeCumplimiento(dto.getPorcentajeReal(),dto.getPorcentajeEsperado()));

            listaDto.add(dto);
        }
        return listaDto;
    }

    public void actualizarEntidad(EntidadSprintProyectoArea entidad, SprintProyectoArea sprintProyectoArea,
                                  EntidadInformacionSprintProyectoArea entidadInformacionSprintProyectoArea) {
        entidad.setDescripcion(sprintProyectoArea.getDescripcion());
        entidad.setFechaInicial(sprintProyectoArea.getFechaInicial());
        entidad.setFechaFinal(sprintProyectoArea.getFechaFinal());
        var duracion = obtenerDuracion(entidad.getFechaInicial(),entidad.getFechaFinal());
        entidadInformacionSprintProyectoArea.setPorcentajeEsperado(obtenerPorcentajeEsperado(entidad.getFechaInicial(),duracion));
    }
    public long obtenerTotalSprintProyectoAreas(Long id){
        var entidad = this.repositorioSprintProyectoAreaJpa.findByIdProyectoArea(id);
        return entidad.stream().map(EntidadSprintProyectoArea::getIdSprintProyectoArea).count();
    }
    public EntidadSprintProyectoArea obtenerIdProyectoRelacionadoConElSprintProyectoArea(Long id){
        return this.repositorioSprintProyectoAreaJpa.findById(id).orElseThrow();
    }
    public Integer obtenerDuracion(LocalDate fechaInicial, LocalDate fechaFinal){
        return servicioObtenerDuracion.calcular(fechaInicial,fechaFinal);
    }
    public double obtenerPorcentajeEsperado(LocalDate fechaInicial, long duracion){
        return Math.min(servicioObtenerPorcentaje.obtenerPorcentajeEsperado(fechaInicial,duracion), Mensaje.PORCENTAJE);
    }
}
