package com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.entidad;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "rol_usuario")
@IdClass(UsuarioRolId.class)
@NoArgsConstructor
@AllArgsConstructor
public class EntidadUsuarioRol {
    @Id
    @Column(name = "id_usuario",nullable = false, length = 20)
    private Long idUsuario;

    @Id
    @Column(name = "nombre_rol",nullable = false, length = 20)
    private String nombreRol;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    private EntidadUsuario usuario;

}
