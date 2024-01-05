package com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad;

import com.ccoa.planeacionestrategica.dominio.modelo.area.enums.EDireccion;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.enums.EProceso;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad.EntidadDireccion;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad.EntidadProceso;
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
@Table(name = "informacion_usuario")
public class EntidadInformacionUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_informacion_usuario", nullable = false)
    private Long idInformacionUsuario;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private List<EDireccion> direccion;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private List<EProceso> procesos;
    public EntidadInformacionUsuario(List<EDireccion> direccion, List<EProceso> procesos) {
        this.direccion = direccion;
        this.procesos = procesos;
    }
}
