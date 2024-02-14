package com.ccoa.planeacionestrategica.dominio.servicio.sprintproyectoarea;

import com.ccoa.planeacionestrategica.dominio.modelo.sprint.InformacionSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.Sprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.documento.DocumentoSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.InformacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.SprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.documento.DocumentoSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.puerto.sprint.RepositorioSprint;
import com.ccoa.planeacionestrategica.dominio.puerto.sprintproyectoarea.RepositorioSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
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
        if(this.repositorioSprintProyectoArea.existe(sprintProyectoArea)) throw new ValorInvalidoExcepcion(YA_EXISTE_EL_SPRINT_DEL_PROYECTO_DEL_AREA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioSprintProyectoArea.guardar(sprintProyectoArea, informacionSprintProyectoArea);
    }

    public Long ejecutarGuardarDocumento(DocumentoSprintProyectoArea documentoSprintProyectoArea, Long codigo){
        if(this.repositorioSprintProyectoArea.existeDocumento(documentoSprintProyectoArea)) throw new ValorInvalidoExcepcion(YA_EXISTE_UN_DOCUMENTO_RELACIONADO_CON_EL_SPRINT_DEL_PROYECTO_DEL_AREA,MENSAJE_DEFECTO);
        return this.repositorioSprintProyectoArea.guardarDocumento(documentoSprintProyectoArea,codigo);
    }

}
