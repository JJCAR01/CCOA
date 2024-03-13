package com.ccoa.planeacionestrategica.dominio.servicio.area;

import com.ccoa.planeacionestrategica.dominio.modelo.area.Area;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.YA_EXISTE_EL_AREA_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioGuardarArea {

    private final RepositorioArea repositorioArea;

    public ServicioGuardarArea(RepositorioArea repositorioArea) {
        this.repositorioArea = repositorioArea;
    }

    public Long ejecutarGuardar(Area area){

        if(this.repositorioArea.existe(area)) throw new ExcepcionValidadorInvalido(YA_EXISTE_EL_AREA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioArea.guardar(area);
    }
}
