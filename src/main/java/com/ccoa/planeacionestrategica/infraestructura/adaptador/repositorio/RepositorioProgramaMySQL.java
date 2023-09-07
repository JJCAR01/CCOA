package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.programa.DetallePrograma;
import com.ccoa.planeacionestrategica.dominio.modelo.programa.InformacionPrograma;
import com.ccoa.planeacionestrategica.dominio.modelo.programa.Programa;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioPrograma;
import com.ccoa.planeacionestrategica.dominio.transversal.formateador.FormateadorHora;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadArea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadImperativoEstrategico;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.usuario.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.programa.EntidadDetallePograma;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.programa.EntidadInformacionPrograma;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.programa.EntidadPrograma;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioAreaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioImperativoEstrategicoJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.programa.RepositorioDetalleProgramaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.programa.RepositorioInformacionProgramaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.programa.RepositorioProgramaJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioProgramaMySQL implements RepositorioPrograma {

    private final RepositorioProgramaJpa repositorioProgramaJpa;
    private final RepositorioDetalleProgramaJpa repositorioDetalleProgramaJpa;
    private final RepositorioInformacionProgramaJpa repositorioInformacionProgramaJpa;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioAreaJpa repositorioAreaJpa;
    private final RepositorioImperativoEstrategicoJpa repositorioImperativoEstrategicoJpa;

    public RepositorioProgramaMySQL(RepositorioProgramaJpa repositorioProgramaJpa, RepositorioDetalleProgramaJpa repositorioDetalleProgramaJpa, RepositorioInformacionProgramaJpa repositorioInformacionProgramaJpa, RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioAreaJpa repositorioAreaJpa, RepositorioImperativoEstrategicoJpa repositorioImperativoEstrategicoJpa) {
        this.repositorioProgramaJpa = repositorioProgramaJpa;
        this.repositorioDetalleProgramaJpa = repositorioDetalleProgramaJpa;
        this.repositorioInformacionProgramaJpa = repositorioInformacionProgramaJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioAreaJpa = repositorioAreaJpa;
        this.repositorioImperativoEstrategicoJpa = repositorioImperativoEstrategicoJpa;
    }

    @Override
    public List<Programa> listarPrograma() {
        List<EntidadPrograma> programas = this.repositorioProgramaJpa.findAll();
        return programas.stream().map(entidad -> Programa.listar(entidad.getNombre(), entidad.getCodigo(), entidad.getVersion(),entidad.getFechaInicio(),
                entidad.getFechaFinal(),entidad.getFechaRegistro())).toList();

    }

    @Override
    public List<DetallePrograma> listarDetallePrograma() {
        List<EntidadDetallePograma> detallePogramas = this.repositorioDetalleProgramaJpa.findAll();
        return detallePogramas.stream().map(entidad -> DetallePrograma.of(entidad.getIdImperativoEstrategico(), entidad.getIdUsuario(),
                entidad.getIdArea())).toList();
    }

    @Override
    public List<InformacionPrograma> listarInformacionPrograma() {
        List<EntidadInformacionPrograma> informacionProgramas = this.repositorioInformacionProgramaJpa.findAll();
        return informacionProgramas.stream().map(entidad -> InformacionPrograma.of(entidad.getPorcentajeReal(), entidad.getPorcentajeEsperado(),
                entidad.getCumplimiento(),entidad.getPresupuestoIngreso(),entidad.getPresupuestoGasto())).toList();
    }

    @Override
    public Programa consultarPorId(Long id) {
        return this.repositorioProgramaJpa
                .findById(id)
                .map(entidad ->  Programa.listar(entidad.getNombre(), entidad.getCodigo(), entidad.getVersion(),entidad.getFechaInicio(),
                        entidad.getFechaFinal(),entidad.getFechaRegistro())).orElse(null);

    }

    @Override
    public Long guardar(Programa programa, DetallePrograma detallePrograma, InformacionPrograma informacionPrograma) {
        Optional<EntidadUsuario> entidadUsuario = this.repositorioUsuarioJpa.findById(detallePrograma.getIdUsuario());
        Optional<EntidadArea> entidadArea = this.repositorioAreaJpa.findById(detallePrograma.getIdArea());
        Optional<EntidadImperativoEstrategico> entidadImperativoEstrategico = this.repositorioImperativoEstrategicoJpa.findById(detallePrograma.getIdImperativoEstrategico());

        var entidadPrograma = new EntidadPrograma(programa.getNombre(), programa.getCodigo(), programa.getVersion(), FormateadorHora.obtenerFechaTexto(programa.getFechaInicio()),
                FormateadorHora.obtenerFechaTexto(programa.getFechaFinal()), programa.getFechaRegistro());
        var entidadInformacionPrograma = new EntidadInformacionPrograma(informacionPrograma.getPorcentajeReal(),
                informacionPrograma.getPorcentajeEsperado(),informacionPrograma.getCumplimiento(),informacionPrograma.getPresupuestoIngreso(),
                informacionPrograma.getPresupuestoGasto());
        var entidadDetallePrograma = new EntidadDetallePograma(entidadArea.get().getIdArea(),entidadUsuario.get().getIdUsuario(),
                entidadImperativoEstrategico.get().getIdImperativoEstrategico());

        this.repositorioDetalleProgramaJpa.save(entidadDetallePrograma);
        this.repositorioInformacionProgramaJpa.save(entidadInformacionPrograma);

        return this.repositorioProgramaJpa.save(entidadPrograma).getIdPrograma();
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

        /*Optional<EntidadUsuario> entidadUsuario = this.repositorioUsuarioJpa.findById(detallePrograma.getIdUsuario());
        Optional<EntidadArea> entidadArea = this.repositorioAreaJpa.findById(detallePrograma.getIdArea());
        Optional<EntidadImperativoEstrategico> entidadImperativoEstrategico = this.repositorioImperativoEstrategicoJpa.findById(detallePrograma.getIdImperativoEstrategico());
        */

        repositorioProgramaJpa.findById(id);
        EntidadPrograma entidadPrograma = new EntidadPrograma();
        entidadPrograma.setIdPrograma(id);
        entidadPrograma.setNombre(programa.getNombre());

        repositorioProgramaJpa.save(entidadPrograma);
        return id;
    }
}
