package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.adaptador;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDuracionDias;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class MapeadorAplicacionInformacionProyecto implements MapeadorAplicacion<DtoProyecto, InformacionProyecto> {
    private final ServicioCalcularDuracionDias servicioCalcularDuracionDias;

    public MapeadorAplicacionInformacionProyecto(ServicioCalcularDuracionDias servicioCalcularDuracionDias) {
        this.servicioCalcularDuracionDias = servicioCalcularDuracionDias;
    }

    @Override
    public InformacionProyecto mapeadorAplicacion(DtoProyecto dto) {
        return new InformacionProyecto(dto.getFechaInicial(),dto.getFechaFinal(), dto.getAvance(), servicioCalcularDuracionDias.ejecutar(LocalDate.now(),dto.getFechaFinal()),dto.getPlaneacionSprint(),
                dto.getTotalSprint(), dto.getIdUsuario());
    }
}
