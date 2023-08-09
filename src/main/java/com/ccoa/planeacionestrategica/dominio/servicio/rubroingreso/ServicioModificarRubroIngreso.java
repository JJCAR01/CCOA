package com.ccoa.planeacionestrategica.dominio.servicio.rubroingreso;

import com.ccoa.planeacionestrategica.dominio.modelo.RubroGasto;
import com.ccoa.planeacionestrategica.dominio.modelo.RubroIngreso;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroGasto;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroIngreso;
import org.springframework.stereotype.Service;

@Service
public class ServicioModificarRubroIngreso {

    private static final String MENSAJE_NO_EXISTE = "No existe el Rubro de Ingreso con los datos ingresados";

    private final RepositorioRubroIngreso repositorioRubroIngreso;

    public ServicioModificarRubroIngreso(RepositorioRubroIngreso repositorioRubroIngreso) {
        this.repositorioRubroIngreso = repositorioRubroIngreso;
    }

    public Long ejecutarModificar(RubroIngreso rubroIngreso, Long codigo){

        if(this.repositorioRubroIngreso.consultarPorId(codigo)==null) throw new IllegalStateException(MENSAJE_NO_EXISTE);

        return this.repositorioRubroIngreso.modificar(rubroIngreso,codigo);
    }
}
