package com.ccoa.planeacionestrategica.infraestructura.clase.cargo.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import com.ccoa.planeacionestrategica.infraestructura.clase.area.adaptador.repositorio.jpa.RepositorioAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.cargo.adaptador.entidad.EntidadCargo;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.stereotype.Component;

@Component
public class MapeadorCargo implements MapeadorInfraestructura<EntidadCargo, Cargo> {

    private final RepositorioAreaJpa repositorioAreaJpa;

    public MapeadorCargo(RepositorioAreaJpa repositorioAreaJpa) {
        this.repositorioAreaJpa = repositorioAreaJpa;
    }

    @Override
    public Cargo mapeadorDominio(EntidadCargo entidad) {
        return new Cargo(entidad.getIdCargo(), entidad.getNombre(), entidad.getIdCargo());
    }
    @Override
    public EntidadCargo mapeadorEntidad(Cargo dominio) {
        var idArea = this.repositorioAreaJpa.findById(dominio.getIdArea()).orElseThrow().getIdArea();
        return new EntidadCargo(dominio.getNombre(),idArea);
    }
    public void actualizarEntidad(EntidadCargo entidad, Cargo cargo) {
        entidad.setNombre(cargo.getNombre());
        entidad.setIdArea(cargo.getIdArea());
    }
}
