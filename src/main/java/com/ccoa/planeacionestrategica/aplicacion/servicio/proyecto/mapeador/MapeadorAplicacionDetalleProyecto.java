package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.DetalleProyecto;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDiasRestantes;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDuracionDias;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionDetalleProyecto implements MapeadorAplicacion<DtoProyecto, DetalleProyecto> {
    private final ServicioCalcularDuracionDias servicioCalcularDuracionDias;

    public MapeadorAplicacionDetalleProyecto(ServicioCalcularDuracionDias servicioCalcularDuracionDias) {
        this.servicioCalcularDuracionDias = servicioCalcularDuracionDias;;
    }
    @Override
    public DetalleProyecto mapeadorAplicacion(DtoProyecto dto) {
        return DetalleProyecto.of(servicioCalcularDuracionDias.calcular(dto.getFechaInicial(),dto.getFechaFinal()) , Mensaje.POR_DEFECTO_AVANCE,
                Mensaje.POR_DEFECTO_AVANCE,Mensaje.POR_DEFECTO_AVANCE);
    }
}
