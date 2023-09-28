package com.ccoa.planeacionestrategica.aplicacion.servicio.cargo;

import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioCargo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarCargo {

    private final RepositorioCargo repositorioCargo;

    public ServicioAplicacionListarCargo(RepositorioCargo repositorioCargo) {
        this.repositorioCargo = repositorioCargo;
    }

    public List<Cargo> ejecutar(){return this.repositorioCargo.listar();}

    public Cargo consultarById(Long id){return this.repositorioCargo.consultarPorId(id);}
}
