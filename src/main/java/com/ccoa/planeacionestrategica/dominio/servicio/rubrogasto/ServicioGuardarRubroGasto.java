package com.ccoa.planeacionestrategica.dominio.servicio.rubrogasto;

import com.ccoa.planeacionestrategica.dominio.modelo.RubroGasto;
import com.ccoa.planeacionestrategica.dominio.modelo.RubroIngreso;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroGasto;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroIngreso;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarRubroGasto {

    private static final String MENSAJE_YA_EXISTE = "Ya existe el Rubro de Gasto con los datos ingresados";

    private final RepositorioRubroGasto repositorioRubroGasto;

    public ServicioGuardarRubroGasto(RepositorioRubroGasto repositorioRubroGasto) {
        this.repositorioRubroGasto = repositorioRubroGasto;
    }

    public Long ejecutarGuardar(RubroGasto rubroGasto){

        if(this.repositorioRubroGasto.existe(rubroGasto)) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioRubroGasto.guardar(rubroGasto);}
}
