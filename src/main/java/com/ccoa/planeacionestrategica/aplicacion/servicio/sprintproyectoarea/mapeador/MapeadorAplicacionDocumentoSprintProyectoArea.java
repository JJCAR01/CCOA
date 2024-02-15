package com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprintproyectoarea.DtoDocumentoSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.documento.DocumentoSprintProyectoArea;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionDocumentoSprintProyectoArea implements MapeadorAplicacion<DtoDocumentoSprintProyectoArea, DocumentoSprintProyectoArea> {

    @Override
    public DocumentoSprintProyectoArea mapeadorAplicacion(DtoDocumentoSprintProyectoArea dto) {
        return null;
    }

    public DocumentoSprintProyectoArea mapeadorAplicacionCrear(DtoDocumentoSprintProyectoArea dto, Long codigo) {
        return new DocumentoSprintProyectoArea(codigo,dto.getRutaArchivo());
    }
}
