package com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class EntidadUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(unique = true, length = 50)
    private String nombre;

    @Column(unique = true, length = 50)
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
