package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "documentos_actividad_gestion")
public class EntidadDocumentoActividadGestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_documento_actividad_gestion")
    private Long idDocumentoActividadGestion;

    @Column(name = "id_actividad_gestion")
    private Long idActividadGestion;

    @Column(name = "ruta_documento")
    private String rutaDocumento;

    private LocalDate fecha;

    public EntidadDocumentoActividadGestion(Long idActividadGestion, String rutaDocumento, LocalDate fecha) {
        this.idActividadGestion = idActividadGestion;
        this.rutaDocumento = rutaDocumento;
        this.fecha = fecha;
    }
}
