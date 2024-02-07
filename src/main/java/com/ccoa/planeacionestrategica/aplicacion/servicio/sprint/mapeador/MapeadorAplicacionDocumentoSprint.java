package com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoRutaArchivo;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.documento.DocumentoSprint;
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
