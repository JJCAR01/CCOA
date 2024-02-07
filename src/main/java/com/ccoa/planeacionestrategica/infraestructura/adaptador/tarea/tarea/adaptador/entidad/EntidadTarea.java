package com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.entidad;

import com.ccoa.planeacionestrategica.dominio.transversal.enums.EEstado;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.ETipoASE;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tareas")
public class EntidadTarea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tarea")
    private Long idTarea;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private EEstado estado;

    private String descripcion;

    @Enumerated(EnumType.STRING)
    private ETipoASE tipoASE;

    private Long idASE;

    @JoinColumn(name = "id_usuario")
    private Long idUsuario;

    public EntidadTarea(String nombre, EEstado estado, String descripcion, ETipoASE tipoASE, Long idASE, Long idUsuario) {
        this.nombre = nombre;
        this.estado = estado;
        this.descripcion = descripcion;
        this.tipoASE = tipoASE;
        this.idASE = idASE;
        this.idUsuario = idUsuario;
    }
}
