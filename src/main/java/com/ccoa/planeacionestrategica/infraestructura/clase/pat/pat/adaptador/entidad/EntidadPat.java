    package com.ccoa.planeacionestrategica.infraestructura.clase.pat.pat.adaptador.entidad;

    import jakarta.persistence.*;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.time.LocalDate;

    @Data
    @Entity
    @NoArgsConstructor
    @Table(name = "pat")
    public class EntidadPat {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id_pat")
        private Long idPat;

        @Column(unique = true)
        private String nombre;

        @Column( name = "fecha_anual")
        private Integer fechaAnual;

        @Column(name = "fecha_registro")
        private LocalDate fechaRegistro;

        @JoinColumn(name = "id_usuario")
        private Long idUsuario;


        public EntidadPat(String nombre, Integer fechaAnual, LocalDate fechaRegistro,Long idUsuario) {
            this.nombre = nombre;
            this.fechaAnual = fechaAnual;
            this.fechaRegistro = fechaRegistro;
            this.idUsuario = idUsuario;
        }
    }
