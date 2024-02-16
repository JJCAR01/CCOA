package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.documento.DocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadestrategica.RepositorioActividadEstrategica;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarActividadEstrategica {

    private final RepositorioActividadEstrategica repositorioActividadEstrategica;

    public ServicioAplicacionListarActividadEstrategica(RepositorioActividadEstrategica repositorioActividadEstrategica) {
        this.repositorioActividadEstrategica = repositorioActividadEstrategica;
    }

    public List<DtoActividadEstrategicaResumen> ejecutar(){return this.repositorioActividadEstrategica.listar();}

    public DtoActividadEstrategicaResumen consultarById(Long id){return this.repositorioActividadEstrategica.consultarPorId(id);}
    public DocumentoActividadEstrategica consultarByIdDocumento(Long id){return this.repositorioActividadEstrategica.consultarPorIdParaObtenerDocumento(id);}
    public List<DtoActividadEstrategicaResumen> consultarByIdPat(Long id){return this.repositorioActividadEstrategica.consultarPorIdPat(id);}
}
