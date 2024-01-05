package com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "direccion")
public class EntidadDireccion {

    @Id
    private String nombre;

}
