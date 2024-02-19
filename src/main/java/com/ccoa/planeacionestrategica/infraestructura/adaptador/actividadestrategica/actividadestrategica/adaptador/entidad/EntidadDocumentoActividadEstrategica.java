package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "documentos_actividad_estrategica")
public class EntidadDocumentoActividadEstrategica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_documento_actividad_estrategica")
    private Long idDocumentoActividadEstrategica;

    @Column(name = "id_actividad_estrategica")
    private Long idActividadEstrategica;

    @Column(name = "ruta_documento")
    private String rutaDocumento;

    public EntidadDocumentoActividadEstrategica(String rutaDocumento) {
        this.rutaDocumento = rutaDocumento;
    }

    public EntidadDocumentoActividadEstrategica(Long idActividadEstrategica, String rutaDocumento) {
        this.idActividadEstrategica = idActividadEstrategica;
        this.rutaDocumento = rutaDocumento;
    }
}
