package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.*;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioLineaEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadLineaEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.programa.EntidadPrograma;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioLineaEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.programa.RepositorioProgramaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioLineaEstrategicaMySQL implements RepositorioLineaEstrategica {

    private final RepositorioLineaEstrategicaJpa repositorioLineaEstrategicaJpa;
    private final RepositorioProgramaJpa repositorioProgramaJpa;

    private final RepositorioUsuarioJpa repositorioUsuarioJpa;

    public RepositorioLineaEstrategicaMySQL(RepositorioLineaEstrategicaJpa repositorioLineaEstrategicaJpa, RepositorioProgramaJpa repositorioProgramaJpa, RepositorioUsuarioJpa repositorioUsuarioJpa) {
        this.repositorioLineaEstrategicaJpa = repositorioLineaEstrategicaJpa;
        this.repositorioProgramaJpa = repositorioProgramaJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
    }

    @Override
    public List<LineaEstrategica> listar() {
        List<EntidadLineaEstrategica> lineaEstrategicas = this.repositorioLineaEstrategicaJpa.findAll();
        return lineaEstrategicas.stream().map(entidad -> LineaEstrategica.of(entidad.getNombre(),entidad.getEntregable(),entidad.getFechaInicio(),entidad.getFechaFinal(),
                entidad.getFechaRegistro(),entidad.getIndicadorResultado(),entidad.getIdPrograma(),entidad.getIdUsuario())).toList();
    }

    @Override
    public LineaEstrategica consultarPorId(Long id) {
        return this.repositorioLineaEstrategicaJpa
                .findById(id)
                .map(entidad -> LineaEstrategica.of(entidad.getNombre(),entidad.getEntregable(),entidad.getFechaInicio(),entidad.getFechaFinal(),
                        entidad.getFechaRegistro(),entidad.getIndicadorResultado(),entidad.getIdPrograma(),entidad.getIdUsuario())).orElse(null);

    }


    @Override
    public Long guardar(LineaEstrategica lineaEstrategica) {
        Optional<EntidadUsuario> entidadUsuario = this.repositorioUsuarioJpa.findById(lineaEstrategica.getIdUsuario());
        Optional<EntidadPrograma> entidadPrograma = this.repositorioProgramaJpa.findById(lineaEstrategica.getIdUsuario());

        EntidadLineaEstrategica entidadLineaEstrategica = new EntidadLineaEstrategica(lineaEstrategica.getNombre(), lineaEstrategica.getEntregable(),
                lineaEstrategica.getFechaInicio(),lineaEstrategica.getFechaFinal(),lineaEstrategica.getFechaRegistro(),lineaEstrategica.getIndicadorResultado(),
                entidadUsuario.get().getIdUsuario(),entidadPrograma.get().getIdPrograma());

        return this.repositorioLineaEstrategicaJpa.save(entidadLineaEstrategica).getId();
    }

    @Override
    public boolean existe(LineaEstrategica lineaEstrategica) {
        return this.repositorioLineaEstrategicaJpa.findByNombre(lineaEstrategica.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioLineaEstrategicaJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(LineaEstrategica lineaEstrategica, Long id) {
        Optional<EntidadUsuario> entidadUsuario = this.repositorioUsuarioJpa.findById(lineaEstrategica.getIdUsuario());
        Optional<EntidadPrograma> entidadPrograma = this.repositorioProgramaJpa.findById(lineaEstrategica.getIdUsuario());

        repositorioLineaEstrategicaJpa.findById(id);
        EntidadLineaEstrategica entidadLineaEstrategica = new EntidadLineaEstrategica();
        entidadLineaEstrategica.setId(id);
        entidadLineaEstrategica.setNombre(lineaEstrategica.getNombre());

        entidadLineaEstrategica.setIdPrograma(entidadPrograma.get().getIdPrograma());
        entidadLineaEstrategica.setIdUsuario(entidadUsuario.get().getIdUsuario());

        repositorioLineaEstrategicaJpa.save(entidadLineaEstrategica);
        return id;
    }
}
