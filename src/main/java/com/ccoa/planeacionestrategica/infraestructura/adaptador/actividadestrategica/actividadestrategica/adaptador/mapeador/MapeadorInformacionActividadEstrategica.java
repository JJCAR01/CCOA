package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.InformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerPorcentaje;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.entidad.EntidadActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.entidad.EntidadInformacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.repositorio.jpa.RepositorioActividadGestionEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.repositorio.jpa.RepositorioInformacionActividadGestionEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.mapeador.MapeadorInformacionPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.entidad.EntidadDetalleProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.entidad.EntidadProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.repositorio.jpa.RepositorioDetalleProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.repositorio.jpa.RepositorioProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapeadorInformacionActividadEstrategica implements MapeadorInfraestructura<EntidadInformacionActividadEstrategica, InformacionActividadEstrategica> {
    private final RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa;
    private final RepositorioProyectoJpa repositorioProyectoJpa;
    private final RepositorioDetalleProyectoJpa repositorioDetalleProyectoJpa;
    private final RepositorioInformacionActividadGestionEstrategicaJpa repositorioInformacionActividadGestionEstrategicaJpa;
    private final RepositorioActividadGestionEstrategicaJpa repositorioActividadGestionEstrategicaJpa;
    private final MapeadorInformacionPat mapeadorInformacionPat;
    private final MapeadorActividadEstrategica mapeadorActividadEstrategica;
    private final ServicioObtenerPorcentaje servicioObtenerPorcentaje;
    public MapeadorInformacionActividadEstrategica(
            RepositorioInformacionActividadEstrategicaJpa repositorioInformacionActividadEstrategicaJpa,
            RepositorioDetalleProyectoJpa repositorioDetalleProyectoJpa,
            RepositorioProyectoJpa repositorioProyectoJpa,
            RepositorioInformacionActividadGestionEstrategicaJpa repositorioInformacionActividadGestionEstrategicaJpa,
            RepositorioActividadGestionEstrategicaJpa repositorioActividadGestionEstrategicaJpa,
            MapeadorInformacionPat mapeadorInformacionPat, MapeadorActividadEstrategica mapeadorActividadEstrategica, ServicioObtenerPorcentaje servicioObtenerPorcentaje) {

        this.repositorioInformacionActividadEstrategicaJpa = repositorioInformacionActividadEstrategicaJpa;
        this.repositorioInformacionActividadGestionEstrategicaJpa = repositorioInformacionActividadGestionEstrategicaJpa;
        this.repositorioProyectoJpa = repositorioProyectoJpa;
        this.mapeadorInformacionPat = mapeadorInformacionPat;
        this.mapeadorActividadEstrategica = mapeadorActividadEstrategica;
        this.repositorioDetalleProyectoJpa = repositorioDetalleProyectoJpa;
        this.repositorioActividadGestionEstrategicaJpa = repositorioActividadGestionEstrategicaJpa;
        this.servicioObtenerPorcentaje = servicioObtenerPorcentaje;
    }

    @Override
    public InformacionActividadEstrategica mapeadorDominio(EntidadInformacionActividadEstrategica entidad) {
        return new InformacionActividadEstrategica(entidad.getDuracion(), entidad.getDiasRestantes(),
                entidad.getPorcentajeReal(), entidad.getPorcentajeEsperado(),entidad.getPorcentajeCumplimiento(), entidad.getPorcentajePat());
    }

    @Override
    public EntidadInformacionActividadEstrategica mapeadorEntidad(InformacionActividadEstrategica dominio) {
        return new EntidadInformacionActividadEstrategica(dominio.getDuracion(),dominio.getDiasRestantes(), dominio.getPorcentajeReal(),
                dominio.getPorcentajeEsperado(), dominio.getPorcentajeCumplimiento(), dominio.getPorcentajePat());
    }


    public void actualizarPorcentajeAvance(EntidadInformacionActividadEstrategica entidad, Long idActividadEstrategica) {
        List<EntidadProyecto> proyectos = this.repositorioProyectoJpa.findByIdActividadEstrategica(idActividadEstrategica);
        List<EntidadDetalleProyecto> detalleProyectos = this.repositorioDetalleProyectoJpa.
                findAll()
                .stream()
                .filter(e -> proyectos.stream()
                        .anyMatch(proyecto -> proyecto.getIdProyecto().equals(e.getIdDetalleProyecto())))
                .toList();
        List<EntidadActividadGestionEstrategica> actividadGestionActividadEstrategicas = this.repositorioActividadGestionEstrategicaJpa.findByIdActividadEstrategica(idActividadEstrategica);
        List<EntidadInformacionActividadGestionEstrategica> informacionActividadGestionEstrategicas = this.repositorioInformacionActividadGestionEstrategicaJpa.
                findAll()
                .stream()
                .filter(e -> actividadGestionActividadEstrategicas.stream()
                        .anyMatch(actividad -> actividad.getIdActividadGestionEstrategica().equals(e.getIdInformacionActividadGestionEstrategica())))
                .toList();

        long totalProyectos = proyectos.size();
        long totalActividadesGestion = actividadGestionActividadEstrategicas.size();

        double sumaProyectos = detalleProyectos.stream().mapToDouble(EntidadDetalleProyecto::getPorcentajeReal).sum();
        double sumaActividadesGestion = informacionActividadGestionEstrategicas.stream().mapToDouble(EntidadInformacionActividadGestionEstrategica::getPorcentajeReal).sum();

        int nuevoAvance = (int) ((sumaProyectos + sumaActividadesGestion)/ (totalProyectos + totalActividadesGestion));
        entidad.setPorcentajeReal((double) nuevoAvance);
        entidad.setIdInformacionActividadEstrategica(idActividadEstrategica);
        entidad.setPorcentajeEsperado(entidad.getPorcentajeEsperado());
        entidad.setPorcentajeCumplimiento(servicioObtenerPorcentaje.obtenerPorcentajeDeCumplimiento(entidad.getPorcentajeReal(),entidad.getPorcentajeEsperado()));
        repositorioInformacionActividadEstrategicaJpa.save(entidad);
        var idPat = mapeadorActividadEstrategica.obtenerPatRelacionadoConActividadEstrategica(entidad.getIdInformacionActividadEstrategica()).getIdPat();
        var entidadPat = mapeadorInformacionPat.obtenerTodaEntidadPat(idPat);
        mapeadorInformacionPat.actualizarPorcentajeAvance(entidadPat,idPat);
    }

    public EntidadInformacionActividadEstrategica obtenerTodaEntidadActividadEstrategica(Long idActividadEstrategica) {
        var entidad = repositorioInformacionActividadEstrategicaJpa.findById(idActividadEstrategica);
        return new EntidadInformacionActividadEstrategica(
                entidad.orElseThrow().getDuracion(),
                entidad.orElseThrow().getDiasRestantes(),
                entidad.orElseThrow().getPorcentajeReal(),
                entidad.orElseThrow().getPorcentajeEsperado(),
                entidad.orElseThrow().getPorcentajeCumplimiento(),
                entidad.orElseThrow().getPorcentajePat());
    }
}
