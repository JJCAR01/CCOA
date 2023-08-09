package com.ccoa.planeacionestrategica.aplicacion.servicio.tipocontrato;

import com.ccoa.planeacionestrategica.dominio.modelo.TipoActividad;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoContrato;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoActividad;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoContrato;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarTipoContrato {

    private final RepositorioTipoContrato repositorioTipoContrato;

    public ServicioAplicacionListarTipoContrato(RepositorioTipoContrato repositorioTipoContrato) {
        this.repositorioTipoContrato = repositorioTipoContrato;
    }

    public List<TipoContrato> ejecutar(){return this.repositorioTipoContrato.listar();}

    public TipoContrato consultarById(Long id){return this.repositorioTipoContrato.consultarPorId(id);}
}
