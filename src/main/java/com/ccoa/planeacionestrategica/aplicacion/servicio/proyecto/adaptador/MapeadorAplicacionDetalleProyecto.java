package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.adaptador;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.DetalleProyecto;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionDetalleProyecto implements MapeadorAplicacion<DtoProyecto, DetalleProyecto> {
    @Override
    public DetalleProyecto mapeadorAplicacion(DtoProyecto dto) {
        return DetalleProyecto.of(dto.getIdProyecto(), Mensaje.POR_DEFECTO_AVANCE,dto.getIdActividadEstrategica(), dto.getIdUsuario());
    }
}
