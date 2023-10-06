package com.ccoa.planeacionestrategica.infraestructura.clase.actividad.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.actividad.InformacionActividad;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividad.adaptador.entidad.EntidadInformacionActividad;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividad.adaptador.repositorio.jpa.RepositorioActividadJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.repositorio.jpa.RepositorioEpicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.repositorio.jpa.RepositorioGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorInformacionActividad implements MapeadorInfraestructura<EntidadInformacionActividad, InformacionActividad> {
    private final RepositorioGestionJpa repositorioGestionJpa;
    private final RepositorioEpicaJpa repositorioEpicaJpa;

    public MapeadorInformacionActividad(RepositorioGestionJpa repositorioGestionJpa, RepositorioEpicaJpa repositorioEpicaJpa) {
        this.repositorioGestionJpa = repositorioGestionJpa;
        this.repositorioEpicaJpa = repositorioEpicaJpa;
    }

    @Override
    public InformacionActividad mapeadorDominio(EntidadInformacionActividad entidad) {
        return new InformacionActividad(entidad.getIdInformacionActividad(), entidad.getDuracion(),entidad.getDiasRestantes(),
                entidad.getAvance(), entidad.getIdEpica(), entidad.getIdGestion());
    }

    @Override
    public EntidadInformacionActividad mapeadorEntidad(InformacionActividad dominio) {
        //var gestion = this.repositorioGestionJpa.findById(dominio.getIdGestion()).orElseThrow().getIdGestion();
        //var epica = this.repositorioEpicaJpa.findById(dominio.getIdEpica()).orElseThrow().getIdEpica();
        return new EntidadInformacionActividad(dominio.getDuracion(),dominio.getDiasRestantes(),dominio.getAvance(),
                dominio.getIdEpica(), dominio.getIdGestion());
    }
}
