package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "documentos_sprint_proyecto_area")
public class EntidadDocumentoSprintProyectoArea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_documneto_sprint_proyecto_area")
    private Long idDocumentoSprintProyectoArea;

    @Column(name = "id_sprint_proyecto_area")
    private Long idSprintProyectoArea;

    @Column(name = "ruta_documento")
    private String rutaDocumento;

    private LocalDate fecha;

    public EntidadDocumentoSprintProyectoArea(Long idSprintProyectoArea, String rutaDocumento, LocalDate fecha) {
        this.idSprintProyectoArea = idSprintProyectoArea;
        this.rutaDocumento = rutaDocumento;
        this.fecha = fecha;
    }
}
