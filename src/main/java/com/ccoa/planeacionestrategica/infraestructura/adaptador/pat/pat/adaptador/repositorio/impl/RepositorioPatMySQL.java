package com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.dto.DtoPatResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.DetallePat;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.InformacionPat;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.Pat;
import com.ccoa.planeacionestrategica.dominio.puerto.pat.RepositorioPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.mapeador.MapeadorDetallePat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.mapeador.MapeadorInformacionPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.mapeador.MapeadorPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioDetallePatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioInformacionPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.entidad.EntidadInformacionUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.mapeador.MapeadorInformacionUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa.RepositorioInformacionUsuarioJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class RepositorioPatMySQL implements RepositorioPat {

    private final RepositorioPatJpa repositorioPatJpa;
    private final RepositorioInformacionPatJpa repositorioInformacionPatJpa;
    private final RepositorioDetallePatJpa repositorioDetallePatJpa;
    private final MapeadorPat mapeadorPat;
    private final MapeadorInformacionPat mapeadorInformacionPat;
    private final MapeadorDetallePat mapeadorDetallePat;
    private final MapeadorInformacionUsuario mapeadorInformacionUsuario;
    private final RepositorioInformacionUsuarioJpa repositorioInformacionUsuarioJpa;
    public RepositorioPatMySQL(RepositorioPatJpa repositorioPatJpa,
                               RepositorioInformacionPatJpa repositorioInformacionPatJpa, RepositorioDetallePatJpa repositorioDetallePatJpa,
                               MapeadorPat mapeadorPat, MapeadorInformacionPat mapeadorInformacionPat, MapeadorDetallePat mapeadorDetallePat,
                               MapeadorInformacionUsuario mapeadorInformacionUsuario, RepositorioInformacionUsuarioJpa repositorioInformacionUsuarioJpa) {
        this.repositorioPatJpa = repositorioPatJpa;
        this.repositorioInformacionPatJpa = repositorioInformacionPatJpa;
        this.repositorioDetallePatJpa = repositorioDetallePatJpa;
        this.mapeadorPat = mapeadorPat;
        this.mapeadorInformacionPat = mapeadorInformacionPat;
        this.mapeadorDetallePat = mapeadorDetallePat;
        this.mapeadorInformacionUsuario = mapeadorInformacionUsuario;
        this.repositorioInformacionUsuarioJpa = repositorioInformacionUsuarioJpa;
    }

    @Override
    public List<DtoPatResumen> listar() {
        var entidadPats =this.repositorioPatJpa.findAll();
        return this.mapeadorPat.listarDominio(entidadPats);
    }

    @Override
    public DtoPatResumen consultarPorId(Long id) {
        var entidad = this.repositorioPatJpa.findById(id).orElse(null);
        assert entidad != null;
        var informacionPat = this.repositorioInformacionPatJpa.findById(id).orElse(null);
        assert informacionPat != null;
        var detallePat = this.repositorioDetallePatJpa.findById(id).orElse(null);
        assert detallePat != null;

        return this.mapeadorPat.patDominio(entidad,informacionPat,detallePat);
    }

    @Override
    public Long guardar(Pat pat, InformacionPat informacionPat, DetallePat detallePat) {
        var entidadPat = mapeadorPat.mapeadorEntidad(pat);
        var idPat = this.repositorioPatJpa.save(entidadPat).getIdPat();

        var entidadInformacionPat = mapeadorInformacionPat.mapeadorEntidad(informacionPat);
        entidadInformacionPat.setIdInformacionPat(idPat);

        var entidadDetallePat = mapeadorDetallePat.mapeadorEntidad(detallePat);
        entidadDetallePat.setIdDetallePat(idPat);

        this.repositorioInformacionPatJpa.save(entidadInformacionPat);
        var entidadUsuario = mapeadorInformacionUsuario.obtenerUsuario(pat.getIdUsuario());
        mapeadorInformacionUsuario.actualizarPatsPorPat(entidadUsuario, pat);
        repositorioInformacionUsuarioJpa.save(entidadUsuario);
        return idPat;
    }

    @Override
    public boolean existe(Pat pat) {
        return this.repositorioPatJpa.findByNombre(pat.getNombre()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        eliminarReferenciasDePat(id);
        this.repositorioInformacionPatJpa.deleteById(id);
        this.repositorioPatJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Pat pat, InformacionPat informacionPat, Long id) {
        var entidadPat = this.repositorioPatJpa.findById(id).orElse(null);
        var entidadInformacionpat = this.repositorioInformacionPatJpa.findById(id).orElse(null);
        assert entidadPat != null;
        assert entidadInformacionpat != null;
        this.mapeadorPat.actualizarEntidad(entidadPat, pat);
        this.mapeadorInformacionPat.actualizarEntidad(entidadInformacionpat, informacionPat);
        this.repositorioInformacionPatJpa.save(entidadInformacionpat);
        var entidadUsuario = mapeadorInformacionUsuario.obtenerUsuario(pat.getIdUsuario());
        repositorioInformacionUsuarioJpa.save(entidadUsuario);
        this.repositorioPatJpa.save(entidadPat);
        return id;
    }
    public void eliminarReferenciasDePat(Long idPat) {
        // Obtén todas las instancias de EntidadInformacionUsuario que contengan la EntidadPat
        List<EntidadInformacionUsuario> usuariosConPat = repositorioInformacionUsuarioJpa.findByPats_IdPat(idPat);

        // Itera sobre cada EntidadInformacionUsuario y elimina la EntidadPat de la lista pats
        for (EntidadInformacionUsuario usuario : usuariosConPat) {
            usuario.getPats().removeIf(pat -> Objects.equals(pat.getIdPat(), idPat));
            repositorioInformacionUsuarioJpa.save(usuario); // Guarda los cambios
        }
    }

}
