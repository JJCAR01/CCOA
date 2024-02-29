package com.ccoa.planeacionestrategica.dominio.servicio.tarea;

import com.ccoa.planeacionestrategica.dominio.modelo.tarea.InformacionTarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.Tarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.documento.DocumentoTarea;
import com.ccoa.planeacionestrategica.dominio.puerto.tarea.RepositorioTarea;
import org.springframework.stereotype.Service;


@Service
public class ServicioGuardarTarea {
    private final RepositorioTarea repositorioTarea;

    public ServicioGuardarTarea(RepositorioTarea repositorioTarea) {
        this.repositorioTarea = repositorioTarea;
    }

    public Long ejecutarGuardar(Tarea tarea, InformacionTarea informacionTarea){
        return this.repositorioTarea.guardar(tarea,informacionTarea);
    }
    public Long ejecutarGuardarDocumento(DocumentoTarea documentoTarea, Long codigo){
        return this.repositorioTarea.guardarDocumento(documentoTarea,codigo);
    }
}
