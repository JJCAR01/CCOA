package com.ccoa.planeacionestrategica.dominio.servicio.proyecto;

import com.ccoa.planeacionestrategica.dominio.puerto.proyecto.RepositorioProyecto;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_EL_PROYECTO_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarProyecto {
    private final RepositorioProyecto repositorioProyecto;

    public ServicioEliminarProyecto(RepositorioProyecto repositorioProyecto) {
        this.repositorioProyecto = repositorioProyecto;
    }

    public Long ejecutarEliminar(Long id){
        if(this.repositorioProyecto.consultarPorId(id)== null) throw new ValorObligatorioExcepcion(NO_EXISTE_EL_PROYECTO_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioProyecto.eliminar(id);
    }
    public Long ejecutarEliminarPorActividadEstrategica(Long id){
        if(this.repositorioProyecto.consultarPorIdActividadEstrategicaAEliminar(id)== null) throw new ValorObligatorioExcepcion(NO_EXISTE_EL_PROYECTO_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioProyecto.eliminarPorActividadEstrategica(id);
    }
}
