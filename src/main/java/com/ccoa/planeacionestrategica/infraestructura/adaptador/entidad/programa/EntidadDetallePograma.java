package com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.programa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detalle_programa")
public class EntidadDetallePograma {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_detalle_programa")
    private Long idDetallePrograma;

    @JoinColumn(name = "area_id")
    private Long idArea;

    @JoinColumn(name = "usuario_id")
    private Long idUsuario;

    @JoinColumn(name = "imperativo_estrategico_id")
    private Long idImperativoEstrategico;

    public EntidadDetallePograma(Long idArea, Long idUsuario, Long idImperativoEstrategico) {
        this.idArea = idArea;
        this.idUsuario = idUsuario;
        this.idImperativoEstrategico = idImperativoEstrategico;
    }
}
