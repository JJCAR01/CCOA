package com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.entidad;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.direccion.adaptador.entidad.EntidadDireccion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.entidad.EntidadPat;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "informacion_usuarios")
public class EntidadInformacionUsuario {
    @Id
    @Column(name = "id_informacion_usuario", nullable = false)
    private Long idInformacionUsuario;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<EntidadDireccion> direccion = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    private List<EntidadPat> pats = new ArrayList<>();
    public EntidadInformacionUsuario(List<EntidadDireccion> direccion, List<EntidadPat> pats) {
        this.direccion = direccion;
        this.pats = pats;
    }
}
