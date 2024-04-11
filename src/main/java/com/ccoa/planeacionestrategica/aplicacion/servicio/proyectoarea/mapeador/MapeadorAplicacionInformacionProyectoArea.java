package com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyectoarea.DtoProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.InformacionProyectoArea;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioCambiarFecha;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDuracionDias;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularTotalSprint;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioObtenerHoraActual;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;


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
        var duracion = servicioCalcularDuracionDias.calcular(dto.getFechaInicial(),dto.getFechaFinal());
        var totalSprint = servicioCalcularTotalSprint.calcular(duracion, dto.getPlaneacionSprint());

        return InformacionProyectoArea.of(dto.getFechaInicial(),dto.getFechaFinal(),servicioObtenerHoraActual.calcular(dto.getFechaRegistro()),
                dto.getPlaneacionSprint(),totalSprint);
    }
    public InformacionProyectoArea mapeadorAplicacionDuplicar(DtoProyectoArea dto, LocalDate fechaInicial, LocalDate fechaFinal) {
        var duracion = servicioCalcularDuracionDias.calcular(fechaInicial,fechaFinal);
        var totalSprint = servicioCalcularTotalSprint.calcular(duracion, dto.getPlaneacionSprint());

        return InformacionProyectoArea.of(fechaInicial,fechaFinal,servicioObtenerHoraActual.calcular(dto.getFechaRegistro()),
                dto.getPlaneacionSprint(),totalSprint);
    }
}
