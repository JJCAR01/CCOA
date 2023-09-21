package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.epicagestion;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.epicagestion.enums.ETipoEG;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipo_eg")
public class EntidadTipoEG {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_tipo_eg")
    private Long idTipoGI;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ETipoEG nombre;


}
