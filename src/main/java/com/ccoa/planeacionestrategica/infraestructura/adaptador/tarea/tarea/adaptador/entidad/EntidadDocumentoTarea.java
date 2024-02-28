package com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "documentos_tarea")
public class EntidadDocumentoTarea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_documento_tarea")
    private Long idDocumentoTarea;

    @Column(name = "id_tarea")
    private Long idTarea;

    @Column(name = "ruta_documento")
    private String rutaDocumento;

    private LocalDate fecha;

    public EntidadDocumentoTarea(Long idTarea, String rutaDocumento, LocalDate fecha) {
        this.idTarea = idTarea;
        this.rutaDocumento = rutaDocumento;
        this.fecha = fecha;
    }
}
