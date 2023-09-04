package com.ccoa.planeacionestrategica.dominio.servicio.tipogi;

import com.ccoa.planeacionestrategica.dominio.modelo.TipoGI;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoGI;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarTipoGI {

    private static final String MENSAJE_YA_EXISTE = "Ya existe el Tipo GI con los datos ingresados";

    private final RepositorioTipoGI repositorioTipoGI;

    public ServicioGuardarTipoGI(RepositorioTipoGI repositorioTipoGI) {
        this.repositorioTipoGI = repositorioTipoGI;
    }
    public Long ejecutarGuardar(TipoGI tipoGI){

        if(this.repositorioTipoGI.existe(tipoGI)) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioTipoGI.guardar(tipoGI);
    }

}
