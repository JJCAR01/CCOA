package com.ccoa.planeacionestrategica.dominio.servicio.proyecto;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.DetalleProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.Proyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.documento.DocumentoProyecto;
import com.ccoa.planeacionestrategica.dominio.puerto.proyecto.RepositorioProyecto;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioGuardarProyecto {
    private final RepositorioProyecto repositorioProyecto;

    public ServicioGuardarProyecto(RepositorioProyecto repositorioProyecto) {
        this.repositorioProyecto = repositorioProyecto;
    }

    public Long ejecutarGuardar(Proyecto proyecto, InformacionProyecto informacionProyecto, DetalleProyecto detalleProyecto){
        if(this.repositorioProyecto.existe(proyecto)) throw new ExcepcionValidadorInvalido(YA_EXISTE_EL_PROYECTO_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioProyecto.guardar(proyecto,informacionProyecto,detalleProyecto);
    }
    public Long ejecutarGuardarDuplicado(Proyecto proyecto, InformacionProyecto informacionProyecto, DetalleProyecto detalleProyecto){
        return this.repositorioProyecto.guardar(proyecto,informacionProyecto,detalleProyecto);
    }
    public Long ejecutarGuardarDocumento(DocumentoProyecto documentoProyecto, Long codigo){
        return this.repositorioProyecto.guardarDocumento(documentoProyecto,codigo);
    }
}
