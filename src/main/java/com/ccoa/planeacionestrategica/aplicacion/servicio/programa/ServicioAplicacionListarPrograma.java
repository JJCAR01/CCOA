package com.ccoa.planeacionestrategica.aplicacion.servicio.programa;

import com.ccoa.planeacionestrategica.dominio.modelo.programa.Programa;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioPrograma;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarPrograma {

    private final RepositorioPrograma repositorioPrograma;

    public ServicioAplicacionListarPrograma(RepositorioPrograma repositorioPrograma) {
        this.repositorioPrograma = repositorioPrograma;
    }

    public List<Programa> ejecutar(){return this.repositorioPrograma.listarPrograma();}

    public Programa consultarById(Long id){return this.repositorioPrograma.consultarPorId(id);}
}
