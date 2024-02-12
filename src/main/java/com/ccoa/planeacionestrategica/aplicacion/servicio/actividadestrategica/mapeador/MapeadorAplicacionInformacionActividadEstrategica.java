package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.InformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDiasRestantes;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDuracionDias;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularPorcentaje;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionInformacionActividadEstrategica implements MapeadorAplicacion<DtoActividadEstrategica, InformacionActividadEstrategica> {
    private final ServicioCalcularDiasRestantes servicioCalcularDiasRestantes;
    private final ServicioCalcularDuracionDias servicioCalcularDuracionDias;
    private final ServicioCalcularPorcentaje servicioCalcularPorcentaje;

    public MapeadorAplicacionInformacionActividadEstrategica(ServicioCalcularDiasRestantes servicioCalcularDiasRestantes, ServicioCalcularDuracionDias servicioCalcularDuracionDias, ServicioCalcularPorcentaje servicioCalcularPorcentaje) {
        this.servicioCalcularDiasRestantes = servicioCalcularDiasRestantes;
        this.servicioCalcularDuracionDias = servicioCalcularDuracionDias;
        this.servicioCalcularPorcentaje = servicioCalcularPorcentaje;
    }

    @Override
    public InformacionActividadEstrategica mapeadorAplicacion(DtoActividadEstrategica dto) {
        return InformacionActividadEstrategica.of(servicioCalcularDuracionDias.calcular(dto.getFechaInicial(),dto.getFechaFinal()),
                servicioCalcularDiasRestantes.calcular(dto.getFechaFinal()),Mensaje.POR_DEFECTO_AVANCE,
                servicioCalcularPorcentaje.obtenerPorcentajeEsperado(dto.getFechaInicial(),servicioCalcularDuracionDias.calcular(dto.getFechaInicial(),dto.getFechaFinal())),
                Mensaje.POR_DEFECTO_AVANCE,dto.getMeta(), dto.getResultado());
    }
    public InformacionActividadEstrategica mapeadorModificarResultado(DtoActividadEstrategica dto) {
        return InformacionActividadEstrategica.modificarResultado(dto.getDuracion(), dto.getDiasRestantes(), dto.getPorcentajeReal(),
                dto.getPorcentajeEsperado(), dto.getPorcentajeCumplimiento(), dto.getMeta(), dto.getResultado());
    }
}
