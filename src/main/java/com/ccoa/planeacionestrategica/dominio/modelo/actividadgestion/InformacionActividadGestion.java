package com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;

@Setter
@Getter
public class InformacionActividadGestion {
    private final Long idInformacionActividad;
    private final LocalDate fechaRegistro;
    private final Integer duracion;
    private final Integer diasRestantes;
    private final Double avance;

    public static InformacionActividadGestion of(Long idInformacionActividad, LocalDate fechaRegistro, Integer duracion, Integer diasRestantes, Double avance){
        ValidadorDominio.siEsFechaActualRegistrada(fechaRegistro, LA_FECHA_REGISTRO_DEBE_SER_LA_FECHA_ACTUAL);
        ValidadorDominio.validadorNumeroEnteroYMayorACero(duracion,LA_DURACION_NO_PUEDE_SER_NEGATIVA);
        ValidadorDominio.validarObjeto(diasRestantes,LOS_DIAS_RESTANTES_NO_PUEDEN_SER_NULOS);
        ValidadorDominio.validadorNumeroDoubleYMayorACero(avance,EL_PORCENTAJE_DE_AVANCE_NO_PUEDE_ESTAR_VACIO);
        return new InformacionActividadGestion(idInformacionActividad, fechaRegistro,duracion,diasRestantes,avance);
    }
    public InformacionActividadGestion(Long idInformacionActividad, LocalDate fechaRegistro, Integer duracion, Integer diasRestantes, Double avance) {
        this.idInformacionActividad = idInformacionActividad;
        this.fechaRegistro = fechaRegistro;
        this.duracion = duracion;
        this.diasRestantes = diasRestantes;
        this.avance = avance;
    }
}
