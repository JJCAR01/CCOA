package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.*;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioImperativoEstrategico;
import com.ccoa.planeacionestrategica.dominio.transversal.formateador.FormateadorHora;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.usuario.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadImperativoEstrategico;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioImperativoEstrategicoJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioImperativoEstrategicoMySQL implements RepositorioImperativoEstrategico {

    private final RepositorioImperativoEstrategicoJpa repositorioImperativoEstrategicoJpa;
    private final RepositorioPatJpa repositorioPatJpa;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;

    public RepositorioImperativoEstrategicoMySQL(RepositorioImperativoEstrategicoJpa repositorioImperativoEstrategicoJpa, RepositorioPatJpa repositorioPatJpa,
                                                 RepositorioUsuarioJpa repositorioUsuarioJpa) {
        this.repositorioImperativoEstrategicoJpa = repositorioImperativoEstrategicoJpa;
        this.repositorioPatJpa = repositorioPatJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
    }

    @Override
    public List<ImperativoEstrategico> listar() {
        List<EntidadImperativoEstrategico> entidadImperativoEstrategicos =this.repositorioImperativoEstrategicoJpa.findAll();
        return entidadImperativoEstrategicos.stream().map(entidad -> ImperativoEstrategico.listar(entidad.getIdImperativoEstrategico(), entidad.getNombre(),
                entidad.getFechaInicio(),
                entidad.getFechaFinal(),
                entidad.getFechaRegistro(), entidad.getPorcentajeReal(), entidad.getPorcentajeEsperado(), entidad.getCumplimiento(),
                entidad.getIdPat(), entidad.getIdUsuario())).toList();
    }

    @Override
    public ImperativoEstrategico consultarPorId(Long id) {
        return this.repositorioImperativoEstrategicoJpa
                .findById(id)
                .map(entidad -> ImperativoEstrategico.listar(entidad.getIdImperativoEstrategico(), entidad.getNombre(),
                        entidad.getFechaInicio(),
                        entidad.getFechaFinal(),
                        entidad.getFechaRegistro(), entidad.getPorcentajeReal(), entidad.getPorcentajeEsperado(),
                        entidad.getCumplimiento(), entidad.getIdPat(), entidad.getIdUsuario()))
                .orElse(null);
    }


    @Override
    public Long guardar(ImperativoEstrategico imperativoEstrategico) {
        Optional<EntidadUsuario> entidadUsuario = this.repositorioUsuarioJpa.findById(imperativoEstrategico.getIdUsuario());
        Optional<EntidadPat> entidadPat = this.repositorioPatJpa.findById(imperativoEstrategico.getIdPat());

        EntidadImperativoEstrategico entidadImperativoEstrategico = new EntidadImperativoEstrategico(imperativoEstrategico.getNombre(),
                FormateadorHora.obtenerFechaTexto(imperativoEstrategico.getFechaInicio()),
                FormateadorHora.obtenerFechaTexto(imperativoEstrategico.getFechaFinal()),imperativoEstrategico.getFechaRegistro(), imperativoEstrategico.getPorcentajeReal(),
                imperativoEstrategico.getPorcentajeEsperado(), imperativoEstrategico.getCumplimiento(), entidadPat.get().getIdPat() ,
                entidadUsuario.get().getIdUsuario());

        return this.repositorioImperativoEstrategicoJpa.save(entidadImperativoEstrategico).getIdImperativoEstrategico();
    }

    @Override
    public boolean existe(ImperativoEstrategico imperativoEstrategico) {
        return this.repositorioImperativoEstrategicoJpa.findByNombre(imperativoEstrategico.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioImperativoEstrategicoJpa.deleteById(id);
        return id;
    }


    @Override
    public Long modificar(ImperativoEstrategico imperativoEstrategico, Long id) {
        Optional<EntidadUsuario> entidadUsuario = this.repositorioUsuarioJpa.findById(imperativoEstrategico.getIdUsuario());
        Optional<EntidadPat> entidadPat = this.repositorioPatJpa.findById(imperativoEstrategico.getIdPat());

        repositorioImperativoEstrategicoJpa.findById(id);
        EntidadImperativoEstrategico entidadImperativoEstrategico = new EntidadImperativoEstrategico();
        entidadImperativoEstrategico.setIdImperativoEstrategico(id);
        entidadImperativoEstrategico.setNombre(imperativoEstrategico.getNombre());

        entidadImperativoEstrategico.setIdPat(entidadPat.get().getIdPat());
        entidadImperativoEstrategico.setIdUsuario(entidadUsuario.get().getIdUsuario());

        repositorioImperativoEstrategicoJpa.save(entidadImperativoEstrategico);
        return id;

    }


}
