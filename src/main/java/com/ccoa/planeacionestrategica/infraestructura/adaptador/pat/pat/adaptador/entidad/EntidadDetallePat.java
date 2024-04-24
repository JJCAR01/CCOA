package com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "detalle_pats")
public class EntidadDetallePat {

    @Id
    @Column(name = "id_detalle_pat")
    private Long idDetallePat;

    private boolean estrategica;

    @Column(name = "de_proceso")
    private boolean deProceso;

    public EntidadDetallePat(boolean estrategica, boolean deProceso) {
        this.estrategica = estrategica;
        this.deProceso = deProceso;
    }
}
