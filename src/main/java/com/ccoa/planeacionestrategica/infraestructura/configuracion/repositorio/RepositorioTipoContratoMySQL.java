package com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoContrato;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoContrato;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadArea;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadTipoContrato;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio.jpa.RepositorioTipoContratoJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioTipoContratoMySQL implements RepositorioTipoContrato {

    private final RepositorioTipoContratoJpa repositorioTipoContratoJpa;

    public RepositorioTipoContratoMySQL(RepositorioTipoContratoJpa repositorioTipoContratoJpa) {
        this.repositorioTipoContratoJpa = repositorioTipoContratoJpa;
    }

    @Override
    public List<TipoContrato> listar() {
        List<EntidadTipoContrato> entidadTipoContratos =this.repositorioTipoContratoJpa.findAll();
        return entidadTipoContratos.stream().map(entidadTipoContrato -> TipoContrato.of(entidadTipoContrato.getNombre())).toList();
    }

    @Override
    public TipoContrato consultarPorId(Long id) {
        return this.repositorioTipoContratoJpa.findById(id).map(entidadTipoContrato -> TipoContrato.of(entidadTipoContrato.getNombre())).orElse(null);

    }

    @Override
    public Long guardar(TipoContrato tipoContrato) {
        EntidadTipoContrato entidadTipoContrato = new EntidadTipoContrato(tipoContrato.getNombre());
        return this.repositorioTipoContratoJpa.save(entidadTipoContrato).getId();
    }

    @Override
    public boolean existe(TipoContrato tipoContrato) {
        return this.repositorioTipoContratoJpa.findByNombre(tipoContrato.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioTipoContratoJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(TipoContrato tipoContrato, Long id) {
        repositorioTipoContratoJpa.findById(id);
        EntidadTipoContrato entidadTipoContrato = new EntidadTipoContrato();
        entidadTipoContrato.setId(id);
        entidadTipoContrato.setNombre(tipoContrato.getNombre());
        repositorioTipoContratoJpa.save(entidadTipoContrato);
        return id;
    }
}
