package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "documentos_sprint")
public class EntidadDocumentoSprint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_documento_sprint")
    private Long idDocumentoSprint;

    @Column(name = "id_sprint")
    private Long idSprint;

    @Column(name = "ruta_documento")
    private String rutaDocumento;

    private LocalDate fecha;

    public EntidadDocumentoSprint(Long idSprint, String rutaDocumento, LocalDate fecha) {
        this.idSprint = idSprint;
        this.rutaDocumento = rutaDocumento;
        this.fecha = fecha;
    }
}
