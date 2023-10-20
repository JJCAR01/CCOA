package com.ccoa.planeacionestrategica.infraestructura.clase.sprint.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "documento_sprint")
public class EntidadDocumentoSprint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_documneto_sprint")
    private Long idDocumentoSprint;

    @Column(name = "ruta_archivo")
    private String rutaArchivo;

    public EntidadDocumentoSprint(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }
}
