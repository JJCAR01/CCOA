package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.InformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDiasRestantes;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDuracionDias;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionInformacionActividadEstrategica implements MapeadorAplicacion<DtoActividadEstrategica, InformacionActividadEstrategica> {
    private final ServicioCalcularDiasRestantes servicioCalcularDiasRestantes;
    private final ServicioCalcularDuracionDias servicioCalcularDuracionDias;

    public MapeadorAplicacionInformacionActividadEstrategica(ServicioCalcularDiasRestantes servicioCalcularDiasRestantes, ServicioCalcularDuracionDias servicioCalcularDuracionDias) {
        this.servicioCalcularDiasRestantes = servicioCalcularDiasRestantes;
        this.servicioCalcularDuracionDias = servicioCalcularDuracionDias;
    }

    @Override
    public InformacionActividadEstrategica mapeadorAplicacion(DtoActividadEstrategica dto) {
        return InformacionActividadEstrategica.of(servicioCalcularDuracionDias.calcular(dto.getFechaInicial(),dto.getFechaFinal()),
                servicioCalcularDiasRestantes.calcular(dto.getFechaFinal()),dto.getEstado(),
                Mensaje.POR_DEFECTO_AVANCE, dto.getIdPat(), dto.getIdUsuario());
    }
}
