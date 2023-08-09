package com.ccoa.planeacionestrategica.dominio.servicio.rubroingreso;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroGasto;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroIngreso;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarRubroIngreso {

    private static final String MENSAJE_YA_EXISTE = "No existe el Rubro de Ingresos con los datos ingresados";

    private final RepositorioRubroIngreso repositorioRubroIngreso;

    public ServicioEliminarRubroIngreso(RepositorioRubroIngreso repositorioRubroIngreso) {
        this.repositorioRubroIngreso = repositorioRubroIngreso;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioRubroIngreso.consultarPorId(id)== null) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioRubroIngreso.eliminar(id);
    }
}
