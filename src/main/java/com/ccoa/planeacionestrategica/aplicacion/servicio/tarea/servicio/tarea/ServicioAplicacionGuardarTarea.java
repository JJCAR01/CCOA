package com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.servicio.tarea;

import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoDocumentoTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.mapeador.documento.MapeadorAplicacionDocumentoTarea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.mapeador.MapeadorAplicacionInformacionTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.mapeador.MapeadorAplicacionTarea;
import com.ccoa.planeacionestrategica.dominio.servicio.tarea.ServicioGuardarTarea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarTarea {
    private final ServicioGuardarTarea servicioGuardarTarea;
    private final MapeadorAplicacionTarea mapeadorAplicacionTarea;
    private final MapeadorAplicacionInformacionTarea mapeadorAplicacionInformacionTarea;
    private final MapeadorAplicacionDocumentoTarea mapeadorAplicacionDocumentoTarea;

    public ServicioAplicacionGuardarTarea(ServicioGuardarTarea servicioGuardarTarea,
                                          MapeadorAplicacionTarea mapeadorAplicacionTarea,
                                          MapeadorAplicacionInformacionTarea mapeadorAplicacionInformacionTarea,
                                          MapeadorAplicacionDocumentoTarea mapeadorAplicacionDocumentoTarea) {
        this.servicioGuardarTarea = servicioGuardarTarea;
        this.mapeadorAplicacionTarea = mapeadorAplicacionTarea;
        this.mapeadorAplicacionInformacionTarea = mapeadorAplicacionInformacionTarea;
        this.mapeadorAplicacionDocumentoTarea = mapeadorAplicacionDocumentoTarea;
    }

    public DtoRespuesta<Long> ejecutar(DtoTarea dto){
        var tarea = this.mapeadorAplicacionTarea.mapeadorAplicacion(dto);
        var informacionTarea = this.mapeadorAplicacionInformacionTarea.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarTarea.ejecutarGuardar(tarea,informacionTarea));
    }
    public DtoRespuesta<Long> guardarDuplicado(DtoTarea dto,Long idActividadGestionEstrategica){
        var tarea = this.mapeadorAplicacionTarea.mapeadorAplicacionDuplicar(dto,idActividadGestionEstrategica);
        var informacionTarea = this.mapeadorAplicacionInformacionTarea.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarTarea.ejecutarGuardar(tarea,informacionTarea));
    }
    public DtoRespuesta<Long> guardarRutaArchivo(DtoDocumentoTarea dto, Long codigo){
        var docTarea = this.mapeadorAplicacionDocumentoTarea.mapeadorAplicacionCrear(dto,codigo);
        return new DtoRespuesta<>(this.servicioGuardarTarea.ejecutarGuardarDocumento(docTarea,codigo));
    }
}
