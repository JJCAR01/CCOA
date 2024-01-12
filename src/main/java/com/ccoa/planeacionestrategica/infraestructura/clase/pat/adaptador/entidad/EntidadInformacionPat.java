package com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad;

import com.ccoa.planeacionestrategica.infraestructura.clase.direccion.adaptador.entidad.EntidadDireccion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "informacion_pat")
public class EntidadInformacionPat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_informacion_pat")
    private Long idInformacionPat;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_direccion")
    private EntidadDireccion direccion;

    public EntidadInformacionPat(EntidadDireccion direccion) {
        this.direccion = direccion;
    }
}
