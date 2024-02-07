package com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.documento;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.LA_URL_DEL_DOCUMENTO_DEBE_DE_SER_VALIDA;
import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO;

@Data
public class DocumentoActividadGestion {
    private final Long idRutaDocumentoActividadGestion;
    private final String rutaDocumento;
    public static DocumentoActividadGestion of(Long idRutaDocumentoActividadGestion, String rutaDocumento){
        ValidadorDominio.validarObligatorio(rutaDocumento,RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validarPatronURLEsValido(rutaDocumento,LA_URL_DEL_DOCUMENTO_DEBE_DE_SER_VALIDA);
        return new DocumentoActividadGestion(idRutaDocumentoActividadGestion,rutaDocumento);
    }

    public DocumentoActividadGestion(Long idRutaDocumentoActividadGestion, String rutaDocumento) {
        this.idRutaDocumentoActividadGestion = idRutaDocumentoActividadGestion;
        this.rutaDocumento = rutaDocumento;
    }
}
