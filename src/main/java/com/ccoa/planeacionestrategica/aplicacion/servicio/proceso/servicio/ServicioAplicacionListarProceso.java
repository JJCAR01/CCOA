package com.ccoa.planeacionestrategica.aplicacion.servicio.proceso.servicio;

import com.ccoa.planeacionestrategica.dominio.modelo.proceso.Proceso;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioProceso;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ServicioAplicacionListarProceso {

    private final RepositorioProceso repositorioProceso;

    public ServicioAplicacionListarProceso(RepositorioProceso repositorioProceso) {
        this.repositorioProceso = repositorioProceso;
    }

    public List<Proceso> ejecutar(){return this.repositorioProceso.listar();}

    public Proceso consultarById(Long id){return this.repositorioProceso.consultarPorId(id);}
}
