package com.ccoa.planeacionestrategica.infraestructura.adaptador.cargo.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioCargo;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.cargo.adaptador.entidad.EntidadCargo;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.cargo.adaptador.mapeador.MapeadorCargo;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.cargo.adaptador.repositorio.jpa.RepositorioCargoJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioCargoMySQL implements RepositorioCargo {
    private final RepositorioCargoJpa repositorioCargoJpa;
    private final MapeadorCargo mapeadorCargo;

    public RepositorioCargoMySQL(RepositorioCargoJpa repositorioCargoJpa, MapeadorCargo mapeadorCargo) {
        this.repositorioCargoJpa = repositorioCargoJpa;
        this.mapeadorCargo = mapeadorCargo;
    }

    @Override
    public List<Cargo> listar() {
        List<EntidadCargo> entidadCargos =this.repositorioCargoJpa.findAll();
        return entidadCargos.stream().map(entidadCargo -> Cargo.of(entidadCargo.getIdCargo(), entidadCargo.getNombre(), entidadCargo.getIdArea())).toList();}

    @Override
    public Cargo consultarPorId(Long id) {
        var entidad = this.repositorioCargoJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorCargo.mapeadorDominio(entidad);
    }

    @Override
    public Long guardar(Cargo cargo) {
        return this.repositorioCargoJpa.save(this.mapeadorCargo.mapeadorEntidad(cargo)).getIdCargo();
    }

    @Override
    public boolean existe(Cargo cargo) {
        return this.repositorioCargoJpa.findByNombre(cargo.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioCargoJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Cargo cargo, Long id) {
        var entidadCargo = this.repositorioCargoJpa.findById(id).orElse(null);
        assert entidadCargo != null;
        this.mapeadorCargo.actualizarEntidad(entidadCargo, cargo);
        return this.repositorioCargoJpa.save(entidadCargo).getIdCargo();
    }
}
