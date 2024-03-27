package com.ccoa.planeacionestrategica.dominio.servicio.tarea;

import com.ccoa.planeacionestrategica.dominio.modelo.tarea.InformacionTarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.Tarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.documento.DocumentoTarea;
import com.ccoa.planeacionestrategica.dominio.puerto.tarea.RepositorioTarea;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_TAREA_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioModificarTarea {
    private final RepositorioTarea repositorioTarea;

    public ServicioModificarTarea(RepositorioTarea repositorioTarea) {
        this.repositorioTarea = repositorioTarea;
    }

    public Long ejecutarModificar(Tarea tarea, InformacionTarea  informacionTarea,Long codigo){
        if(this.repositorioTarea.consultarPorId(codigo)==null) throw new ExcepcionValidadorInvalido(NO_EXISTE_LA_TAREA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioTarea.modificar(tarea,informacionTarea,codigo);
    }
    public Long modificarEstado(Tarea tarea, InformacionTarea  informacionTarea,Long codigo){
        if(this.repositorioTarea.consultarPorId(codigo)==null) throw new ExcepcionValidadorInvalido(NO_EXISTE_LA_TAREA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioTarea.modificarEstado(tarea,informacionTarea,codigo);
    }

    public Long modificarPorcentaje(Tarea tarea, InformacionTarea  informacionTarea,Long codigo){
        if(this.repositorioTarea.consultarPorId(codigo)==null) throw new ExcepcionValidadorInvalido(NO_EXISTE_LA_TAREA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioTarea.modificarPorcentaje(tarea,informacionTarea,codigo);
    }
    public Long modificarDocumento(DocumentoTarea documentoTarea, Long codigo){
        return this.repositorioTarea.modificarDocumento(documentoTarea, codigo);
    }
}
