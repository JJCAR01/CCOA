package com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoRutaArchivo;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoSprint;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.dto.DtoSprintResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.DocumentoSprint;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionDocumentoSprint implements MapeadorAplicacion<DtoRutaArchivo, DocumentoSprint> {


    @Override
    public DocumentoSprint mapeadorAplicacion(DtoRutaArchivo dto) {
        return null;
    }

    public DocumentoSprint mapeadorAplicacionCrear(DtoRutaArchivo dto, Long codigo) {
        return new DocumentoSprint(codigo,dto.getRutaArchivo());
    }
}
