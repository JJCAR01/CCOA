package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.InformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.repositorio.jpa.RepositorioActividadGestionEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.entidad.EntidadPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.mapeador.MapeadorPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.repositorio.jpa.RepositorioDetalleProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDiasRestantes;
import org.springframework.stereotype.Component;

@Component
public class MapeadorInformacionActividadEstrategica implements MapeadorInfraestructura<EntidadInformacionActividadEstrategica, InformacionActividadEstrategica> {
    private final RepositorioPatJpa repositorioPatJpa;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa;
    private final ServicioCalcularDiasRestantes servicioCalcularDiasRestantes;
    private final RepositorioDetalleProyectoJpa repositorioDetalleProyectoJpa;
    private final RepositorioActividadGestionEstrategicaJpa repositorioActividadGestionEstrategicaJpa;
    private final MapeadorPat mapeadorPat;
    public MapeadorInformacionActividadEstrategica(RepositorioPatJpa repositorioPatJpa, RepositorioUsuarioJpa repositorioUsuarioJpa,
                                                   RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa,
                                                   ServicioCalcularDiasRestantes servicioCalcularDiasRestantes,
                                                   RepositorioDetalleProyectoJpa repositorioDetalleProyectoJpa,
                                                   RepositorioActividadGestionEstrategicaJpa repositorioActividadGestionEstrategicaJpa, MapeadorPat mapeadorPat) {
        this.repositorioPatJpa = repositorioPatJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioActividadEstrategicaJpa = repositorioActividadEstrategicaJpa;
        this.servicioCalcularDiasRestantes = servicioCalcularDiasRestantes;
        this.repositorioDetalleProyectoJpa = repositorioDetalleProyectoJpa;
        this.repositorioActividadGestionEstrategicaJpa = repositorioActividadGestionEstrategicaJpa;
        this.mapeadorPat = mapeadorPat;
    }

    @Override
    public InformacionActividadEstrategica mapeadorDominio(EntidadInformacionActividadEstrategica entidad) {
        return new InformacionActividadEstrategica(entidad.getDuracion(), entidad.getDiasRestantes(),
                entidad.getPorcentajeReal(), entidad.getPorcentajeEsperado(),entidad.getPorcentajeCumplimiento(),entidad.getMeta(),
                entidad.getResultado());
    }

    @Override
    public EntidadInformacionActividadEstrategica mapeadorEntidad(InformacionActividadEstrategica dominio) {
        return new EntidadInformacionActividadEstrategica(dominio.getDuracion(),dominio.getDiasRestantes(), dominio.getPorcentajeReal(),
                dominio.getPorcentajeReal(), dominio.getPorcentajeCumplimiento(),dominio.getMeta(), dominio.getResultado());
    }


    public void actualizarPorcentajeAvance(EntidadInformacionActividadEstrategica entidad) {
        /*List<EntidadDetalleProyecto> proyectos = this.repositorioDetalleProyectoJpa.findByIdActividadEstrategica(entidad.getIdInformacionActividadEstrategica());
        List<EntidadActividadGestionActividadEstrategica> actividadGestionActividadEstrategicas = this.repositorioActividadGestionActividadEstrategicaJpa.findByIdActividadEstrategica(entidad.getIdInformacionActividadEstrategica());

        long totalProyectos = proyectos.size();
        long totalActividadesGestion = actividadGestionActividadEstrategicas.size();

        double sumaProyectos = proyectos.stream().mapToDouble(EntidadDetalleProyecto::getAvance).sum();
        double sumaActividadesGestion = actividadGestionActividadEstrategicas.stream().mapToDouble(EntidadActividadGestionActividadEstrategica::getAvance).sum();

        int nuevoAvance = (int) ((sumaProyectos + sumaActividadesGestion)/ (totalProyectos + totalActividadesGestion));
        //entidad.setAvance((double) nuevoAvance);
        //mapeadorPat.actualizarPorcentajeAvance(obtenerPatRelacionado(entidad.getIdPat()));*/
    }

    public EntidadPat obtenerPatRelacionado(Long id){
        return this.repositorioPatJpa.findById(id).orElseThrow();
    }
}
