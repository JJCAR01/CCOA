package com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad;

import com.ccoa.planeacionestrategica.infraestructura.clase.direccion.adaptador.entidad.EntidadDireccion;
import com.ccoa.planeacionestrategica.infraestructura.clase.proceso.adaptador.entidad.EntidadProceso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "informacion_usuario")
public class EntidadInformacionUsuario {
    @Id
    @Column(name = "id_informacion_usuario", nullable = false)
    private Long idInformacionUsuario;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<EntidadDireccion> direccion = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    private List<EntidadProceso> procesos = new ArrayList<>();
    public EntidadInformacionUsuario(List<EntidadDireccion> direccion, List<EntidadProceso> procesos) {
        this.direccion = direccion;
        this.procesos = procesos;
    }
}
