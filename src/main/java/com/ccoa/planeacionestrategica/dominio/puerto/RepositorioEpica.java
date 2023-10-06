package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.dto.DtoEpicaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.epica.Epica;
import com.ccoa.planeacionestrategica.dominio.modelo.epica.InformacionEpica;

import java.util.List;

public interface RepositorioEpica{
    List<DtoEpicaResumen> listar();
    Epica consultarPorId(Long id);
    Long guardar(Epica epica, InformacionEpica informacionEpica) ;
    boolean existe(Epica epica);
    Long eliminar(Long id);
    Long modificar(Epica epica , Long id);
    List<Epica> consultarPorIdPat(Long idPat);
}
