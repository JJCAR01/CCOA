package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadprincipal;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadprincipal.DtoActividadPrincipal;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadprincipal.ActividadPrincipal;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadprincipal.DatoActividadPrincipal;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadprincipal.DetalleActividadPrincipal;
import com.ccoa.planeacionestrategica.dominio.servicio.ServicioObtenerHoraActual;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadprincipal.ServicioGuardarActividadPrincipal;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarActividadPrincipal {

    private final ServicioGuardarActividadPrincipal servicioGuardarActividadPrincipal;
    private final ServicioObtenerHoraActual servicioObtenerHoraActual;

    public ServicioAplicacionGuardarActividadPrincipal(ServicioGuardarActividadPrincipal servicioGuardarActividadPrincipal, ServicioObtenerHoraActual servicioObtenerHoraActual) {
        this.servicioGuardarActividadPrincipal = servicioGuardarActividadPrincipal;
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
    }

    public DtoRespuesta<Long> ejecutar(DtoActividadPrincipal dto){

        ActividadPrincipal actividadPrincipal = ActividadPrincipal.of(dto.getIdActividadPrincipal(), dto.getNombre(), dto.getTipoActividad(), dto.getEntregable(),dto.getPresupuesto());

        DetalleActividadPrincipal detalleActividadPrincipal = DetalleActividadPrincipal.of(dto.getIdLineaEstrategica(), dto.getIdUsuario(),
                dto.getIdTipoGI());

        DatoActividadPrincipal datoActividadPrincipal = DatoActividadPrincipal.of(dto.getFechaInicio(),dto.getFechaFinal(),servicioObtenerHoraActual.ejecutar());

        return new DtoRespuesta<>(this.servicioGuardarActividadPrincipal.ejecutarGuardar(actividadPrincipal,detalleActividadPrincipal,datoActividadPrincipal));
    }
}
