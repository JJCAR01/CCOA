package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.adaptador.MapeadorAplicacionInformacionProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.adaptador.MapeadorAplicacionProyecto;
import com.ccoa.planeacionestrategica.dominio.servicio.proyecto.ServicioGuardarProyecto;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarProyecto {
    private final ServicioGuardarProyecto servicioGuardarProyecto;
    private final MapeadorAplicacionProyecto mapeadorAplicacionProyecto;
    private final MapeadorAplicacionInformacionProyecto mapeadorAplicacionInformacionProyecto;

    public ServicioAplicacionGuardarProyecto(ServicioGuardarProyecto servicioGuardarProyecto, MapeadorAplicacionProyecto mapeadorAplicacionProyecto,
                                             MapeadorAplicacionInformacionProyecto mapeadorAplicacionInformacionProyecto) {
        this.servicioGuardarProyecto = servicioGuardarProyecto;
        this.mapeadorAplicacionProyecto = mapeadorAplicacionProyecto;
        this.mapeadorAplicacionInformacionProyecto = mapeadorAplicacionInformacionProyecto;
    }

    public DtoRespuesta<Long> ejecutar(DtoProyecto dto){
        var proyecto = this.mapeadorAplicacionProyecto.mapeadorAplicacion(dto);
        var informacionProyecto = this.mapeadorAplicacionInformacionProyecto.mapeadorAplicacion(dto);

        return new DtoRespuesta<>(this.servicioGuardarProyecto.ejecutarGuardar(proyecto,informacionProyecto));
    }
}
