package com.ccoa.planeacionestrategica.dominio.servicio.sprint;

import com.ccoa.planeacionestrategica.dominio.puerto.sprint.RepositorioSprint;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_EL_SPRINT_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarSprint {

    private final RepositorioSprint repositorioSprint;

    public ServicioEliminarSprint(RepositorioSprint repositorioSprint) {
        this.repositorioSprint = repositorioSprint;
    }

    public Long ejecutarEliminar(Long id){
        if(this.repositorioSprint.consultarPorId(id)== null) throw new ValorObligatorioExcepcion(NO_EXISTE_EL_SPRINT_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioSprint.eliminar(id);
    }
}
