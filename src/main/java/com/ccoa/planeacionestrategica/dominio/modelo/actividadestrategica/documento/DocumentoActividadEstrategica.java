package com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.documento;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.LA_URL_DEL_DOCUMENTO_DEBE_DE_SER_VALIDA;
import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO;
@NoArgsConstructor
@Data
public class DocumentoActividadEstrategica {
    private Long idActividadEstrategica;
    private String rutaDocumento;
    public static DocumentoActividadEstrategica of( Long idActividadEstrategica, String rutaDocumento){
        ValidadorDominio.validarObligatorio(rutaDocumento,RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validarPatronURLEsValido(rutaDocumento,LA_URL_DEL_DOCUMENTO_DEBE_DE_SER_VALIDA);
        return new DocumentoActividadEstrategica(idActividadEstrategica,rutaDocumento);
    }

    public DocumentoActividadEstrategica(Long idActividadEstrategica, String rutaDocumento) {
        this.idActividadEstrategica = idActividadEstrategica;
        this.rutaDocumento = rutaDocumento;
    }
}
