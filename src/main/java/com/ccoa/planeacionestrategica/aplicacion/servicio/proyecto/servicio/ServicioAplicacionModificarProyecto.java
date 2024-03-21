package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoDocumentoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.mapeador.documento.MapeadorAplicacionDocumentoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.mapeador.MapeadorAplicacionInformacionProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.mapeador.MapeadorAplicacionProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.mapeador.MapeadorAplicacionDetalleProyecto;
import com.ccoa.planeacionestrategica.dominio.servicio.proyecto.ServicioModificarProyecto;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarProyecto {
    private final ServicioModificarProyecto servicioModificarProyecto;
    private final MapeadorAplicacionProyecto mapeadorAplicacionProyecto;
    private final MapeadorAplicacionInformacionProyecto mapeadorAplicacionInformacionProyecto;
    private final MapeadorAplicacionDetalleProyecto mapeadorAplicacionDetalleProyecto;
    private final MapeadorAplicacionDocumentoProyecto mapeadorAplicacionDocumentoProyecto;

    public ServicioAplicacionModificarProyecto(ServicioModificarProyecto servicioModificarProyecto, MapeadorAplicacionProyecto mapeadorAplicacionProyecto, MapeadorAplicacionInformacionProyecto mapeadorAplicacionInformacionProyecto, MapeadorAplicacionDetalleProyecto mapeadorAplicacionDetalleProyecto, MapeadorAplicacionDocumentoProyecto mapeadorAplicacionDocumentoProyecto) {
        this.servicioModificarProyecto = servicioModificarProyecto;
        this.mapeadorAplicacionProyecto = mapeadorAplicacionProyecto;
        this.mapeadorAplicacionInformacionProyecto = mapeadorAplicacionInformacionProyecto;
        this.mapeadorAplicacionDetalleProyecto = mapeadorAplicacionDetalleProyecto;
        this.mapeadorAplicacionDocumentoProyecto = mapeadorAplicacionDocumentoProyecto;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoProyecto dto, Long codigo){
        var proyecto = this.mapeadorAplicacionProyecto.mapeadorAplicacion(dto);
        var informacionProyecto = this.mapeadorAplicacionInformacionProyecto.mapeadorAplicacion(dto);
        var deatalleProyecto = this.mapeadorAplicacionDetalleProyecto.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarProyecto.ejecutarModificar(proyecto,informacionProyecto,deatalleProyecto,codigo));
    }
    public DtoRespuesta<Long> ejecutarModificarValorEjecutado(DtoProyecto dto, Long codigo){
        var proyecto = this.mapeadorAplicacionProyecto.mapeadorAplicacionValorEjecutado(dto);
        return new DtoRespuesta<>(this.servicioModificarProyecto.ejecutarModificarValorEjecutado(proyecto,codigo));
    }
    public DtoRespuesta<Long> modificarDocumento(DtoDocumentoProyecto dto, Long codigo){
        var documento = this.mapeadorAplicacionDocumentoProyecto.mapeadorAplicacionModificar(dto,codigo);
        return new DtoRespuesta<>(this.servicioModificarProyecto.modificarDocumento(documento,codigo));
    }

}
