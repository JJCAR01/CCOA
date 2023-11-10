package com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;

@Setter
@Getter
public class InformacionActividadGestionActividadEstrategica  {

    private final Long idInformacionActividad;
    private final LocalDate fechaRegistro;
    private final Integer duracion;
    private final Integer diasRestantes;

    public static InformacionActividadGestionActividadEstrategica of(Long idInformacionActividad, LocalDate fechaRegistro, Integer duracion, Integer diasRestantes){
        ValidadorDominio.siEsFechaActualRegistrada(fechaRegistro, LA_FECHA_REGISTRO_DEBE_SER_LA_FECHA_ACTUAL);
        ValidadorDominio.validadorNumeroEnteroYMayorACero(duracion,LA_DURACION_NO_PUEDE_SER_NEGATIVA);
        ValidadorDominio.validarObjeto(diasRestantes,LOS_DIAS_RESTANTES_NO_PUEDEN_SER_NULOS);
        return new InformacionActividadGestionActividadEstrategica(idInformacionActividad, fechaRegistro,duracion,diasRestantes);
    }
    public InformacionActividadGestionActividadEstrategica(Long idInformacionActividad, LocalDate fechaRegistro, Integer duracion, Integer diasRestantes) {
        this.idInformacionActividad = idInformacionActividad;
        this.fechaRegistro = fechaRegistro;
        this.duracion = duracion;
        this.diasRestantes = diasRestantes;
    }
}
