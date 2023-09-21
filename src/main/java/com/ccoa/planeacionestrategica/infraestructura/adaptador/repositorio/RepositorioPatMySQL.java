package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.*;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.pat.EntidadPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.usuario.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioPatMySQL implements RepositorioPat {

    private final RepositorioPatJpa repositorioPatJpa;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    public RepositorioPatMySQL(RepositorioPatJpa repositorioPatJpa, RepositorioUsuarioJpa repositorioUsuarioJpa) {
        this.repositorioPatJpa = repositorioPatJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
    }

    @Override
    public List<Pat> listar() {
        List<EntidadPat> entidadPats =this.repositorioPatJpa.findAll();
        return entidadPats.stream().map(entidad -> Pat.listar(entidad.getIdPat(), entidad.getNombre(),entidad.getFechaAnual(),
                entidad.getFechaRegistro(),entidad.getPorcentaje(), String.valueOf(entidad.getProceso()), entidad.getIdUsuario())).toList();
    }


    @Override
    public Pat consultarPorId(Long id) {
        return this.repositorioPatJpa
                .findById(id)
                .map(entidad ->  Pat.listar(entidad.getIdPat(), entidad.getNombre(),entidad.getFechaAnual(),
                        entidad.getFechaRegistro(),entidad.getPorcentaje(), String.valueOf(entidad.getProceso()),
                        entidad.getIdUsuario()))
                .orElse(null);
    }

    @Override
    public Long guardar(Pat pat) {
        Optional<EntidadUsuario> entidadUsuario = this.repositorioUsuarioJpa.findById(pat.getIdUsuario());

        EntidadPat entidadPat = new EntidadPat(pat.getNombre(), pat.getFechaAnual(),
                pat.getFechaRegistro(),pat.getPorcentaje(),pat.getProceso(),
                entidadUsuario.get().getIdUsuario());

        return this.repositorioPatJpa.save(entidadPat).getIdPat();
    }

    @Override
    public boolean existe(Pat pat) {
        return this.repositorioPatJpa.findByNombre(pat.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioPatJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Pat pat, Long id) {

        Optional<EntidadUsuario> entidadUsuario = this.repositorioUsuarioJpa.findById(pat.getIdUsuario());

        repositorioPatJpa.findById(id);
        EntidadPat entidadPat = new EntidadPat();
        entidadPat.setIdPat(id);
        entidadPat.setNombre(pat.getNombre());
        entidadPat.setIdUsuario(entidadUsuario.get().getIdUsuario());

        repositorioPatJpa.save(entidadPat);
        return id;
    }

}
