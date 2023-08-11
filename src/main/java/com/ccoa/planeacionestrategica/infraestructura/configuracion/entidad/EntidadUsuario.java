package com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
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

    @Column(unique = true, length = 50, name = "nombre")
    private String nombre;

    @Column(unique = true, length = 50, name = "apellido")
    private String apellidos;

    @Column(length = 50, name = "password")
    private String password;

    @Column(unique = true, length = 50, name = "correo")
    private String correo;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "cargo_id")
    private EntidadCargo cargo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name= "rol_id")
    private List<EntidadRol> roles;

    public EntidadUsuario() {
    }

    public EntidadUsuario(String nombreUsuario, String nombre, String apellidos, String password, String correo, EntidadCargo cargo, List<EntidadRol> roles) {
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
        this.correo = correo;
        this.cargo = cargo;
        this.roles = roles;
    }
}
