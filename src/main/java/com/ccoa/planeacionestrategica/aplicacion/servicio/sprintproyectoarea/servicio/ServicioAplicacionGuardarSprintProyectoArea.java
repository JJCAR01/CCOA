package com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.servicio;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprintproyectoarea.DtoDocumentoSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprintproyectoarea.DtoSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.mapeador.documento.MapeadorAplicacionDocumentoSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.mapeador.MapeadorAplicacionInformacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.mapeador.MapeadorAplicacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.servicio.sprintproyectoarea.ServicioGuardarSprintProyectoArea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarSprintProyectoArea {
    private final ServicioGuardarSprintProyectoArea servicioGuardarSprintProyectoArea;
    private final MapeadorAplicacionSprintProyectoArea mapeadorAplicacionSprintProyectoArea;
    private final MapeadorAplicacionInformacionSprintProyectoArea mapeadorAplicacionInformacionSprintProyectoArea;
    private final MapeadorAplicacionDocumentoSprintProyectoArea mapeadorAplicacionDocumentoSprintProyectoArea;

    public ServicioAplicacionGuardarSprintProyectoArea(ServicioGuardarSprintProyectoArea servicioGuardarSprintProyectoArea, MapeadorAplicacionSprintProyectoArea mapeadorAplicacionSprintProyectoArea,
                                                                   MapeadorAplicacionInformacionSprintProyectoArea mapeadorAplicacionInformacionSprintProyectoArea, MapeadorAplicacionDocumentoSprintProyectoArea mapeadorAplicacionDocumentoSprintProyectoArea) {
        this.servicioGuardarSprintProyectoArea = servicioGuardarSprintProyectoArea;
        this.mapeadorAplicacionSprintProyectoArea = mapeadorAplicacionSprintProyectoArea;
        this.mapeadorAplicacionInformacionSprintProyectoArea = mapeadorAplicacionInformacionSprintProyectoArea;
        this.mapeadorAplicacionDocumentoSprintProyectoArea = mapeadorAplicacionDocumentoSprintProyectoArea;
    }

    public DtoRespuesta<Long> ejecutar(DtoSprintProyectoArea dto){
        var sprintProyectoArea = this.mapeadorAplicacionSprintProyectoArea.mapeadorAplicacion(dto);
        var informacionSprintProyectoArea = this.mapeadorAplicacionInformacionSprintProyectoArea.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarSprintProyectoArea.ejecutarGuardar(sprintProyectoArea,informacionSprintProyectoArea));
    }
    public DtoRespuesta<Long> guardarRutaArchivo(DtoDocumentoSprintProyectoArea dto, Long codigo){
        var docSprintProyectoArea = this.mapeadorAplicacionDocumentoSprintProyectoArea.mapeadorAplicacionCrear(dto,codigo);
        return new DtoRespuesta<>(this.servicioGuardarSprintProyectoArea.ejecutarGuardarDocumento(docSprintProyectoArea,codigo));
    }
}
