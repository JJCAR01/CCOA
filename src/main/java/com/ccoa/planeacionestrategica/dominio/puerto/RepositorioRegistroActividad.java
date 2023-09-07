package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.modelo.registroactividad.Documento;
import com.ccoa.planeacionestrategica.dominio.modelo.registroactividad.RegistroActividad;

import java.util.List;

public interface RepositorioRegistroActividad {

    Long guardarDocumento(Documento documento, Long idRegistroActividad);
    List<RegistroActividad> listar();
    RegistroActividad consultarPorId(Long id);
    Long guardar(RegistroActividad registroActividad );
    boolean existe(RegistroActividad registroActividad );
    Long eliminar(Long id);
    Long modificar(RegistroActividad registroActividad, Long id);

}
