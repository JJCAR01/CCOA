package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.InformacionProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.entidad.EntidadInformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.repositorio.jpa.RepositorioInformacionProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.entidad.EntidadInformacionProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.repositorio.jpa.RepositorioInformacionProyectoAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.NoSuchElementException;

@Configuration
public class MapeadorInformacionProyectoArea implements MapeadorInfraestructura<EntidadInformacionProyectoArea, InformacionProyectoArea> {
    private final RepositorioInformacionProyectoAreaJpa repositorioInformacionProyectoAreaJpa;

    public MapeadorInformacionProyectoArea(RepositorioInformacionProyectoAreaJpa repositorioInformacionProyectoAreaJpa) {
        this.repositorioInformacionProyectoAreaJpa = repositorioInformacionProyectoAreaJpa;
    }
    @Override
    public InformacionProyectoArea mapeadorDominio(EntidadInformacionProyectoArea entidad) {
        return new InformacionProyectoArea(entidad.getFechaInicial(),entidad.getFechaFinal(),entidad.getFechaRegistro(),entidad.getPlaneacionSprint(),
                entidad.getTotalSprint());
    }
    @Override
    public EntidadInformacionProyectoArea mapeadorEntidad(InformacionProyectoArea dominio) {
        return new EntidadInformacionProyectoArea(dominio.getFechaInicial(),dominio.getFechaFinal(), dominio.getFechaRegistro(),dominio.getPlaneacionSprint(),
                dominio.getTotalSprint());
    }
    public long obtenerTotalSprintProyectoArea(Long id){
        return this.repositorioInformacionProyectoAreaJpa.findById(id).orElseThrow().getIdInformacionProyectoArea();
    }

    public long obtenerTotalSprintProyectoAreas(Long id){
        return this.repositorioInformacionProyectoAreaJpa.findById(id)
                .map(EntidadInformacionProyectoArea::getTotalSprint)
                .orElseThrow(() -> new NoSuchElementException("No se encontró información para el ProyectoArea con ID: " + id));
    }
}
