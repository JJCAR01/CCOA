package com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionestrategica;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.ActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.documento.DocumentoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.InformacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestionestrategica.RepositorioActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioGuardarActividadGestionEstrategica {
    private final RepositorioActividadGestionEstrategica repositorioActividadGestionEstrategica;

    public ServicioGuardarActividadGestionEstrategica(RepositorioActividadGestionEstrategica repositorioActividadGestionEstrategica) {
        this.repositorioActividadGestionEstrategica = repositorioActividadGestionEstrategica;
    }

    public Long ejecutarGuardar(ActividadGestionEstrategica actividadGestionEstrategica, InformacionActividadGestionEstrategica informacionActividadGestionEstrategica) {
        if(this.repositorioActividadGestionEstrategica.existe(actividadGestionEstrategica)) throw new ValorInvalidoExcepcion(YA_EXISTE_ACTIVIDAD_DE_GESTION_DE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioActividadGestionEstrategica.guardar(actividadGestionEstrategica,informacionActividadGestionEstrategica);
    }
    public Long ejecutarGuardarDocumento(DocumentoActividadGestionEstrategica documentoActividadGestionEstrategica, Long codigo){
        if(this.repositorioActividadGestionEstrategica.existeDocumento(documentoActividadGestionEstrategica)) throw new ValorInvalidoExcepcion(YA_EXISTE_UN_DOCUMENTO_RELACIONADO_CON_LA_ACTIVIDAD_DE_GESTION_DE_LA_ACTIVIDAD_ESTRATEGICA,MENSAJE_DEFECTO);
        return this.repositorioActividadGestionEstrategica.guardarDocumento(documentoActividadGestionEstrategica,codigo);
    }
}
