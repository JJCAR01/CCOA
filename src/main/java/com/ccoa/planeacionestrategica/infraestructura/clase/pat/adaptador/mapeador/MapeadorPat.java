package com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.mapeador;
import com.ccoa.planeacionestrategica.dominio.dto.DtoPatResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.Pat;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.entidad.EntidadInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.entidad.EntidadActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.entidad.EntidadInformacionActividadGestion;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.repositorio.jpa.RepositorioActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.repositorio.jpa.RepositorioInformacionActividadGestionJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad.EntidadPat;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.repositorio.jpa.RepositorioInformacionPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorPat implements MapeadorInfraestructura<EntidadPat, Pat> {
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioInformacionPatJpa repositorioInformacionPatJpa;
    private final RepositorioInformacionActividadGestionJpa repositorioInformacionActividadGestionJpa;
    private final RepositorioActividadGestionJpa repositorioActividadGestionJpa;
    private final RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa;

    public MapeadorPat(RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioInformacionPatJpa repositorioInformacionPatJpa, RepositorioInformacionActividadGestionJpa repositorioInformacionActividadGestionJpa, RepositorioActividadGestionJpa repositorioActividadGestionJpa, RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioInformacionPatJpa = repositorioInformacionPatJpa;
        this.repositorioInformacionActividadGestionJpa = repositorioInformacionActividadGestionJpa;
        this.repositorioActividadGestionJpa = repositorioActividadGestionJpa;
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
    public List<DtoPatResumen> listarDominio(List<EntidadPat> entidades){
        List<DtoPatResumen> listaDto = new ArrayList<>();
        for (EntidadPat entidad : entidades) {
            DtoPatResumen dto = new DtoPatResumen();
            dto.setIdPat(entidad.getIdPat());
            dto.setNombre(entidad.getNombre());
            dto.setFechaAnual(entidad.getFechaAnual());
            dto.setPorcentaje(entidad.getPorcentaje());
            dto.setProceso(entidad.getProceso());
            dto.setIdUsuario(entidad.getIdUsuario());

            var infEntidad = repositorioInformacionPatJpa.findById(entidad.getIdPat());

            dto.setDireccion(infEntidad.orElseThrow().getDireccion());

            listaDto.add(dto);
        }
        return listaDto;
    }

    public void actualizarPorcentajeAvance(EntidadPat entidad) {
        List<EntidadActividadGestion> actividadGestiones = this.repositorioActividadGestionJpa.findByIdPat(entidad.getIdPat());
        List<EntidadInformacionActividadGestion> informacionActividadesGestiones = actividadGestiones.stream()
                .map(actividadGestion -> this.repositorioInformacionActividadGestionJpa.findByIdInformacionActividad(actividadGestion.getIdActividadGestion()))
                .flatMap(List::stream).toList();
        List<EntidadInformacionActividadEstrategica> actividadEstrategicas = this.repositorioInformacionActividadEstrategicaJpa.findByIdPat(entidad.getIdPat());

        double porcentajeActividades = (double) Mensaje.PORCENTAJE / (actividadGestiones.size() + actividadEstrategicas.size());

        double sumaActGestion = informacionActividadesGestiones.stream().mapToDouble(eGestion -> eGestion.getAvance() * porcentajeActividades).sum();
        double sumaActEstrategica = actividadEstrategicas.stream().mapToDouble(eEstrategica -> eEstrategica.getAvance() * porcentajeActividades).sum();

            double avanceTotal = (sumaActGestion + sumaActEstrategica)/ Mensaje.PORCENTAJE;
        entidad.setPorcentaje(avanceTotal);
    }

    public void actualizarEntidad(EntidadPat entidad, Pat pat) {
        entidad.setNombre(pat.getNombre());
        entidad.setFechaAnual(pat.getFechaAnual());
        entidad.setProceso(pat.getProceso());
    }
}
