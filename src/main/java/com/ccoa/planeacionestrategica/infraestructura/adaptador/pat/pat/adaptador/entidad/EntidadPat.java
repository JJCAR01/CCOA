    package com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.entidad;

    import jakarta.persistence.*;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.time.LocalDate;

    @Data
    @Entity
    @NoArgsConstructor
    @Table(name = "pats")
    public class EntidadPat {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id_pat")
        private Long idPat;

        private String nombre;

        @Column( name = "fecha_anual")
        private Integer fechaAnual;

        @Column(name = "fecha_registro")
        private LocalDate fechaRegistro;

        @Column(name = "porcentaje_pat")
        private Double porcentajePat;

        @JoinColumn(name = "id_usuario")
        private Long idUsuario;

        @JoinColumn(name = "id_clasificacion")
        private Long idClasificacion;


        public EntidadPat(String nombre, Integer fechaAnual, LocalDate fechaRegistro, Double porcentajePat, Long idUsuario, Long idClasificacion) {
            this.nombre = nombre;
            this.fechaAnual = fechaAnual;
            this.fechaRegistro = fechaRegistro;
            this.porcentajePat = porcentajePat;
            this.idUsuario = idUsuario;
            this.idClasificacion = idClasificacion;
        }
    }
