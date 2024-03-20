package com.ccoa.planeacionestrategica.dominio.servicio.actividadgestion;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.ActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.documento.DocumentoActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.InformacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestion.RepositorioActividadGestion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

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
