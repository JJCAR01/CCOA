package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador.documento;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoDocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.documento.DocumentoActividadEstrategica;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionDocumentoActividadEstrategica implements MapeadorAplicacion<DtoDocumentoActividadEstrategica, DocumentoActividadEstrategica> {
    @Override
    public DocumentoActividadEstrategica mapeadorAplicacion(DtoDocumentoActividadEstrategica dto) {
        return null;
    }
    public DocumentoActividadEstrategica mapeadorAplicacionCrear(DtoDocumentoActividadEstrategica dto, Long codigo) {
        return new DocumentoActividadEstrategica(codigo,dto.getRutaDocumento());
    }
}
