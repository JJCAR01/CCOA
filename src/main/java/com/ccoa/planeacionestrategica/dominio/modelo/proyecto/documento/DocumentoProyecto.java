package com.ccoa.planeacionestrategica.dominio.modelo.proyecto.documento;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.LA_URL_DEL_DOCUMENTO_DEBE_DE_SER_VALIDA;
import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO;
@NoArgsConstructor
@Data
public class DocumentoProyecto {
    private Long idDocumentoProyecto;
    private Long idProyecto;
    private String rutaDocumento;
    private LocalDate fecha;
    public static DocumentoProyecto of(Long idDocumentoProyecto, Long idProyecto, String rutaDocumento, LocalDate fecha){
        ValidadorDominio.validarObligatorio(rutaDocumento,RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validarPatronURLEsValido(rutaDocumento,LA_URL_DEL_DOCUMENTO_DEBE_DE_SER_VALIDA);
        return new DocumentoProyecto(idDocumentoProyecto,idProyecto, rutaDocumento, fecha);
    }

    public DocumentoProyecto(Long idDocumentoProyecto, Long idProyecto, String rutaDocumento, LocalDate fecha) {
        this.idDocumentoProyecto = idDocumentoProyecto;
        this.idProyecto = idProyecto;
        this.rutaDocumento = rutaDocumento;
        this.fecha = fecha;
    }
}
