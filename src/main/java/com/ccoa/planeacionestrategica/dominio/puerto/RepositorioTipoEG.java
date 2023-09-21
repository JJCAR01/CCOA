package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.modelo.TipoEG;

import java.util.List;

public interface RepositorioTipoEG {

    List<TipoEG> listar();
    TipoEG consultarPorId(Long id);
    boolean existe(TipoEG tipoGI);
    Long eliminar(Long id);
}


