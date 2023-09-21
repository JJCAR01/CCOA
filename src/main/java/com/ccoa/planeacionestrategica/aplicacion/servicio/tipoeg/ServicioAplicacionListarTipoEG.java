package com.ccoa.planeacionestrategica.aplicacion.servicio.tipoeg;

import com.ccoa.planeacionestrategica.dominio.modelo.TipoEG;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoEG;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarTipoEG {

    private final RepositorioTipoEG repositorioTipoEG;
    public ServicioAplicacionListarTipoEG(RepositorioTipoEG repositorioTipoEG) {
        this.repositorioTipoEG = repositorioTipoEG;
    }
    public List<TipoEG> ejecutar(){return this.repositorioTipoEG.listar();}

    public TipoEG consultarById(Long id){return this.repositorioTipoEG.consultarPorId(id);}
}
