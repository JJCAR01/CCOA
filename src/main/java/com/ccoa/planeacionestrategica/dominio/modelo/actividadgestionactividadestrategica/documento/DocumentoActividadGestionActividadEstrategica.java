package com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.documento;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.LA_URL_DEL_DOCUMENTO_DEBE_DE_SER_VALIDA;
import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO;
@Data
public class DocumentoActividadGestionActividadEstrategica {
    private final Long idRutaDocumentoActividadGestionActividadEstrategica;
    private final String rutaDocumento;
    public static DocumentoActividadGestionActividadEstrategica of(Long idRutaDocumentoActividadGestionActividadEstrategica, String rutaDocumento){
        ValidadorDominio.validarObligatorio(rutaDocumento,RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validarPatronURLEsValido(rutaDocumento,LA_URL_DEL_DOCUMENTO_DEBE_DE_SER_VALIDA);
        return new DocumentoActividadGestionActividadEstrategica(idRutaDocumentoActividadGestionActividadEstrategica,rutaDocumento);
    }

    public DocumentoActividadGestionActividadEstrategica(Long idRutaDocumentoActividadGestionActividadEstrategica, String rutaDocumento) {
        this.idRutaDocumentoActividadGestionActividadEstrategica = idRutaDocumentoActividadGestionActividadEstrategica;
        this.rutaDocumento = rutaDocumento;
    }
}
