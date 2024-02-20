package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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

    private LocalDate fecha;

    public EntidadDocumentoActividadEstrategica(Long idActividadEstrategica, String rutaDocumento, LocalDate fecha) {
        this.idActividadEstrategica = idActividadEstrategica;
        this.rutaDocumento = rutaDocumento;
        this.fecha = fecha;
    }
}
