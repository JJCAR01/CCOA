package com.ccoa.planeacionestrategica.aplicacion.servicio.direccion.servicio;

import com.ccoa.planeacionestrategica.dominio.modelo.direccion.Direccion;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioDireccion;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ServicioAplicacionListarDireccion {

    private final RepositorioDireccion repositorioDireccion;

    public ServicioAplicacionListarDireccion(RepositorioDireccion repositorioDireccion) {
        this.repositorioDireccion = repositorioDireccion;
    }

    public List<Direccion> ejecutar(){return this.repositorioDireccion.listar();}

    public Direccion consultarById(Long id){return this.repositorioDireccion.consultarPorId(id);}
}
