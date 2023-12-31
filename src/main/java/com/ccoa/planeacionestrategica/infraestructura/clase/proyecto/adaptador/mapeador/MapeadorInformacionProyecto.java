package com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad.EntidadInformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.repositorio.jpa.RepositorioInformacionProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.NoSuchElementException;

@Configuration
public class MapeadorInformacionProyecto implements MapeadorInfraestructura<EntidadInformacionProyecto, InformacionProyecto> {
    private final RepositorioInformacionProyectoJpa repositorioInformacionProyectoJpa;

    public MapeadorInformacionProyecto(RepositorioInformacionProyectoJpa repositorioInformacionProyectoJpa) {
        this.repositorioInformacionProyectoJpa = repositorioInformacionProyectoJpa;
    }
    @Override
    public InformacionProyecto mapeadorDominio(EntidadInformacionProyecto entidad) {
        return new InformacionProyecto(entidad.getIdInformacionProyecto(), entidad.getFechaInicial(),entidad.getFechaFinal(), entidad.getDuracion(),entidad.getPlaneacionSprint(),
                entidad.getTotalSprint());
    }
    @Override
    public EntidadInformacionProyecto mapeadorEntidad(InformacionProyecto dominio) {
        return new EntidadInformacionProyecto(dominio.getFechaInicial(),dominio.getFechaFinal(), dominio.getDuracion(),dominio.getPlaneacionSprint(),
                dominio.getTotalSprint());
    }
    public long obtenerTotalSprint(Long id){
        return this.repositorioInformacionProyectoJpa.findById(id).orElseThrow().getIdInformacionProyecto();
    }

    public long obtenerTotalSprints(Long id){
        return this.repositorioInformacionProyectoJpa.findById(id)
                .map(EntidadInformacionProyecto::getTotalSprint)
                .orElseThrow(() -> new NoSuchElementException("No se encontró información para el proyecto con ID: " + id));
    }
}
