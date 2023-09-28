package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.Gestion;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioGestion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadGestion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.pat.EntidadPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioPatJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioGestionMySQL implements RepositorioGestion {

    private final RepositorioGestionJpa repositorioGestionJpa;
    private final RepositorioPatJpa repositorioPatJpa;

    public RepositorioGestionMySQL(RepositorioGestionJpa repositorioGestionJpa, RepositorioPatJpa repositorioPatJpa) {
        this.repositorioGestionJpa = repositorioGestionJpa;
        this.repositorioPatJpa = repositorioPatJpa;
    }

    @Override
    public List<Gestion> listar() {
        List<EntidadGestion> gestiones = this.repositorioGestionJpa.findAll();
        return gestiones.stream().map(entidad -> Gestion.of(entidad.getIdGestion(), entidad.getNombre(), entidad.getIdPat())).toList();

    }

    @Override
    public Gestion consultarPorId(Long id) {
        return this.repositorioGestionJpa.findById(id).map(entidad -> Gestion.of(entidad.getIdGestion(), entidad.getNombre(), entidad.getIdPat())).orElse(null);

    }

    @Override
    public Long guardar(Gestion gestion) {
        Optional<EntidadPat> entidadPat = this.repositorioPatJpa.findById(gestion.getIdPat());


        EntidadGestion entidadGestion = new EntidadGestion(gestion.getIdGestion(), gestion.getNombre(), entidadPat.get().getIdPat());

        return this.repositorioGestionJpa.save(entidadGestion).getIdPat();
    }

    @Override
    public boolean existe(Gestion gestion) {
        return this.repositorioGestionJpa.findById(gestion.getIdGestion()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioGestionJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Gestion gestion, Long id) {
        return null;
    }

}
