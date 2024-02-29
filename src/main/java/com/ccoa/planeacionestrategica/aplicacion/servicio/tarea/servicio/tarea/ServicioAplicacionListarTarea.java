package com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.servicio.tarea;

import com.ccoa.planeacionestrategica.dominio.dto.DtoTareaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.Tarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.documento.DocumentoTarea;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.ETipoASE;
import com.ccoa.planeacionestrategica.dominio.puerto.tarea.RepositorioTarea;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarTarea {
    private final RepositorioTarea repositorioTarea;

    public ServicioAplicacionListarTarea(RepositorioTarea repositorioTarea) {
        this.repositorioTarea = repositorioTarea;
    }

    public List<DtoTareaResumen> ejecutar(){return this.repositorioTarea.listar();}

    public Tarea consultarById(Long id){return this.repositorioTarea.consultarPorId(id);}
    public List<DtoTareaResumen> consultarPorIdActividadGestion(Long id,ETipoASE tipoASE) {
        return this.repositorioTarea.consultarPorIdActividadGestion(id,tipoASE);
    }
    public List<DtoTareaResumen> consultarPorIdSprint(Long id, ETipoASE tipoASE){return this.repositorioTarea.consultarPorIdSprint(id,tipoASE);}
    public List<DtoTareaResumen> consultarPorIdSprintProyectoArea(Long id, ETipoASE tipoASE){return this.repositorioTarea.consultarPorIdSprintProyectoArea(id,tipoASE);}
    public List<DtoTareaResumen> consultarPorIdActividadGestionActvidadEstrategica(Long id, ETipoASE tipoASE){
        return this.repositorioTarea.consultarPorIdActividadGestionActvidadEstrategica(id,tipoASE );}
    public List<DocumentoTarea> consultarByIdDocumento(Long id){return this.repositorioTarea.consultarPorIdParaObtenerDocumento(id);}
}
