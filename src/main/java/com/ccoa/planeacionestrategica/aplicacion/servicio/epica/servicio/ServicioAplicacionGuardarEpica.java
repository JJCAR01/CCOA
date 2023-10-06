package com.ccoa.planeacionestrategica.aplicacion.servicio.epica.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.epica.DtoEpica;
import com.ccoa.planeacionestrategica.aplicacion.dto.epica.DtoInformacionEpica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.epica.mapeador.MapeadorAplicacionEpica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.epica.mapeador.MapeadorAplicacionInformacionEpica;
import com.ccoa.planeacionestrategica.dominio.servicio.epica.ServicioGuardarEpica;
import org.springframework.stereotype.Component;
@Component
public class ServicioAplicacionGuardarEpica {

    private final ServicioGuardarEpica servicioGuardarEpica;
    private final MapeadorAplicacionEpica mapeadorAplicacionEpica;
    private final MapeadorAplicacionInformacionEpica mapeadorAplicacionInformacionEpica;

    public ServicioAplicacionGuardarEpica(ServicioGuardarEpica servicioGuardarEpica, MapeadorAplicacionEpica mapeadorAplicacionEpica, MapeadorAplicacionInformacionEpica mapeadorAplicacionInformacionEpica) {
        this.servicioGuardarEpica = servicioGuardarEpica;
        this.mapeadorAplicacionEpica = mapeadorAplicacionEpica;
        this.mapeadorAplicacionInformacionEpica = mapeadorAplicacionInformacionEpica;
    }


    public DtoRespuesta<Long> ejecutar(DtoEpica dto, DtoInformacionEpica dtoInfo){
        var epica = this.mapeadorAplicacionEpica.mapeadorAplicacion(dto);
        var informacionEpica = this.mapeadorAplicacionInformacionEpica.mapeadorAplicacion(dtoInfo);

        return new DtoRespuesta<>(this.servicioGuardarEpica.ejecutarGuardar(epica,informacionEpica));
    }
}
