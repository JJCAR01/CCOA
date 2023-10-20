package com.ccoa.planeacionestrategica.infraestructura.clase.sprint.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoSprintResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.Sprint;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.repositorio.jpa.RepositorioProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.adaptador.entidad.EntidadSprint;
import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.adaptador.repositorio.jpa.RepositorioDocumentoSprintJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorSprint implements MapeadorInfraestructura<EntidadSprint, Sprint> {
    @Autowired
    private RepositorioProyectoJpa repositorioProyectoJpa;
    @Autowired
    private RepositorioDocumentoSprintJpa repositorioDocumentoSprintJpa;
    @Override
    public Sprint mapeadorDominio(EntidadSprint entidad) {
        return new Sprint(entidad.getIdSprint(), entidad.getDescripcion(),entidad.getFechaInicial(),entidad.getFechaFinal(),
                entidad.getAvance(), entidad.getEstado(), entidad.getIdProyecto());
    }

    @Override
    public EntidadSprint mapeadorEntidad(Sprint dominio) {
        var proyecto = this.repositorioProyectoJpa.findById(dominio.getIdProyecto()).orElseThrow().getIdProyecto();
        return new EntidadSprint(dominio.getDescripcion(),dominio.getFechaInicial(),dominio.getFechaFinal(), dominio.getAvance(),
                dominio.getEstado(), proyecto);
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
}
