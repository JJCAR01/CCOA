package com.ccoa.planeacionestrategica.dominio.servicio.actividad;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividad;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarActividad {
    private static final String MENSAJE_YA_EXISTE = "No existe la Actividad con los datos ingresados";
    private final RepositorioActividad repositorioActividad;
    public ServicioEliminarActividad(RepositorioActividad repositorioActividad) {
        this.repositorioActividad = repositorioActividad;
    }
    public Long ejecutarEliminar(Long id){

        if(this.repositorioActividad.consultarPorId(id)== null) throw new ValorObligatorioExcepcion(MENSAJE_YA_EXISTE,MENSAJE_DEFECTO);

        return this.repositorioActividad.eliminar(id);
    }
}
