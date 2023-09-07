package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.registroactividad.Documento;
import com.ccoa.planeacionestrategica.dominio.modelo.registroactividad.RegistroActividad;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRegistroActividad;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioRegistroActividadMySQL implements RepositorioRegistroActividad {
    @Override
    public Long guardarDocumento(Documento documento, Long idRegistroActividad) {
        return null;
    }

    @Override
    public List<RegistroActividad> listar() {
        return null;
    }

    @Override
    public RegistroActividad consultarPorId(Long id) {
        return null;
    }

    @Override
    public Long guardar(RegistroActividad registroActividad) {
        return null;
    }

    @Override
    public boolean existe(RegistroActividad registroActividad) {
        return false;
    }

    @Override
    public Long eliminar(Long id) {
        return null;
    }

    @Override
    public Long modificar(RegistroActividad registroActividad, Long id) {
        return null;
    }
}
