package com.ccoa.planeacionestrategica.dominio.modelo.sprint.documento;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.LA_URL_DEL_DOCUMENTO_DEBE_DE_SER_VALIDA;
import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO;
@NoArgsConstructor
@Data
public class DocumentoSprint {
    private Long idSprint;
    private String rutaDocumento;
    private LocalDate fecha;
    public static DocumentoSprint of(Long idSprint, String rutaDocumento, LocalDate fecha){
        ValidadorDominio.validarObligatorio(rutaDocumento,RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validarPatronURLEsValido(rutaDocumento,LA_URL_DEL_DOCUMENTO_DEBE_DE_SER_VALIDA);
        return new DocumentoSprint(idSprint, rutaDocumento, fecha);
    }

    public DocumentoSprint(Long idSprint, String rutaDocumento, LocalDate fecha) {
        this.idSprint = idSprint;
        this.rutaDocumento = rutaDocumento;
        this.fecha = fecha;
    }
}
