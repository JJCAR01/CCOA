package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.epica.InformacionEpica;
import com.ccoa.planeacionestrategica.dominio.modelo.epica.Epica;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioEpica;
import com.ccoa.planeacionestrategica.dominio.transversal.formateador.FormateadorHora;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.epica.EntidadEpica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.epica.EntidadInformacionEpica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.usuario.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.epica.RepositorioEpicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.epica.RepositorioInformacionEpicaJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioEpicaMySQL implements RepositorioEpica {

    private final RepositorioEpicaJpa repositorioEpicaJpa;
    private final RepositorioInformacionEpicaJpa repositorioInformacionEpicaJpa;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioAreaJpa repositorioAreaJpa;


    public RepositorioEpicaMySQL(RepositorioEpicaJpa repositorioEpicaJpa, RepositorioInformacionEpicaJpa repositorioInformacionEpicaJpa, RepositorioUsuarioJpa repositorioUsuarioJpa,
                                 RepositorioAreaJpa repositorioAreaJpa) {
        this.repositorioEpicaJpa = repositorioEpicaJpa;
        this.repositorioInformacionEpicaJpa = repositorioInformacionEpicaJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioAreaJpa = repositorioAreaJpa;
    }

    @Override
    public List<Epica> listarEpica() {
        List<EntidadEpica> programas = this.repositorioEpicaJpa.findAll();
        return programas.stream().map(entidad -> Epica.listar(entidad.getIdEpica(),entidad.getNombre(),entidad.getFechaInicio(),
                entidad.getFechaFinal(),entidad.getFechaRegistro(),entidad.getIdUsuario())).toList();

    }


    @Override
    public List<InformacionEpica> listarInformacionEpica() {
        List<EntidadInformacionEpica> informacionProgramas = this.repositorioInformacionEpicaJpa.findAll();
        return informacionProgramas.stream().map(entidad -> InformacionEpica.of(entidad.getDuracion(),
                entidad.getDiasRestantes(),entidad.getEstado(),entidad.getAvance())).toList();
    }

    @Override
    public Epica consultarPorId(Long id) {
        return this.repositorioEpicaJpa
                .findById(id)
                .map(entidad ->  Epica.listar(entidad.getIdEpica(),entidad.getNombre(),entidad.getFechaInicio(),
                        entidad.getFechaFinal(),entidad.getFechaRegistro(), entidad.getIdUsuario())).orElse(null);

    }

    @Override
    public Long guardar(Epica epica, InformacionEpica informacionEpica) {
        Optional<EntidadUsuario> entidadUsuario = this.repositorioUsuarioJpa.findById(epica.getIdUsuario());

        var entidadEpica = new EntidadEpica(epica.getNombre(), FormateadorHora.obtenerFechaTexto(epica.getFechaInicio()),
                FormateadorHora.obtenerFechaTexto(epica.getFechaFinal()), epica.getFechaRegistro(),entidadUsuario.get().getIdUsuario());
        var entidadInformacionEpica = new EntidadInformacionEpica(informacionEpica.getDuracion(),
                informacionEpica.getDiasRestantes(),informacionEpica.getEstado(),informacionEpica.getAvance());

        this.repositorioInformacionEpicaJpa.save(entidadInformacionEpica);

        return this.repositorioEpicaJpa.save(entidadEpica).getIdEpica();
    }

    @Override
        public boolean existe(Epica epica,InformacionEpica informacionEpica) {
        return this.repositorioEpicaJpa.findByNombre(epica.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioEpicaJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Epica epica, Long id) {

        /*Optional<EntidadUsuario> entidadUsuario = this.repositorioUsuarioJpa.findById(detallePrograma.getIdUsuario());
        Optional<EntidadArea> entidadArea = this.repositorioAreaJpa.findById(detallePrograma.getIdArea());
        Optional<EntidadImperativoEstrategico> entidadImperativoEstrategico = this.repositorioImperativoEstrategicoJpa.findById(detallePrograma.getIdImperativoEstrategico());
        */

        repositorioEpicaJpa.findById(id);
        EntidadEpica entidadEpica = new EntidadEpica();
        entidadEpica.setIdEpica(id);
        entidadEpica.setNombre(epica.getNombre());

        repositorioEpicaJpa.save(entidadEpica);
        return id;
    }
}
