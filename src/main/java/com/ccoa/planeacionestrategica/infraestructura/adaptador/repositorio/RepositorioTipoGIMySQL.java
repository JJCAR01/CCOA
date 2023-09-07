package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.Rubro;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoGI;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoGI;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadRubro;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadTipoGI;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioTipoGIJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioTipoGIMySQL implements RepositorioTipoGI {

    private final RepositorioTipoGIJpa repositorioTipoGIJpa;

    public RepositorioTipoGIMySQL(RepositorioTipoGIJpa repositorioTipoGIJpa) {
        this.repositorioTipoGIJpa = repositorioTipoGIJpa;
    }

    @Override
    public List<TipoGI> listar() {
        List<EntidadTipoGI> entidadTipoGIS = this.repositorioTipoGIJpa.findAll();
        return entidadTipoGIS.stream().map(entidad -> TipoGI.of(entidad.getIdTipoGI(), entidad.getCantidad(), entidad.getClasificacion(),
                entidad.getValorUnitario(),entidad.getValorTotal(),entidad.getObservacion())).toList();

    }

    @Override
    public TipoGI consultarPorId(Long id) {
        return this.repositorioTipoGIJpa.findById(id).map(entidad -> TipoGI.of(entidad.getIdTipoGI(), entidad.getCantidad(), entidad.getClasificacion(),
                entidad.getValorUnitario(),entidad.getValorTotal(), entidad.getObservacion())).orElse(null);

    }

    @Override
    public Long guardar(TipoGI tipoGI) {
        EntidadTipoGI entidadTipoGI = new EntidadTipoGI(tipoGI.getCantidad(), tipoGI.getClasificacion(),tipoGI.getValorUnitario(),
                tipoGI.getValorTotal(), tipoGI.getObservacion());
        return this.repositorioTipoGIJpa.save(entidadTipoGI).getIdTipoGI();
    }

    @Override
    public boolean existe(TipoGI tipoGI) {
        return this.repositorioTipoGIJpa.findById(tipoGI.getIdTipoGI()).isPresent();
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioTipoGIJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(TipoGI tipoGI, Long id) {
        repositorioTipoGIJpa.findById(id);
        EntidadTipoGI entidadTipoGI = new EntidadTipoGI();
        entidadTipoGI.setIdTipoGI(id);
        entidadTipoGI.setCantidad(tipoGI.getCantidad());
        repositorioTipoGIJpa.save(entidadTipoGI);
        return id;
    }
}
