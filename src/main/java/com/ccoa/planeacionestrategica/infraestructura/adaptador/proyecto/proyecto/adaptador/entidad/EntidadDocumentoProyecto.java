package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "documentos_proyecto")
public class EntidadDocumentoProyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_documento_proyecto")
    private Long idDocumentoProyecto;

    @Column(name = "id_proyecto")
    private Long idProyecto;

    @Column(name = "ruta_documento")
    private String rutaDocumento;

    private LocalDate fecha;

    public EntidadDocumentoProyecto(Long idProyecto, String rutaDocumento, LocalDate fecha) {
        this.idProyecto = idProyecto;
        this.rutaDocumento = rutaDocumento;
        this.fecha = fecha;
    }
}
