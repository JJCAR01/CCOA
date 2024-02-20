package com.ccoa.planeacionestrategica.dominio.servicio.proyectoarea;

import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.DetalleProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.InformacionProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.ProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.documento.DocumentoProyectoArea;
import com.ccoa.planeacionestrategica.dominio.puerto.proyectoarea.RepositorioProyectoArea;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioGuardarProyectoArea {
    private final RepositorioProyectoArea repositorioProyectoArea;

    public ServicioGuardarProyectoArea(RepositorioProyectoArea repositorioProyectoArea) {
        this.repositorioProyectoArea = repositorioProyectoArea;
    }

    public Long ejecutarGuardar(ProyectoArea proyectoArea, InformacionProyectoArea informacionProyectoArea, DetalleProyectoArea detalleProyectoArea){
        if(this.repositorioProyectoArea.existe(proyectoArea)) throw new ValorInvalidoExcepcion(YA_EXISTE_EL_PROYECTO_DEL_AREA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioProyectoArea.guardar(proyectoArea,informacionProyectoArea,detalleProyectoArea);
    }
    public Long ejecutarGuardarDocumento(DocumentoProyectoArea documentoProyectoArea, Long codigo){
        return this.repositorioProyectoArea.guardarDocumento(documentoProyectoArea,codigo);
    }
}
