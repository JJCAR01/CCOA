package com.ccoa.planeacionestrategica.dominio.servicio.sprint;

import com.ccoa.planeacionestrategica.dominio.modelo.sprint.InformacionSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.documento.DocumentoSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.Sprint;
import com.ccoa.planeacionestrategica.dominio.puerto.sprint.RepositorioSprint;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarSprint {
    private final RepositorioSprint repositorioSprint;

    public ServicioGuardarSprint(RepositorioSprint repositorioSprint) {
        this.repositorioSprint = repositorioSprint;
    }

    public Long ejecutarGuardar(Sprint sprint, InformacionSprint informacionSprint){
        return this.repositorioSprint.guardar(sprint, informacionSprint);
    }

    public Long ejecutarGuardarDocumento(DocumentoSprint documentoSprint,Long codigo){
        return this.repositorioSprint.guardarDocumento(documentoSprint,codigo);
    }

}
