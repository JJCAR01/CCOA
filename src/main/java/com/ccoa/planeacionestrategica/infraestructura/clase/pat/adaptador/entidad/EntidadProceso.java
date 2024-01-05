package com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad;

import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad.EntidadInformacionUsuario;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "proceso")
public class EntidadProceso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_proceso")
    private Long idProceso;

    @Column(unique = true)
    private String nombre;

}
