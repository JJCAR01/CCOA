package com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.documento;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.LA_URL_DEL_DOCUMENTO_DEBE_DE_SER_VALIDA;
import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO;
@NoArgsConstructor
@Data
public class DocumentoActividadGestion {
    private Long idDocumentoActividadGestion;
    private Long idActividadGestion;
    private String rutaDocumento;
    private LocalDate fecha;
    public static DocumentoActividadGestion of(Long idDocumentoActividadGestion, Long idActividadGestion, String rutaDocumento, LocalDate fecha){
        ValidadorDominio.validarObligatorio(rutaDocumento,RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validarPatronURLEsValido(rutaDocumento,LA_URL_DEL_DOCUMENTO_DEBE_DE_SER_VALIDA);
        return new DocumentoActividadGestion(idDocumentoActividadGestion,idActividadGestion, rutaDocumento, fecha);
    }

    public DocumentoActividadGestion(Long idDocumentoActividadGestion, Long idActividadGestion, String rutaDocumento, LocalDate fecha) {
        this.idDocumentoActividadGestion = idDocumentoActividadGestion;
        this.idActividadGestion = idActividadGestion;
        this.rutaDocumento = rutaDocumento;
        this.fecha = fecha;
    }
}
