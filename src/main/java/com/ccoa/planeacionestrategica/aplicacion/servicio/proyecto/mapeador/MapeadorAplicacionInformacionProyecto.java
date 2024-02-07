package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDuracionDias;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularTotalSprint;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MapeadorAplicacionInformacionProyecto implements MapeadorAplicacion<DtoProyecto, InformacionProyecto> {
    private final ServicioCalcularDuracionDias servicioCalcularDuracionDias;
    private final ServicioCalcularTotalSprint servicioCalcularTotalSprint;

    public MapeadorAplicacionInformacionProyecto(ServicioCalcularDuracionDias servicioCalcularDuracionDias,
                                                 ServicioCalcularTotalSprint servicioCalcularTotalSprint) {
        this.servicioCalcularDuracionDias = servicioCalcularDuracionDias;
        this.servicioCalcularTotalSprint = servicioCalcularTotalSprint;
    }

    @Override
    public InformacionProyecto mapeadorAplicacion(DtoProyecto dto) {
        Integer duracion = servicioCalcularDuracionDias.calcular(dto.getFechaInicial(),dto.getFechaFinal());
        return InformacionProyecto.of(dto.getIdProyecto(), dto.getFechaInicial(),dto.getFechaFinal(),
                duracion,dto.getPlaneacionSprint(),
                servicioCalcularTotalSprint.calcular(duracion, dto.getPlaneacionSprint()));
    }
}
