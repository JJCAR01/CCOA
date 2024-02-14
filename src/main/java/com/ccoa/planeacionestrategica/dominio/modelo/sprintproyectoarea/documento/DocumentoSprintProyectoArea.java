package com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.documento;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.LA_URL_DEL_DOCUMENTO_DEBE_DE_SER_VALIDA;
import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO;

@Data
public class DocumentoSprintProyectoArea {
    private final Long idRutaDocumentoSprintProyectoArea;
    private final String rutaArchivo;
    public static DocumentoSprintProyectoArea of(Long idRutaDocumentoSprintProyectoArea, String rutaArchivo){
        ValidadorDominio.validarObligatorio(rutaArchivo,RUTA_ARCHIVO_DEL_DOCUMENTO_NO_PUEDE_ESTAR_VACIO);
        ValidadorDominio.validarPatronURLEsValido(rutaArchivo,LA_URL_DEL_DOCUMENTO_DEBE_DE_SER_VALIDA);
        return new DocumentoSprintProyectoArea(idRutaDocumentoSprintProyectoArea,rutaArchivo);
    }

    public DocumentoSprintProyectoArea(Long idRutaDocumentoSprintProyectoArea, String rutaArchivo) {
        this.idRutaDocumentoSprintProyectoArea = idRutaDocumentoSprintProyectoArea;
        this.rutaArchivo = rutaArchivo;
    }
}
