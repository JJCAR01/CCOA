package com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionactividadestrategica;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.ActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.InformacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.YA_EXISTE_ACTIVIDAD_DE_GESTION_DE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioGuardarActividadGestionActividadEstrategica {
    private final RepositorioActividadGestionActividadEstrategica repositorioActividadGestionActividadEstrategica;

    public ServicioGuardarActividadGestionActividadEstrategica(RepositorioActividadGestionActividadEstrategica repositorioActividadGestionActividadEstrategica) {
        this.repositorioActividadGestionActividadEstrategica = repositorioActividadGestionActividadEstrategica;
    }

    public Long ejecutarGuardar(ActividadGestionActividadEstrategica actividadGestionActividadEstrategica, InformacionActividadGestionActividadEstrategica informacionActividadGestionActividadEstrategica) {
        if(this.repositorioActividadGestionActividadEstrategica.existe(actividadGestionActividadEstrategica)) throw new ValorInvalidoExcepcion(YA_EXISTE_ACTIVIDAD_DE_GESTION_DE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioActividadGestionActividadEstrategica.guardar(actividadGestionActividadEstrategica,informacionActividadGestionActividadEstrategica);
    }

}