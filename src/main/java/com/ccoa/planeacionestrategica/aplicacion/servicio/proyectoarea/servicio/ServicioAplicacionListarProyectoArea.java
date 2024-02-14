package com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.servicio;

import com.ccoa.planeacionestrategica.dominio.dto.DtoProyectoAreaResumen;
import com.ccoa.planeacionestrategica.dominio.dto.DtoProyectoResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsProyecto;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.documento.DocumentoProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.documento.DocumentoProyectoArea;
import com.ccoa.planeacionestrategica.dominio.puerto.proyecto.RepositorioProyecto;
import com.ccoa.planeacionestrategica.dominio.puerto.proyectoarea.RepositorioProyectoArea;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarProyectoArea {
    private final RepositorioProyectoArea repositorioProyectoArea;

    public ServicioAplicacionListarProyectoArea(RepositorioProyectoArea repositorioProyectoArea) {
        this.repositorioProyectoArea = repositorioProyectoArea;
    }

    public List<DtoProyectoAreaResumen> ejecutar(){return this.repositorioProyectoArea.listar();}

    public DtoProyectoAreaResumen consultarById(Long id){return this.repositorioProyectoArea.consultarPorId(id);}
    public List<DtoProyectoAreaResumen> consultarByIdPat(Long id){return this.repositorioProyectoArea.consultarPorIdPat(id);}
    public DocumentoProyectoArea consultarByIdDocumento(Long id){return this.repositorioProyectoArea.consultarPorIdParaObtenerDocumento(id);}
    public List<DtoIdsProyectoArea> consultarByIdPatAEliminar(Long id){return this.repositorioProyectoArea.consultarPorIdPatAEliminar(id);}
}
