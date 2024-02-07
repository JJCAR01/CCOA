package com.ccoa.planeacionestrategica.infraestructura.clase.sprint.sprint.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@Table(name = "documento_sprint")
public class EntidadDocumentoSprint {
    @Id
    @Column(name = "id_documneto_sprint")
    private Long idDocumentoSprint;

    @Column(name = "ruta_archivo")
    private String rutaArchivo;

    public EntidadDocumentoSprint(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public EntidadDocumentoSprint(Long idDocumentoSprint, String rutaArchivo) {
        this.idDocumentoSprint = idDocumentoSprint;
        this.rutaArchivo = rutaArchivo;
    }
}
