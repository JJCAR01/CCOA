package com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRolId implements Serializable {
    private Long idUsuario;
    private String nombreRol;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioRolId that)) return false;
        return Objects.equals(idUsuario, that.idUsuario) && Objects.equals(nombreRol, that.nombreRol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nombreRol);
    }
}