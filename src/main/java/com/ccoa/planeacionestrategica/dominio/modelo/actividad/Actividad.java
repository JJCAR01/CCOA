package com.ccoa.planeacionestrategica.dominio.modelo.actividad;

import com.ccoa.planeacionestrategica.dominio.modelo.actividad.enums.ETipoActividad;
import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Actividad {
    private final Long idActividad;
    private final ETipoActividad tipoActividad;
    private final LocalDate fechaInicial;
    private final LocalDate fechaFinal;
    private final Long idInformacionActividad;

    public static Actividad of(Long idActividad, ETipoActividad tipoActividad, LocalDate fechaInicial,
                               LocalDate fechaFinal, Long idInformacionActividad ){
        ValidadorDominio.validarObligatorio(tipoActividad,"El Tipo de actividad NO puede estar vacía");
        ValidadorDominio.fechaInicioEsMayorActual(fechaInicial,"La fecha inicial no puede ser mayor a la fecha final");
        ValidadorDominio.fechaFinalEsMayorFechaInicio(fechaFinal,fechaInicial,"La fecha Final debe ser mayor a la fecha de Inicio");
        return new Actividad(idActividad, tipoActividad,fechaInicial,fechaFinal,idInformacionActividad);
    }


    public Actividad(Long idActividad, ETipoActividad tipoActividad, LocalDate fechaInicial,
                     LocalDate fechaFinal, Long idInformacionActividad) {
        this.idActividad = idActividad;
        this.tipoActividad = tipoActividad;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.idInformacionActividad = idInformacionActividad;
    }
}
