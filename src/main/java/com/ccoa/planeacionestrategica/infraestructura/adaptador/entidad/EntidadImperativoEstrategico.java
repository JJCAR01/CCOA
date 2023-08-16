package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "imperativo_estrategico")
public class EntidadImperativoEstrategico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, length = 255, name = "nombre")
    private String nombre;

    @Column(unique = true, name = "fecha_inicio")
    private Date fechaInicio;

    @Column(unique = true, name = "fecha_final")
    private Date fechaFinal;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "pat_id",unique = true)
    private EntidadPat pat;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "usuario_id",unique = true)
    private EntidadUsuario usuario;

    @OneToMany(mappedBy = "imperativoEstrategico")
    private List<EntidadPrograma> programas;

    public EntidadImperativoEstrategico() {
    }

    public EntidadImperativoEstrategico(String nombre, Date fechaInicio, Date fechaFinal, Date fechaRegistro, EntidadPat pat, EntidadUsuario usuario) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaRegistro = fechaRegistro;
        this.pat = pat;
        this.usuario = usuario;
    }
}
