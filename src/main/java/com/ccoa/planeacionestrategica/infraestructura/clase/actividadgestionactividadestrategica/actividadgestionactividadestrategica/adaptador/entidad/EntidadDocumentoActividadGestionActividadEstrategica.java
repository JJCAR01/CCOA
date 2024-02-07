package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.actividadgestionactividadestrategica.adaptador.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "documento_actividad_gestion_actividad_estrategica")
public class EntidadDocumentoActividadGestionActividadEstrategica {

    @Id
    @Column(name = "id_documneto_actividad_gestion_actividad_estrategica")
    private Long idDocumentoActividadGestionActividadEstrategica;

    @Column(name = "ruta_documento")
    private String rutaDocumento;

    public EntidadDocumentoActividadGestionActividadEstrategica(String rutaDocumento) {
        this.rutaDocumento = rutaDocumento;
    }

    public EntidadDocumentoActividadGestionActividadEstrategica(Long idDocumentoActividadGestionActividadEstrategica, String rutaDocumento) {
        this.idDocumentoActividadGestionActividadEstrategica = idDocumentoActividadGestionActividadEstrategica;
        this.rutaDocumento = rutaDocumento;
    }
}
