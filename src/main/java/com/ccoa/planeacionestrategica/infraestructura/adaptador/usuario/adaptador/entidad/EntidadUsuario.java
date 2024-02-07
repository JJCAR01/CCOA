package com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.entidad;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
public class EntidadUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(unique = true, length = 50)
    private String nombre;

    private String apellido;

    @Column(unique = true, length = 100)
    private String correo;

    private String password;

    @Column(name = "cargo_id")
    private Long idCargo;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<EntidadUsuarioRol> roles;

    public EntidadUsuario(String nombre, String apellido, String correo, String password, Long idCargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
        this.idCargo = idCargo;
    }
}
