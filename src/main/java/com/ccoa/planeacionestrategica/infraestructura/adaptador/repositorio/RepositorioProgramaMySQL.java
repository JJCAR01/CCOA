package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.programa.DetallePrograma;
import com.ccoa.planeacionestrategica.dominio.modelo.programa.InformacionPrograma;
import com.ccoa.planeacionestrategica.dominio.modelo.programa.Programa;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioPrograma;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadPrograma;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioProgramaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioImperativoEstrategicoJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioProgramaMySQL implements RepositorioPrograma {

    private final RepositorioProgramaJpa repositorioProgramaJpa;
    private final RepositorioImperativoEstrategicoJpa repositorioImperativoEstrategicoJpa;
    private final RepositorioAreaJpa repositorioAreaJpa;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;

    public RepositorioProgramaMySQL(RepositorioProgramaJpa repositorioProgramaJpa, RepositorioImperativoEstrategicoJpa repositorioImperativoEstrategicoJpa,
                                    RepositorioAreaJpa repositorioAreaJpa, RepositorioUsuarioJpa repositorioUsuarioJpa) {
        this.repositorioProgramaJpa = repositorioProgramaJpa;
        this.repositorioImperativoEstrategicoJpa = repositorioImperativoEstrategicoJpa;
        this.repositorioAreaJpa = repositorioAreaJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
    }

    @Override
    public List<Programa> listar() {
        List<EntidadPrograma> programas = this.repositorioProgramaJpa.findAll();
        return programas.stream().map(entidad -> Programa.of(entidad.getNombre(), entidad.getCodigo(), entidad.getVersion(),entidad.getFechaInicio(),
                entidad.getFechaFinal(),entidad.getFechaRegistro())).toList();

    }

    @Override
    public Programa consultarPorId(Long id) {
        return this.repositorioProgramaJpa
                .findById(id)
                .map(entidad ->  Programa.of(entidad.getNombre(), entidad.getCodigo(), entidad.getVersion(),entidad.getFechaInicio(),
                        entidad.getFechaFinal(),entidad.getFechaRegistro())).orElse(null);

    }

    @Override
    public Long guardar(Programa programa, DetallePrograma detallePrograma, InformacionPrograma informacionPrograma) {
        /*EntidadImperativoEstrategico entidadImperativoEstrategico = this.repositorioImperativoEstrategicoJpa.findByNombre(programa.getImperativoEstrategico().getNombre());
        EntidadArea entidadArea = this.repositorioAreaJpa.findByNombre(programa.getArea().getNombre());
        EntidadUsuario entidadUsuario = this.repositorioUsuarioJpa.findByNombreAndApellidos(programa.getUsuario().getNombre(),
                programa.getUsuario().getApellidos());

        EntidadPrograma entidadPrograma = new EntidadPrograma(programa.getNombre(), programa.getCodigo(), programa.getVersion(), programa.getFechaInicio(),
                programa.getFechaFinal(),programa.getFechaRegistro(),programa.getPresupuestoIngreso(),programa.getPresupuestoGasto(),entidadArea,entidadUsuario,
                entidadImperativoEstrategico);

        return this.repositorioProgramaJpa.save(entidadPrograma).getId();*/return null;
    }

    @Override
    public boolean existe(Programa programa, DetallePrograma detallePrograma, InformacionPrograma informacionPrograma) {
        return this.repositorioProgramaJpa.findByNombre(programa.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioProgramaJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Programa programa, Long id) {
        /*
        EntidadImperativoEstrategico entidadImperativoEstrategico = this.repositorioImperativoEstrategicoJpa.findByNombre(programa.getImperativoEstrategico().getNombre());
        EntidadArea entidadArea = this.repositorioAreaJpa.findByNombre(programa.getArea().getNombre());
        EntidadUsuario entidadUsuario = this.repositorioUsuarioJpa.findByNombreAndApellidos(programa.getUsuario().getNombre(),
                programa.getUsuario().getApellidos());

        repositorioProgramaJpa.findById(id);
        EntidadPrograma entidadPrograma = new EntidadPrograma();
        entidadPrograma.setId(id);
        entidadPrograma.setNombre(programa.getNombre());

        entidadPrograma.setArea(entidadArea);
        entidadPrograma.setUsuario(entidadUsuario);
        entidadPrograma.setImperativoEstrategico(entidadImperativoEstrategico);

        repositorioProgramaJpa.save(entidadPrograma);
        return id;*/return null;
    }
}
