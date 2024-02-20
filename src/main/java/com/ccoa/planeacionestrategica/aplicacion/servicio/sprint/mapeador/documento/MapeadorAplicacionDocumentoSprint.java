package com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.mapeador.documento;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoDocumentoSprint;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.documento.DocumentoSprint;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionDocumentoSprint implements MapeadorAplicacion<DtoDocumentoSprint, DocumentoSprint> {


    @Override
    public DocumentoSprint mapeadorAplicacion(DtoDocumentoSprint dto) {
        return null;
    }

    public DocumentoSprint mapeadorAplicacionCrear(DtoDocumentoSprint dto, Long codigo) {
        return new DocumentoSprint(codigo,dto.getRutaDocumento(),dto.getFecha());
    }
}
