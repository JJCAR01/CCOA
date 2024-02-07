package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "documentos_actividad_estrategica")
public class EntidadDocumentoActividadEstrategica {

    @Id
    @Column(name = "id_documento_actividad_estrategica")
    private Long idDocumentoActividadEstrategica;

    @Column(name = "ruta_documento")
    private String rutaDocumento;

    public EntidadDocumentoActividadEstrategica(String rutaDocumento) {
        this.rutaDocumento = rutaDocumento;
    }

    public EntidadDocumentoActividadEstrategica(Long idDocumentoActividadEstrategica, String rutaDocumento) {
        this.idDocumentoActividadEstrategica = idDocumentoActividadEstrategica;
        this.rutaDocumento = rutaDocumento;
    }
}
