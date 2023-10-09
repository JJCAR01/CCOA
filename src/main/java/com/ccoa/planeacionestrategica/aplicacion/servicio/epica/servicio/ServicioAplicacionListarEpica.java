package com.ccoa.planeacionestrategica.aplicacion.servicio.epica.servicio;

import com.ccoa.planeacionestrategica.dominio.dto.DtoEpicaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.epica.Epica;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioEpica;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarEpica {

    private final RepositorioEpica repositorioEpica;

    public ServicioAplicacionListarEpica(RepositorioEpica repositorioEpica) {
        this.repositorioEpica = repositorioEpica;
    }

    public List<DtoEpicaResumen> ejecutar(){return this.repositorioEpica.listar();}

    public Epica consultarById(Long id){return this.repositorioEpica.consultarPorId(id);}

    public List<DtoEpicaResumen> consultarByIdpat(Long id){return this.repositorioEpica.consultarPorIdPat(id);}
}
