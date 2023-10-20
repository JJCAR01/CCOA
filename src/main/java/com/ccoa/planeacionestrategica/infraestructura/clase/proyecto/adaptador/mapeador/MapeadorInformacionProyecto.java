package com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad.EntidadInformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorInformacionProyecto implements MapeadorInfraestructura<EntidadInformacionProyecto, InformacionProyecto> {
    @Autowired
    private RepositorioUsuarioJpa repositorioUsuarioJpa;
    @Override
    public InformacionProyecto mapeadorDominio(EntidadInformacionProyecto entidad) {
        return new InformacionProyecto(entidad.getFechaInicial(),entidad.getFechaFinal(),entidad.getDuracion(),entidad.getPlaneacionSprint(),
                entidad.getTotalSprint(), entidad.getIdUsuario());
    }

    @Override
    public EntidadInformacionProyecto mapeadorEntidad(InformacionProyecto dominio) {
        var usuario = this.repositorioUsuarioJpa.findById(dominio.getIdUsuario()).orElseThrow().getIdUsuario();
        return new EntidadInformacionProyecto(dominio.getFechaInicial(),dominio.getFechaFinal(),dominio.getDuracion(),dominio.getPlaneacionSprint(),
                dominio.getTotalSprint(),usuario);
    }
}
