package com.ccoa.planeacionestrategica.aplicacion.servicio.epica.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.epica.DtoEpica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.epica.Epica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioObtenerHoraActual;
import org.springframework.stereotype.Component;

@Component
public class MapeadorAplicacionEpica implements MapeadorAplicacion<DtoEpica, Epica> {
    private final ServicioObtenerHoraActual servicioObtenerHoraActual;
    public MapeadorAplicacionEpica(ServicioObtenerHoraActual servicioObtenerHoraActual) {
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
    }
    @Override
    public Epica mapeadorAplicacion(DtoEpica dto) {
        return new Epica(dto.getIdEpica(), dto.getNombre(), dto.getFechaInicial(),dto.getFechaFinal(),servicioObtenerHoraActual.ejecutar(dto.getFechaRegistro()),
                dto.getIdInformacionEpica());
    }
}
