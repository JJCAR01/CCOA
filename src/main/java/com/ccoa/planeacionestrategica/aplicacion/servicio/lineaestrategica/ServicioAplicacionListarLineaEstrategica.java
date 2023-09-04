package com.ccoa.planeacionestrategica.aplicacion.servicio.lineaestrategica;

import com.ccoa.planeacionestrategica.dominio.modelo.LineaEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioLineaEstrategica;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarLineaEstrategica {

    private final RepositorioLineaEstrategica repositorioLineaEstrategica;

    public ServicioAplicacionListarLineaEstrategica(RepositorioLineaEstrategica repositorioLineaEstrategica) {
        this.repositorioLineaEstrategica = repositorioLineaEstrategica;
    }

    public List<LineaEstrategica> ejecutar(){return this.repositorioLineaEstrategica.listar();}

    public LineaEstrategica consultarById(Long id){return this.repositorioLineaEstrategica.consultarPorId(id);}
}
