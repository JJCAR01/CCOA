package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDuracionDias;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularTotalSprint;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioObtenerHoraActual;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;


@Configuration
public class MapeadorAplicacionInformacionProyecto implements MapeadorAplicacion<DtoProyecto, InformacionProyecto> {
    private final ServicioCalcularDuracionDias servicioCalcularDuracionDias;
    private final ServicioCalcularTotalSprint servicioCalcularTotalSprint;
    private final ServicioObtenerHoraActual servicioObtenerHoraActual;

    public MapeadorAplicacionInformacionProyecto(ServicioCalcularDuracionDias servicioCalcularDuracionDias,
                                                 ServicioCalcularTotalSprint servicioCalcularTotalSprint, ServicioObtenerHoraActual servicioObtenerHoraActual) {
        this.servicioCalcularDuracionDias = servicioCalcularDuracionDias;
        this.servicioCalcularTotalSprint = servicioCalcularTotalSprint;
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
    }

    @Override
    public InformacionProyecto mapeadorAplicacion(DtoProyecto dto) {
        var duracion = servicioCalcularDuracionDias.calcular(dto.getFechaInicial(),dto.getFechaFinal());
        var totalSprint = servicioCalcularTotalSprint.calcular(duracion, dto.getPlaneacionSprint());

        return InformacionProyecto.of(dto.getFechaInicial(),dto.getFechaFinal(),
                servicioObtenerHoraActual.calcular(dto.getFechaRegistro()),
                dto.getPlaneacionSprint(), totalSprint);
    }
    public InformacionProyecto mapeadorAplicacionDuplicar(DtoProyecto dto, LocalDate fechaInicial, LocalDate fechaFinal) {
        var duracion = servicioCalcularDuracionDias.calcular(fechaInicial,fechaFinal);
        var totalSprint = servicioCalcularTotalSprint.calcular(duracion, dto.getPlaneacionSprint());

        return InformacionProyecto.of(fechaInicial,fechaFinal,
                servicioObtenerHoraActual.calcular(dto.getFechaRegistro()),
                dto.getPlaneacionSprint(),totalSprint);
    }
}
