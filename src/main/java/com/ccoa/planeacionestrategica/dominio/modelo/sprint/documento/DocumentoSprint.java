package com.ccoa.planeacionestrategica.dominio.modelo.sprint.documento;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;
import lombok.Setter;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.LA_URL_DEL_DOCUMENTO_DEBE_DE_SER_VALIDA;
import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO;
@Getter
@Setter
public class DocumentoSprint {
    private final Long idRutaArchivo;
    private final String rutaArchivo;
    public static DocumentoSprint of(Long idRutaArchivo, String rutaArchivo){
        ValidadorDominio.validarObligatorio(rutaArchivo,RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validarPatronURLEsValido(rutaArchivo,LA_URL_DEL_DOCUMENTO_DEBE_DE_SER_VALIDA);
        return new DocumentoSprint(idRutaArchivo,rutaArchivo);
    }

    public DocumentoSprint(Long idRutaArchivo, String rutaArchivo) {
        this.idRutaArchivo = idRutaArchivo;
        this.rutaArchivo = rutaArchivo;
    }
}
