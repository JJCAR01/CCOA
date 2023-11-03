package com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.mapeador;
import com.ccoa.planeacionestrategica.dominio.modelo.Pat;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.entidad.EntidadInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.entidad.EntidadInformacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.repositorio.jpa.RepositorioInformacionActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad.EntidadPat;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MapeadorPat implements MapeadorInfraestructura<EntidadPat, Pat> {
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioInformacionActividadGestionJpa repositorioInformacionActividadGestionJpa;
    private final RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa;

    public MapeadorPat(RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioInformacionActividadGestionJpa repositorioInformacionActividadGestionJpa, RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;

        this.repositorioInformacionActividadGestionJpa = repositorioInformacionActividadGestionJpa;
        this.repositorioInformacionActividadEstrategicaJpa = repositorioInformacionActividadEstrategicaJpa;
    }

    @Override
    public Pat mapeadorDominio(EntidadPat entidad) {
        return new Pat(entidad.getIdPat(), entidad.getNombre(), entidad.getFechaAnual(),entidad.getFechaRegistro(),
                entidad.getPorcentaje(),entidad.getProceso(), entidad.getIdUsuario());
    }

    @Override
    public EntidadPat mapeadorEntidad(Pat dominio) {
        var idUsuario = this.repositorioUsuarioJpa.findById(dominio.getIdUsuario()).orElseThrow().getIdUsuario();
        return new EntidadPat(dominio.getNombre(), dominio.getFechaAnual(),dominio.getFechaRegistro(),
                dominio.getPorcentaje(),dominio.getProceso(),idUsuario);
    }
    public List<Pat> listarDominio(List<EntidadPat> entidades){
        return entidades.stream().map(entidad -> new Pat(entidad.getIdPat(), entidad.getNombre(), entidad.getFechaAnual(),entidad.getFechaRegistro(),
                entidad.getPorcentaje(),entidad.getProceso(), entidad.getIdUsuario())).toList();
    }

    public void actualizarPorcentajeAvance(EntidadPat entidad) {
        List<EntidadInformacionActividadGestion> actividadGestiones = this.repositorioInformacionActividadGestionJpa.findAll();
        List<EntidadInformacionActividadEstrategica> actividadEstrategicas = this.repositorioInformacionActividadEstrategicaJpa.findAll();

        double porcentajeActividades = (double) Mensaje.PORCENTAJE / (actividadGestiones.size() + actividadEstrategicas.size());

        double sumaActGestion = actividadGestiones.stream().mapToDouble(eGestion -> eGestion.getAvance() * porcentajeActividades).sum();
        double sumaActEstrategica = actividadEstrategicas.stream().mapToDouble(eEstrategica -> eEstrategica.getAvance() * porcentajeActividades).sum();

        double avanceTotal = (sumaActGestion + sumaActEstrategica)/ Mensaje.PORCENTAJE;
        entidad.setPorcentaje(avanceTotal);
    }

    public void actualizarEntidad(EntidadPat entidad, Pat pat) {
        entidad.setFechaAnual(pat.getFechaAnual());
        entidad.setProceso(pat.getProceso());
    }
}
