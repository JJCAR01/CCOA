package com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.documento;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.LA_URL_DEL_DOCUMENTO_DEBE_DE_SER_VALIDA;
import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO;
@Data
public class DocumentoActividadGestionEstrategica {
    private final Long idRutaDocumentoActividadGestionEstrategica;
    private final String rutaDocumento;
    public static DocumentoActividadGestionEstrategica of(Long idRutaDocumentoActividadGestionEstrategica, String rutaDocumento){
        ValidadorDominio.validarObligatorio(rutaDocumento,RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validarPatronURLEsValido(rutaDocumento,LA_URL_DEL_DOCUMENTO_DEBE_DE_SER_VALIDA);
        return new DocumentoActividadGestionEstrategica(idRutaDocumentoActividadGestionEstrategica,rutaDocumento);
    }

    public DocumentoActividadGestionEstrategica(Long idRutaDocumentoActividadGestionEstrategica, String rutaDocumento) {
        this.idRutaDocumentoActividadGestionEstrategica = idRutaDocumentoActividadGestionEstrategica;
        this.rutaDocumento = rutaDocumento;
    }
}
