package com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.documento;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.LA_URL_DEL_DOCUMENTO_DEBE_DE_SER_VALIDA;
import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO;

@Data
public class DocumentoActividadEstrategica {
    private final Long idRutaDocumentoActividadEstrategica;
    private final String rutaDocumento;
    public static DocumentoActividadEstrategica of(Long idRutaDocumentoActividadEstrategica, String rutaDocumento){
        ValidadorDominio.validarObligatorio(rutaDocumento,RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validarPatronURLEsValido(rutaDocumento,LA_URL_DEL_DOCUMENTO_DEBE_DE_SER_VALIDA);
        return new DocumentoActividadEstrategica(idRutaDocumentoActividadEstrategica,rutaDocumento);
    }

    public DocumentoActividadEstrategica(Long idRutaDocumentoActividadEstrategica, String rutaDocumento) {
        this.idRutaDocumentoActividadEstrategica = idRutaDocumentoActividadEstrategica;
        this.rutaDocumento = rutaDocumento;
    }
}
