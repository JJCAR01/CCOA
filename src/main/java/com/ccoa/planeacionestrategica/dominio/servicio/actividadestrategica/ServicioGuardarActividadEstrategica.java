package com.ccoa.planeacionestrategica.dominio.servicio.actividadestrategica;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.ActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.DetalleActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.InformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.documento.DocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadestrategica.RepositorioActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioGuardarActividadEstrategica {

    private final RepositorioActividadEstrategica repositorioActividadEstrategica;

    public ServicioGuardarActividadEstrategica(RepositorioActividadEstrategica repositorioActividadEstrategica) {
        this.repositorioActividadEstrategica = repositorioActividadEstrategica;
    }

    public Long ejecutarGuardar(ActividadEstrategica actividadEstrategica, InformacionActividadEstrategica informacionActividadEstrategica,
                                DetalleActividadEstrategica detalleActividadEstrategica){
        if(this.repositorioActividadEstrategica.existe(actividadEstrategica)) throw new ExcepcionValidadorInvalido(YA_EXISTE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioActividadEstrategica.guardar(actividadEstrategica,informacionActividadEstrategica, detalleActividadEstrategica);
    }
    public Long ejecutarGuardarDuplicado(ActividadEstrategica actividadEstrategica, InformacionActividadEstrategica informacionActividadEstrategica,
                                DetalleActividadEstrategica detalleActividadEstrategica){
        return this.repositorioActividadEstrategica.guardar(actividadEstrategica,informacionActividadEstrategica, detalleActividadEstrategica);
    }
    public Long ejecutarGuardarDocumento(DocumentoActividadEstrategica documentoActividadEstrategica, Long codigo){
        return this.repositorioActividadEstrategica.guardarDocumento(documentoActividadEstrategica,codigo);
    }


}
