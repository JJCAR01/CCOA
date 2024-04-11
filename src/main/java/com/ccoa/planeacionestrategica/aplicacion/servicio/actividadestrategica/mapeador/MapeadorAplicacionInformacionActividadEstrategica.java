package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.InformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDiasRestantes;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularDuracionDias;
import com.ccoa.planeacionestrategica.infraestructura.transversal.servicio.ServicioCalcularPorcentaje;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

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
        var duracion = servicioCalcularDuracionDias.calcular(dto.getFechaInicial(),dto.getFechaFinal());
        var diasRestantes = servicioCalcularDiasRestantes.calcular(dto.getFechaFinal());
        var porcentajeEsperado = servicioCalcularPorcentaje.obtenerPorcentajeEsperado(dto.getFechaInicial(),duracion);

        return InformacionActividadEstrategica.of(duracion,diasRestantes,Mensaje.POR_DEFECTO_AVANCE, porcentajeEsperado,
                Mensaje.POR_DEFECTO_AVANCE,dto.getPorcentajePat());
    }
    public InformacionActividadEstrategica mapeadorAplicacionDuplicar(DtoActividadEstrategica dto, LocalDate fechaInicial,LocalDate fechaFinal) {
        var duracion = servicioCalcularDuracionDias.calcular(fechaInicial,fechaFinal);
        var diasRestantes = servicioCalcularDiasRestantes.calcular(fechaFinal);
        var porcentajeEsperado = servicioCalcularPorcentaje.obtenerPorcentajeEsperado(fechaInicial,duracion);

        return InformacionActividadEstrategica.of(duracion,diasRestantes
                ,Mensaje.POR_DEFECTO_AVANCE, porcentajeEsperado,
                Mensaje.POR_DEFECTO_AVANCE,dto.getPorcentajePat());
    }
    public InformacionActividadEstrategica mapeadorAplicacionActualizarPorcentaje(DtoActividadEstrategica dto) {
        return new  InformacionActividadEstrategica(dto.getDuracion(),dto.getDiasRestantes(), dto.getPorcentajeReal(), dto.getPorcentajeEsperado(),
                dto.getPorcentajeCumplimiento(), dto.getPorcentajePat());
    }

}
