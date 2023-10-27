package com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoProyectoResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.Proyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.repositorio.jpa.RepositorioActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad.EntidadInformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad.EntidadProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.repositorio.jpa.RepositorioInformacionProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorProyecto implements MapeadorInfraestructura<EntidadProyecto, Proyecto> {
    private final RepositorioInformacionProyectoJpa repositorioInformacionProyectoJpa;
    private final RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa;

    public MapeadorProyecto(RepositorioInformacionProyectoJpa repositorioInformacionProyectoJpa, RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa) {
        this.repositorioInformacionProyectoJpa = repositorioInformacionProyectoJpa;
        this.repositorioActividadEstrategicaJpa = repositorioActividadEstrategicaJpa;
    }

    @Override
    public Proyecto mapeadorDominio(EntidadProyecto entidad) {
        return new Proyecto(entidad.getIdProyecto(), entidad.getNombre(), entidad.getPresupuesto(),entidad.getModalidad(),
                entidad.getValorEjecutado(), entidad.getEstado(),entidad.getIdActividadEstrategica());
    }

    @Override
    public EntidadProyecto mapeadorEntidad(Proyecto dominio) {
        var actividad = this.repositorioActividadEstrategicaJpa.findById(dominio.getIdActividadEstrategica()).orElseThrow().getIdActividadEstrategica();
        return new EntidadProyecto(dominio.getNombre(),dominio.getPresupuesto(),dominio.getModalidad(),dominio.getValorEjecutado(),
                dominio.getEstado(),actividad);
    }
    public List<DtoProyectoResumen> listarDominio(List<EntidadProyecto> entidades){
        List<DtoProyectoResumen> listaDto = new ArrayList<>();
        for (EntidadProyecto entidad : entidades) {
            DtoProyectoResumen dto = new DtoProyectoResumen();
            dto.setIdProyecto(entidad.getIdProyecto());
            dto.setNombre(entidad.getNombre());
            dto.setPresupuesto(entidad.getPresupuesto());
            dto.setModalidad(entidad.getModalidad().toString());
            dto.setValorEjecutado(entidad.getValorEjecutado());
            dto.setIdActividadEstrategica(entidad.getIdActividadEstrategica());

            var infEntidad = repositorioInformacionProyectoJpa.findById(entidad.getIdActividadEstrategica());

            dto.setFechaInicial(infEntidad.orElseThrow().getFechaInicial());
            dto.setFechaFinal(infEntidad.orElseThrow().getFechaFinal());
            dto.setDuracion(infEntidad.orElseThrow().getDuracion());
            dto.setPlaneacionSprint(infEntidad.orElseThrow().getPlaneacionSprint().toString());
            dto.setTotalSprint(infEntidad.orElseThrow().getTotalSprint());

            listaDto.add(dto);
        }
        return listaDto;
    }
    public void actualizarEntidad(EntidadProyecto entidad, Proyecto proyecto,
                                  EntidadInformacionProyecto entidadInformacionProyecto,
                                  InformacionProyecto informacionProyecto) {
        entidad.setPresupuesto(proyecto.getPresupuesto());
        entidadInformacionProyecto.setFechaInicial(informacionProyecto.getFechaInicial());
        entidadInformacionProyecto.setFechaFinal(informacionProyecto.getFechaFinal());
        entidadInformacionProyecto.setDuracion(informacionProyecto.getDuracion());
    }
}
