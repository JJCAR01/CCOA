package com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.dto.proyectoarea.DtoObservacionProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.dto.proyectoarea.DtoProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.InformacionProyectoArea;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDuracionDias;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularTotalSprint;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioObtenerHoraActual;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MapeadorAplicacionInformacionProyectoArea implements MapeadorAplicacion<DtoProyectoArea, InformacionProyectoArea> {
    private final ServicioCalcularDuracionDias servicioCalcularDuracionDias;
    private final ServicioCalcularTotalSprint servicioCalcularTotalSprint;
    private final ServicioObtenerHoraActual servicioObtenerHoraActual;

    public MapeadorAplicacionInformacionProyectoArea(ServicioCalcularDuracionDias servicioCalcularDuracionDias,
                                                     ServicioCalcularTotalSprint servicioCalcularTotalSprint, ServicioObtenerHoraActual servicioObtenerHoraActual) {
        this.servicioCalcularDuracionDias = servicioCalcularDuracionDias;
        this.servicioCalcularTotalSprint = servicioCalcularTotalSprint;
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
    }

    @Override
    public InformacionProyectoArea mapeadorAplicacion(DtoProyectoArea dto) {
        Integer duracion = servicioCalcularDuracionDias.calcular(dto.getFechaInicial(),dto.getFechaFinal());
        return InformacionProyectoArea.of(dto.getFechaInicial(),dto.getFechaFinal(),servicioObtenerHoraActual.calcular(dto.getFechaRegistro()),
                dto.getPlaneacionSprint(),servicioCalcularTotalSprint.calcular(duracion, dto.getPlaneacionSprint()));
    }
}
