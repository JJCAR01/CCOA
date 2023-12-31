package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadGestionActividadEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.ActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.InformacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.EEstado;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.ETipoASE;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerDiasRestantes;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.entidad.EntidadInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.mapeador.MapeadorInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.repositorio.jpa.RepositorioActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.adaptador.entidad.EntidadActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.adaptador.entidad.EntidadInformacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadGestionActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.adaptador.entidad.EntidadTarea;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.adaptador.repositorio.jpa.RepositorioTareaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
@Configuration
public class MapeadorActividadGestionActividadEstrategica implements MapeadorInfraestructura<EntidadActividadGestionActividadEstrategica, ActividadGestionActividadEstrategica> {
    private final RepositorioInformacionActividadGestionActividadEstrategicaJpa repositorioInformacionActividadGestionActividadEstrategicaJpa;
    private final RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa;
    private final RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final ServicioObtenerDiasRestantes servicioObtenerDiasRestantes;
    private final RepositorioTareaJpa repositorioTareaJpa;
    private final MapeadorInformacionActividadEstrategica mapeadorInformacionActividadEstrategica;

    public MapeadorActividadGestionActividadEstrategica(RepositorioInformacionActividadGestionActividadEstrategicaJpa repositorioInformacionActividadGestionActividadEstrategicaJpa,
                                                        RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa, RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa, RepositorioUsuarioJpa repositorioUsuarioJpa, ServicioObtenerDiasRestantes servicioObtenerDiasRestantes, RepositorioTareaJpa repositorioTareaJpa, MapeadorInformacionActividadEstrategica mapeadorInformacionActividadEstrategica) {
        this.repositorioInformacionActividadGestionActividadEstrategicaJpa = repositorioInformacionActividadGestionActividadEstrategicaJpa;
        this.repositorioActividadEstrategicaJpa = repositorioActividadEstrategicaJpa;
        this.repositorioInformacionActividadEstrategicaJpa = repositorioInformacionActividadEstrategicaJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.servicioObtenerDiasRestantes = servicioObtenerDiasRestantes;
        this.repositorioTareaJpa = repositorioTareaJpa;
        this.mapeadorInformacionActividadEstrategica = mapeadorInformacionActividadEstrategica;
    }

    @Override
    public ActividadGestionActividadEstrategica mapeadorDominio(EntidadActividadGestionActividadEstrategica entidad) {
        return new ActividadGestionActividadEstrategica(entidad.getIdActividadGestionActividadEstrategica(), entidad.getNombre(),
                entidad.getFechaInicial(),entidad.getFechaFinal(),
                entidad.getAvance(), entidad.getIdUsuario(), entidad.getIdActividadEstrategica());
    }
    @Override
    public EntidadActividadGestionActividadEstrategica mapeadorEntidad(ActividadGestionActividadEstrategica dominio) {
        var usuario = this.repositorioUsuarioJpa.findById(dominio.getIdUsuario()).orElseThrow().getIdUsuario();
        var actividad = this.repositorioActividadEstrategicaJpa.findById(dominio.getIdActividadEstrategica()).orElseThrow().getIdActividadEstrategica();
        return new EntidadActividadGestionActividadEstrategica(dominio.getNombre(),dominio.getFechaInicial(),dominio.getFechaFinal(),
                dominio.getAvance() ,usuario,
                actividad);
    }
    public List<DtoActividadGestionActividadEstrategicaResumen> listarDominio(List<EntidadActividadGestionActividadEstrategica> entidades){
        List<DtoActividadGestionActividadEstrategicaResumen> listaDto = new ArrayList<>();

        for (EntidadActividadGestionActividadEstrategica entidad : entidades) {
            DtoActividadGestionActividadEstrategicaResumen dto = new DtoActividadGestionActividadEstrategicaResumen();
            dto.setIdActividadGestionActividadEstrategica(entidad.getIdActividadGestionActividadEstrategica());
            dto.setNombre(entidad.getNombre());
            dto.setFechaInicial(entidad.getFechaInicial());
            dto.setFechaFinal(entidad.getFechaFinal());
            dto.setAvance(entidad.getAvance());
            dto.setIdUsuario(entidad.getIdUsuario());
            dto.setIdActividadEstrategica(entidad.getIdActividadEstrategica());

            var infEntidad = repositorioInformacionActividadGestionActividadEstrategicaJpa.findById(entidad.getIdActividadGestionActividadEstrategica());

            dto.setFechaRegistro(infEntidad.orElseThrow().getFechaRegistro());
            dto.setDuracion(infEntidad.orElseThrow().getDuracion());
            dto.setDiasRestantes(servicioObtenerDiasRestantes.calcular(entidad.getFechaFinal()));

            listaDto.add(dto);
        }
        return listaDto;
    }
    public void actualizarEntidad(EntidadActividadGestionActividadEstrategica entidad, ActividadGestionActividadEstrategica actividadGestion,
                                  EntidadInformacionActividadGestionActividadEstrategica entidadInformacionActividadGestion,
                                  InformacionActividadGestionActividadEstrategica informacionActividadGestion) {
        entidad.setNombre(actividadGestion.getNombre());
        entidad.setFechaInicial(actividadGestion.getFechaInicial());
        entidad.setFechaFinal(actividadGestion.getFechaFinal());
        entidadInformacionActividadGestion.setDuracion(informacionActividadGestion.getDuracion());
        entidadInformacionActividadGestion.setDiasRestantes(informacionActividadGestion.getDiasRestantes());
    }
    public void actualizarPorcentajeAvance(EntidadActividadGestionActividadEstrategica entidad, ActividadGestionActividadEstrategica actividadGestionActividadEstrategicaactividadGestion) {
        List<EntidadTarea> actividades = this.repositorioTareaJpa.findByIdASEAndTipoASE(actividadGestionActividadEstrategicaactividadGestion.getIdActividadGestionActividadEstrategica(),
                ETipoASE.ACTIVIDAD_GESTION_ACTIVIDAD_ESTRATEGICA);
        long totalActividades = actividades.size();
        long tareasTerminadas = actividades.stream().filter(tarea -> tarea.getEstado() == EEstado.TERMINADO).count();

        if (totalActividades > 0) {
            int nuevoAvance = (int) ((tareasTerminadas * 100) / totalActividades);
            entidad.setAvance((double) nuevoAvance);
            mapeadorInformacionActividadEstrategica.actualizarPorcentajeAvance(obtenerActividdEstrategicaRelacionado(entidad.getIdActividadEstrategica()));
        }
    }
    public EntidadInformacionActividadEstrategica obtenerActividdEstrategicaRelacionado(Long id){
        return this.repositorioInformacionActividadEstrategicaJpa.findById(id).orElseThrow();
    }
}
