package com.ccoa.planeacionestrategica.aplicacion.dto.proyecto;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.enums.EModalidad;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.enums.EPlaneacionSprint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoProyecto {
    private Long idProyecto;
    private String nombre;
    private Double presupuesto;
    private EModalidad modalidad;
    private Double valorEjecutado;
    private Boolean estado;
    private Long idActividadEstrategica;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private Integer duracion;
    private Integer totalSprint;
    private EPlaneacionSprint planeacionSprint;
    private Long idUsuario;
}
