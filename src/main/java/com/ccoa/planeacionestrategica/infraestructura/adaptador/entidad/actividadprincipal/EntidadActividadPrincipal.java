package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.actividadprincipal;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.actividadprincipal.enums.ETipoActividadPrincipal;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "actividad_principal")
public class EntidadActividadPrincipal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_actividad_principal")
    private Long idActividadPrincipal;

    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ETipoActividadPrincipal tipoActividad;

    private String entregable;
    private Double presupuesto;

    public EntidadActividadPrincipal() {
    }

    public EntidadActividadPrincipal(String nombre, String tipoActividad,
                                     String entregable, Double presupuesto) {
        this.nombre = nombre;
        this.tipoActividad = ETipoActividadPrincipal.valueOf(tipoActividad);
        this.entregable = entregable;
        this.presupuesto = presupuesto;
    }


}

