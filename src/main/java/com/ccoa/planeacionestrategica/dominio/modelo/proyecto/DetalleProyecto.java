package com.ccoa.planeacionestrategica.dominio.modelo.proyecto;

import com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio;
import lombok.Getter;
import lombok.Setter;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_PUEDE_EXISTIR_SIN_ACTIVIDAD_ESTRATEGICA;
import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_PUEDE_EXISTIR_SIN_USUARIO;


@Getter
@Setter
public class DetalleProyecto {

    private final Long idDetalleProyecto;
    private final Double avance;
    private final Long idActividadEstrategica;
    private final Long idUsuario;

    public static DetalleProyecto of(Long idDetalleProyecto,Double avance, Long idActividadEstrategica, Long idUsuario){
        ValidadorDominio.validarObligatorio(idActividadEstrategica,NO_PUEDE_EXISTIR_SIN_ACTIVIDAD_ESTRATEGICA);
        ValidadorDominio.validarObligatorio(idUsuario,NO_PUEDE_EXISTIR_SIN_USUARIO);
        return new DetalleProyecto(idDetalleProyecto, avance, idActividadEstrategica,idUsuario);
    }

   public DetalleProyecto(Long idDetalleProyecto, Double avance, Long idActividadEstrategica, Long idUsuario) {
        this.idDetalleProyecto = idDetalleProyecto;
       this.avance = avance;
       this.idActividadEstrategica = idActividadEstrategica;
        this.idUsuario = idUsuario;
    }
}
