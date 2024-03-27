package com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionestrategica;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.ActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.InformacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.documento.DocumentoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestionestrategica.RepositorioActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_ACTIVIDAD_DE_GESTION_DE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;
@Service
public class ServicioModificarActividadGestionEstrategica {

    private final RepositorioActividadGestionEstrategica repositorioActividadGestionEstrategica;

    public ServicioModificarActividadGestionEstrategica(RepositorioActividadGestionEstrategica repositorioActividadGestionEstrategica) {
        this.repositorioActividadGestionEstrategica = repositorioActividadGestionEstrategica;
    }

    public Long ejecutarModificar(ActividadGestionEstrategica actividadGestionEstrategica,
                                  InformacionActividadGestionEstrategica informacionActividadGestionEstrategica, Long codigo){

        if(this.repositorioActividadGestionEstrategica.consultarPorId(codigo)==null) throw new ExcepcionValidadorInvalido(NO_EXISTE_ACTIVIDAD_DE_GESTION_DE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioActividadGestionEstrategica.modificar(actividadGestionEstrategica,informacionActividadGestionEstrategica , codigo);
    }
    public Long modificarDocumento(DocumentoActividadGestionEstrategica documentoActividadGestionEstrategica, Long codigo){
        return this.repositorioActividadGestionEstrategica.modificarDocumento(documentoActividadGestionEstrategica, codigo);
    }
}
