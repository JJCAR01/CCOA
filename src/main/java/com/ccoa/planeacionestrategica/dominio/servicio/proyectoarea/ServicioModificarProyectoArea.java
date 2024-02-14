package com.ccoa.planeacionestrategica.dominio.servicio.proyectoarea;

import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.DetalleProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.Proyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.DetalleProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.InformacionProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.ProyectoArea;
import com.ccoa.planeacionestrategica.dominio.puerto.proyecto.RepositorioProyecto;
import com.ccoa.planeacionestrategica.dominio.puerto.proyectoarea.RepositorioProyectoArea;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_EL_PROYECTO_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_EL_PROYECTO_DEL_AREA_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioModificarProyectoArea {
    private final RepositorioProyectoArea repositorioProyectoArea;

    public ServicioModificarProyectoArea(RepositorioProyectoArea repositorioProyectoArea) {
        this.repositorioProyectoArea = repositorioProyectoArea;
    }

    public Long ejecutarModificar(ProyectoArea proyectoArea, InformacionProyectoArea informacionProyectoArea, DetalleProyectoArea detalleProyectoArea, Long codigo){
        if(this.repositorioProyectoArea.consultarPorId(codigo)==null) throw new ValorInvalidoExcepcion(NO_EXISTE_EL_PROYECTO_DEL_AREA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioProyectoArea.modificar(proyectoArea, informacionProyectoArea,detalleProyectoArea , codigo);
    }
}
