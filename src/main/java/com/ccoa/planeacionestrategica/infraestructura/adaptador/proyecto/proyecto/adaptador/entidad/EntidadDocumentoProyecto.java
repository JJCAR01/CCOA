package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "documentos_proyecto")
public class EntidadDocumentoProyecto {

    @Id
    @Column(name = "id_documento_proyecto")
    private Long idDocumentoProyecto;

    @Column(name = "ruta_documento")
    private String rutaDocumento;

    public EntidadDocumentoProyecto(String rutaDocumento) {
        this.rutaDocumento = rutaDocumento;
    }

    public EntidadDocumentoProyecto(Long idDocumentoProyecto, String rutaDocumento) {
        this.idDocumentoProyecto = idDocumentoProyecto;
        this.rutaDocumento = rutaDocumento;
    }
}
