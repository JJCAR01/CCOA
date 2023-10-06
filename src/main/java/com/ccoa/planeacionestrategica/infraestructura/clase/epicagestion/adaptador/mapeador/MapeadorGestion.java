package com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.Gestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.entidad.EntidadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.repositorio.jpa.RepositorioPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapeadorGestion implements MapeadorInfraestructura<EntidadGestion, Gestion> {

    private final RepositorioPatJpa repositorioPatJpa;

    public MapeadorGestion(RepositorioPatJpa repositorioPatJpa) {
        this.repositorioPatJpa = repositorioPatJpa;
    }

    @Override
    public Gestion mapeadorDominio(EntidadGestion entidad) {
        return new Gestion(entidad.getIdGestion(), entidad.getNombre(), entidad.getIdPat());
    }
    @Override
    public EntidadGestion mapeadorEntidad(Gestion dominio) {
        var pat = this.repositorioPatJpa.findById(dominio.getIdPat()).orElseThrow().getIdPat();
        return new EntidadGestion(dominio.getNombre(), pat);
    }
    public List<Gestion> listarDominio(List<EntidadGestion> entidades){
        return entidades.stream().map(entidad -> new Gestion(entidad.getIdGestion(), entidad.getNombre(), entidad.getIdPat())).toList();
    }

    public void actualizarEntidad(EntidadGestion entidad, Gestion gestion) {
        entidad.setNombre(gestion.getNombre());
    }
}
