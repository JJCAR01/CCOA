package com.ccoa.planeacionestrategica.infraestructura.adaptador.direccion.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.dto.DtoDireccionResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.direccion.Direccion;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioDireccion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.direccion.adaptador.mapeador.MapeadorDireccion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.direccion.adaptador.repositorio.jpa.RepositorioDireccionJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RepositorioDireccionMySQL implements RepositorioDireccion {

    private final RepositorioDireccionJpa repositorioDireccionJpa;
    private final MapeadorDireccion mapeadorDireccion;

    public RepositorioDireccionMySQL(RepositorioDireccionJpa repositorioDireccionJpa, MapeadorDireccion mapeadorDireccion) {
        this.repositorioDireccionJpa = repositorioDireccionJpa;
        this.mapeadorDireccion = mapeadorDireccion;
    }

    @Override
    public List<DtoDireccionResumen> listar() {
        var entidad =this.repositorioDireccionJpa.findAll();
        return this.mapeadorDireccion.listarDominio(entidad);
    }

    @Override
    public DtoDireccionResumen consultarPorId(Long id) {
        var entidad = this.repositorioDireccionJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorDireccion.listarDtoResumen(entidad);
    }

    @Override
    public Long guardar(Direccion direccion) {
        return this.repositorioDireccionJpa.save(this.mapeadorDireccion.mapeadorEntidad(direccion)).getIdDireccion();
    }

    @Override
    public boolean existe(Direccion direccion)  {
        return this.repositorioDireccionJpa.findByNombre(direccion.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioDireccionJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Direccion direccion, Long id) {
        var entidad = this.repositorioDireccionJpa.findById(id).orElse(null);
        assert entidad != null;
        this.mapeadorDireccion.actualizarEntidad(entidad, direccion);
        return this.repositorioDireccionJpa.save(entidad).getIdDireccion();
    }
}
