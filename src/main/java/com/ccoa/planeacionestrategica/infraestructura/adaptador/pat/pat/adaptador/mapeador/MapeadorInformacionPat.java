package com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.direccion.Direccion;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.InformacionPat;
import com.ccoa.planeacionestrategica.dominio.modelo.proceso.Proceso;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.entidad.EntidadInformacionPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.direccion.adaptador.repositorio.jpa.RepositorioDireccionJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proceso.adaptador.repositorio.jpa.RepositorioProcesoJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorInformacionPat implements MapeadorInfraestructura<EntidadInformacionPat, InformacionPat> {

    private final RepositorioDireccionJpa repositorioDireccionJpa;
    private final RepositorioProcesoJpa repositorioProcesoJpa;

    public MapeadorInformacionPat(RepositorioDireccionJpa repositorioDireccionJpa, RepositorioProcesoJpa repositorioProcesoJpa) {
        this.repositorioDireccionJpa = repositorioDireccionJpa;
        this.repositorioProcesoJpa = repositorioProcesoJpa;
    }

    @Override
    public InformacionPat mapeadorDominio(EntidadInformacionPat entidad) {
        Proceso proceso = Proceso.of(entidad.getProceso().getNombre());
        Direccion direccion = Direccion.of(entidad.getDireccion().getNombre());
        return InformacionPat.of(entidad.getIdInformacionPat(), proceso,direccion,entidad.getPorcentajeReal(),
                entidad.getPorcentajeEsperado(), entidad.getPorcentajeCumplimiento());
    }

    @Override
    public EntidadInformacionPat mapeadorEntidad(InformacionPat dominio) {
        Proceso proceso = dominio.getProceso();
        Direccion direccion = dominio.getDireccion();

        // Buscar la entidad entidad por nombre
        var entidadProceso = this.repositorioProcesoJpa.findByNombre(proceso.getNombre());
        var entidadDireccion = this.repositorioDireccionJpa.findByNombre(direccion.getNombre());

        // Crear y devolver la entidad EntidadInformacionPat
        return new EntidadInformacionPat(entidadProceso,entidadDireccion, dominio.getPorcentajeReal(),
                dominio.getPorcentajeEsperado(), dominio.getPorcentajeCumplimiento());
    }

    public void actualizarEntidad(EntidadInformacionPat entidad, InformacionPat informacionPat) {

        Proceso proceso = informacionPat.getProceso();
        Direccion direccion = informacionPat.getDireccion();
        // Buscar la entidad EntidadDireccion por nombre
        var entidadProceso = this.repositorioProcesoJpa.findByNombre(proceso.getNombre());
        var entidadDireccion = this.repositorioDireccionJpa.findByNombre(direccion.getNombre());
        entidad.setProceso(entidadProceso);
        entidad.setDireccion(entidadDireccion);
    }
}
