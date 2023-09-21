package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.modelo.epica.InformacionEpica;
import com.ccoa.planeacionestrategica.dominio.modelo.epica.Epica;

import java.util.List;

public interface RepositorioEpica {

    List<Epica> listarEpica();
    List<InformacionEpica> listarInformacionEpica();
    Epica consultarPorId(Long id);
    Long guardar(Epica programa, InformacionEpica informacionEpica);
    boolean existe(Epica programa, InformacionEpica informacionEpica);
    Long eliminar(Long id);
    Long modificar(Epica epica, Long id);

}