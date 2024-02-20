package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.mapeador.documento;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoDocumentoActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.documento.DocumentoActividadGestion;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MapeadorAplicacionDocumentoActividadGestion implements MapeadorAplicacion<DtoDocumentoActividadGestion, DocumentoActividadGestion> {
    @Override
    public DocumentoActividadGestion mapeadorAplicacion(DtoDocumentoActividadGestion dto) {
        return null;
    }
    public DocumentoActividadGestion mapeadorAplicacionCrear(DtoDocumentoActividadGestion dto, Long codigo) {
        return new DocumentoActividadGestion(codigo,dto.getRutaDocumento(),dto.getFecha());
    }
}
