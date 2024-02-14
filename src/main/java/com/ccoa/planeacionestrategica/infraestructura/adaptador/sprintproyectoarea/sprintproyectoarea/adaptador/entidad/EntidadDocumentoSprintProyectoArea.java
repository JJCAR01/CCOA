package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "documentos_sprint_proyecto_area")
public class EntidadDocumentoSprintProyectoArea {
    @Id
    @Column(name = "id_documneto_sprint_proyecto_area")
    private Long idDocumentoSprintProyectoArea;

    @Column(name = "ruta_archivo")
    private String rutaArchivo;

    public EntidadDocumentoSprintProyectoArea(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public EntidadDocumentoSprintProyectoArea(Long idDocumentoSprintProyectoArea, String rutaArchivo) {
        this.idDocumentoSprintProyectoArea = idDocumentoSprintProyectoArea;
        this.rutaArchivo = rutaArchivo;
    }
}
