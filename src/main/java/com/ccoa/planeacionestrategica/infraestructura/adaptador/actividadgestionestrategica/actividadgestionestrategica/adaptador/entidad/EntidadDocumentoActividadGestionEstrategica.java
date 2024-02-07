package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "documentos_actividad_gestion_estrategica")
public class EntidadDocumentoActividadGestionEstrategica {

    @Id
    @Column(name = "id_documneto_actividad_gestion_actividad_estrategica")
    private Long idDocumentoActividadGestionEstrategica;

    @Column(name = "ruta_documento")
    private String rutaDocumento;

    public EntidadDocumentoActividadGestionEstrategica(String rutaDocumento) {
        this.rutaDocumento = rutaDocumento;
    }

    public EntidadDocumentoActividadGestionEstrategica(Long idDocumentoActividadGestionEstrategica, String rutaDocumento) {
        this.idDocumentoActividadGestionEstrategica = idDocumentoActividadGestionEstrategica;
        this.rutaDocumento = rutaDocumento;
    }
}
