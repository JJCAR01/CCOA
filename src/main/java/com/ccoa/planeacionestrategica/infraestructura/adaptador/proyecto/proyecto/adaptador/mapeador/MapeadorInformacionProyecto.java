package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.entidad.EntidadInformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.entidad.EntidadProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.repositorio.jpa.RepositorioInformacionProyectoJpa;
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
        return new InformacionProyecto(entidad.getFechaInicial(),entidad.getFechaFinal(),entidad.getFechaRegistro(),entidad.getPlaneacionSprint(),
                entidad.getTotalSprint());
    }
    @Override
    public EntidadInformacionProyecto mapeadorEntidad(InformacionProyecto dominio) {
        return new EntidadInformacionProyecto(dominio.getFechaInicial(),dominio.getFechaFinal(), dominio.getFechaRegistro(),dominio.getPlaneacionSprint(),
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

    public EntidadInformacionProyecto obtenerInformacionProyectoAProyecto(Long id){
        return this.repositorioInformacionProyectoJpa.findById(id).orElseThrow();
    }
}
