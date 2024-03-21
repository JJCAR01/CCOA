package com.ccoa.planeacionestrategica.dominio.servicio.proyectoarea;

import com.ccoa.planeacionestrategica.dominio.puerto.proyectoarea.RepositorioProyectoArea;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorObligatorio;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarProyectoArea {
    private final RepositorioProyectoArea repositorioProyectoArea;

    public ServicioEliminarProyectoArea(RepositorioProyectoArea repositorioProyectoArea) {
        this.repositorioProyectoArea = repositorioProyectoArea;
    }
    public Long ejecutarEliminar(Long id){
        if(this.repositorioProyectoArea.consultarPorId(id)== null) throw new ExcepcionValidadorObligatorio(NO_EXISTE_EL_PROYECTO_DEL_AREA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioProyectoArea.eliminar(id);
    }
    public Long ejecutarEliminarPorPat(Long id){
        if(this.repositorioProyectoArea.consultarPorIdPat(id)== null) throw new ExcepcionValidadorObligatorio(NO_EXISTE_EL_PROYECTO_DEL_AREA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioProyectoArea.eliminarPorPat(id);
    }
    public Long eliminarDocumento(Long id){
        if(this.repositorioProyectoArea.consultarPorId(id)== null) throw new ExcepcionValidadorInvalido(NO_EXISTE_EL_DOCUMENTO_RELACIONADO_CON_EL_PROYECTO_DEL_AREA,MENSAJE_DEFECTO);
        return this.repositorioProyectoArea.eliminarDocumento(id);
    }
}
