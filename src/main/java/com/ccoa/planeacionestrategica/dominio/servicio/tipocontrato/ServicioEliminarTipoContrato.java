package com.ccoa.planeacionestrategica.dominio.servicio.tipocontrato;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoActividad;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoContrato;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarTipoContrato {

    private static final String MENSAJE_YA_EXISTE = "No existe el Tipo de Contrato con los datos ingresados";

    private final RepositorioTipoContrato repositorioTipoContrato;

    public ServicioEliminarTipoContrato(RepositorioTipoContrato repositorioTipoContrato) {
        this.repositorioTipoContrato = repositorioTipoContrato;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioTipoContrato.consultarPorId(id)== null) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioTipoContrato.eliminar(id);
    }
}
