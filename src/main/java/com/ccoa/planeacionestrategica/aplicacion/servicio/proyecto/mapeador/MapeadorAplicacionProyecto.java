package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.Proyecto;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionProyecto implements MapeadorAplicacion<DtoProyecto, Proyecto> {
    @Override
    public Proyecto mapeadorAplicacion(DtoProyecto dto) {
        return new Proyecto(dto.getIdProyecto(),dto.getNombre(), dto.getPresupuesto(),dto.getModalidad(),
                dto.getValorEjecutado(), dto.getIdActividadEstrategica(), dto.getIdUsuario());
    }
    public Proyecto mapeadorAplicacionDuplicar(DtoProyecto dto, Long idActividadEstrategica) {
        return new Proyecto(dto.getIdProyecto(),dto.getNombre(), Mensaje.PORCENTAJE_CERO,dto.getModalidad(),
                Mensaje.PORCENTAJE_CERO, idActividadEstrategica, dto.getIdUsuario());
    }
    public Proyecto mapeadorAplicacionValorEjecutado(DtoProyecto dto) {
        return Proyecto.ofValorEjecutado(dto.getIdProyecto(),dto.getNombre(), dto.getPresupuesto(),dto.getModalidad(),
                dto.getValorEjecutado(), dto.getIdActividadEstrategica(), dto.getIdUsuario());
    }

}
