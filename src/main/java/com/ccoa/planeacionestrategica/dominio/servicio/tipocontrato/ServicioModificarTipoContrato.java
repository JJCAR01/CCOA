package com.ccoa.planeacionestrategica.dominio.servicio.tipocontrato;

import com.ccoa.planeacionestrategica.dominio.modelo.TipoActividad;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoContrato;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoActividad;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoContrato;
import org.springframework.stereotype.Service;

@Service
public class ServicioModificarTipoContrato {

    private static final String MENSAJE_NO_EXISTE = "No existe el Tipo de Contrato con los datos ingresados";

    private final RepositorioTipoContrato repositorioTipoContrato;

    public ServicioModificarTipoContrato(RepositorioTipoContrato repositorioTipoContrato) {
        this.repositorioTipoContrato = repositorioTipoContrato;
    }

    public Long ejecutarModificar(TipoContrato tipoContrato, Long codigo){

        if(this.repositorioTipoContrato.consultarPorId(codigo)==null) throw new IllegalStateException(MENSAJE_NO_EXISTE);

        return this.repositorioTipoContrato.modificar(tipoContrato,codigo);
    }
}
