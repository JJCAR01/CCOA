package com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.documento;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.LA_URL_DEL_DOCUMENTO_DEBE_DE_SER_VALIDA;
import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO;

@Data
public class DocumentoProyectoArea {
    private final Long idRutaDocumentoProyectoArea;
    private final String rutaDocumento;
    public static DocumentoProyectoArea of(Long idRutaDocumentoProyectoArea, String rutaDocumento){
        ValidadorDominio.validarObligatorio(rutaDocumento,RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validarPatronURLEsValido(rutaDocumento,LA_URL_DEL_DOCUMENTO_DEBE_DE_SER_VALIDA);
        return new DocumentoProyectoArea(idRutaDocumentoProyectoArea,rutaDocumento);
    }
    public DocumentoProyectoArea(Long idRutaDocumentoProyectoArea, String rutaDocumento) {
        this.idRutaDocumentoProyectoArea = idRutaDocumentoProyectoArea;
        this.rutaDocumento = rutaDocumento;
    }
}
