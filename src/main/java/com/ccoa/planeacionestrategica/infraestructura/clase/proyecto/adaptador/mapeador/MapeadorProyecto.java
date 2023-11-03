package com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.Proyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad.EntidadInformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad.EntidadProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.repositorio.jpa.RepositorioProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MapeadorProyecto implements MapeadorInfraestructura<EntidadProyecto, Proyecto> {
    private final RepositorioProyectoJpa repositorioProyectoJpa;

    public MapeadorProyecto(RepositorioProyectoJpa repositorioProyectoJpa) {

        this.repositorioProyectoJpa = repositorioProyectoJpa;
    }

    @Override
    public Proyecto mapeadorDominio(EntidadProyecto entidad) {
        return new Proyecto(entidad.getIdProyecto(), entidad.getNombre(), entidad.getPresupuesto(),entidad.getModalidad(),
                entidad.getValorEjecutado(), entidad.getEstado());
    }

    @Override
    public EntidadProyecto mapeadorEntidad(Proyecto dominio) {
        return new EntidadProyecto(dominio.getNombre(),dominio.getPresupuesto(),dominio.getModalidad(),dominio.getValorEjecutado(),
                dominio.getEstado());
    }

    public void actualizarEntidad(EntidadProyecto entidad, Proyecto proyecto,
                                  EntidadInformacionProyecto entidadInformacionProyecto,
                                  InformacionProyecto informacionProyecto) {
        entidad.setPresupuesto(proyecto.getPresupuesto());
        entidadInformacionProyecto.setFechaInicial(informacionProyecto.getFechaInicial());
        entidadInformacionProyecto.setFechaFinal(informacionProyecto.getFechaFinal());
        entidadInformacionProyecto.setDuracion(informacionProyecto.getDuracion());
    }

    public EntidadProyecto obtenerProyectoRelacionado(Long id) {
        return this.repositorioProyectoJpa.findById(id).orElse(null);
    }
}
