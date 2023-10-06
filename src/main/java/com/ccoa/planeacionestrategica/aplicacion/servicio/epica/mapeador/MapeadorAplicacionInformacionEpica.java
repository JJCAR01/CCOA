package com.ccoa.planeacionestrategica.aplicacion.servicio.epica.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.epica.DtoInformacionEpica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.epica.InformacionEpica;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerDiasRestantes;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioObtenerDuracion;
import org.springframework.stereotype.Component;

@Component
public class MapeadorAplicacionInformacionEpica implements MapeadorAplicacion<DtoInformacionEpica, InformacionEpica> {
    private final ServicioObtenerDuracion servicioObtenerDuracion;
    private final ServicioObtenerDiasRestantes servicioObtenerDiasRestantes;

    public MapeadorAplicacionInformacionEpica(ServicioObtenerDuracion servicioObtenerDuracion, ServicioObtenerDiasRestantes servicioObtenerDiasRestantes) {
        this.servicioObtenerDuracion = servicioObtenerDuracion;
        this.servicioObtenerDiasRestantes = servicioObtenerDiasRestantes;
    }

    @Override
    public InformacionEpica mapeadorAplicacion(DtoInformacionEpica dto) {
        return new InformacionEpica(dto.getIdInformacionEpica(), dto.getDuracion(),dto.getDiasRestantes(),dto.getEstado(),
                dto.getAvance());
    }
}
