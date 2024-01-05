package com.ccoa.planeacionestrategica.aplicacion.dto.pat;

import com.ccoa.planeacionestrategica.dominio.modelo.area.enums.EDireccion;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.enums.EProceso;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad.EntidadDireccion;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad.EntidadProceso;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoPat {

    private Long idPat;
    private String nombre;
    private Integer fechaAnual;
    private LocalDate fechaRegistro;
    private Double porcentaje;
    private EProceso proceso;
    private EDireccion direccion;
    private Long idUsuario;

}
