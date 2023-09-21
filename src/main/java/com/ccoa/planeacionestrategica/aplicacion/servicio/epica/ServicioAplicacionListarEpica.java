package com.ccoa.planeacionestrategica.aplicacion.servicio.epica;

import com.ccoa.planeacionestrategica.dominio.modelo.epica.Epica;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioEpica;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarEpica{

    private final RepositorioEpica repositorioEpica;

    public ServicioAplicacionListarEpica(RepositorioEpica repositorioEpica) {
        this.repositorioEpica = repositorioEpica;
    }

    public List<Epica> ejecutar(){return this.repositorioEpica.listarEpica();}

    public Epica consultarById(Long id){return this.repositorioEpica.consultarPorId(id);}
}
