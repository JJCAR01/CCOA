package com.ccoa.planeacionestrategica.dominio.servicio.rubroingreso;

import com.ccoa.planeacionestrategica.dominio.modelo.RubroIngreso;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoContrato;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubroIngreso;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoContrato;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarRubroIngreso {

    private static final String MENSAJE_YA_EXISTE = "Ya existe el Rubro de Ingreso con los datos ingresados";

    private final RepositorioRubroIngreso repositorioRubroIngreso;

    public ServicioGuardarRubroIngreso(RepositorioRubroIngreso repositorioRubroIngreso) {
        this.repositorioRubroIngreso = repositorioRubroIngreso;
    }

    public Long ejecutarGuardar(RubroIngreso rubroIngreso){

        if(this.repositorioRubroIngreso.existe(rubroIngreso)) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioRubroIngreso.guardar(rubroIngreso);}
}
