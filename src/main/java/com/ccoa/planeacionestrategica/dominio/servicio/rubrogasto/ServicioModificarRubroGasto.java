package com.ccoa.planeacionestrategica.dominio.servicio.rubrogasto;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.RubroGasto;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroGasto;
import org.springframework.stereotype.Service;

@Service
public class ServicioModificarRubroGasto {
    private static final String MENSAJE_NO_EXISTE = "No existe el Rubro de Gasto con los datos ingresados";

    private final RepositorioRubroGasto repositorioRubroGasto;

    public ServicioModificarRubroGasto(RepositorioRubroGasto repositorioRubroGasto) {
        this.repositorioRubroGasto = repositorioRubroGasto;
    }

    public Long ejecutarModificar(RubroGasto rubroGasto, Long codigo){

        if(this.repositorioRubroGasto.consultarPorId(codigo)==null) throw new IllegalStateException(MENSAJE_NO_EXISTE);

        return this.repositorioRubroGasto.modificar(rubroGasto,codigo);
    }

}
