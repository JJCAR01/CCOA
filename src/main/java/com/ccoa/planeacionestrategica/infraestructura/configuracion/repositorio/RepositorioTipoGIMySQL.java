package com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.TipoGI;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoGI;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioTipoGIMySQL implements RepositorioTipoGI {
    @Override
    public List<TipoGI> listar() {
        return null;
    }

    @Override
    public TipoGI consultarPorId(Long id) {
        return null;
    }

    @Override
    public Long guardar(TipoGI tipoGI) {
        return null;
    }

    @Override
    public boolean existe(TipoGI tipoGI) {
        return false;
    }

    @Override
    public Long eliminar(Long id) {
        return null;
    }

    @Override
    public Long modificar(TipoGI tipoGI, Long id) {
        return null;
    }
}
