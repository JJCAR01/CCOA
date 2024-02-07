package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.mapeador.documento;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionactividadestrategica.DtoDocumentoActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.documento.DocumentoActividadGestionActividadEstrategica;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MapeadorAplicacionDocumentoActividadGestionActividadEstrategica implements MapeadorAplicacion<DtoDocumentoActividadGestionActividadEstrategica,
        DocumentoActividadGestionActividadEstrategica> {
    @Override
    public DocumentoActividadGestionActividadEstrategica mapeadorAplicacion(DtoDocumentoActividadGestionActividadEstrategica dto) {
        return null;
    }

    public DocumentoActividadGestionActividadEstrategica mapeadorAplicacionCrear(DtoDocumentoActividadGestionActividadEstrategica dto, Long codigo) {
        return new DocumentoActividadGestionActividadEstrategica(codigo,dto.getRutaDocumento());
    }
}
