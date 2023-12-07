package com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoProyectoResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.Proyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad.EntidadDetalleProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad.EntidadInformacionProyecto;
import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad.EntidadProyecto;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorProyecto implements MapeadorInfraestructura<EntidadProyecto, Proyecto> {

    @Override
    public Proyecto mapeadorDominio(EntidadProyecto entidad) {
        return new Proyecto(entidad.getIdProyecto(), entidad.getNombre(), entidad.getPresupuesto(),entidad.getModalidad(),
                entidad.getValorEjecutado(), entidad.getEstado());
    }
    @Override
    public EntidadProyecto mapeadorEntidad(Proyecto dominio) {
        return new EntidadProyecto(dominio.getNombre(),dominio.getPresupuesto(),dominio.getModalidad(),dominio.getValorEjecutado(),
                dominio.getEstado());
    }
    public void actualizarEntidad(EntidadProyecto entidad, Proyecto proyecto,
                                  EntidadInformacionProyecto entidadInformacionProyecto,
                                  InformacionProyecto informacionProyecto) {
        entidad.setNombre(proyecto.getNombre());
        entidad.setPresupuesto(proyecto.getPresupuesto());
        entidad.setModalidad(proyecto.getModalidad());
        entidadInformacionProyecto.setPlaneacionSprint(informacionProyecto.getPlaneacionSprint());
        entidadInformacionProyecto.setFechaInicial(informacionProyecto.getFechaInicial());
        entidadInformacionProyecto.setFechaFinal(informacionProyecto.getFechaFinal());
        entidadInformacionProyecto.setDuracion(informacionProyecto.getDuracion());
    }
    public DtoProyectoResumen mapeadorDominioProyecto(EntidadProyecto entidad, EntidadDetalleProyecto detalleProyecto,
                                                      EntidadInformacionProyecto entidadInformacionProyecto) {
        return new DtoProyectoResumen(entidad.getIdProyecto(), entidad.getNombre(), entidad.getPresupuesto(),entidad.getModalidad(),
                entidad.getValorEjecutado(), entidad.getEstado(), detalleProyecto.getIdActividadEstrategica(),
                entidadInformacionProyecto.getFechaInicial(),entidadInformacionProyecto.getFechaFinal(), detalleProyecto.getAvance(),
                entidadInformacionProyecto.getDuracion(),entidadInformacionProyecto.getTotalSprint()
                ,entidadInformacionProyecto.getPlaneacionSprint(),detalleProyecto.getIdUsuario());
    }

}
