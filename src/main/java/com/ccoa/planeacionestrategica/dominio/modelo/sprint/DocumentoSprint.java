package com.ccoa.planeacionestrategica.dominio.modelo.sprint;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;
import lombok.Setter;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO;
@Getter
@Setter
public class DocumentoSprint {
    private final Long idRutaArchivo;
    private final String rutaArchivo;
    public static DocumentoSprint of(Long idRutaArchivo, String rutaArchivo){
        ValidadorDominio.validarObligatorio(rutaArchivo,RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO);
        return new DocumentoSprint(idRutaArchivo,rutaArchivo);
    }

    public DocumentoSprint(Long idRutaArchivo, String rutaArchivo) {
        this.idRutaArchivo = idRutaArchivo;
        this.rutaArchivo = rutaArchivo;
    }
}
