package com.ccoa.planeacionestrategica.aplicacion.servicio.rubrogasto;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.RubroGasto;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroGasto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarRubroGasto {

    private final RepositorioRubroGasto repositorioRubroGasto;

    public ServicioAplicacionListarRubroGasto(RepositorioRubroGasto repositorioRubroGasto) {
        this.repositorioRubroGasto = repositorioRubroGasto;
    }

    public List<RubroGasto> ejecutar(){return this.repositorioRubroGasto.listar();}

    public RubroGasto consultarById(Long id){return this.repositorioRubroGasto.consultarPorId(id);}
}
