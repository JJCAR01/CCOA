package com.ccoa.planeacionestrategica.dominio.servicio.tipogi;

import com.ccoa.planeacionestrategica.dominio.modelo.TipoGI;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoGI;
import org.springframework.stereotype.Service;

@Service
public class ServicioModificarTipoGI {

    private static final String MENSAJE_NO_EXISTE = "No existe el Tipo GI con los datos ingresados";

    private final RepositorioTipoGI repositorioTipoGI;

    public ServicioModificarTipoGI(RepositorioTipoGI repositorioTipoGI) {
        this.repositorioTipoGI = repositorioTipoGI;
    }
    public Long ejecutarModificar(TipoGI tipoGI, Long codigo){

        if(this.repositorioTipoGI.consultarPorId(codigo)==null) throw new IllegalStateException(MENSAJE_NO_EXISTE);

        return this.repositorioTipoGI.modificar(tipoGI,codigo);
    }

}
