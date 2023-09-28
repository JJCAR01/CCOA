package com.ccoa.planeacionestrategica.aplicacion.servicio.gestion;

import com.ccoa.planeacionestrategica.dominio.modelo.Gestion;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioGestion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarGestion {

    private final RepositorioGestion repositorioGestion;
    public ServicioAplicacionListarGestion(RepositorioGestion repositorioGestion) {
        this.repositorioGestion = repositorioGestion;
    }
    public List<Gestion> ejecutar(){return this.repositorioGestion.listar();}

    public Gestion consultarById(Long id){return this.repositorioGestion.consultarPorId(id);}
}
