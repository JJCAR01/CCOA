package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionactividadestrategica.DtoActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.InformacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDiasRestantes;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDuracionDias;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionInformacionActividadGestionActividadEstrategica implements MapeadorAplicacion<DtoActividadGestionActividadEstrategica,
        InformacionActividadGestionActividadEstrategica> {

    private final ServicioCalcularDuracionDias servicioCalcularDuracionDias;
    private final ServicioCalcularDiasRestantes servicioCalcularDiasRestantes;

    public MapeadorAplicacionInformacionActividadGestionActividadEstrategica(ServicioCalcularDuracionDias servicioCalcularDuracionDias, ServicioCalcularDiasRestantes servicioCalcularDiasRestantes) {
        this.servicioCalcularDuracionDias = servicioCalcularDuracionDias;
        this.servicioCalcularDiasRestantes = servicioCalcularDiasRestantes;
    }

    @Override
    public InformacionActividadGestionActividadEstrategica mapeadorAplicacion(DtoActividadGestionActividadEstrategica dto) {
        return InformacionActividadGestionActividadEstrategica.of(servicioCalcularDuracionDias.calcular(dto.getFechaInicial(),dto.getFechaFinal()) ,
                servicioCalcularDiasRestantes.calcular(dto.getFechaFinal()), Mensaje.POR_DEFECTO_AVANCE,
                Mensaje.POR_DEFECTO_AVANCE,Mensaje.POR_DEFECTO_AVANCE);
    }
}
