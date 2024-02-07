package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.mapeador.documento;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoDocumentoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.documento.DocumentoProyecto;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionDocumentoProyecto implements MapeadorAplicacion<DtoDocumentoProyecto, DocumentoProyecto> {
    @Override
    public DocumentoProyecto mapeadorAplicacion(DtoDocumentoProyecto dto) {return null; }
    public DocumentoProyecto mapeadorAplicacionCrear(DtoDocumentoProyecto dto, Long codigo) {
        return new DocumentoProyecto(codigo,dto.getRutaDocumento());
    }
}
