package com.ccoa.planeacionestrategica.dominio.servicio.actividadgestion;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.ActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.documento.DocumentoActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.InformacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestion.RepositorioActividadGestion;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarActividadGestion {
    private final RepositorioActividadGestion repositorioActividadGestion;
    public ServicioGuardarActividadGestion(RepositorioActividadGestion repositorioActividadGestion) {
        this.repositorioActividadGestion = repositorioActividadGestion;
    }
    public Long ejecutarGuardar(ActividadGestion actividadGestion, InformacionActividadGestion informacionActividadGestion) {
        return this.repositorioActividadGestion.guardar(actividadGestion,informacionActividadGestion);
    }
    public Long ejecutarGuardarDocumento(DocumentoActividadGestion documentoActividadGestion, Long codigo){
        return this.repositorioActividadGestion.guardarDocumento(documentoActividadGestion,codigo);
    }

}
