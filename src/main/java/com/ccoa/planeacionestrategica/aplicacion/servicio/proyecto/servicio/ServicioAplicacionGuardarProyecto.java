package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoDocumentoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.mapeador.MapeadorAplicacionInformacionProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.mapeador.MapeadorAplicacionProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.mapeador.MapeadorAplicacionDetalleProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.mapeador.documento.MapeadorAplicacionDocumentoProyecto;
import com.ccoa.planeacionestrategica.dominio.servicio.proyecto.ServicioGuardarProyecto;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioCambiarFecha;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarProyecto {
    private final ServicioGuardarProyecto servicioGuardarProyecto;
    private final MapeadorAplicacionProyecto mapeadorAplicacionProyecto;
    private final MapeadorAplicacionInformacionProyecto mapeadorAplicacionInformacionProyecto;
    private final MapeadorAplicacionDetalleProyecto mapeadorAplicacionDetalleProyecto;
    private final MapeadorAplicacionDocumentoProyecto mapeadorAplicacionDocumentoProyecto;
    private final ServicioCambiarFecha servicioCambiarFecha;

    public ServicioAplicacionGuardarProyecto(ServicioGuardarProyecto servicioGuardarProyecto, MapeadorAplicacionProyecto mapeadorAplicacionProyecto,
                                             MapeadorAplicacionInformacionProyecto mapeadorAplicacionInformacionProyecto, MapeadorAplicacionDetalleProyecto mapeadorAplicacionDetalleProyecto, MapeadorAplicacionDocumentoProyecto mapeadorAplicacionDocumentoProyecto, ServicioCambiarFecha servicioCambiarFecha) {
        this.servicioGuardarProyecto = servicioGuardarProyecto;
        this.mapeadorAplicacionProyecto = mapeadorAplicacionProyecto;
        this.mapeadorAplicacionInformacionProyecto = mapeadorAplicacionInformacionProyecto;
        this.mapeadorAplicacionDetalleProyecto = mapeadorAplicacionDetalleProyecto;
        this.mapeadorAplicacionDocumentoProyecto = mapeadorAplicacionDocumentoProyecto;
        this.servicioCambiarFecha = servicioCambiarFecha;
    }

    public DtoRespuesta<Long> ejecutar(DtoProyecto dto){
        var proyecto = this.mapeadorAplicacionProyecto.mapeadorAplicacion(dto);
        var informacionProyecto = this.mapeadorAplicacionInformacionProyecto.mapeadorAplicacion(dto);
        var detalleProyecto = this.mapeadorAplicacionDetalleProyecto.mapeadorAplicacion(dto);

        return new DtoRespuesta<>(this.servicioGuardarProyecto.ejecutarGuardar(proyecto,informacionProyecto,detalleProyecto));
    }
    public DtoRespuesta<Long> guardarDuplicado(DtoProyecto dto,Long idActividadEstrategica,Integer fechaAnual){
        var fechaInicial = servicioCambiarFecha.calcular(dto.getFechaInicial(),fechaAnual);
        var fechaFinal = servicioCambiarFecha.calcular(dto.getFechaFinal(),fechaAnual);

        var proyecto = this.mapeadorAplicacionProyecto.mapeadorAplicacionDuplicar(dto,idActividadEstrategica);
        var informacionProyecto = this.mapeadorAplicacionInformacionProyecto.mapeadorAplicacionDuplicar(dto,fechaInicial,fechaFinal);
        var detalleProyecto = this.mapeadorAplicacionDetalleProyecto.mapeadorAplicacionDuplicar(fechaInicial,fechaFinal);

        return new DtoRespuesta<>(this.servicioGuardarProyecto.ejecutarGuardarDuplicado(proyecto,informacionProyecto,detalleProyecto));
    }
    public DtoRespuesta<Long> guardarRutaArchivo(DtoDocumentoProyecto dto, Long codigo){
        var documento = this.mapeadorAplicacionDocumentoProyecto.mapeadorAplicacionCrear(dto,codigo);
        return new DtoRespuesta<>(this.servicioGuardarProyecto.ejecutarGuardarDocumento(documento,codigo));
    }
}
