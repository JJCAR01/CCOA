package com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad;

import com.ccoa.planeacionestrategica.dominio.modelo.area.enums.EDireccion;
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EDireccion direccion;

    public EntidadInformacionPat(EDireccion direccion) {
        this.direccion = direccion;
    }
}
