package com.ccoa.planeacionestrategica.dominio.servicio.sprintproyectoarea;

import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.InformacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.SprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.documento.DocumentoSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.puerto.sprintproyectoarea.RepositorioSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioGuardarSprintProyectoArea {
    private final RepositorioSprintProyectoArea repositorioSprintProyectoArea;

    public ServicioGuardarSprintProyectoArea(RepositorioSprintProyectoArea repositorioSprintProyectoArea) {
        this.repositorioSprintProyectoArea = repositorioSprintProyectoArea;
    }

    public Long ejecutarGuardar(SprintProyectoArea sprintProyectoArea, InformacionSprintProyectoArea informacionSprintProyectoArea){
        return this.repositorioSprintProyectoArea.guardar(sprintProyectoArea, informacionSprintProyectoArea);
    }

    public Long ejecutarGuardarDocumento(DocumentoSprintProyectoArea documentoSprintProyectoArea, Long codigo){
        return this.repositorioSprintProyectoArea.guardarDocumento(documentoSprintProyectoArea,codigo);
    }

}
