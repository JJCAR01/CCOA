package com.ccoa.planeacionestrategica.dominio.servicio.direccion;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioDireccion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorObligatorio;
import org.springframework.stereotype.Service;
;
import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_DIRECCION_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;
@Service
public class ServicioEliminarDireccion {

    private final RepositorioDireccion repositorioDireccion;

    public ServicioEliminarDireccion(RepositorioDireccion repositorioDireccion) {
        this.repositorioDireccion = repositorioDireccion;
    }
    public Long ejecutarEliminar(Long id){

        if(this.repositorioDireccion.consultarPorId(id)== null) throw new ExcepcionValidadorObligatorio(NO_EXISTE_LA_DIRECCION_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioDireccion.eliminar(id);
    }
}
