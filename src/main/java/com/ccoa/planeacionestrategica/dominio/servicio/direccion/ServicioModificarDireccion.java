package com.ccoa.planeacionestrategica.dominio.servicio.direccion;

import com.ccoa.planeacionestrategica.dominio.modelo.direccion.Direccion;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioDireccion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_DIRECCION_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;
@Service
public class ServicioModificarDireccion {

    private final RepositorioDireccion repositorioDireccion;

    public ServicioModificarDireccion(RepositorioDireccion repositorioDireccion) {
        this.repositorioDireccion = repositorioDireccion;
    }
    public Long ejecutarModificar(Direccion direccion, Long codigo){

        if(this.repositorioDireccion.consultarPorId(codigo)==null) throw new ExcepcionValidadorInvalido(NO_EXISTE_LA_DIRECCION_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioDireccion.modificar(direccion,codigo);
    }
}
