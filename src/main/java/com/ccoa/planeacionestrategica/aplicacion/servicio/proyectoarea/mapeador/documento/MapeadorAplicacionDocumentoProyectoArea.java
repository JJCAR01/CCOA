package com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.mapeador.documento;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyectoarea.DtoDocumentoProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.documento.DocumentoProyectoArea;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionDocumentoProyectoArea implements MapeadorAplicacion<DtoDocumentoProyectoArea, DocumentoProyectoArea> {

    @Override
    public DocumentoProyectoArea mapeadorAplicacion(DtoDocumentoProyectoArea dto) {
        return null;
    }
    public DocumentoProyectoArea mapeadorAplicacionCrear(DtoDocumentoProyectoArea dto, Long codigo) {
        return new DocumentoProyectoArea(dto.getIdDocumentoProyectoArea(),codigo, dto.getRutaDocumento(),dto.getFecha());
    }
    public DocumentoProyectoArea mapeadorAplicacionModificar(DtoDocumentoProyectoArea dto, Long codigo) {
        return new DocumentoProyectoArea(dto.getIdDocumentoProyectoArea(),codigo,dto.getRutaDocumento(),dto.getFecha());
    }
}
