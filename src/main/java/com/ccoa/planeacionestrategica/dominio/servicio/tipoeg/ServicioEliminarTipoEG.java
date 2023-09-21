package com.ccoa.planeacionestrategica.dominio.servicio.tipoeg;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoEG;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarTipoEG {

    private static final String MENSAJE_YA_EXISTE = "No existe el Tipo Gasto o Ingreso con los datos ingresados";

    private final RepositorioTipoEG repositorioTipoEG;
    public ServicioEliminarTipoEG(RepositorioTipoEG repositorioTipoEG) {
        this.repositorioTipoEG = repositorioTipoEG;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioTipoEG.consultarPorId(id)== null) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioTipoEG.eliminar(id);
    }

}
