package com.ccoa.planeacionestrategica.dominio.servicio.rubrogasto;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroGasto;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarRubroGasto {

    private static final String MENSAJE_YA_EXISTE = "No existe el Rubro de Gasto con los datos ingresados";

    private final RepositorioRubroGasto repositorioRubroGasto;

    public ServicioEliminarRubroGasto(RepositorioRubroGasto repositorioRubroGasto) {
        this.repositorioRubroGasto = repositorioRubroGasto;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioRubroGasto.consultarPorId(id)== null) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioRubroGasto.eliminar(id);
    }
}
