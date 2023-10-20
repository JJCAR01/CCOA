package com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoSprint;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.DocumentoSprint;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionDocumentoSprint implements MapeadorAplicacion<DtoSprint, DocumentoSprint> {
    @Override
    public DocumentoSprint mapeadorAplicacion(DtoSprint dto) {
        return new DocumentoSprint(dto.getRutaArchivo());
    }
}
