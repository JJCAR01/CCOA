package com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionestrategica.DtoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.dto.proyectoarea.DtoProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoSprint;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprintproyectoarea.DtoSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio.ServicioAplicacionGuardarActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.servicio.ServicioAplicacionGuardarActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.servicio.ServicioAplicacionGuardarActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.servicio.ServicioAplicacionGuardarProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.servicio.ServicioAplicacionGuardarProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio.ServicioAplicacionGuardarSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.servicio.ServicioAplicacionGuardarSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.servicio.tarea.ServicioAplicacionGuardarTarea;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.DetallePat;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.InformacionPat;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.Pat;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadestrategica.RepositorioActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestion.RepositorioActividadGestion;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestionestrategica.RepositorioActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.pat.RepositorioDuplicar;
import com.ccoa.planeacionestrategica.dominio.puerto.proyecto.RepositorioProyecto;
import com.ccoa.planeacionestrategica.dominio.puerto.proyectoarea.RepositorioProyectoArea;
import com.ccoa.planeacionestrategica.dominio.puerto.sprint.RepositorioSprint;
import com.ccoa.planeacionestrategica.dominio.puerto.sprintproyectoarea.RepositorioSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.puerto.tarea.RepositorioTarea;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.mapeador.MapeadorDetallePat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.mapeador.MapeadorInformacionPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.mapeador.MapeadorPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioDetallePatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioInformacionPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.mapeador.MapeadorInformacionUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa.RepositorioInformacionUsuarioJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ccoa.planeacionestrategica.dominio.transversal.enums.ETipoASE.*;

@Repository
public class RepositorioDuplicarMySQL implements RepositorioDuplicar {
    private final MapeadorPat mapeadorPat;
    private final RepositorioPatJpa repositorioPatJpa;
    private final MapeadorInformacionPat mapeadorInformacionPat;
    private final MapeadorDetallePat mapeadorDetallePat;
    private final RepositorioInformacionPatJpa repositorioInformacionPatJpa;
    private final RepositorioDetallePatJpa repositorioDetallePatJpa;
    private final MapeadorInformacionUsuario mapeadorInformacionUsuario;
    private final RepositorioInformacionUsuarioJpa repositorioInformacionUsuarioJpa;
    private final RepositorioActividadEstrategica repositorioActividadEstrategica;
    private final RepositorioActividadGestion repositorioActividadGestion;
    private final RepositorioActividadGestionEstrategica repositorioActividadGestionEstrategica;
    private final RepositorioProyecto repositorioProyecto;
    private final RepositorioProyectoArea repositorioProyectoArea;
    private final RepositorioTarea repositorioTarea;
    private final RepositorioSprint repositorioSprint;
    private final RepositorioSprintProyectoArea repositorioSprintProyectoArea;
    private final ServicioAplicacionGuardarActividadEstrategica servicioAplicacionGuardarActividadEstrategica;
    private final ServicioAplicacionGuardarTarea servicioAplicacionGuardarTarea;
    private final ServicioAplicacionGuardarActividadGestionEstrategica servicioAplicacionGuardarActividadGestionEstrategica;
    private final ServicioAplicacionGuardarActividadGestion servicioAplicacionGuardarActividadGestion;
    private final ServicioAplicacionGuardarSprint servicioAplicacionGuardarSprint;
    private final ServicioAplicacionGuardarSprintProyectoArea servicioAplicacionGuardarSprintProyectoArea;
    private final ServicioAplicacionGuardarProyecto servicioAplicacionGuardarProyecto;
    private final ServicioAplicacionGuardarProyectoArea servicioAplicacionGuardarProyectoArea;

    public RepositorioDuplicarMySQL(MapeadorPat mapeadorPat, RepositorioPatJpa repositorioPatJpa, MapeadorInformacionPat mapeadorInformacionPat, MapeadorDetallePat mapeadorDetallePat, RepositorioInformacionPatJpa repositorioInformacionPatJpa, RepositorioDetallePatJpa repositorioDetallePatJpa, MapeadorInformacionUsuario mapeadorInformacionUsuario, RepositorioInformacionUsuarioJpa repositorioInformacionUsuarioJpa, RepositorioActividadEstrategica repositorioActividadEstrategica, RepositorioActividadGestion repositorioActividadGestion, RepositorioActividadGestionEstrategica repositorioActividadGestionEstrategica, RepositorioProyecto repositorioProyecto, RepositorioProyectoArea repositorioProyectoArea, RepositorioTarea repositorioTarea, RepositorioSprint repositorioSprint, RepositorioSprintProyectoArea repositorioSprintProyectoArea, ServicioAplicacionGuardarActividadEstrategica servicioAplicacionGuardarActividadEstrategica, ServicioAplicacionGuardarTarea servicioAplicacionGuardarTarea, ServicioAplicacionGuardarActividadGestionEstrategica servicioAplicacionGuardarActividadGestionEstrategica, ServicioAplicacionGuardarActividadGestion servicioAplicacionGuardarActividadGestion, ServicioAplicacionGuardarSprint servicioAplicacionGuardarSprint, ServicioAplicacionGuardarSprintProyectoArea servicioAplicacionGuardarSprintProyectoArea, ServicioAplicacionGuardarProyecto servicioAplicacionGuardarProyecto, ServicioAplicacionGuardarProyectoArea servicioAplicacionGuardarProyectoArea) {
        this.mapeadorPat = mapeadorPat;
        this.repositorioPatJpa = repositorioPatJpa;
        this.mapeadorInformacionPat = mapeadorInformacionPat;
        this.mapeadorDetallePat = mapeadorDetallePat;
        this.repositorioInformacionPatJpa = repositorioInformacionPatJpa;
        this.repositorioDetallePatJpa = repositorioDetallePatJpa;
        this.mapeadorInformacionUsuario = mapeadorInformacionUsuario;
        this.repositorioInformacionUsuarioJpa = repositorioInformacionUsuarioJpa;
        this.repositorioActividadEstrategica = repositorioActividadEstrategica;
        this.repositorioActividadGestion = repositorioActividadGestion;
        this.repositorioActividadGestionEstrategica = repositorioActividadGestionEstrategica;
        this.repositorioProyecto = repositorioProyecto;
        this.repositorioProyectoArea = repositorioProyectoArea;
        this.repositorioTarea = repositorioTarea;
        this.repositorioSprint = repositorioSprint;
        this.repositorioSprintProyectoArea = repositorioSprintProyectoArea;
        this.servicioAplicacionGuardarActividadEstrategica = servicioAplicacionGuardarActividadEstrategica;
        this.servicioAplicacionGuardarTarea = servicioAplicacionGuardarTarea;
        this.servicioAplicacionGuardarActividadGestionEstrategica = servicioAplicacionGuardarActividadGestionEstrategica;
        this.servicioAplicacionGuardarActividadGestion = servicioAplicacionGuardarActividadGestion;
        this.servicioAplicacionGuardarSprint = servicioAplicacionGuardarSprint;
        this.servicioAplicacionGuardarSprintProyectoArea = servicioAplicacionGuardarSprintProyectoArea;
        this.servicioAplicacionGuardarProyecto = servicioAplicacionGuardarProyecto;
        this.servicioAplicacionGuardarProyectoArea = servicioAplicacionGuardarProyectoArea;
    }

    @Override
    public Long guardarDuplicado(Pat pat, InformacionPat informacionPat, DetallePat detallePat, Long codigo) {
        var entidadPat = mapeadorPat.mapeadorEntidad(pat);
        var idPatCreado = this.repositorioPatJpa.save(entidadPat).getIdPat();

        var entidadInformacionPat = mapeadorInformacionPat.mapeadorEntidad(informacionPat);
        entidadInformacionPat.setIdInformacionPat(idPatCreado);

        var entidadDetallePat = mapeadorDetallePat.mapeadorEntidad(detallePat);
        entidadDetallePat.setIdDetallePat(idPatCreado);

        this.repositorioInformacionPatJpa.save(entidadInformacionPat);
        this.repositorioDetallePatJpa.save(entidadDetallePat);
        var entidadUsuario = mapeadorInformacionUsuario.obtenerUsuario(pat.getIdUsuario());
        mapeadorInformacionUsuario.actualizarPatsPorPat(entidadUsuario, pat);
        repositorioInformacionUsuarioJpa.save(entidadUsuario);

        var fechaAnual = entidadPat.getFechaAnual();

        duplicarActividadesEstrategicas(codigo, idPatCreado, fechaAnual);
        duplicarActividadesGestion(codigo, idPatCreado,fechaAnual);
        duplicarProyectosArea(codigo, idPatCreado,fechaAnual);

        return idPatCreado;
    }
    private void duplicarActividadesEstrategicas(Long codigo, Long idPatCreado, Integer fechaAnual) {
        List<DtoActividadEstrategica> entidadesActivdidadEstrategica = repositorioActividadEstrategica.consultarPorIdPatParaDuplicarActividadesEstrategicas(codigo);
        if(!entidadesActivdidadEstrategica.isEmpty()){
            for (DtoActividadEstrategica eActividadEstrategica : entidadesActivdidadEstrategica) {
                var idActividadEstrategica = eActividadEstrategica.getIdActividadEstrategica();
                var idActividadEstrategicaGuardada = servicioAplicacionGuardarActividadEstrategica.guardarDuplicado(eActividadEstrategica, idPatCreado,fechaAnual);

                // Obtener y duplicar actividades de gestión estratégica
                List<DtoActividadGestionEstrategica> entidadesActividadGestionEstrategicas = repositorioActividadGestionEstrategica.consultarPorIdActividadEstrategicaParaDuplicar(idActividadEstrategica);
                if(!entidadesActividadGestionEstrategicas.isEmpty()){
                    duplicarActividadesGestionEstrategicas(entidadesActividadGestionEstrategicas, idActividadEstrategicaGuardada.getValor(),fechaAnual);
                }

                // Obtener y duplicar proyectos asociados a la actividad estratégica
                List<DtoProyecto> entidadesProyecto = repositorioProyecto.consultarPorIdActividadEstrategicaParaDuplicar(idActividadEstrategica);
                if(!entidadesProyecto.isEmpty()) {
                    duplicarProyectos(entidadesProyecto, idActividadEstrategicaGuardada.getValor(),fechaAnual);
                }
            }
        }
    }

    private void duplicarActividadesGestion(Long codigo, Long idPatCreado, Integer fechaAnual) {
        List<DtoActividadGestion> entidadesActividadGestion = repositorioActividadGestion.consultarPorIdPatParaDuplicar(codigo);
        if(!entidadesActividadGestion.isEmpty()){
            for (DtoActividadGestion eActividadGestion : entidadesActividadGestion) {
                var idActividadGestion = eActividadGestion.getIdActividadGestion();
                var idActividadGestionGuardado = servicioAplicacionGuardarActividadGestion.guardarDuplicado(eActividadGestion, idPatCreado,fechaAnual);
                List<DtoTarea> entidadTarea = repositorioTarea.consultarPorIdActividadGestionParaDuplicar(idActividadGestion, ACTIVIDAD_GESTION);
                if(!entidadTarea.isEmpty()) {
                    duplicarTareas(entidadTarea, idActividadGestionGuardado.getValor());
                }
            }
        }
    }
    private void duplicarActividadesGestionEstrategicas(List<DtoActividadGestionEstrategica> entidadesActividadGestionEstrategicas, Long idActividadEstrategicaGuardada,
                                                        Integer fechaAnual) {
        for (DtoActividadGestionEstrategica eActividadGestionEstrategica : entidadesActividadGestionEstrategicas) {
            var idActividadGestionEstrategica = eActividadGestionEstrategica.getIdActividadGestionEstrategica();
            var idActividadGestionEstrategicaGuardada = servicioAplicacionGuardarActividadGestionEstrategica.guardarDuplicado(eActividadGestionEstrategica, idActividadEstrategicaGuardada,fechaAnual);

            // Obtener y duplicar tareas asociadas a la actividad de gestión estratégica
            List<DtoTarea> entidadTarea = repositorioTarea.consultarPorIdActividadGestionActvidadEstrategicaParaDuplicar(idActividadGestionEstrategica, ACTIVIDAD_GESTION_ACTIVIDAD_ESTRATEGICA);
            if(!entidadTarea.isEmpty()) {
                duplicarTareas(entidadTarea, idActividadGestionEstrategicaGuardada.getValor());
            }
        }
    }
    private void duplicarProyectos(List<DtoProyecto> entidadesProyecto, Long idActividadEstrategicaGuardada,Integer fechaAnual) {
        for (DtoProyecto eProyecto : entidadesProyecto) {
            var idProyecto = eProyecto.getIdProyecto();
            var idProyectoGuardada = servicioAplicacionGuardarProyecto.guardarDuplicado(eProyecto, idActividadEstrategicaGuardada,fechaAnual);

            // Obtener y duplicar sprints asociados al proyecto
            List<DtoSprint> entidadesSprint = repositorioSprint.consultarPorIdProyectoParaDuplicar(idProyecto);
            if(!entidadesSprint.isEmpty()) {
                duplicarSprints(entidadesSprint, idProyectoGuardada.getValor(),fechaAnual);
            }
        }
    }
    private void duplicarSprints(List<DtoSprint> entidadesSprint, Long idProyectoGuardado,Integer fechaAnual) {
        for (DtoSprint eSprint : entidadesSprint) {
            var idSprint = eSprint.getIdSprint();
            var isSprintGuardado = servicioAplicacionGuardarSprint.guardarDuplicado(eSprint, idProyectoGuardado,fechaAnual);

            // Obtener y duplicar tareas asociadas al sprint
            List<DtoTarea> entidadTarea = repositorioTarea.consultarPorIdSprintParaDuplicar(idSprint, SPRINT);
            if(!entidadTarea.isEmpty()) {
                duplicarTareas(entidadTarea, isSprintGuardado.getValor());
            }
        }
    }
    private void duplicarSprintsProyectoArea(List<DtoSprintProyectoArea> entidadesSprintProyectoArea, Long idProyectoAreaGuardado,Integer fechaAnual) {
        for (DtoSprintProyectoArea eSprintProyectoArea : entidadesSprintProyectoArea) {
            var idSprintProyectoArea = eSprintProyectoArea.getIdSprintProyectoArea();
            var idSprintProyectoAreaGuardado = servicioAplicacionGuardarSprintProyectoArea.guardarDuplicado(eSprintProyectoArea, idProyectoAreaGuardado,fechaAnual);
            List<DtoTarea> entidadTarea = repositorioTarea.consultarPorIdSprintProyectoAreaParaDuplicar(idSprintProyectoArea, SPRINT_PROYECTO_AREA);
            if(!entidadTarea.isEmpty()) {
                duplicarTareas(entidadTarea, idSprintProyectoAreaGuardado.getValor());
            }
        }
    }

    private void duplicarProyectosArea(Long codigo, Long idPatCreado, Integer fechaAnual) {
        List<DtoProyectoArea> entidadesProyectoArea = repositorioProyectoArea.consultarPorIdPatParaDuplicar(codigo);
        if(!entidadesProyectoArea.isEmpty()){
            for (DtoProyectoArea eProyectoArea : entidadesProyectoArea) {
                var idProyectoArea = eProyectoArea.getIdProyectoArea();
                var idProyectoAreaGuardada = servicioAplicacionGuardarProyectoArea.guardarDuplicado(eProyectoArea, idPatCreado,fechaAnual);
                List<DtoSprintProyectoArea> entidadesSprintProyectoArea = repositorioSprintProyectoArea.consultarPorIdProyectoAreaParaDuplicar(idProyectoArea);
                if(!entidadesSprintProyectoArea.isEmpty()){
                    duplicarSprintsProyectoArea(entidadesSprintProyectoArea, idProyectoAreaGuardada.getValor(),fechaAnual);
                }
            }
        }
    }
    private void duplicarTareas(List<DtoTarea> entidadTarea, Long idCorrespondiente) {
        for (DtoTarea eTarea : entidadTarea) {
            servicioAplicacionGuardarTarea.guardarDuplicado(eTarea, idCorrespondiente);
        }
    }
}
