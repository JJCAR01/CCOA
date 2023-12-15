package com.ccoa.planeacionestrategica.dominio.dto;

import com.ccoa.planeacionestrategica.dominio.modelo.area.enums.EDireccion;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.enums.EProceso;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DtoPatResumen {
    private Long idPat;
    private String nombre;
    private Integer fechaAnual;
    private LocalDate fechaRegistro;
    private Double porcentaje;
    private EProceso proceso;
    private EDireccion direccion;
    private Long idUsuario;
}
