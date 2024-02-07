package com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.actividadestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.InformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa.RepositorioActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.actividadgestionactividadestrategica.adaptador.entidad.EntidadActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.actividadgestionactividadestrategica.adaptador.repositorio.jpa.RepositorioActividadGestionActividadEstrategicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.pat.adaptador.entidad.EntidadPat;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.pat.adaptador.mapeador.MapeadorPat;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.pat.adaptador.repositorio.jpa.RepositorioPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.proyecto.adaptador.entidad.EntidadDetalleProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.proyecto.adaptador.repositorio.jpa.RepositorioDetalleProyectoJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDiasRestantes;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapeadorInformacionActividadEstrategica implements MapeadorInfraestructura<EntidadInformacionActividadEstrategica, InformacionActividadEstrategica> {
    private final RepositorioPatJpa repositorioPatJpa;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa;
    private final ServicioCalcularDiasRestantes servicioCalcularDiasRestantes;
    private final RepositorioDetalleProyectoJpa repositorioDetalleProyectoJpa;
    private final RepositorioActividadGestionActividadEstrategicaJpa repositorioActividadGestionActividadEstrategicaJpa;
    private final MapeadorPat mapeadorPat;
    public MapeadorInformacionActividadEstrategica(RepositorioPatJpa repositorioPatJpa, RepositorioUsuarioJpa repositorioUsuarioJpa,
                                                   RepositorioActividadEstrategicaJpa repositorioActividadEstrategicaJpa,
                                                   ServicioCalcularDiasRestantes servicioCalcularDiasRestantes,
                                                   RepositorioDetalleProyectoJpa repositorioDetalleProyectoJpa,
                                                   RepositorioActividadGestionActividadEstrategicaJpa repositorioActividadGestionActividadEstrategicaJpa, MapeadorPat mapeadorPat) {
        this.repositorioPatJpa = repositorioPatJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioActividadEstrategicaJpa = repositorioActividadEstrategicaJpa;
        this.servicioCalcularDiasRestantes = servicioCalcularDiasRestantes;
        this.repositorioDetalleProyectoJpa = repositorioDetalleProyectoJpa;
        this.repositorioActividadGestionActividadEstrategicaJpa = repositorioActividadGestionActividadEstrategicaJpa;
        this.mapeadorPat = mapeadorPat;
    }

    @Override
    public InformacionActividadEstrategica mapeadorDominio(EntidadInformacionActividadEstrategica entidad) {
        return new InformacionActividadEstrategica(entidad.getDuracion(), entidad.getDiasRestantes(),
                entidad.getPorcentajeReal(), entidad.getPorcentajeEsperado(),entidad.getPorcentajeCumplimiento() );
    }

    @Override
    public EntidadInformacionActividadEstrategica mapeadorEntidad(InformacionActividadEstrategica dominio) {

        return new EntidadInformacionActividadEstrategica(dominio.getDuracion(),dominio.getDiasRestantes(), dominio.getPorcentajeReal(),
                dominio.getPorcentajeReal(), dominio.getPorcentajeCumplimiento());
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
