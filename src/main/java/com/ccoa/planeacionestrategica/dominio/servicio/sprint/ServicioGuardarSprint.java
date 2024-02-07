package com.ccoa.planeacionestrategica.dominio.servicio.sprint;

import com.ccoa.planeacionestrategica.dominio.modelo.sprint.InformacionSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.documento.DocumentoSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.Sprint;
import com.ccoa.planeacionestrategica.dominio.puerto.sprint.RepositorioSprint;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.YA_EXISTE_EL_SPRINT_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.YA_EXISTE_UN_DOCUMENTO_RELACIONADO_CON_EL_SPRINT;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioGuardarSprint {
    private final RepositorioSprint repositorioSprint;

    public ServicioGuardarSprint(RepositorioSprint repositorioSprint) {
        this.repositorioSprint = repositorioSprint;
    }

    public Long ejecutarGuardar(Sprint sprint, InformacionSprint informacionSprint){
        if(this.repositorioSprint.existe(sprint)) throw new ValorInvalidoExcepcion(YA_EXISTE_EL_SPRINT_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioSprint.guardar(sprint, informacionSprint);
    }

    public Long ejecutarGuardarDocumento(DocumentoSprint documentoSprint,Long codigo){
        if(this.repositorioSprint.existeDocumento(documentoSprint)) throw new ValorInvalidoExcepcion(YA_EXISTE_UN_DOCUMENTO_RELACIONADO_CON_EL_SPRINT,MENSAJE_DEFECTO);
        return this.repositorioSprint.guardarDocumento(documentoSprint,codigo);
    }

}
