package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.actividadprincipal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detalle_actividad_principal")
public class EntidadDetalleActividadPrincipal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_detalle_actividad_principal")
    private Long idDetalleAtividadPrincipal;

    @Column(name = "usuario_id")
    private Long idUsuario;

    @Column(name = "tipo_gi_id")
    private Long idTipoGI;

    @Column(name = "linea_estrategica_id")
    private Long idLineaEstrategica;

}
