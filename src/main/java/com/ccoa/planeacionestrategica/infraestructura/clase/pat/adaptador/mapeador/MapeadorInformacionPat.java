package com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.direccion.Direccion;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.InformacionPat;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad.EntidadInformacionPat;
import com.ccoa.planeacionestrategica.infraestructura.clase.direccion.adaptador.repositorio.jpa.RepositorioDireccionJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorInformacionPat implements MapeadorInfraestructura<EntidadInformacionPat, InformacionPat> {

    private final RepositorioDireccionJpa repositorioDireccionJpa;

    public MapeadorInformacionPat(RepositorioDireccionJpa repositorioDireccionJpa) {
        this.repositorioDireccionJpa = repositorioDireccionJpa;
    }

    @Override
    public InformacionPat mapeadorDominio(EntidadInformacionPat entidad) {
        Direccion direccion = Direccion.of(entidad.getDireccion().getNombre());
        return InformacionPat.of(entidad.getIdInformacionPat(), direccion);
    }

    @Override
    public EntidadInformacionPat mapeadorEntidad(InformacionPat dominio) {
        Direccion dtoDireccion = dominio.getDireccion();

        // Buscar la entidad EntidadDireccion por nombre
        var entidadDireccion = this.repositorioDireccionJpa.findByNombre(dtoDireccion.getNombre());

        // Crear y devolver la entidad EntidadInformacionPat
        return new EntidadInformacionPat(entidadDireccion);
    }
}
