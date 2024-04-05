package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "documentos_actividad_gestion_estrategica")
public class EntidadDocumentoActividadGestionEstrategica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_documento_actividad_gestion_estrategica")
    private Long idDocumentoActividadGestionEstrategica;

    @Column(name = "id_actividad_gestion_estrategica")
    private Long idActividadGestionEstrategica;

    @Column(name = "ruta_documento")
    private String rutaDocumento;

    private LocalDate fecha;

    public EntidadDocumentoActividadGestionEstrategica(Long idActividadGestionEstrategica, String rutaDocumento, LocalDate fecha) {
        this.idActividadGestionEstrategica = idActividadGestionEstrategica;
        this.rutaDocumento = rutaDocumento;
        this.fecha = fecha;
    }
}
