package com.ccoa.planeacionestrategica.dominio.servicio.direccion;

import com.ccoa.planeacionestrategica.dominio.modelo.direccion.Direccion;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioDireccion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.YA_EXISTE_LA_DIRECCION_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;
@Service
public class ServicioGuardarDireccion {
    private final RepositorioDireccion repositorioDireccion;

    public ServicioGuardarDireccion(RepositorioDireccion repositorioDireccion) {
        this.repositorioDireccion = repositorioDireccion;
    }

    public Long ejecutarGuardar(Direccion direccion)  {

        if(this.repositorioDireccion.existe(direccion)) throw new ValorInvalidoExcepcion(YA_EXISTE_LA_DIRECCION_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioDireccion.guardar(direccion);
    }
}
