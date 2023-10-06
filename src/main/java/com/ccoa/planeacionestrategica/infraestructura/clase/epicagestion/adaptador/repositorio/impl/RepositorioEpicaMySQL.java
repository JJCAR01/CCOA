package com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.dto.DtoEpicaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.epica.Epica;
import com.ccoa.planeacionestrategica.dominio.modelo.epica.InformacionEpica;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioEpica;
import com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.entidad.EntidadEpica;
import com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.mapeador.MapeadorEpica;
import com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.mapeador.MapeadorInformacionEpica;
import com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.repositorio.jpa.RepositorioEpicaJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.repositorio.jpa.RepositorioInformacionEpicaJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioEpicaMySQL implements RepositorioEpica {
    private final RepositorioEpicaJpa repositorioEpicaJpa;
    private final RepositorioInformacionEpicaJpa repositorioInformacionEpicaJpa;
    private final MapeadorEpica mapeadorEpica;
    private final MapeadorInformacionEpica mapeadorInformacionEpica;
    public RepositorioEpicaMySQL(RepositorioEpicaJpa repositorioEpicaJpa, RepositorioInformacionEpicaJpa repositorioInformacionEpicaJpa, MapeadorEpica mapeadorEpica, MapeadorInformacionEpica mapeadorInformacionEpica) {
        this.repositorioEpicaJpa = repositorioEpicaJpa;
        this.repositorioInformacionEpicaJpa = repositorioInformacionEpicaJpa;
        this.mapeadorEpica = mapeadorEpica;
        this.mapeadorInformacionEpica = mapeadorInformacionEpica;
    }
    @Override
    public List<DtoEpicaResumen> listar() {
        var entidad = this.repositorioEpicaJpa.findAll();
        var entidaInfo = this.repositorioInformacionEpicaJpa.findAll();
        return this.mapeadorEpica.mapearAListaDto(entidad,entidaInfo);
    }


    @Override
    public Epica consultarPorId(Long id) {
        var entidad = this.repositorioEpicaJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorEpica.mapeadorDominio(entidad);
    }

    @Override
    public Long guardar(Epica epica, InformacionEpica informacionEpica) {
        var epicaEntidad = this.mapeadorEpica.mapeadorEntidad(epica);
        var informacionGestionEntidad = this.mapeadorInformacionEpica.mapeadorEntidad(informacionEpica);
        Long idInformacionEpica = this.repositorioInformacionEpicaJpa.save(informacionGestionEntidad).getIdInformacionEpica();
        epicaEntidad.setIdEpica(idInformacionEpica);
        return this.repositorioEpicaJpa.save(epicaEntidad).getIdEpica();
    }

    @Override
    public boolean existe(Epica epica) {
        return this.repositorioEpicaJpa.findByNombre(epica.getNombre())!=null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioEpicaJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Epica epica, Long id) {
        var entidad = this.repositorioEpicaJpa.findById(id).orElse(null);
        assert entidad != null;
        this.mapeadorEpica.actualizarEntidad(entidad, epica);
        return this.repositorioEpicaJpa.save(entidad).getIdEpica();
    }

    @Override
    public List<Epica> consultarPorIdPat(Long idPat) {
        List<EntidadEpica> entidades = this.repositorioEpicaJpa.findByIdPat(idPat);
        return this.mapeadorEpica.listarDominio(entidades);
    }
}
