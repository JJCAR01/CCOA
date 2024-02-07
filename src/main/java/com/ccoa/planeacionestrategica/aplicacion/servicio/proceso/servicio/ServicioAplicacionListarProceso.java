package com.ccoa.planeacionestrategica.aplicacion.servicio.proceso.servicio;

import com.ccoa.planeacionestrategica.dominio.dto.DtoProcesoResumen;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioProceso;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ServicioAplicacionListarProceso {

    private final RepositorioProceso repositorioProceso;

    public ServicioAplicacionListarProceso(RepositorioProceso repositorioProceso) {
        this.repositorioProceso = repositorioProceso;
    }

    public List<DtoProcesoResumen> ejecutar(){return this.repositorioProceso.listar();}

    public DtoProcesoResumen consultarById(Long id){return this.repositorioProceso.consultarPorId(id);}
}
