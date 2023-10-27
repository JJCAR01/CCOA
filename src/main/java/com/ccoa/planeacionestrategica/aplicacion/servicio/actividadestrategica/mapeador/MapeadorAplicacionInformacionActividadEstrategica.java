package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.InformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDiasRestantes;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDuracionDias;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MapeadorAplicacionInformacionActividadEstrategica implements MapeadorAplicacion<DtoActividadEstrategica, InformacionActividadEstrategica> {
    private final ServicioCalcularDiasRestantes servicioCalcularDiasRestantes;
    private final ServicioCalcularDuracionDias servicioCalcularDuracionDias;

    public MapeadorAplicacionInformacionActividadEstrategica(ServicioCalcularDiasRestantes servicioCalcularDiasRestantes, ServicioCalcularDuracionDias servicioCalcularDuracionDias) {
        this.servicioCalcularDiasRestantes = servicioCalcularDiasRestantes;
        this.servicioCalcularDuracionDias = servicioCalcularDuracionDias;
    }

    @Override
    public InformacionActividadEstrategica mapeadorAplicacion(DtoActividadEstrategica dto) {
        return new InformacionActividadEstrategica(servicioCalcularDuracionDias.ejecutar(dto.getFechaInicial(),dto.getFechaFinal()),
                servicioCalcularDiasRestantes.ejecutar(LocalDate.now(),dto.getFechaFinal()),dto.getEstado(),
                dto.getAvance(), dto.getIdPat(), dto.getIdUsuario());
    }
}
