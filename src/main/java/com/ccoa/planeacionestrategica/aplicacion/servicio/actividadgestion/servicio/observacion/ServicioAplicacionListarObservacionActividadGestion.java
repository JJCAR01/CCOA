package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoObservacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.observacion.ObservacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestion.RepositorioObservacionActividadGestion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarObservacionActividadGestion {

    private final RepositorioObservacionActividadGestion repositorioObservacionActividadGestion;

    public ServicioAplicacionListarObservacionActividadGestion(RepositorioObservacionActividadGestion repositorioObservacionActividadGestion) {
        this.repositorioObservacionActividadGestion = repositorioObservacionActividadGestion;
    }
    public List<DtoObservacionActividadGestion> ejecutar(){return this.repositorioObservacionActividadGestion.listar();}
    public ObservacionActividadGestion consultarById(Long id){return this.repositorioObservacionActividadGestion.consultarPorId(id);}
    public List<DtoObservacionActividadGestion> consultarPorIdActividadGestion(Long id){return this.repositorioObservacionActividadGestion.consultarPorIdActividadGestion(id);}
}
