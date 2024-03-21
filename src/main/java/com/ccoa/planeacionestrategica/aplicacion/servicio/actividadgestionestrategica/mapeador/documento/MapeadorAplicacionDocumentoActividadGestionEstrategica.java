package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.mapeador.documento;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoDocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionestrategica.DtoDocumentoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.documento.DocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.documento.DocumentoActividadGestionEstrategica;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MapeadorAplicacionDocumentoActividadGestionEstrategica implements MapeadorAplicacion<DtoDocumentoActividadGestionEstrategica,
        DocumentoActividadGestionEstrategica> {
    @Override
    public DocumentoActividadGestionEstrategica mapeadorAplicacion(DtoDocumentoActividadGestionEstrategica dto) {
        return null;
    }

    public DocumentoActividadGestionEstrategica mapeadorAplicacionCrear(DtoDocumentoActividadGestionEstrategica dto, Long codigo) {
        return new DocumentoActividadGestionEstrategica(dto.getIdDocumentoActividadGestionEstrategica(),codigo,dto.getRutaDocumento(),dto.getFecha());
    }
    public DocumentoActividadGestionEstrategica mapeadorAplicacionModificar(DtoDocumentoActividadGestionEstrategica dto, Long codigo) {
        return new DocumentoActividadGestionEstrategica(dto.getIdDocumentoActividadGestionEstrategica(),codigo,dto.getRutaDocumento(),dto.getFecha());
    }
}
