package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio;

import com.ccoa.planeacionestrategica.dominio.modelo.tarea.InformacionTarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.Tarea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTarea;
import com.ccoa.planeacionestrategica.dominio.transversal.formateador.FormateadorHora;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.pat.EntidadPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.tarea.EntidadInformacionTarea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.tarea.EntidadTarea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.usuario.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.tarea.RepositorioInformacionTareaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.tarea.RepositorioTareaJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioTareaMySQL implements RepositorioTarea {

    private final RepositorioTareaJpa repositorioTareaJpa;
    private final RepositorioInformacionTareaJpa repositorioInformacionTareaJpa;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioPatJpa repositorioPatJpa;


    public RepositorioTareaMySQL(RepositorioTareaJpa repositorioTareaJpa, RepositorioInformacionTareaJpa repositorioInformacionTareaJpa,
                                 RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioPatJpa repositorioPatJpa) {
        this.repositorioTareaJpa = repositorioTareaJpa;
        this.repositorioInformacionTareaJpa = repositorioInformacionTareaJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioPatJpa = repositorioPatJpa;
    }

    @Override
    public List<Tarea> listar() {
        List<EntidadTarea> tareas = this.repositorioTareaJpa.findAll();
        return tareas.stream().map(entidad -> Tarea.listar(entidad.getIdTarea(),entidad.getNombre(),entidad.getFechaInicio(),
                entidad.getFechaFinal(),entidad.getFechaRegistro(),entidad.getIdUsuario(), entidad.getIdPat())).toList();

    }


    @Override
    public List<InformacionTarea> listarInformacionTarea() {
        List<EntidadInformacionTarea> informacionTareas = this.repositorioInformacionTareaJpa.findAll();
        return informacionTareas.stream().map(entidad -> InformacionTarea.of(entidad.getDuracion(),
                entidad.getDiasRestantes(),entidad.getEstado(),entidad.getAvance())).toList();
    }

    @Override
    public Tarea consultarPorId(Long id) {
        return this.repositorioTareaJpa
                .findById(id)
                .map(entidad ->  Tarea.listar(entidad.getIdTarea(),entidad.getNombre(),entidad.getFechaInicio(),
                        entidad.getFechaFinal(),entidad.getFechaRegistro(), entidad.getIdUsuario(), entidad.getIdPat())).orElse(null);

    }

    @Override
    public Long guardar(Tarea tarea, InformacionTarea informacionTarea) {
        Optional<EntidadUsuario> entidadUsuario = this.repositorioUsuarioJpa.findById(tarea.getIdUsuario());
        Optional<EntidadPat> entidadPat = this.repositorioPatJpa.findById(tarea.getIdPat());

        var entidadTarea = new EntidadTarea( tarea.getNombre(), FormateadorHora.obtenerFechaTexto(tarea.getFechaInicio()),
                FormateadorHora.obtenerFechaTexto(tarea.getFechaFinal()), tarea.getFechaRegistro(),entidadUsuario.get().getIdUsuario(),
                entidadPat.get().getIdPat());
        var entidadInformacionTarea = new EntidadInformacionTarea(informacionTarea.getDuracion(),
                informacionTarea.getDiasRestantes(),informacionTarea.getEstado(),informacionTarea.getAvance());

        this.repositorioInformacionTareaJpa.save(entidadInformacionTarea);

        return this.repositorioTareaJpa.save(entidadTarea).getIdTarea();
    }

    @Override
        public boolean existe(Tarea tarea, InformacionTarea informacionEpica) {
        return this.repositorioTareaJpa.findByNombre(tarea.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioTareaJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Tarea tarea, Long id) {

        repositorioTareaJpa.findById(id);
        EntidadTarea entidadTarea = new EntidadTarea();
        entidadTarea.setIdTarea(id);
        entidadTarea.setNombre(tarea.getNombre());

        repositorioTareaJpa.save(entidadTarea);
        return id;
    }
}
