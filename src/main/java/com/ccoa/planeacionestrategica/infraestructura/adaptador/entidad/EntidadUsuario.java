package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class EntidadUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, length = 50, name = "nombre_usuario")
    private String nombreUsuario;

    @Column(unique = true, length = 50)
    private String nombre;

    @Column(unique = true, length = 50, name = "apellido")
    private String apellidos;

    @Column(length = 50)
    private String password;

    @Column(unique = true, length = 50)
    private String correo;

    @Column(name = "cargo_id")
    private Long idCargo;

    @Column(name= "rol_id")
    private Long idRol;

    public EntidadUsuario() {
    }

    public EntidadUsuario(String nombreUsuario, String nombre, String apellidos, String password, String correo, Long idCargo, Long idRol) {
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
        this.correo = correo;
        this.idCargo = idCargo;
        this.idRol = idRol;
    }
}
