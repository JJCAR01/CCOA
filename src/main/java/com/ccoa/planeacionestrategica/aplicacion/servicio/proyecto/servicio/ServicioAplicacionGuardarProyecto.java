package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoDocumentoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.mapeador.MapeadorAplicacionInformacionProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.mapeador.MapeadorAplicacionProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.mapeador.MapeadorAplicacionDetalleProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.mapeador.documento.MapeadorAplicacionDocumentoProyecto;
import com.ccoa.planeacionestrategica.dominio.servicio.proyecto.ServicioGuardarProyecto;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarProyecto {
    private final ServicioGuardarProyecto servicioGuardarProyecto;
    private final MapeadorAplicacionProyecto mapeadorAplicacionProyecto;
    private final MapeadorAplicacionInformacionProyecto mapeadorAplicacionInformacionProyecto;
    private final MapeadorAplicacionDetalleProyecto mapeadorAplicacionDetalleProyecto;
    private final MapeadorAplicacionDocumentoProyecto mapeadorAplicacionDocumentoProyecto;

    public ServicioAplicacionGuardarProyecto(ServicioGuardarProyecto servicioGuardarProyecto, MapeadorAplicacionProyecto mapeadorAplicacionProyecto,
                                             MapeadorAplicacionInformacionProyecto mapeadorAplicacionInformacionProyecto, MapeadorAplicacionDetalleProyecto mapeadorAplicacionDetalleProyecto, MapeadorAplicacionDocumentoProyecto mapeadorAplicacionDocumentoProyecto) {
        this.servicioGuardarProyecto = servicioGuardarProyecto;
        this.mapeadorAplicacionProyecto = mapeadorAplicacionProyecto;
        this.mapeadorAplicacionInformacionProyecto = mapeadorAplicacionInformacionProyecto;
        this.mapeadorAplicacionDetalleProyecto = mapeadorAplicacionDetalleProyecto;
        this.mapeadorAplicacionDocumentoProyecto = mapeadorAplicacionDocumentoProyecto;
    }

    public DtoRespuesta<Long> ejecutar(DtoProyecto dto){
        var proyecto = this.mapeadorAplicacionProyecto.mapeadorAplicacion(dto);
        var informacionProyecto = this.mapeadorAplicacionInformacionProyecto.mapeadorAplicacion(dto);
        var detalleProyecto = this.mapeadorAplicacionDetalleProyecto.mapeadorAplicacion(dto);

        return new DtoRespuesta<>(this.servicioGuardarProyecto.ejecutarGuardar(proyecto,informacionProyecto,detalleProyecto));
    }
    public DtoRespuesta<Long> guardarRutaArchivo(DtoDocumentoProyecto dto, Long codigo){
        var documento = this.mapeadorAplicacionDocumentoProyecto.mapeadorAplicacionCrear(dto,codigo);
        return new DtoRespuesta<>(this.servicioGuardarProyecto.ejecutarGuardarDocumento(documento,codigo));
    }
}
