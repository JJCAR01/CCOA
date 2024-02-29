package com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoDocumentoTarea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.servicio.tarea.ServicioAplicacionEliminarTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.servicio.tarea.ServicioAplicacionGuardarTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.servicio.tarea.ServicioAplicacionListarTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.servicio.tarea.ServicioAplicacionModificarTarea;
import com.ccoa.planeacionestrategica.dominio.dto.DtoTareaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.Tarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.documento.DocumentoTarea;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.ETipoASE;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/tareas")
public class ControladorTarea {

    private final ServicioAplicacionGuardarTarea servicioAplicacionGuardarTarea;
    private final ServicioAplicacionListarTarea servicioAplicacionListarTarea;
    private final ServicioAplicacionEliminarTarea servicioAplicacionEliminarTarea;
    private final ServicioAplicacionModificarTarea servicioAplicacionModificarTarea;

    public ControladorTarea(ServicioAplicacionGuardarTarea servicioAplicacionGuardarTarea, ServicioAplicacionListarTarea servicioAplicacionListarTarea,
                            ServicioAplicacionEliminarTarea servicioAplicacionEliminarTarea, ServicioAplicacionModificarTarea servicioAplicacionModificarTarea) {
        this.servicioAplicacionGuardarTarea = servicioAplicacionGuardarTarea;
        this.servicioAplicacionListarTarea = servicioAplicacionListarTarea;
        this.servicioAplicacionEliminarTarea = servicioAplicacionEliminarTarea;
        this.servicioAplicacionModificarTarea = servicioAplicacionModificarTarea;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoTarea tarea){
        return ResponseEntity.ok(this.servicioAplicacionGuardarTarea.ejecutar(tarea));
    }

    @GetMapping
    public ResponseEntity<List<DtoTareaResumen>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarTarea.ejecutar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Tarea> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarTarea.consultarById(codigo));
    }
    @GetMapping("/gestion/{codigo}")
    public ResponseEntity<List<DtoTareaResumen>> listarPorActividadGestion(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarTarea.consultarPorIdActividadGestion(codigo, ETipoASE.ACTIVIDAD_GESTION));
    }
    @GetMapping("/sprint/{codigo}")
    public ResponseEntity<List<DtoTareaResumen>> listarPorSprint(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarTarea.consultarPorIdSprint(codigo,ETipoASE.SPRINT));
    }
    @GetMapping("/sprintproyectoarea/{codigo}")
    public ResponseEntity<List<DtoTareaResumen>> listarPorSprintProyectoArea(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarTarea.consultarPorIdSprintProyectoArea(codigo,ETipoASE.SPRINT_PROYECTO_AREA));
    }
    @GetMapping("/actividad/{codigo}")
    public ResponseEntity<List<DtoTareaResumen>> listarPorActividadGestionActividadEstrategica(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarTarea.consultarPorIdActividadGestionActvidadEstrategica(codigo,ETipoASE.ACTIVIDAD_GESTION_ACTIVIDAD_ESTRATEGICA));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarTarea.ejecutarEliminar(codigo));
    }

    @PutMapping("/estado/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificarEstado(@RequestBody DtoTarea tarea, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarTarea.modificarEstado(tarea,codigo));
    }
    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoTarea tarea, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarTarea.ejecutarModificar(tarea,codigo));
    }

    @PutMapping("/porcentaje/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificarPorcentaje(@RequestBody DtoTarea tarea, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarTarea.modificarPorcentaje(tarea,codigo));
    }
    @PutMapping("/archivo/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> guardarDocumento(@RequestBody DtoDocumentoTarea rutaArchivo, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionGuardarTarea.guardarRutaArchivo(rutaArchivo,codigo));
    }
    @GetMapping("/archivo/{codigo}")
    public ResponseEntity<List<DocumentoTarea>> obtenerDocumento(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarTarea.consultarByIdDocumento(codigo));
    }
}
