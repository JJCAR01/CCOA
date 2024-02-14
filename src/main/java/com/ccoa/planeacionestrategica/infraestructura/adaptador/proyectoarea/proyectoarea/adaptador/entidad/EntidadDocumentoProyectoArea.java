package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "documentos_proyecto_area")
public class EntidadDocumentoProyectoArea {

    @Id
    @Column(name = "id_documento_proyecto_area")
    private Long idDocumentoProyectoArea;

    @Column(name = "ruta_documento")
    private String rutaDocumento;

    public EntidadDocumentoProyectoArea(String rutaDocumento) {
        this.rutaDocumento = rutaDocumento;
    }

    public EntidadDocumentoProyectoArea(Long idDocumentoProyectoArea, String rutaDocumento) {
        this.idDocumentoProyectoArea = idDocumentoProyectoArea;
        this.rutaDocumento = rutaDocumento;
    }
}
