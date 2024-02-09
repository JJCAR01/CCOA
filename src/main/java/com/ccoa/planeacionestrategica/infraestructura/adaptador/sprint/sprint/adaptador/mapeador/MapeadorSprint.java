package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoSprintResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.Sprint;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObjetoExcepcion;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentaje;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.repositorio.jpa.RepositorioProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.repositorio.jpa.RepositorioInformacionSprintJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.repositorio.jpa.RepositorioSprintJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.mapeador.MapeadorInformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.entidad.EntidadSprint;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

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

    public MapeadorSprint(RepositorioProyectoJpa repositorioProyectoJpa, RepositorioInformacionSprintJpa repositorioInformacionSprintJpa,
                          RepositorioSprintJpa repositorioSprintJpa, MapeadorInformacionProyecto mapeadorInformacionProyecto, ServicioObtenerPorcentaje servicioObtenerPorcentaje) {
        this.repositorioProyectoJpa = repositorioProyectoJpa;
        this.repositorioInformacionSprintJpa = repositorioInformacionSprintJpa;
        this.repositorioSprintJpa = repositorioSprintJpa;
        this.mapeadorInformacionProyecto = mapeadorInformacionProyecto;
        this.servicioObtenerPorcentaje = servicioObtenerPorcentaje;
    }

    @Override
    public Sprint mapeadorDominio(EntidadSprint entidad) {
        return new Sprint(entidad.getIdSprint(), entidad.getDescripcion(),entidad.getFechaInicial(),entidad.getFechaFinal(), entidad.getIdProyecto());
    }

    @Override
    public EntidadSprint mapeadorEntidad(Sprint dominio) {
        var proyecto = this.repositorioProyectoJpa.findById(dominio.getIdProyecto()).orElseThrow().getIdProyecto();

        long totalSprintEnProyecto = mapeadorInformacionProyecto.obtenerTotalSprint(dominio.getIdProyecto());
        long totalSprintCreados = obtenerTotalSprints(dominio.getIdProyecto());

        if(totalSprintCreados <= totalSprintEnProyecto ){
            return new EntidadSprint(dominio.getDescripcion(),dominio.getFechaInicial(),dominio.getFechaFinal(),proyecto);
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
            dto.setIdProyecto(entidad.getIdProyecto());

            var informacionSprint = repositorioInformacionSprintJpa.findById(entidad.getIdSprint());

            dto.setPorcentajeReal(informacionSprint.orElseThrow().getPorcentajeReal());
            dto.setPorcentajeEsperado(informacionSprint.orElseThrow().getPorcentajeEsperado());
            dto.setPorcentajeCumplimiento(informacionSprint.orElseThrow().getPorcentajeCumplimiento());

            listaDto.add(dto);
        }
        return listaDto;
    }

    public void actualizarEntidad(EntidadSprint entidad, Sprint sprint) {
        entidad.setDescripcion(sprint.getDescripcion());
        entidad.setFechaInicial(sprint.getFechaInicial());
        entidad.setFechaFinal(sprint.getFechaFinal());
    }
    public long obtenerTotalSprints(Long id){
        var entidad = this.repositorioSprintJpa.findByIdProyecto(id);
        return entidad.stream().map(EntidadSprint::getIdSprint).count();
    }
    public EntidadSprint obtenerIdProyectoRelacionadoConElSprint(Long id){
        return this.repositorioSprintJpa.findById(id).orElseThrow();
    }
}
