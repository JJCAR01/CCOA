package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.InformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerDiasRestantes;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerDuracion;
import org.springframework.stereotype.Component;

@Component
public class MapeadorAplicacionInformacionActividadEstrategica implements MapeadorAplicacion<DtoActividadEstrategica, InformacionActividadEstrategica> {
    private final ServicioObtenerDuracion servicioObtenerDuracion;
    private final ServicioObtenerDiasRestantes servicioObtenerDiasRestantes;

    public MapeadorAplicacionInformacionActividadEstrategica(ServicioObtenerDuracion servicioObtenerDuracion, ServicioObtenerDiasRestantes servicioObtenerDiasRestantes) {
        this.servicioObtenerDuracion = servicioObtenerDuracion;
        this.servicioObtenerDiasRestantes = servicioObtenerDiasRestantes;
    }

    @Override
    public InformacionActividadEstrategica mapeadorAplicacion(DtoActividadEstrategica dto) {
        return new InformacionActividadEstrategica(servicioObtenerDuracion.ejecutar(dto.getFechaInicial(),dto.getFechaFinal()),
                servicioObtenerDiasRestantes.ejecutar(dto.getFechaInicial(),dto.getFechaFinal()),dto.getEstado(),
                dto.getAvance(), dto.getIdPat(), dto.getIdUsuario());
    }
}
