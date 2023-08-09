package com.ccoa.planeacionestrategica.dominio.servicio.tipocontrato;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoContrato;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoContrato;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarTipoContrato {

    private static final String MENSAJE_YA_EXISTE = "Ya existe el Tipo de Contrato con los datos ingresados";

    private final RepositorioTipoContrato repositorioTipoContrato;

    public ServicioGuardarTipoContrato(RepositorioTipoContrato repositorioTipoContrato) {
        this.repositorioTipoContrato = repositorioTipoContrato;
    }

    public Long ejecutarGuardar(TipoContrato tipoContrato){

        if(this.repositorioTipoContrato.existe(tipoContrato)) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioTipoContrato.guardar(tipoContrato);}
}
