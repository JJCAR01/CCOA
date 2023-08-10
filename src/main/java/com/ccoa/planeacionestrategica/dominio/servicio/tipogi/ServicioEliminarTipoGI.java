package com.ccoa.planeacionestrategica.dominio.servicio.tipogi;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoGI;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarTipoGI {

    private static final String MENSAJE_YA_EXISTE = "No existe el Tipo GI con los datos ingresados";

    private final RepositorioTipoGI repositorioTipoGI;

    public ServicioEliminarTipoGI(RepositorioTipoGI repositorioTipoGI) {
        this.repositorioTipoGI = repositorioTipoGI;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioTipoGI.consultarPorId(id)== null) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioTipoGI.eliminar(id);
    }
}
