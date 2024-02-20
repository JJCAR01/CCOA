package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "documentos_proyecto_area")
public class EntidadDocumentoProyectoArea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_documento_proyecto_area")
    private Long idDocumentoProyectoArea;

    @Column(name = "id_proyecto_area")
    private Long idProyectoArea;

    @Column(name = "ruta_documento")
    private String rutaDocumento;

    private LocalDate fecha;

    public EntidadDocumentoProyectoArea(Long idProyectoArea, String rutaDocumento, LocalDate fecha) {
        this.idProyectoArea = idProyectoArea;
        this.rutaDocumento = rutaDocumento;
        this.fecha = fecha;
    }
}
