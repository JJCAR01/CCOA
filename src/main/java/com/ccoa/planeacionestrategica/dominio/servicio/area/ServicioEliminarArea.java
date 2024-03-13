package com.ccoa.planeacionestrategica.dominio.servicio.area;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorObligatorio;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_EL_AREA_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarArea {

    private final RepositorioArea repositorioArea;

    public ServicioEliminarArea(RepositorioArea repositorioArea) {
        this.repositorioArea = repositorioArea;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioArea.consultarPorId(id)== null) throw new ExcepcionValidadorObligatorio(NO_EXISTE_EL_AREA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioArea.eliminar(id);
    }
}
