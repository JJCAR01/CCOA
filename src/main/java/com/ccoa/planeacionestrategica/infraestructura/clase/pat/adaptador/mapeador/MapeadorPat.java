package com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.mapeador;
import com.ccoa.planeacionestrategica.dominio.modelo.Pat;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad.EntidadPat;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MapeadorPat implements MapeadorInfraestructura<EntidadPat, Pat> {
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;

    public MapeadorPat(RepositorioUsuarioJpa repositorioUsuarioJpa) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
    }

    @Override
    public Pat mapeadorDominio(EntidadPat entidad) {
        return new Pat(entidad.getIdPat(), entidad.getNombre(), entidad.getFechaAnual(),entidad.getFechaRegistro(),
                entidad.getPorcentaje(),entidad.getProceso(), entidad.getIdUsuario());
    }

    @Override
    public EntidadPat mapeadorEntidad(Pat dominio) {
        var idUsuario = this.repositorioUsuarioJpa.findById(dominio.getIdUsuario()).orElseThrow().getIdUsuario();
        return new EntidadPat(dominio.getNombre(), dominio.getFechaAnual(),dominio.getFechaRegistro(),
                dominio.getPorcentaje(),dominio.getProceso(),idUsuario);
    }
    public List<Pat> listarDominio(List<EntidadPat> entidades){
        return entidades.stream().map(entidad -> new Pat(entidad.getIdPat(), entidad.getNombre(), entidad.getFechaAnual(),entidad.getFechaRegistro(),
                entidad.getPorcentaje(),entidad.getProceso(), entidad.getIdUsuario())).toList();
    }

    public void actualizarEntidad(EntidadPat entidad, Pat pat) {
        entidad.setFechaAnual(pat.getFechaAnual());
        entidad.setProceso(pat.getProceso());
    }
}
