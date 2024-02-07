package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.actividadgestionactividadestrategica.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.documento.DocumentoActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.actividadgestionactividadestrategica.adaptador.entidad.EntidadDocumentoActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorDocumentoActividadGestionActividadEstrategica implements MapeadorInfraestructura<EntidadDocumentoActividadGestionActividadEstrategica,
        DocumentoActividadGestionActividadEstrategica> {
    @Override
    public DocumentoActividadGestionActividadEstrategica mapeadorDominio(EntidadDocumentoActividadGestionActividadEstrategica entidad) {
        return new DocumentoActividadGestionActividadEstrategica(entidad.getIdDocumentoActividadGestionActividadEstrategica(),
                entidad.getRutaDocumento());
    }
    @Override
    public EntidadDocumentoActividadGestionActividadEstrategica mapeadorEntidad(DocumentoActividadGestionActividadEstrategica dominio) {
        return new EntidadDocumentoActividadGestionActividadEstrategica(dominio.getRutaDocumento());
    }
    public EntidadDocumentoActividadGestionActividadEstrategica mapeadorEntidadDocumento(DocumentoActividadGestionActividadEstrategica dominio, Long id) {
        return new EntidadDocumentoActividadGestionActividadEstrategica(id,dominio.getRutaDocumento());
    }
}
