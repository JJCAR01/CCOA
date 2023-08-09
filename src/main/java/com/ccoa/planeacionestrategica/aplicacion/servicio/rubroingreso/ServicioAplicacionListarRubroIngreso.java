package com.ccoa.planeacionestrategica.aplicacion.servicio.rubroingreso;

import com.ccoa.planeacionestrategica.dominio.modelo.RubroGasto;
import com.ccoa.planeacionestrategica.dominio.modelo.RubroIngreso;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroGasto;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroIngreso;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarRubroIngreso {

    private final RepositorioRubroIngreso repositorioRubroIngreso;

    public ServicioAplicacionListarRubroIngreso(RepositorioRubroIngreso repositorioRubroIngreso) {
        this.repositorioRubroIngreso = repositorioRubroIngreso;
    }

    public List<RubroIngreso> ejecutar(){return this.repositorioRubroIngreso.listar();}

    public RubroIngreso consultarById(Long id){return this.repositorioRubroIngreso.consultarPorId(id);}
}
