package com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.mapeador.documento;

import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoDocumentoTarea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.documento.DocumentoTarea;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionDocumentoTarea implements MapeadorAplicacion<DtoDocumentoTarea, DocumentoTarea> {

    @Override
    public DocumentoTarea mapeadorAplicacion(DtoDocumentoTarea dto) {
        return null;
    }

    public DocumentoTarea mapeadorAplicacionCrear(DtoDocumentoTarea dto, Long codigo) {
        return new DocumentoTarea(codigo,dto.getRutaDocumento(),dto.getFecha());
    }
}
