package com.ccoa.planeacionestrategica.dominio.servicio.area;

import com.ccoa.planeacionestrategica.dominio.modelo.area.Area;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_EL_AREA_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioModificarArea {

    private final RepositorioArea repositorioArea;

    public ServicioModificarArea(RepositorioArea repositorioArea) {
        this.repositorioArea = repositorioArea;
    }

    public Long ejecutarModificar(Area area, Long codigo){

        if(this.repositorioArea.consultarPorId(codigo)==null) throw new ExcepcionValidadorInvalido(NO_EXISTE_EL_AREA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioArea.modificar(area,codigo);
    }
}
