package com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.servicio;

import com.ccoa.planeacionestrategica.dominio.dto.DtoSprintProyectoAreaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.SprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.documento.DocumentoSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.puerto.sprintproyectoarea.RepositorioSprintProyectoArea;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarSprintProyectoArea {
    private final RepositorioSprintProyectoArea repositorioSprintProyectoArea;

    public ServicioAplicacionListarSprintProyectoArea(RepositorioSprintProyectoArea repositorioSprintProyectoArea) {
        this.repositorioSprintProyectoArea = repositorioSprintProyectoArea;
    }

    public List<DtoSprintProyectoAreaResumen> ejecutar(){return this.repositorioSprintProyectoArea.listar();}
    public SprintProyectoArea consultarById(Long id){return this.repositorioSprintProyectoArea.consultarPorId(id);}
    public List<DocumentoSprintProyectoArea> consultarByIdDocumento(Long id){return this.repositorioSprintProyectoArea.consultarPorIdParaObtenerDocumento(id);}
    public List<DtoSprintProyectoAreaResumen> consultarByIdProyectoArea(Long id){return this.repositorioSprintProyectoArea.consultarPorIdProyectoArea(id);}
}
