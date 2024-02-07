package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "documentos_actividad_gestion")
public class EntidadDocumentoActividadGestion {

    @Id
    @Column(name = "id_documento_actividad_gestion")
    private Long idDocumentoActividadGestion;

    @Column(name = "ruta_documento")
    private String rutaDocumento;

    public EntidadDocumentoActividadGestion(String rutaDocumento) {
        this.rutaDocumento = rutaDocumento;
    }
    public EntidadDocumentoActividadGestion(Long idDocumentoActividadGestion, String rutaDocumento) {
        this.idDocumentoActividadGestion = idDocumentoActividadGestion;
        this.rutaDocumento = rutaDocumento;
    }
}
