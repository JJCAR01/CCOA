package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.rubro;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.gastoingreso.enums.ETipoGI;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rubro")
public class EntidadRubro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_rubro")
    private Long idRubro;

    @Column(unique = true)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column( nullable = false)
    private ETipoGI clasificacion;

    @JoinColumn(name = "tipo_gi_id",unique = true)
    private Long idTipoGI;

    public EntidadRubro() {
    }

    public EntidadRubro(String nombre, String clasificacion, Long idTipoGI) {
        this.nombre = nombre;
        this.clasificacion = ETipoGI.valueOf(clasificacion);
        this.idTipoGI = idTipoGI;
    }
}
