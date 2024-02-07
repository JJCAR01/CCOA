package com.ccoa.planeacionestrategica.dominio.modelo.proyecto.documento;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.LA_URL_DEL_DOCUMENTO_DEBE_DE_SER_VALIDA;
import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO;

@Data
public class DocumentoProyecto {
    private final Long idRutaDocumentoProyecto;
    private final String rutaDocumento;
    public static DocumentoProyecto of(Long idRutaDocumentoProyecto, String rutaDocumento){
        ValidadorDominio.validarObligatorio(rutaDocumento,RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validarPatronURLEsValido(rutaDocumento,LA_URL_DEL_DOCUMENTO_DEBE_DE_SER_VALIDA);
        return new DocumentoProyecto(idRutaDocumentoProyecto,rutaDocumento);
    }
    public DocumentoProyecto(Long idRutaDocumentoProyecto, String rutaDocumento) {
        this.idRutaDocumentoProyecto = idRutaDocumentoProyecto;
        this.rutaDocumento = rutaDocumento;
    }
}
