package com.ccoa.planeacionestrategica.dominio.servicio.sprint;

import com.ccoa.planeacionestrategica.dominio.modelo.sprint.InformacionSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.Sprint;
import com.ccoa.planeacionestrategica.dominio.puerto.sprint.RepositorioSprint;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_EL_SPRINT_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioModificarSprint {

    private final RepositorioSprint repositorioSprint;

    public ServicioModificarSprint(RepositorioSprint repositorioSprint) {
        this.repositorioSprint = repositorioSprint;
    }

    public Long ejecutarModificar(Sprint sprint, InformacionSprint informacionSprint, Long codigo){
        if(this.repositorioSprint.consultarPorId(codigo)==null) throw new ValorInvalidoExcepcion(NO_EXISTE_EL_SPRINT_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioSprint.modificar(sprint,informacionSprint , codigo);
    }
}
