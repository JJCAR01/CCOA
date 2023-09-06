package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "rol_usuario")
@IdClass(UsuarioRolId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntidadUsuarioRol {
    @Id
    @Column(name = "id_usuario",nullable = false, length = 20)
    private Long idUsuario;

    @Id
    @Column(nullable = false, length = 20)
    private String rol;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    private EntidadUsuario usuario;


    public EntidadUsuarioRol( String rol) {
        this.rol = rol;
    }

    public EntidadUsuarioRol(Long idUsuario, String rol) {
        this.idUsuario = idUsuario;
        this.rol = rol;
    }
}
